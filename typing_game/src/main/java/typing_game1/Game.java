package typing_game1;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

public class Game extends Thread{
	private Image Game_BottomImage = new ImageIcon(Main.class.getResource("../image/Game_bottom.png")).getImage();
	private Image Game_JudgeBarImage = new ImageIcon(Main.class.getResource("../image/Game_judgeBar.png")).getImage();
	private Image Game_NoteLine_SImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_DImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_FImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_JImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_KImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	private Image Game_NoteLine_LImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	
	private Image Game_S = new ImageIcon(Main.class.getResource("../image/Game_S.png")).getImage();
	private Image Game_D = new ImageIcon(Main.class.getResource("../image/Game_D.png")).getImage();
	private Image Game_F = new ImageIcon(Main.class.getResource("../image/Game_F.png")).getImage();
	private Image Game_J = new ImageIcon(Main.class.getResource("../image/Game_J.png")).getImage();
	private Image Game_K = new ImageIcon(Main.class.getResource("../image/Game_K.png")).getImage();
	private Image Game_L = new ImageIcon(Main.class.getResource("../image/Game_L.png")).getImage();
	
	ArrayList<Note> Notelist = new ArrayList<Note>();
	
	public void screenDraw(Graphics2D g, int nowTrack) {
		
		g.drawImage(Game_NoteLine_SImage, 330, 0, null);
		g.drawImage(Game_NoteLine_DImage, 434, 0, null);
		g.drawImage(Game_NoteLine_FImage, 538, 0, null);
		g.drawImage(Game_NoteLine_JImage, 642, 0, null);
		g.drawImage(Game_NoteLine_KImage, 746, 0, null);
		g.drawImage(Game_NoteLine_LImage, 850, 0, null);
		g.drawImage(Game_BottomImage, 0, 680, null);
		g.drawImage(Game_JudgeBarImage, 0, 600, null);
		for(int i=0;i<Notelist.size();i++) {
			Note note=Notelist.get(i);
			if(!note.getProceeded()) {
				Notelist.remove(i);
				i--;
			}
			else {
				note.screendraw(g);
			}
		}
		g.drawImage(Game_S, 330, 600, null);
		g.drawImage(Game_D, 434, 600, null);
		g.drawImage(Game_F, 538, 600, null);
		g.drawImage(Game_J, 642, 600, null);
		g.drawImage(Game_K, 746, 600, null);
		g.drawImage(Game_L, 850, 600, null);
		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		if(nowTrack==0)g.drawString("Me After You - Paul Kim", 20,710);
		if(nowTrack==1)g.drawString("Canon - Johan Pachelbel", 20,710);
		if(nowTrack==2)g.drawString("Sleeping Beauty - Paul", 20,710);
	}
	
	private String titleName;	//노래 제목
	private String titleMusic;	//실행되는 노래파일 이름
	private Music gameMusic;	//노래 객체
	
	
	
	public Game(String titleName,String titleMusic) {
		this.titleName=titleName;
		this.titleMusic=titleMusic;
		gameMusic=new Music(this.titleMusic,false);
		this.start();
	}
	public void pressS() {
		judge("S");
		Game_NoteLine_SImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseS() {
		Game_NoteLine_SImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	public void pressD() {
		judge("D");
		Game_NoteLine_DImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseD() {
		Game_NoteLine_DImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	public void pressF() {
		judge("F");
		Game_NoteLine_FImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseF() {
		Game_NoteLine_FImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	public void pressJ() {
		judge("J");
		Game_NoteLine_JImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseJ() {
		Game_NoteLine_JImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	public void pressK() {
		judge("K");
		Game_NoteLine_KImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseK() {
		Game_NoteLine_KImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	public void pressL() {
		judge("L");
		Game_NoteLine_LImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine_Pushed.png")).getImage();
	}
	public void releaseL() {
		Game_NoteLine_LImage = new ImageIcon(Main.class.getResource("../image/Game_noteLine.png")).getImage();
	}
	@Override
	public void run() {
		
		dropNotes(this.titleName);
	}
	
	public void close() {
		gameMusic.close();
		//this.interrupt();
	}
	public String randomNote() {
		int rand = (int)(Math.random()*10)%6;
		if(rand==0)return "S";
		else if(rand==1)return "D";
		else if(rand==2)return "F";
		else if(rand==3)return "J";
		else if(rand==4)return "K";
		else return "L";
	}
	public void dropNotes(String titleName) {
		ArrayList<Beat> beats = null;
		if(titleName.contentEquals("meet you")) {
			int startTime = 3400-1000*Main.REACH_TIME;
			beats = new ArrayList<Beat>();
			beats.add(new Beat(1200,"F"));
			beats.add(new Beat(4700,"D"));
			beats.add(new Beat(5500,"S"));
			beats.add(new Beat(8050,"J"));
			beats.add(new Beat(11300,"D"));
			beats.add(new Beat(11700,"F"));
			beats.add(new Beat(12100,"J"));
			beats.add(new Beat(12500,"K"));
			beats.add(new Beat(12900,"L"));
			
			beats.add(new Beat(14700,"K"));
			beats.add(new Beat(15100,"J"));
			beats.add(new Beat(15400,"L"));
			
			beats.add(new Beat(18100,"D"));
			beats.add(new Beat(18500,"S"));
			beats.add(new Beat(18900,"F"));
			
			beats.add(new Beat(21400,"S"));
			beats.add(new Beat(21400,"F"));
			
			beats.add(new Beat(24800,"D"));
			beats.add(new Beat(24800,"F"));
			beats.add(new Beat(25600,"J"));
			beats.add(new Beat(26400,"S"));
			beats.add(new Beat(27300,"K"));
			
			beats.add(new Beat(28100,"D"));//식탁위에
			beats.add(new Beat(28500,"S"));
			beats.add(new Beat(28800,"F"));
			
			beats.add(new Beat(31200,"L"));//마주앉아
			beats.add(new Beat(31600,"J"));
			beats.add(new Beat(32000,"K"));
			
			beats.add(new Beat(34700,"D"));//너의하루는
			beats.add(new Beat(35100,"S"));
			beats.add(new Beat(35500,"F"));
			
			beats.add(new Beat(38100,"L"));//어땠는지 묻거나
			beats.add(new Beat(38500,"J"));
			beats.add(new Beat(38900,"K"));
			
			beats.add(new Beat(39800,"D"));//나의 하루도 
			beats.add(new Beat(40200,"S"));
			
			beats.add(new Beat(41500,"F"));
			
			beats.add(new Beat(42300,"D"));
			beats.add(new Beat(42600,"F"));
			beats.add(new Beat(42900,"J"));
			
			beats.add(new Beat(44900,"F"));//썩괜찮았어
			beats.add(new Beat(45200,"S"));
			beats.add(new Beat(45500,"D"));
			beats.add(new Beat(45800,"J"));
			beats.add(new Beat(46100,"D"));
			
			beats.add(new Beat(48200,"K"));
			
			beats.add(new Beat(49800,"J"));
			
			beats.add(new Beat(51000,"J"));//웃으며 대답해주고 싶어
			beats.add(new Beat(51400,"D"));
			beats.add(new Beat(51800,"F"));
			beats.add(new Beat(52000,"J"));
			beats.add(new Beat(52200,"K"));
			beats.add(new Beat(52500,"D"));
			
			beats.add(new Beat(53000,"D"));
			beats.add(new Beat(53400,"K"));
			beats.add(new Beat(53600,"K"));
			beats.add(new Beat(54000,"K"));
			beats.add(new Beat(54800,"K"));
			
			beats.add(new Beat(55200,"D"));//별것 아닌일에
			beats.add(new Beat(55600,"S"));
			beats.add(new Beat(56000,"D"));
			beats.add(new Beat(56400,"F"));
			beats.add(new Beat(56800,"F"));
			beats.add(new Beat(57200,"F"));
			
			beats.add(new Beat(58400,"L"));
			beats.add(new Beat(58800,"K"));
			beats.add(new Beat(59200,"J"));
			beats.add(new Beat(59600,"K"));
			beats.add(new Beat(60000,"L"));
			
			beats.add(new Beat(60400,"S"));
			beats.add(new Beat(60800,"D"));
			beats.add(new Beat(61200,"F"));
			beats.add(new Beat(61600,"F"));
			beats.add(new Beat(62000,"F"));
			
			beats.add(new Beat(62500,"K"));
			beats.add(new Beat(62800,"D"));
			beats.add(new Beat(63200,"S"));
			beats.add(new Beat(63700,"J"));
			beats.add(new Beat(64000,"K"));
			
			beats.add(new Beat(64400,"D"));
			beats.add(new Beat(64800,"D"));
			beats.add(new Beat(65200,"S"));
			beats.add(new Beat(65600,"F"));
			beats.add(new Beat(67000,"J"));
			
			beats.add(new Beat(67400,"J"));
			beats.add(new Beat(67800,"J"));
			beats.add(new Beat(68200,"D"));
			beats.add(new Beat(68600,"S"));
			beats.add(new Beat(69000,"L"));
			
			beats.add(new Beat(69500,"K"));
			beats.add(new Beat(69900,"D"));
			beats.add(new Beat(70200,"S"));
			beats.add(new Beat(70300,"J"));
			beats.add(new Beat(70700,"K"));
			
			beats.add(new Beat(71100,"D"));
			beats.add(new Beat(71400,"D"));
			beats.add(new Beat(71800,"S"));
			beats.add(new Beat(72000,"F"));
			beats.add(new Beat(72200,"J"));
			
			beats.add(new Beat(72400,"J"));
			beats.add(new Beat(72600,"J"));
			beats.add(new Beat(73000,"D"));
			beats.add(new Beat(73400,"S"));
			beats.add(new Beat(73800,"L"));
			
			beats.add(new Beat(74200,"S"));
			beats.add(new Beat(74600,"D"));
			beats.add(new Beat(75000,"F"));
			beats.add(new Beat(75200,"F"));
			beats.add(new Beat(75400,"J"));
			
			beats.add(new Beat(75800,"K"));
			beats.add(new Beat(76200,"J"));
			beats.add(new Beat(76600,"K"));
			beats.add(new Beat(77000,"L"));
			beats.add(new Beat(77500,"L"));
			
			beats.add(new Beat(77900,"D"));
			beats.add(new Beat(78200,"D"));
			beats.add(new Beat(78500,"F"));
			beats.add(new Beat(78800,"F"));
			beats.add(new Beat(79500,"K"));
			
			beats.add(new Beat(79800,"L"));
			beats.add(new Beat(80200,"K"));
			beats.add(new Beat(80600,"J"));
			beats.add(new Beat(81000,"K"));
			beats.add(new Beat(81400,"L"));
			
			beats.add(new Beat(81600,"D"));
			beats.add(new Beat(81800,"F"));
			beats.add(new Beat(82100,"J"));
			beats.add(new Beat(82500,"K"));
			beats.add(new Beat(82800,"K"));
			
			beats.add(new Beat(83200,"J"));
			beats.add(new Beat(83500,"F"));
			beats.add(new Beat(83800,"D"));
			beats.add(new Beat(84200,"S"));
			beats.add(new Beat(84500,"S"));
			
			beats.add(new Beat(85000,"S"));//너를 만나
			beats.add(new Beat(85500,"D"));
			beats.add(new Beat(86000,"F"));
			beats.add(new Beat(86500,"F"));
			beats.add(new Beat(87000,"K"));
			
			beats.add(new Beat(87500,"J"));
			beats.add(new Beat(88000,"F"));
			beats.add(new Beat(88500,"J"));
			beats.add(new Beat(89000,"K"));
			beats.add(new Beat(89500,"L"));
			
			beats.add(new Beat(90000,"D"));
			beats.add(new Beat(90500,"F"));
			beats.add(new Beat(91000,"J"));
			beats.add(new Beat(91500,"K"));
			beats.add(new Beat(92000,"K"));
			
			beats.add(new Beat(92500,"J"));
			beats.add(new Beat(93000,"F"));
			beats.add(new Beat(93500,"D"));
			beats.add(new Beat(94000,"S"));
			beats.add(new Beat(94500,"S"));
			
			beats.add(new Beat(95000,"D"));
			beats.add(new Beat(95500,"F"));
			beats.add(new Beat(96000,"J"));
			beats.add(new Beat(96500,"K"));
			beats.add(new Beat(97000,"K"));
			
			beats.add(new Beat(97500,"F"));
			beats.add(new Beat(98000,"F"));
			beats.add(new Beat(98500,"D"));
			beats.add(new Beat(99000,"S"));
			beats.add(new Beat(99500,"S"));
			
			beats.add(new Beat(100000,"J"));//따듯한 이해로 다 안아줘서
			beats.add(new Beat(100500,"K"));
			beats.add(new Beat(101000,"L"));
			beats.add(new Beat(101500,"L"));
			beats.add(new Beat(102000,"K"));
			
			beats.add(new Beat(102500,"J"));
			beats.add(new Beat(103000,"F"));
			beats.add(new Beat(103500,"D"));
			beats.add(new Beat(104000,"S"));
			beats.add(new Beat(104500,"S"));
		}
		else if(titleName.contentEquals("Canon")) {
			beats = new ArrayList<Beat>();
			int startPos=1000;
			int gap=400;
			for(int i=0;i<330;i++) {
				beats.add(new Beat(startPos+gap*i,randomNote()));
			}
		}
		if(titleName.contentEquals("sleepingbeauty")) {
			beats = new ArrayList<Beat>();
			int startPos=1000;
			int gap=500;
			for(int i=0;i<355;i++) {
				beats.add(new Beat(startPos+gap*i,randomNote()));
			}
		}
		gameMusic.start();
		int idx=0;
		while(true) {
			if(beats.get(idx).getTime()<=gameMusic.getTime()) {
				Note note = new Note(beats.get(idx).getNoteName());
				note.start();
				Notelist.add(note);
				idx++;
			}
		}
	}
	
	public void judge(String input) {
		for(int i=0;i<Notelist.size();i++) {
			Note note=Notelist.get(i);
			if(input==note.getNoteType()) {
				note.judge();
				break;
			}
		}
	}
	
}
