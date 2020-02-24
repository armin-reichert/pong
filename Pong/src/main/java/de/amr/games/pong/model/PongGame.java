package de.amr.games.pong.model;

import de.amr.easy.game.assets.Assets;

public class PongGame {

	public enum PlayMode {
		Player1_Player2, Player1_Computer, Computer_Player2, Computer_Computer
	}

	public int scoreLeft;
	public int scoreRight;
	public PlayMode playMode;

	public PongGame() {
		Assets.sound("plop.mp3");
		Assets.sound("plip.mp3");
		Assets.sound("out.mp3");
		scoreLeft = 11;
		scoreRight = 11;
		playMode = PlayMode.Player1_Player2;
	}

	public void playSoundPlip() {
		Assets.sound("plip.mp3").play();
	}

	public void playSoundPlop() {
		Assets.sound("plop.mp3").play();
	}

	public void playSoundOut() {
		Assets.sound("out.mp3").play();
	}
}