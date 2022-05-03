package Main;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import static Main.Game.GAME_HEIGHT;
import static Main.Game.GAME_WIDTH;


public class GamePanel extends JPanel {

	private MouseInputs mouseInputs;
	private Game game;
	public GamePanel(Game game){
		mouseInputs = new MouseInputs(this);
		this.game = game;
		
		setPanelSize();
		addKeyListener(new KeyboardInputs(this));
		addMouseListener(mouseInputs);
		addMouseMotionListener(mouseInputs);
	}


	private void setPanelSize() {
		Dimension size = new Dimension(GAME_WIDTH, GAME_HEIGHT);
		setPreferredSize(size);
		System.out.println("Size :" + GAME_WIDTH + " : " + GAME_HEIGHT);
	}

	public void updateGame() {

	}
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		game.render(g);

	}
	// Getter function for keyboardInputs from GamePanel
	public Game getGame() {
		return game;
	}
}