package de.amr.games.pong.entities;

public class AutoPaddleRight extends Paddle {

	private float ballRightY;

	@Override
	public void init() {
	}

	@Override
	public void update() {
		tf.setVelocityY(0);
		float targetY = maxY / 2 + tf.height;
		if (ball.tf.getVelocityX() > 0) {
			computeBallPositionRight();
			targetY = ballRightY;
		}
		float diff = tf.y + tf.height / 2 - targetY;
		if (diff < -ball.tf.width) {
			tf.setVelocityY(speed);
		} else if (diff > ball.tf.width) {
			tf.setVelocityY(-speed);
		}
		move();
	}

	private void computeBallPositionRight() {
		ballRightY = ball.tf.y + ball.tf.height / 2;
		for (float x = ball.tf.x; x < maxX - tf.width - ball.tf.width; x += ball.tf.getVelocityX()) {
			if (ballRightY < 0) {
				ballRightY += ball.tf.getVelocityY();
			} else if (ballRightY >= maxY) {
				ballRightY -= ball.tf.getVelocityY();
			}
		}
	}
}