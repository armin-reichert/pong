package de.amr.games.pong.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import de.amr.easy.game.controller.Lifecycle;
import de.amr.easy.game.entity.Entity;

public abstract class Paddle extends Entity implements Lifecycle {

	public int speed;
	public int maxX, maxY;
	public Color color;
	public Ball ball;

	protected void move() {
		tf.move();
		if (tf.getY() < 0) {
			tf.setY(0);
		} else if (tf.getY() >= maxY - tf.getHeight()) {
			tf.setY(maxY - tf.getHeight());
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect((int) tf.getX(), (int) tf.getY(), tf.getWidth(), tf.getHeight());
	}
}