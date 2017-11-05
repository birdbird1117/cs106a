/* 
 * Note: these methods are public in order for them to be used by other files
 * in this assignment; DO NOT change them to private.  You may add additional
 * private methods to implement required functionality if you would like.
 * 
 * You should remove the stub lines from each method and replace them with your
 * implementation that returns an updated image.
 */

// TODO: comment this file explaining its behavior

import java.util.*;
import acm.graphics.*;

public class ImageShopAlgorithms implements ImageShopAlgorithmsInterface {

	public GImage flipHorizontal(GImage source) {
		// TODO
		return null;
	}

	public GImage rotateLeft(GImage source) {
		// TODO
		return null;
	}

	public GImage rotateRight(GImage source) {
		// TODO
		return null;
	}

	public GImage greenScreen(GImage source) {
		// TODO
		return null;
	}

	public GImage equalize(GImage source) {
		// TODO
		return null;
	}

	public GImage negative(GImage source) {
		int[][] pixels = source.getPixelArray();
		int rows = pixels.length;
		int cols = pixels[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols ; j++ ) {				
				int px = pixels[i][j];
				int red = 255 - GImage.getRed(px);
				int green = 255 - GImage.getGreen(px);
				int blue = 255 - GImage.getBlue(px);
				pixels[i][j] = GImage.createRGBPixel(red, green, blue);
			}
		}
		GImage image = new GImage(pixels);
		return image;
	}

	public GImage translate(GImage source, int dx, int dy) {
		// TODO
		return null;
	}

	public GImage blur(GImage source) {
		// TODO
		return null;
	}
}
