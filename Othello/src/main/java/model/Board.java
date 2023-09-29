package model;

import java.io.Serializable;

public class Board implements Serializable {

	private Stone[][] stones = new Stone[10][10];
	private int passCount = 0;
	private int turn = 1;

	public Board() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				stones[i][j] = new Stone();
			}
		}
		Stone.white = 0;
		Stone.black = 0;
		stones[4][5].setColor(-1);
		stones[5][4].setColor(-1);
		stones[4][4].setColor(1);
		stones[5][5].setColor(1);
	}
	
	public void reset() {
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				stones[i][j].setColor(0);
			}
		}
		Stone.white = 0;
		Stone.black = 0;
		stones[4][5].setColor(-1);
		stones[5][4].setColor(-1);
		stones[4][4].setColor(1);
		stones[5][5].setColor(1);
		turn = 1;
		passCount = 0;
	}
	
	public void checkClear(){
		for (int x = 1; x <= 8; x++) {
			for (int y = 1; y <= 8; y++) {
				if (stones[x][y].getColor() == 10) {
					stones[x][y].setColor(0);
				}
			}
		}
	}

	public int winner() {
		if(Stone.white < Stone.black) {
			return 1;
		}
		else if(Stone.white > Stone.black) {
			return -1;
		}
		return 0;
	}
	
	public Stone[][] getStones() {
		return stones;
	}

	public void setStones(Stone[][] stones, int x, int y) {
		this.stones[x][y] = stones[x][y];
	}

	public int getTurn() {
		return turn;
	}

	public void setTurn(int turn) {
		this.turn = turn;
	}

	public void nextTurn() {
		if (this.turn == 1) {
			this.turn = -1;
		} else if(this.turn == -1){
			this.turn = 1;
		}
		
	}

	public boolean continuetion() {
		
		if(passCount >= 2) {
			return  false;
		}
		if ((Stone.white + Stone.black) < 64 && Stone.white != 0 && Stone.black != 0) {
			return true;
		}
		return false;
	}
	
	
	public void kakunin() {
		for (int i = 0; i <= 9; i++) {
			for (int j = 0; j <= 9; j++) {
				if (j == 9) {
					System.out.println(stones[i][j].getColor());
				} else {
					System.out.print(stones[i][j].getColor());
				}
			}
		}
	}

	public int getPassCount() {
		return passCount;
	}

	public void setPassCount(int passCount) {
		this.passCount = passCount;
	}

}
