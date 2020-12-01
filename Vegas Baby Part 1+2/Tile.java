import java.awt.Color;
import java.io.Serializable;
import java.util.Random;
/**
 * Sets the colors and shapes along ewith generates their values by a randomizer
 */
public class Tile implements Serializable {
	private static final Color[] colors = {Color.YELLOW, Color.GREEN, Color.ORANGE, Color.RED, Color.BLUE};
	private static final String[] colorNames = {"yellow","green","orange","red","blue"};
	private static final String[] shapes = {"circle","square"};
	private int color; //0 - yellow, 1 - green, 2 - orange, 3 - red, 4 - blue
	private int shape; // 0 - circle, 1 - square, 2 - diamond
	int scCounter, c, s;
	//default
	public Tile() {
		color = 3;
		shape = 0;
	}
	//overside
	/**
	 * sets color and shape for that tile
	 * @param color
	 * @param shape
	 */
	public Tile(int color, int shape) {
		setColor(color);
		setShape(shape);
	}
	/**
	 * getter for color
	 * @return result of color
	 */
	public int getColor() {
		return color;
	}
	/**
	 * sets tht color to ensure it is a valid option
	 * @param color
	 */
	public void setColor(int color) {
		if (color < 0) {
			this.color = 0;
		} else if (color > 4) {
			this.color = 4;
		} else {
			this.color = color;
		}
	}
	/**
	 * randomizes the colors and shapes 100 times ans sets random color/shape
	 * @param rnd
	 */
	public void setRandomly(Random rnd) {
		while(scCounter != 100){
			c = rnd.nextInt(colors.length);
			s = rnd.nextInt(shapes.length);
			scCounter +=1;
		}
		color = c;
		shape = s;
		//color = rnd.nextInt(colors.length);
		//shape = rnd.nextInt(shapes.length);
	}
	/**
	 * gets the actual color by calling the array and setting it to the arrays value for that int
	 * @return
	 */
	public Color getActualColor() {
		return colors[color];
	}
	/**
	 * getter for colornames to retrieve colorcode for color 
	 * @return
	 */
	public String getColorName() {
		return colorNames[color];
	}
	/**
	 * getter for shape
	 * @return shape int
	 */
	public int getShape() {
		return shape; 
	}
	/**
	 * checks to see if theshape is valide 
	 * @param shape
	 */
	public void setShape(int shape) {
		if (shape < 0) {
			this.shape = 0;
		} else if (shape > 1) {
			this.shape = 1;
		} else {
			this.shape = shape;
		}
	}
	/**
	 * goes to thte array lsit for shape and gets the int that corisponds with the int to determine shape 
	 * @return
	 */
	public String getShapeAsString() {
		return shapes[shape];
	}
	/**
	 * prints out color name and shape
	 * @return
	 */
	public String toStringFancy() {
		return String.format("%s %s", getColorName(), getShapeAsString());
	}
	@Override
	/**
	 * sets color and shape to be printed for the writter class
	 */
	public String toString() {
		return String.format("%d %d",color,shape);
	}
	/**
	 * ill be honest ummmmm yeah 
	 * @return
	 */
	public int getCode() {
		return color*10+shape;
	}
}
