package model;

public class Stone {
	private int color;
	public static int white;
	public static int black;
	
	
	public int getColor() {
		return color;
	}
	public void setColor(int color) {
		if(color == 1) {
			black++;
		}
		else if(color == -1) {
			white++;
		}
		this.color = color;
	}
	public void changeColor(int color) {
		if(color == 1) {
			this.color = 1;
			black++;
			white--;
		}
		else if(color == -1){
			this.color = -1;
			black--;
			white++;
		}
	}
}
