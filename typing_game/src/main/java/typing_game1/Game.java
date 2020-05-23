package typing_game1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import javax.swing.ImageIcon;

public class Game extends Thread{
	private Image Game_BottomImage = new ImageIcon(Main.class.getResource("../image/Game_bottom.png")).getImage();
	private Image Game_JudgeBarImage = new ImageIcon(Main.class.getResource("../image/Game_judgeBar.png")).getImage();
	private Image Game_NoteImage = new ImageIcon(Main.class.getResource("../image/Game_note.png")).getImage();
	private Image Game_NoteLine_SImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_DImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_FImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_SPACE1Image = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_SPACE2Image = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_JImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_KImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_LImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	
	private Image Game_S = new ImageIcon(Main.class.getResource("../image/Game_S.png")).getImage();
	private Image Game_D = new ImageIcon(Main.class.getResource("../image/Game_D.png")).getImage();
	private Image Game_F = new ImageIcon(Main.class.getResource("../image/Game_F.png")).getImage();
	private Image Game_spacebar = new ImageIcon(Main.class.getResource("../image/Game_spacebar.png")).getImage();
	private Image Game_J = new ImageIcon(Main.class.getResource("../image/Game_J.png")).getImage();
	private Image Game_K = new ImageIcon(Main.class.getResource("../image/Game_K.png")).getImage();
	private Image Game_L = new ImageIcon(Main.class.getResource("../image/Game_L.png")).getImage();
	
	public void screenDraw(Graphics2D g, int nowTrack) {
		
		g.drawImage(Game_NoteLine_SImage, 228, 0, null);
		g.drawImage(Game_NoteLine_DImage, 332, 0, null);
		g.drawImage(Game_NoteLine_FImage, 436, 0, null);
		g.drawImage(Game_NoteLine_SPACE1Image, 540, 0, null);
		g.drawImage(Game_NoteLine_SPACE2Image, 640, 0, null);
		g.drawImage(Game_NoteLine_JImage, 744, 0, null);
		g.drawImage(Game_NoteLine_KImage, 848, 0, null);
		g.drawImage(Game_NoteLine_LImage, 952, 0, null);
		g.drawImage(Game_BottomImage, 0, 680, null);
		g.drawImage(Game_JudgeBarImage, 0, 600, null);
		g.drawImage(Game_NoteImage, 332, 440, null);
		g.drawImage(Game_S, 228, 600, null);
		g.drawImage(Game_D, 332, 600, null);
		g.drawImage(Game_F, 436, 600, null);
		g.drawImage(Game_spacebar, 540, 600, null);
		g.drawImage(Game_J, 744, 600, null);
		g.drawImage(Game_K, 848, 600, null);
		g.drawImage(Game_L, 952, 600, null);
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		if(nowTrack==0)g.drawString("Me After You - Paul Kim", 20,710);
		if(nowTrack==1)g.drawString("Canon - Johan Pachelbel", 20,710);
		if(nowTrack==2)g.drawString("Sleeping Beauty - Paul", 20,710);
	}
	
	public void pressS() {
		Game_NoteLine_SImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseS() {
		Game_NoteLine_SImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	public void pressD() {
		Game_NoteLine_DImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseD() {
		Game_NoteLine_DImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	public void pressF() {
		Game_NoteLine_FImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseF() {
		Game_NoteLine_FImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	public void pressSPACE() {
		Game_NoteLine_SPACE1Image = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
		Game_NoteLine_SPACE2Image = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseSPACE() {
		Game_NoteLine_SPACE1Image = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
		Game_NoteLine_SPACE2Image = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	public void pressJ() {
		Game_NoteLine_JImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseJ() {
		Game_NoteLine_JImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	public void pressK() {
		Game_NoteLine_KImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseK() {
		Game_NoteLine_KImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	public void pressL() {
		Game_NoteLine_LImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseL() {
		Game_NoteLine_LImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	@Override
	public void run() {
		
	}
}
