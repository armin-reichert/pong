package de.amr.games.pong.entities;

import java.awt.Color;
import java.awt.Graphics2D;

import de.amr.easy.game.entity.Entity;

public class Court extends Entity {

	public Color floorColor;
	public Color lineColor;
	public int lineWidth;

	@Override
	public void draw(Graphics2D g) {
		g.setColor(floorColor);
		g.fillRect(0, 0, tf.getWidth(), tf.getHeight());
		g.setColor(lineColor);
		g.fillRect(0, 0, tf.getWidth(), lineWidth);
		g.fillRect(0, tf.getHeight() - lineWidth, tf.getWidth(), lineWidth);
		g.fillRect(0, 0, lineWidth, tf.getHeight());
		g.fillRect(tf.getWidth() - lineWidth, 0, lineWidth, tf.getHeight());
		g.fillRect(tf.getWidth() / 2 - lineWidth / 2, 0, lineWidth, tf.getHeight());
	}
}