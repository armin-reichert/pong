package de.amr.games.pong.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import de.amr.easy.game.controller.Lifecycle;
import de.amr.easy.game.entity.Entity;
import de.amr.easy.game.view.View;

public abstract class Paddle extends Entity implements Lifecycle, View {

	public int speed;
	public int maxX, maxY;
	public Color color;
	public Ball ball;

	protected void move() {
		tf.move();
		if (tf.y < 0) {
			tf.y=(0);
		} else if (tf.y >= maxY - tf.height) {
			tf.y=(maxY - tf.height);
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillRect((int) tf.x, (int) tf.y, tf.width, tf.height);
	}
}