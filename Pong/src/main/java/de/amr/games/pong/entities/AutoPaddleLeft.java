package de.amr.games.pong.entities;

public class AutoPaddleLeft extends Paddle {

	private float ballLeftY;
	
	@Override
	public void init() {
	}

	@Override
	public void update() {
		int targetY = maxY / 2 + tf.getHeight();
		if (ball.tf.getVelocityX() < 0) {
			computeBallPositionLeft();
			targetY = (int) ballLeftY;
		}
		float diff = tf.getY() + tf.getHeight() / 2 - targetY;
		if (diff < -ball.tf.getWidth()) {
			tf.setVelocityY(speed);
		} else if (diff > ball.tf.getWidth()) {
			tf.setVelocityY(-speed);
		}
		move();
		tf.setVelocityY(0);
	}

	private void computeBallPositionLeft() {
		ballLeftY = ball.tf.getY() + ball.tf.getHeight() / 2;
		for (float x = ball.tf.getX(); x > tf.getWidth() - 1; x += ball.tf.getVelocityX()) {
			ballLeftY += ball.tf.getVelocityY();
			if (ballLeftY < 0) {
				ballLeftY += ball.tf.getVelocityY();
			} else if (ballLeftY >= maxY) {
				ballLeftY -= ball.tf.getVelocityY();
			}
		}
	}
}