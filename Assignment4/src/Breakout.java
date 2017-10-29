// TODO: comment this program

import acm.graphics.*;     // GOval, GRect, etc.
import acm.program.*;      // GraphicsProgram
import acm.util.*;         // RandomGenerator
import java.awt.*;         // Color
import java.util.*;        // random
import java.awt.event.*;   // MouseEvent

public class Breakout extends BreakoutProgram {

	public void setBricksColor(int RowNumber, GRect rect) {
		switch (RowNumber % 10) {
			case 0: ;
			case 1: rect.setColor(Color.RED); break;
			case 2: ;
			case 3: rect.setColor(Color.ORANGE); break;
			case 4: ;
			case 5: rect.setColor(Color.YELLOW); break;
			case 6: ;
			case 7: rect.setColor(Color.GREEN); break;
			case 8: ;
			case 9: rect.setColor(Color.CYAN); break;
			default: break;
		}
	}

	public void setOneBrickLine(int RowNumber, double InitYLocation) {
		double InitXLocationLeft;
		double InitXLocationRight;
		
		if (NBRICK_COLUMNS % 2 == 0) {
			InitXLocationLeft = CANVAS_WIDTH/2-BRICK_SEP/2-BRICK_WIDTH;
			InitXLocationRight = CANVAS_WIDTH/2+BRICK_SEP/2;
			for (int i = 0; i < NBRICK_COLUMNS/2; i++) {
				GRect rect= new GRect(InitXLocationLeft-(BRICK_SEP+BRICK_WIDTH)*i, InitYLocation, BRICK_WIDTH, BRICK_HEIGHT);
				rect.setFilled(true);
//				rect.setColor(Color.RED);
				setBricksColor(RowNumber, rect);
				add(rect);
				rect= new GRect(InitXLocationRight+(BRICK_SEP+BRICK_WIDTH)*i, InitYLocation, BRICK_WIDTH, BRICK_HEIGHT);
				rect.setFilled(true);
//				rect.setColor(Color.RED);
				setBricksColor(RowNumber, rect);
				add(rect);
			}
		}
	}
	
	public void setBricks() {
		double InitYLocation = BRICK_Y_OFFSET;
		for (int i = 0; i < NBRICK_ROWS; i++) {
			setOneBrickLine(i, InitYLocation);
			InitYLocation = InitYLocation + BRICK_HEIGHT + BRICK_SEP;
		}
	}

	private GRect paddle;

	public void setPaddle() {
	    paddle = new GRect(CANVAS_WIDTH/2 - PADDLE_WIDTH/2, CANVAS_HEIGHT - PADDLE_Y_OFFSET - PADDLE_HEIGHT/2, PADDLE_WIDTH, PADDLE_HEIGHT);
		paddle.setFilled(true);
		paddle.setColor(Color.BLACK);
		add(paddle);
	}

	public void mouseMoved(MouseEvent event) {
		double mouseX = event.getX();
		double mouseY = event.getY();

		double paddleX = mouseX - paddle.getWidth() / 2.0;
		double paddleY = paddle.getY();
		if ((paddleX >= 0) && (paddleX <= CANVAS_WIDTH - PADDLE_WIDTH)) {
			paddle.setLocation(paddleX, paddleY);
		}
	}
	
	private GOval ball;
	private double vx;
	private double vy;

	public void setBall() {
		ball = new GOval(CANVAS_WIDTH/2 - BALL_RADIUS, CANVAS_HEIGHT/2 - BALL_RADIUS, BALL_RADIUS, BALL_RADIUS);
		ball.setFilled(true);
		ball.setColor(Color.BLACK);
		add(ball);

		Random random = new Random();
		vy = VELOCITY_Y;
		vx = VELOCITY_X_MIN + Math.random()*(VELOCITY_X_MAX - VELOCITY_X_MIN);
		vx = vx * (random.nextBoolean() ? 1 : -1);
		while (true) {
			hasHitTopOrBottomEdge();
			hasHitLeftOrRightEdge();
			ball.move(vx, vy);
			pause(DELAY);
		}
	}

	public boolean hasHitTopOrBottomEdge() {
		double ballY = ball.getY();
		if ((ballY <= 0) || (ballY + 2*BALL_RADIUS >= CANVAS_HEIGHT)) {
			vy = -vy;
			return true;
		} else {
			return false;
		}
	}

	public boolean hasHitLeftOrRightEdge() {
		double ballX = ball.getX();
		if ((ballX <= 0) || (ballX + 2*BALL_RADIUS >= CANVAS_WIDTH)) {
			vx = -vx;
			return true;
		} else {
			return false;
		}
	}	
	
	public void run() {
		// Set the window's title bar text
		setTitle("CS 106A Breakout");

		// Set the canvas size.  In your code, remember to ALWAYS use getWidth()
		// and getHeight() to get the screen dimensions, not these constants!
		setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
		
		// TODO: finish this program
		//setOneBrickLine(1, 20);
		setBricks();
		setPaddle();
		setBall();
	}
}
