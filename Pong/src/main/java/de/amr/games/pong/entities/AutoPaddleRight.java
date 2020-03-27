package de.amr.games.pong.entities;

public class AutoPaddleRight extends Paddle {

	private float ballRightY;

	@Override
	public void init() {
	}

	@Override
	public void update() {
		tf.setVelocityY(0);
		float targetY = maxY / 2 + tf.getHeight();
		if (ball.tf.getVelocityX() > 0) {
			computeBallPositionRight();
			targetY = ballRightY;
		}
		float diff = tf.getY() + tf.getHeight() / 2 - targetY;
		if (diff < -ball.tf.getWidth()) {
			tf.setVelocityY(speed);
		} else if (diff > ball.tf.getWidth()) {
			tf.setVelocityY(-speed);
		}
		move();
	}

	private void computeBallPositionRight() {
		ballRightY = ball.tf.getY() + ball.tf.getHeight() / 2;
		for (float x = ball.tf.getX(); x < maxX - tf.getWidth() - ball.tf.getWidth(); x += ball.tf.getVelocityX()) {
			if (ballRightY < 0) {
				ballRightY += ball.tf.getVelocityY();
			} else if (ballRightY >= maxY) {
				ballRightY -= ball.tf.getVelocityY();
			}
		}
	}
}