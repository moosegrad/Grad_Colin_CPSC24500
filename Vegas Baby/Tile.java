import java.util.Random;
//tile class
public class Tile{  
	//private ints
	private int tShape; //shape
	private int tColor; //color
	//getters
	//shape
	public int getTShape(){
		return tShape; //returns tShape
	}//end getTColor 
	//color
	public int getTColor(){
		return tColor; //returns tColor
	}//end getTcolor
	//setters using this.tShape
	//shape
	public void setTShape(int s){
		if(s >= 1){
			this.tShape = 1; // square
		}
		else if(s <= 0){
			this.tShape = 0; // circle
		}//end if
	}//end setTShape
	//color using this.tColor
	public void setTColor(int c){
		if(c == 0){
			this.tColor = 0; //yellow
		}
		else if(c == 1){ 
			this.tColor = 1;//green
		} 
		else if(c == 2){
			this.tColor = 2;//orange
		} else if(c == 3){
			this.tColor = 3;//red
		} else if(c >= 4){
			this.tColor = 4;//blue
		}//end if
	}//end setTcolor
	//setter for left
	
	public Tile(){
		Random rnd = new Random();//rand color(0-4) 0-yellow, 1-green, 2-orange, 3-red, 4- blue
		this.tShape = rnd.nextInt(2); //set random shape(0-1)
		this.tColor = rnd.nextInt(5); //set random color(0-4)
	}//end tile
	
	public void setOverRide(){
		Random rnd = new Random();//rand color(0-4) 0-yellow, 1-green, 2-orange, 3-red, 4- blue
		this.tShape = rnd.nextInt(2); //set random shape(0-1)
		this.tColor = rnd.nextInt(5); //set random color(0-4)
	}//end override
	public Tile(int s, int c){
		setTShape(s); //shape 
		setTColor(c); //color
	}//end tile
	/**
	 * override fucntion
	 */
	@Override
	/**
	 * @return a string to a file 
	 */
	public String toString() {
		//return foramt
			return String.format("%d %d", tShape, tColor);
		}//end tostring
}//end program
	
