package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Player implements Serializable {
	private String name;
	private int color;
	private Board board;

	public Player() {
	}

	public Player(String name, Board board, int color) {
		this.name = name;
		this.color = color;
		this.board = board;
	}

	public boolean equals(Player player) {
		if(this.name == player.getName() &&
		   this.color == player.getColor() 
		   ) {
			return true;
		}
		return false;
	}
	
	
	public int putStone(int x, int y, boolean flg) {
		
		int count = 0;
		if (flg) {
			board.setPassCount(0);
			board.getStones()[x][y].setColor(color);
		}

		count =   upperMiddle(x, y, flg)
				+ upperRight(x, y, flg)
				+ middleRight(x, y, flg)
				+ lowerRight(x, y, flg)
				+ lowerMiddle(x, y, flg)
				+ lowerLeft(x, y, flg)
				+ middleLeft(x, y, flg)
				+ upperLeft(x, y, flg);
		
		return count;
	}
	
	public boolean checkPutStone() {
		int count = 0;         //反転する石の数
		int countPosition = 0; //ひっくり返せる座標の数
		board.checkClear();
		for (int x = 1; x <= 8; x++) {
			for (int y = 1; y <= 8; y++) {
				if (board.getStones()[x][y].getColor() == 0) {
					count = putStone(x, y, false);
					if (count != 0) {
						countPosition++;
						board.getStones()[x][y].setColor(10);
					}
				}
			}
		}
		if(countPosition == 0){
			board.setPassCount((board.getPassCount() + 1));
			return false;
		}
		return true;
	}
	

	public void pass(Player otherPlayer) {
		otherPlayer.checkPutStone();
		board.nextTurn();
	}

	public String getName() {
		return this.name;
	}

	public int getColor() {
		return color;
	}

	public void setColor(int color) {
		this.color = color;
	}

	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public int upperMiddle(int x, int y, boolean flg) {
		int i = 0;
		int j = 0;
		int color = getColor();

		//反転可能な石があるか判定します
		for (i = 1; i < (10 - y); i++) {
			//空白に突き当たった場合処理を終了します。盤外も空白扱いです。
			if (board.getStones()[x][y + i].getColor() == 0 || board.getStones()[x][y + i].getColor() == 10) {
				return 0;
			}
			/*同じ色に突き当たった場合、その一マス前が違う色か確認し、そうであれば突き当たったマスと最初のマスの間の石をすべてひっくり返します
			 * 1マス先は処理対象外 */
			else if (color == board.getStones()[x][y + i].getColor()) {
				if (i == 1) {
					return 0;
				} else {
					if (flg) {
						for (j = 1; j < i; j++) {
							board.getStones()[x][y + j].changeColor(color);
						}
					}
					return i - 1;
				}
			}
		}
		return 0;
	}

	public int upperRight(int x, int y, boolean flg) {
		int i = 0;
		int j = 0;
		int color = getColor();

		//反転可能な石があるか判定します
		for (i = 1; i < (10 - x) && i < (10 - y); i++) {

			//空白に突き当たった場合処理を終了します。盤外も空白扱いです。
			if (board.getStones()[x + i][y + i].getColor() == 0 || board.getStones()[x + i][y + i].getColor() == 10) {
				return 0;
			}
			/*同じ色に突き当たった場合、その一マス前が違う色か確認し、そうであれば突き当たったマスと最初のマスの間の石をすべてひっくり返します
			 * 1マス先は処理対象外 */
			else if (color == board.getStones()[x + i][y + i].getColor()) {
				if (i == 1) {
					return 0;
				} else {
					if (flg) {
						for (j = 1; j < i; j++) {
							board.getStones()[x + j][y + j].changeColor(color);
						}
					}
					return i - 1;
				}
			}
		}
		return 0;
	}

	public int middleRight(int x, int y, boolean flg) {
		int i = 0;
		int j = 0;
		int color = getColor();

		//反転可能な石があるか判定します
		for (i = 1; i < (10 - x); i++) {

			//空白に突き当たった場合処理を終了します。盤外も空白扱いです。
			if (board.getStones()[x + i][y].getColor() == 0 || board.getStones()[x + i][y].getColor() == 10) {
				return 0;
			}
			/*同じ色に突き当たった場合、その一マス前が違う色か確認し、そうであれば突き当たったマスと最初のマスの間の石をすべてひっくり返します
			 * 1マス先は処理対象外 */
			else if (color == board.getStones()[x + i][y].getColor()) {
				if (i == 1) {
					return 0;
				} else {
					if (flg) {
						for (j = 1; j < i; j++) {
							board.getStones()[x + j][y].changeColor(color);
						}
					}
					return i - 1;
				}
			}
		}
		return 0;
	}

	public int lowerRight(int x, int y, boolean flg) {
		int i = 0;
		int j = 0;
		int color = getColor();

		//反転可能な石があるか判定します
		for (i = 1; i < (10 - x) && i <= y; i++) {

			//空白に突き当たった場合処理を終了します。盤外も空白扱いです。
			if (board.getStones()[x + i][y - i].getColor() == 0 || board.getStones()[x + i][y - i].getColor() == 10) {
				return 0;
			}
			/*同じ色に突き当たった場合、その一マス前が違う色か確認し、そうであれば突き当たったマスと最初のマスの間の石をすべてひっくり返します
			 * 1マス先は処理対象外 */
			else if (color == board.getStones()[x + i][y - i].getColor()) {
				if (i == 1) {
					return 0;
				} else {
					if (flg) {
						for (j = 1; j < i; j++) {
							board.getStones()[x + j][y - j].changeColor(color);
						}
					}
					return i - 1;
				}
			}
		}
		return 0;
	}

	public int lowerMiddle(int x, int y, boolean flg) {
		int i = 0;
		int j = 0;
		int color = getColor();

		//反転可能な石があるか判定します
		for (i = 1; i <= y; i++) {

			//空白に突き当たった場合処理を終了します。盤外も空白扱いです。
			if (board.getStones()[x][y - i].getColor() == 0 || board.getStones()[x][y - i].getColor() == 10) {
				return 0;
			}
			/*同じ色に突き当たった場合、その一マス前が違う色か確認し、そうであれば突き当たったマスと最初のマスの間の石をすべてひっくり返します
			 * 1マス先は処理対象外 */
			else if (color == board.getStones()[x][y - i].getColor()) {
				if (i == 1) {
					return 0;
				} else {
					if (flg) {
						for (j = 1; j < i; j++) {
							board.getStones()[x][y - j].changeColor(color);
						}
					}
					return i - 1;
				}
			}
		}
		return 0;
	}

	public int lowerLeft(int x, int y, boolean flg) {
		int i = 0;
		int j = 0;
		int color = getColor();

		//反転可能な石があるか判定します
		for (i = 1; i <= x && i <= y; i++) {

			//空白に突き当たった場合処理を終了します。盤外も空白扱いです。
			if (board.getStones()[x - i][y - i].getColor() == 0 || board.getStones()[x - i][y - i].getColor() == 10) {
				return 0;
			}
			/*同じ色に突き当たった場合、その一マス前が違う色か確認し、そうであれば突き当たったマスと最初のマスの間の石をすべてひっくり返します
			 * 1マス先は処理対象外 */
			else if (color == board.getStones()[x - i][y - i].getColor()) {
				if (i == 1) {
					return 0;
				} else {
					if (flg) {
						for (j = 1; j < i; j++) {
							board.getStones()[x - j][y - j].changeColor(color);
						}
					}
					return i - 1;
				}
			}
		}
		return 0;
	}

	public int middleLeft(int x, int y, boolean flg) {
		int i = 0;
		int j = 0;
		int color = getColor();

		//反転可能な石があるか判定します
		for (i = 1; i <= x; i++) {

			//空白に突き当たった場合処理を終了します。盤外も空白扱いです。
			if (board.getStones()[x - i][y].getColor() == 0 || board.getStones()[x - i][y].getColor() == 10) {
				return 0;
			}
			/*同じ色に突き当たった場合、その一マス前が違う色か確認し、そうであれば突き当たったマスと最初のマスの間の石をすべてひっくり返します
			 * 1マス先は処理対象外 */
			else if (color == board.getStones()[x - i][y].getColor()) {
				if (i == 1) {
					return 0;
				} else {
					if (flg) {
						for (j = 1; j < i; j++) {
							board.getStones()[x - j][y].changeColor(color);
						}
					}
					return i - 1;
				}
			}
		}
		return 0;
	}

	public int upperLeft(int x, int y, boolean flg) {
		int i = 0;
		int j = 0;
		int color = getColor();

		//反転可能な石があるか判定します
		for (i = 1; i <= x && i < (10 - y); i++) {

			//空白に突き当たった場合処理を終了します。盤外も空白扱いです。
			if (board.getStones()[x - i][y + i].getColor() == 0 || board.getStones()[x - i][y + i].getColor() == 10) {
				return 0;
			}
			/*同じ色に突き当たった場合、その一マス前が違う色か確認し、そうであれば突き当たったマスと最初のマスの間の石をすべてひっくり返します
			 * 1マス先は処理対象外 */
			else if (color == board.getStones()[x - i][y + i].getColor()) {
				if (i == 1) {
					return 0;
				} else {
					if (flg) {
						for (j = 1; j < i; j++) {
							board.getStones()[x - j][y + j].changeColor(color);
						}
					}
					return i - 1;
				}
			}
		}
		return 0;
	}

}
