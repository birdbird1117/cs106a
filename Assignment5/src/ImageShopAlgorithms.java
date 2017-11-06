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
		int[][] pixels = source.getPixelArray();
		int rows = pixels.length;
		int cols = pixels[0].length;
		int[][] pixelsRotateLeft = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols ; j++ ) {				
				pixelsRotateLeft[i][cols-j-1] = pixels[i][j];
			}
		}
		
		GImage image = new GImage(pixelsRotateLeft);
		return image;		
	}

	public GImage rotateLeft(GImage source) {
		int[][] pixels = source.getPixelArray();
		int rows = pixels.length;
		int cols = pixels[0].length;
		int[][] pixelsRotateLeft = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols ; j++ ) {				
				pixelsRotateLeft[cols-j-1][i] = pixels[i][j];
			}
		}
		
		GImage image = new GImage(pixelsRotateLeft);
		return image;
	}

	public GImage rotateRight(GImage source) {
		int[][] pixels = source.getPixelArray();
		int rows = pixels.length;
		int cols = pixels[0].length;
		int[][] pixelsRotateLeft = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols ; j++ ) {				
				pixelsRotateLeft[j][rows-i-1] = pixels[i][j];
			}
		}
		
		GImage image = new GImage(pixelsRotateLeft);
		return image;		
	}

	public GImage greenScreen(GImage source) {
		int[][] pixels = source.getPixelArray();
		int rows = pixels.length;
		int cols = pixels[0].length;

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols ; j++ ) {				
				int px = pixels[i][j];
				int red = GImage.getRed(px);
				int green = GImage.getGreen(px);
				int blue = GImage.getBlue(px);
				if (green >= 2*Math.max(red, blue)) {				
					pixels[i][j] = GImage.createRGBPixel(1, 1, 1, 0);
				} else {
					pixels[i][j] = GImage.createRGBPixel(red, green, blue);
				}
			}
		}
		GImage image = new GImage(pixels);
		return image;
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
		int[][] pixels = source.getPixelArray();
		int rows = pixels.length;
		int cols = pixels[0].length;
		int[][] pixelsRotateLeft = new int[cols][rows];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols ; j++ ) {
			// avoid negtive mod 				
				pixelsRotateLeft[((i+dy)%rows+rows)%rows][((j+dx)%cols+cols)%cols] = pixels[i][j];
			}
		}
		
		GImage image = new GImage(pixelsRotateLeft);
		return image;		
	}

	private int averagePixels(int... pixels) {
		int red = 0;
		int green = 0;
		int blue = 0;
		for (int i = 0; i < pixels.length; i++){
			red += GImage.getRed(pixels[i]);
			green += GImage.getGreen(pixels[i]);
			blue += GImage.getBlue(pixels[i]);
		}
		red = red / pixels.length;
		green = green/pixels.length;
		blue = blue/pixels.length;
		return 	GImage.createRGBPixel(red, green, blue);
	}


///// private void printScores(Player... players) {
//     for (int i = 0; i < players.length; ++i) {
//         Player player = players[i];
//         String name   = player.getName();
//         int    score  = player.getScore();
//         // Print name and score followed by a newline
//         System.out.format("%s: %d%n", name, score);
//     }
// }
	public GImage blur(GImage source) {
		int[][] pixels = source.getPixelArray();
		int rows = pixels.length;
		int cols = pixels[0].length;
		int[][] pixelsBlur = new int[rows][cols];

		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols ; j++ ) {				
				if((i==0)&&(j==0)) {
					pixelsBlur[i][j] = averagePixels(pixels[i][j],pixels[i][j+1],pixels[i+1][j],pixels[j+1][j+1]);
				} else if((i==rows-1)&&(j==0)) {
					pixelsBlur[i][j] = averagePixels(pixels[i][j] , pixels[i][j+1] , pixels[i-1][j] , pixels[i-1][j+1]);					
				} else if((i==rows-1)&&(j==cols-1)) {
					pixelsBlur[i][j] = averagePixels(pixels[i][j] , pixels[i][j-1] , pixels[i-1][j] , pixels[i-1][j-1]);					
				} else if((i==0)&&(j==cols-1)) {
					pixelsBlur[i][j] = averagePixels(pixels[i][j] , pixels[i][j-1] , pixels[i+1][j] , pixels[i+1][j-1]);					
				} else if((i==0)&&(j==cols-1)) {
					pixelsBlur[i][j] = averagePixels(pixels[i][j] , pixels[i][j-1] , pixels[i+1][j] , pixels[i+1][j-1]);					
				} else if(i==0) {
					pixelsBlur[i][j] = averagePixels(pixels[i][j] , pixels[i][j-1] , pixels[i][j+1] , pixels[i+1][j-1] , pixels[i+1][j] , pixels[i+1][j+1]);
				} else if(i==rows-1) {
					pixelsBlur[i][j] = averagePixels(pixels[i][j] , pixels[i][j-1] , pixels[i][j+1] , pixels[i-1][j-1] , pixels[i-1][j] , pixels[i-1][j+1]);
				} else if(j==0) {
					pixelsBlur[i][j] = averagePixels(pixels[i][j] , pixels[i-1][j] , pixels[i+1][j] , pixels[i+1][j+1] , pixels[i][j+1] , pixels[i-1][j+1]);
				} else if(j==cols-1) {
					pixelsBlur[i][j] = averagePixels(pixels[i][j] , pixels[i-1][j] , pixels[i+1][j] , pixels[i+1][j-1] , pixels[i][j-1] , pixels[i-1][j-1]);
				} else {
					pixelsBlur[i][j] = averagePixels(pixels[i][j] , pixels[i-1][j-1] , pixels[i-1][j] , pixels[i-1][j+1] 
						, pixels[i][j-1] , pixels[i][j+1] , pixels[i+1][j-1] , pixels[i+1][j] , pixels[i+1][j+1]);

				}

			}
		}
		
		GImage image = new GImage(pixelsBlur);
		return image;				
	}
}
