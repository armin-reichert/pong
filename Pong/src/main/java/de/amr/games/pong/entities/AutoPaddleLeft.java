package de.amr.games.pong.entities;

public class AutoPaddleLeft extends Paddle {

	private float ballLeftY;
	
	@Override
	public void init() {
	}

	@Override
	public void update() {
		int targetY = maxY / 2 + tf.height;
		if (ball.tf.getVelocityX() < 0) {
			computeBallPositionLeft();
			targetY = (int) ballLeftY;
		}
		float diff = tf.y + tf.height / 2 - targetY;
		if (diff < -ball.tf.width) {
			tf.setVelocityY(speed);
		} else if (diff > ball.tf.width) {
			tf.setVelocityY(-speed);
		}
		move();
		tf.setVelocityY(0);
	}

	private void computeBallPositionLeft() {
		ballLeftY = ball.tf.y + ball.tf.height / 2;
		for (float x = ball.tf.x; x > tf.width - 1; x += ball.tf.getVelocityX()) {
			ballLeftY += ball.tf.getVelocityY();
			if (ballLeftY < 0) {
				ballLeftY += ball.tf.getVelocityY();
			} else if (ballLeftY >= maxY) {
				ballLeftY -= ball.tf.getVelocityY();
			}
		}
	}
}