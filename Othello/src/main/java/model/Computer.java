package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Computer extends Player {
	private List<String> maxPosition = new ArrayList<>();

	public Computer(String name, Board board, int color) {

		super(name, board, color);
	}
	
	
	public int putStone(int x, int y,boolean flg) {
		return putStone(flg);
	}
	
	public int putStone(boolean flg) {
		/*try {
			for (int i = 0; i <= 3; i++) {
				Thread.sleep(1000);
				System.out.println("Sleep "+i);
			}
		}catch(Exception e) {
			System.out.println(e);
		}*/
		flg = checkPutStone();
		if(flg) {
		Collections.shuffle(maxPosition);
		int position = Integer.parseInt(maxPosition.get(0));
		int x = (position / 10) % 10;
		int y = position % 10;
		return super.putStone(x, y, flg);}
		return 0;
		
	}

	public boolean checkPutStone() {
		int count = 0; //反転する石の数
		int countMax = 0; //今までで一番多くひっくり返せる石の数
		int countPosition = 0; //ひっくり返せる座標の数
		maxPosition.clear();

		Board board = super.getBoard();
		board.checkClear();
		for (int x = 1; x <= 8; x++) {
			for (int y = 1; y <= 8; y++) {
				if (board.getStones()[x][y].getColor() == 0) {
					count = super.putStone(x, y, false);
					if (count != 0) {
						countPosition++;
						if (count > countMax) {
							maxPosition.clear();
							maxPosition.add(x + "" + y);
							countMax = count;
						}

						else if (count == countMax) {
							maxPosition.add(x + "" + y);
						}
					}
				}
			}
		}
		if (countPosition == 0) {
			board.setPassCount((board.getPassCount() + 1));
			return false;
		}
		return true;
	}
	

}
