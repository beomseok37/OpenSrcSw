package typing_game1;

import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread{
	private Image Game_NoteImage = new ImageIcon(Main.class.getResource("../image/Game_note.png")).getImage();
	private int x,y = 600-(1000/Main.SLEEP_TIME*Main.NOTE_SPEED)*Main.REACH_TIME;
	private boolean proceeded = true;
	private String noteType;
	private boolean pushed=false;
	public boolean getProceeded() {
		return proceeded;
	}
	public String getNoteType() {
		return noteType;
	}
	public int getY() {
		return y;
	}
	public void close() {
		proceeded=false;
	}
	public boolean getPushed() {
		return pushed;
	}
	public Note(String noteType) {
		this.noteType=noteType;
		if(noteType.equals("S")){
			x = 330;
		}
		else if(noteType.contentEquals("D")) {
			x = 434;
		}
		else if(noteType.contentEquals("F")) {
			x = 538;
		}
		else if(noteType.contentEquals("J")) {
			x = 642;
		}
		else if(noteType.contentEquals("K")) {
			x = 746;
		}
		else if(noteType.contentEquals("L")) {
			x = 850;
		}
		
	}
	
	public void screendraw(Graphics2D g) {
		g.drawImage(Game_NoteImage, x, y, null);
	}
	
	public void drop() {
		y+=Main.NOTE_SPEED;
		if(y > 650) {
			close();
		}
		
	}
	@Override
	public void run() {
		try {
			while(true) {
				drop();
				if(proceeded) {
					Thread.sleep(Main.SLEEP_TIME);
				}
				else {
					interrupt();
					break;
				}
			}
		}catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	public String judge() {
		if(y>640) {
			System.out.println("Late");
			close();
			pushed=true;
			return "Miss";
		}
		else if(y>630) {
			System.out.println("Good");
			close();
			pushed=true;
			return "Good";
		}
		else if(y>610) {
			System.out.println("Great");
			close();
			pushed=true;
			return "Great";
		}
		else if(y==600) {
			System.out.println("Perfect");
			close();
			pushed=true;
			return "Perfect";
		}
		else if(y>590) {
			System.out.println("Great");
			close();
			pushed=true;
			return "Great";
		}
		else if(y>580) {
			System.out.println("Good");
			close();
			pushed=true;
			return "Good";
		}
		else if(y>500) {
			System.out.println("Early");
			close();
			pushed=true;
			return "Miss";
		}
		else {
			
			return "None";
		}
	}
}
