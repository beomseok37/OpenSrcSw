package typing_game1;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TypingGame extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;

	private ImageIcon basicExitButtonImage = new ImageIcon(Main.class.getResource("../image/basicExitButton.png"));
	private ImageIcon enteredExitButtonImage = new ImageIcon(Main.class.getResource("../image/enteredExitButton.png"));
	private ImageIcon basicStartButtonImage = new ImageIcon(Main.class.getResource("../image/basicStartButton.png"));
	private ImageIcon enteredStartButtonImage = new ImageIcon(Main.class.getResource("../image/enteredStartButton.png"));
	private ImageIcon basicQuitButtonImage = new ImageIcon(Main.class.getResource("../image/basicQuitButton.png"));
	private ImageIcon enteredQuitButtonImage = new ImageIcon(Main.class.getResource("../image/enteredQuitButton.png"));
	private ImageIcon basicLeftButtonImage = new ImageIcon(Main.class.getResource("../image/basicSelectLeft.png"));
	private ImageIcon basicRightButtonImage = new ImageIcon(Main.class.getResource("../image/basicSelectRight.png"));
	private ImageIcon enteredLeftButtonImage = new ImageIcon(Main.class.getResource("../image/enteredSelectLeft.png"));
	private ImageIcon enteredRightButtonImage = new ImageIcon(Main.class.getResource("../image/enteredSelectRight.png"));
	private ImageIcon basicBackButtonImage = new ImageIcon(Main.class.getResource("../image/basicBackImage.png"));
	private ImageIcon enteredBackButtonImage = new ImageIcon(Main.class.getResource("../image/enteredBackImage.png"));
	private ImageIcon basicSelectGameImage = new ImageIcon(Main.class.getResource("../image/basicSelectGame.png"));
	private ImageIcon enteredSelectGameImage = new ImageIcon(Main.class.getResource("../image/enteredSelectGame.png"));
	

	private JLabel menuBar = new JLabel(new ImageIcon(Main.class.getResource("../image/menuBar2.png")));
	private JButton exitButton = new JButton(basicExitButtonImage);
	private JButton startButton = new JButton(basicStartButtonImage);
	private JButton quitButton = new JButton(basicQuitButtonImage);
	private JButton LeftButton = new JButton(basicLeftButtonImage);
	private JButton RightButton = new JButton(basicRightButtonImage);
	private JButton BackButton = new JButton(basicBackButtonImage);
	private JButton SelectGameButton = new JButton(basicSelectGameImage);
	
	
	private int mouseX, mouseY;
	
	ArrayList<Track> trackList = new ArrayList<Track>();
	ArrayList<Screen> screenList = new ArrayList<Screen>();
	
	private Image Background;
	private Image titleImage;		//노래선택화면의 노래 제목 이미지
	private Image InformationImage = new ImageIcon(Main.class.getResource("../image/InformationImage.png")).getImage();

	
	private Music startMusic = new Music("startmusic.mp3",true);	//시작화면 노래
	private Music playingMusic;		//노래선택화면의 해당 트랙의 노래
	private Image albumImage;		//노래선택화면의 노래 앨범 이미지
	private int nowTrack = 0;		//현재 트랙
	private int nowScreen = 0;		//현재 화면
	
	public static Game game = new Game();
	
	public TypingGame() {
		setUndecorated(true);
		setTitle("Typing Game");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);
		
		LeftButton.setVisible(false);
		RightButton.setVisible(false);
		BackButton.setVisible(false);
		SelectGameButton.setVisible(false);
		trackList.add(new Track("meetyou_title.png","Meetyou_Album.png", "Meetyou_Game.jpg", "meetyou.highlight.mp3", "meetyou.mp3"));
		trackList.add(new Track("canon_title.png","Canon_Album.png", "Canon_Game.jpg", "canon.mp3", "canon.mp3"));
		trackList.add(new Track("sleepingbeauty_title.png","Sleeping Beauty_Album.png", "Sleeping Beauty_Game.jpg", "Sleeping Beauty.highlight.mp3", "Sleeping Beuaty.mp3"));
		screenList.add(new Screen("startImage2.png"));			//screenList.get(0) == 시작화면
		screenList.add(new Screen("gameSelectPage.jpg"));		//screenList.get(1) == 노래선택화면
		screenList.add(new Screen(trackList.get(0).getGameImage()));	//screenList.get(2) == 너름만나 게임화면
		screenList.add(new Screen(trackList.get(1).getGameImage()));	//screenList.get(3) == 캐논변주곡 게임화면
		screenList.add(new Screen(trackList.get(2).getGameImage()));	//screenList.get(4) == sleeping beauty 게임화면
		
		selectScreen(nowScreen);
		startMusic.start();
		
		addKeyListener(new KeyListener());
		
		exitButton.setBounds(1232, 0, 48, 30);	//상단 오른쪽의 나가기 버튼
		exitButton.setBorderPainted(false);		//외곽 색칠
		exitButton.setContentAreaFilled(false);	//해당 이미지의 피픽영역 채울 것인지
		exitButton.setFocusPainted(false);		//선택했을 때 테두리 설정
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {	//마우스가 이미지 안에 들어간 경우
				exitButton.setIcon(enteredExitButtonImage);	//이미지가 enteredExitButtonImage로 바뀐다.
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));	//커서의 이미지 바꿈
			}
			@Override
			public void mouseExited(MouseEvent e) {	//마우스가 이미지를 벗어났을 경우
				exitButton.setIcon(basicExitButtonImage);	//이미지가 basicExitButtonImage로 바뀐다.
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));	//커서의 이미지가 원래대로 돌아 온다.
			}
			@Override
			public void mousePressed(MouseEvent e) {	//이미지를 클릭할 경우
				try {
					Thread.sleep(1000);	//1초 뒤 프로그램이 종료 된다.
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);
		
		startButton.setBounds(490, 330, 300, 75);	//시작화면에서 시작버튼
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(enteredStartButtonImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(basicStartButtonImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				goSelect();
			}
		});
		add(startButton);
		
		quitButton.setBounds(490, 420, 300, 75);	//시작화면에서 종료버튼
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(enteredQuitButtonImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(basicQuitButtonImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				try {
					Thread.sleep(1000);
				}catch(InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);
		
		menuBar.setBounds(0, 0, 1280, 30);	//화면 상단
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);

		LeftButton.setBounds(230, 310, 85, 100);	//음악고르기 왼쪽 버튼
		LeftButton.setBorderPainted(false);
		LeftButton.setContentAreaFilled(false);
		LeftButton.setFocusPainted(false);
		LeftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				LeftButton.setIcon(enteredLeftButtonImage);
				LeftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				LeftButton.setIcon(basicLeftButtonImage);
				LeftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectLeft();
			}
		});
		add(LeftButton);
		
		RightButton.setBounds(965, 310, 85, 100);	//음악고르기 오른쪽 버튼
		RightButton.setBorderPainted(false);
		RightButton.setContentAreaFilled(false);
		RightButton.setFocusPainted(false);
		RightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				RightButton.setIcon(enteredRightButtonImage);
				RightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				RightButton.setIcon(basicRightButtonImage);
				RightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				selectRight();
			}
		});
		add(RightButton);
		
		BackButton.setBounds(30, 50, 160, 80);	//게임 선택화면에서 시작화면으로
		BackButton.setBorderPainted(false);
		BackButton.setContentAreaFilled(false);
		BackButton.setFocusPainted(false);
		BackButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				BackButton.setIcon(enteredBackButtonImage);
				BackButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				BackButton.setIcon(basicBackButtonImage);
				BackButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				Back();
			}
		});
		add(BackButton);
		
		SelectGameButton.setBounds(390, 50, 500, 500);	//음악고르기 오른쪽 버튼
		SelectGameButton.setBorderPainted(false);
		SelectGameButton.setContentAreaFilled(false);
		SelectGameButton.setFocusPainted(false);
		SelectGameButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				SelectGameButton.setIcon(enteredSelectGameImage);
				SelectGameButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				SelectGameButton.setIcon(basicSelectGameImage);
				SelectGameButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				nowScreen++;				//nowScreen=2일때 게임화면을 뜻함
				selectMusic(nowTrack);
			}
		});
		add(SelectGameButton);
		
	}

	public void paint(Graphics g) {
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D)screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(Background, 0, 0, null);
		if(nowScreen == 1) {
			g.drawImage(albumImage, 390, 50, null);
			g.drawImage(titleImage, 390, 550, null);
			g.drawImage(InformationImage, 440, 675, null);
		}
		if(nowScreen == 2) {
			game.screenDraw(g, nowTrack);
		}
		paintComponents(g);
		this.repaint();
	}
	public void goSelect() {
		startMusic.close();
		selectTrack(nowTrack);					//해당 노래의 트랙이 실행 된다.
		startButton.setVisible(false);		//시작화면의 버튼이 안보이게 한다.
		quitButton.setVisible(false);
		LeftButton.setVisible(true);		//노래 선택 화면의 버튼이 보이게 한다.
		RightButton.setVisible(true);
		BackButton.setVisible(true);
		SelectGameButton.setVisible(true);
		nowScreen = 1;
		selectScreen(nowScreen);
	}
	public void selectScreen(int now) {
		Background = new ImageIcon(Main.class.getResource("../image/"+screenList.get(now).getScreenName())).getImage();
	}
	public void selectTrack(int now) {		//해당 트랙의 제목이미지, 앨범이미지, 노래 선택창에서의 노래를 저장
		if(playingMusic != null) {
			playingMusic.close();
		}
		titleImage = new ImageIcon(Main.class.getResource("../image/" + trackList.get(now).getTitleImage())).getImage();
		albumImage = new ImageIcon(Main.class.getResource("../image/" + trackList.get(now).getAlbumImage())).getImage();
		playingMusic = new Music(trackList.get(now).getHighlightMusic(), true);
		playingMusic.start();
	}
	
	public void selectLeft() {
		if(nowTrack == 0) {
			nowTrack = trackList.size() - 1;
		}
		else {
			nowTrack-=1;
		}
		selectTrack(nowTrack);
	}
	public void selectRight() {
		if(nowTrack == trackList.size() - 1) {
			nowTrack = 0;
		}
		else {
			nowTrack+=1;
		}
		selectTrack(nowTrack);
	}
	public void Back() {
		if(nowScreen==1) {
			playingMusic.close();
			startMusic = new Music("startmusic.mp3",true);
			startMusic.start();
			startButton.setVisible(true);
			quitButton.setVisible(true);
			LeftButton.setVisible(false);
			RightButton.setVisible(false);
			BackButton.setVisible(false);
			SelectGameButton.setVisible(false);
		}
		else if(nowScreen==2) {
			selectTrack(nowTrack);
			LeftButton.setVisible(true);
			RightButton.setVisible(true);
			SelectGameButton.setVisible(true);
		}
		nowScreen -= 1;
		selectScreen(nowScreen);
	}
	public void selectMusic(int now) {
		if(playingMusic!=null) {
			playingMusic.close();
		}
		LeftButton.setVisible(false);
		RightButton.setVisible(false);
		SelectGameButton.setVisible(false);
		selectScreen(now+2);
		setFocusable(true);
	}
}
