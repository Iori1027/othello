package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Board;
import model.Computer;
import model.Person;
import model.Player;

/**
 * Servlet implementation class Setting
 */
@WebServlet("/Setting")
public class Setting extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Setting() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/setting.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		String firstPlayerName = request.getParameter("firstPlayerName");
		String firstProperty = request.getParameter("firstProperty");
		String secondPlayerName = request.getParameter("SecondPlayerName");
		String secondProperty = request.getParameter("SecondProperty");
		HttpSession session = request.getSession();
		Board board = (Board) session.getAttribute("board");
		
		//ゲームの初期化
		if (board == null) {
			board = new Board();
		}
		session.setAttribute("board", board);
		Player player1;
		Player player2;
		if (firstProperty.equals("Computer")) {
			player1 = new Computer(firstPlayerName ,board,1);
		} else {
			
			player1 = new Person(firstPlayerName ,board,1);
		}
		if (secondProperty.equals("Computer")) {
			player2 = new Computer(secondPlayerName ,board,-1);
		} else {
			player2 = new Person(secondPlayerName ,board,-1);
		}
		for(int i = 1;i <= 2; i++) {
			session.removeAttribute("player" + i);
		}
		session.setAttribute("player1", player1);
		session.setAttribute("player2", player2);
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/jsp/menu.jsp");
		dispatcher.forward(request, response);

	}

}
