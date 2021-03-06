package typing_game1;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.player.Player;

public class Music extends Thread {
	private String name;
	private Player player;
	private boolean isLoop;
	private File file;
	private FileInputStream fin;
	private BufferedInputStream bin;
	
	public Music(String name, boolean isLoop) {
		try {
			this.isLoop = isLoop;
			this.name = name;
			file = new File(Main.class.getResource("../music/" + this.name).toURI());
			fin = new FileInputStream(file);
			bin = new BufferedInputStream(fin);
			player = new Player(bin);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	public int getTime() {
		if (player == null) {
			return 0;
		}
		return player.getPosition();
	}
	public void close() {
		isLoop = false;
		player.close();
		this.interrupt();
	}
	@Override
	public void run() {
		try {
			do {
				player.play();
				fin = new FileInputStream(file);
				bin = new BufferedInputStream(fin);
				player = new Player(bin);
			}while(isLoop);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
