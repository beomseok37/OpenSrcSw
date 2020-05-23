package typing_game1;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyListener extends KeyAdapter{
	
	@Override
	public void keyPressed(KeyEvent e) {
		if(TypingGame.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			TypingGame.game.pressS();
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			TypingGame.game.pressD();
		}
		if(e.getKeyCode() == KeyEvent.VK_F) {
			TypingGame.game.pressF();
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			TypingGame.game.pressSPACE();
		}
		if(e.getKeyCode() == KeyEvent.VK_J) {
			TypingGame.game.pressJ();
		}
		if(e.getKeyCode() == KeyEvent.VK_K) {
			TypingGame.game.pressK();
		}
		if(e.getKeyCode() == KeyEvent.VK_L) {
			TypingGame.game.pressL();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		if(TypingGame.game == null) {
			return;
		}
		if(e.getKeyCode() == KeyEvent.VK_S) {
			TypingGame.game.releaseS();
		}
		if(e.getKeyCode() == KeyEvent.VK_D) {
			TypingGame.game.releaseD();
		}
		if(e.getKeyCode() == KeyEvent.VK_F) {
			TypingGame.game.releaseF();
		}
		if(e.getKeyCode() == KeyEvent.VK_SPACE) {
			TypingGame.game.releaseSPACE();
		}
		if(e.getKeyCode() == KeyEvent.VK_J) {
			TypingGame.game.releaseJ();
		}
		if(e.getKeyCode() == KeyEvent.VK_K) {
			TypingGame.game.releaseK();
		}
		if(e.getKeyCode() == KeyEvent.VK_L) {
			TypingGame.game.releaseL();
		}
	}
}
