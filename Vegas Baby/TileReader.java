import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class TileReader{
	public ArrayList<Tile> readFromText(String fname) {
		File f = new File(fname); //file 
		return readFromText(f);
	}
	public ArrayList<Tile> readFromText(File f) {
		try {
			ArrayList<Tile> result = new ArrayList<Tile>();
			Scanner fsc = new Scanner(f);
			String line; //string for line
			String[] parts; //string array
			int tShape, tColor; //ints for shape and color
			Tile tile; //tile class variable
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();  // get rid of whitespace at the end
				if (line.length() > 0) {  // prevent processing a blank line
					parts = line.split(" ");
					tShape = Integer.parseInt(parts[0]);
					tColor = Integer.parseInt(parts[1]);
					tile = new Tile(tShape, tColor);
					result.add(tile);
				}//end if
			}//end while
			fsc.close(); //close file
			return result; 
		} catch (Exception ex) {
			ex.printStackTrace(); //used for debugging * DELETE FOR FINAL CODE*
			return null;  // object equivalent to false 
		}
	}
}