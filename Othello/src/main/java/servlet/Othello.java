package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Board;
import model.Computer;
import model.OthelloLogic;
import model.Person;
import model.Stone;
import model.Player;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Othello
 */
@WebServlet("/Othello")
public class Othello extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private Player player1;
	private Player player2;
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Othello() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//セッションスコープからBoardを取得
		HttpSession session = request.getSession();
		Board board = (Board) session.getAttribute("board");
		RequestDispatcher dispatcherSetting = request.getRequestDispatcher("WEB-INF/jsp/setting.jsp");
		//ゲームの初期化
		if (board == null) {
			dispatcherSetting.forward(request, response);

		} else {
			board.reset();
			session.setAttribute("board", board);
		}
		//1ターン目のゲーム画面を表示
		RequestDispatcher dispatcherOthello = request.getRequestDispatcher("WEB-INF/jsp/othello.jsp");
		player1 = getPlayer(request,1);
		player2 = getPlayer(request,2);
		session.setAttribute("player1",player1);
		session.setAttribute("player2",player2);
		if (player1 instanceof Computer) {
			doPost(request,response);
			return;
		}
		player1.checkPutStone();
		dispatcherOthello.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションスコープからBoardを取得
		HttpSession session = request.getSession();
		Board board = (Board) session.getAttribute("board");
		//処理
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/othello.jsp");

		Player nowPlayer;
		Player nextPlayer;
		//置く
		if (board.getTurn() == 1) {
			nowPlayer = player1;
			nextPlayer = player2;
		} else {
			nowPlayer = player2;
			nextPlayer = player1;
		}

		int x = 0;
		int y = 0;
		if (nowPlayer instanceof Person) {
			//positionを取得
			int position = 0;
			position = Integer.parseInt(request.getParameter("position"));
			x = (position / 10) % 10;
			y = position % 10;
		}
		nowPlayer.putStone(x, y, true);
		if (!nextPlayer.checkPutStone()) {
			nextPlayer.pass(nowPlayer);
		}
		//継続確認
		if (board.continuetion()) {
			board.nextTurn();
			//if (nextPlayer instanceof Person) {
			dispatcher.forward(request, response);
			//}
			//else {
			//doPost(request,response);
			//}
		} else {
			board.checkClear();
			Player winner;
			if (board.winner() == 1) {
				winner = player1;
			} else {
				winner = player2;
			}
			request.setAttribute("winner", winner);
			request.setAttribute("white", Stone.white);
			request.setAttribute("black", Stone.black);
			dispatcher = request.getRequestDispatcher("WEB-INF/jsp/result.jsp");
			dispatcher.forward(request, response);
		}

	}

	protected Player getPlayer(HttpServletRequest request, int num)
			throws ServletException, IOException {
		Player player;
		HttpSession session = request.getSession();
		Object obj = session.getAttribute("player" + num);
		if (obj instanceof Person) {
			player = (Person)obj;
		} else{
			player = (Computer)obj;
		}
		return player;
	}


}
