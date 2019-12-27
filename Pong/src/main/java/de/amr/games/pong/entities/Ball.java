package de.amr.games.pong.entities;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;

import de.amr.easy.game.controller.Lifecycle;
import de.amr.easy.game.entity.Entity;

public class Ball extends Entity implements Lifecycle {

	private Dimension courtSize;
	private Color color;

	public Ball(int size) {
		tf.setWidth(size);
		tf.setHeight(size);
	}

	public void setCourtSize(Dimension courtSize) {
		this.courtSize = courtSize;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	@Override
	public void init() {
	}

	@Override
	public void update() {
		tf.move();
		if (tf.getY() <= 0) {
			tf.setY(0);
			tf.setVelocityY(-tf.getVelocityY());
		}
		else if (tf.getY() + tf.getHeight() >= courtSize.height) {
			tf.setY(courtSize.height - 1 - tf.getHeight());
			tf.setVelocityY(-tf.getVelocityY());
		}
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(color);
		g.fillOval((int) tf.getX(), (int) tf.getY(), tf.getWidth(), tf.getHeight());
	}
}