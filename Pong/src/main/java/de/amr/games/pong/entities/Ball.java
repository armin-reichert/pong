package de.amr.games.pong.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import de.amr.easy.game.controller.Lifecycle;
import de.amr.easy.game.entity.Entity;
import de.amr.easy.game.view.View;

public class Ball extends Entity implements Lifecycle, View {

	public int maxY;
	public Color color;

	@Override
	public void init() {
	}

	@Override
	public void update() {
		tf.move();
		if (tf.y <= 0) {
			tf.y=(0);
			tf.setVelocityY(-tf.getVelocityY());
		} else if (tf.y + tf.height >= maxY) {
			tf.y=(maxY - 1 - tf.height);
			tf.setVelocityY(-tf.getVelocityY());
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval((int) tf.x, (int) tf.y, tf.width, tf.height);
	}
}