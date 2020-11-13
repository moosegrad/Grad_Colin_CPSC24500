import java.io.File;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.beans.*;

/**
 * reads the filename from choice
 */
public class TileReader {
	public ArrayList<Tile> readFromText(String fname) {
		File f = new File(fname);

		return readFromText(f);
	}
	/**
	 * if the file is a text file it will sort and concatinate the tile function while there is a next tile.
	 * @param f
	 * @return result to files
	 */
	public ArrayList<Tile> readFromText(File f) {
		try {
			ArrayList<Tile> result = new ArrayList<Tile>();
			Scanner fsc = new Scanner(f);
			String line;
			String[] parts;
			int tShape, tColor;
			Tile tile;
			while (fsc.hasNextLine()) {
				line = fsc.nextLine().trim();  // get rid of whitespace at the end
				if (line.length() > 0) {  // prevent processing a blank line
					parts = line.split(" ");
					tShape = Integer.parseInt(parts[0]);
					tColor = Integer.parseInt(parts[1]);
					tile = new Tile(tShape, tColor);
					result.add(tile);
				}
			}
			fsc.close();
			return result; 
		} catch (Exception ex) {
			ex.printStackTrace();
			return null;  // object equivalent to false 
		}
	}
	/**
	 *  reads a binary file
	 * @param fname
	 * @return
	 */
	public ArrayList<Tile> readFromBinary(String fname) {
		File f = new File(fname);
		return readFromBinary(f);
	}
	/**
	 * if the file is a binary file
	 * @param f
	 * @return result
	 */
	public ArrayList<Tile> readFromBinary(File f) {
		try {
			ArrayList<Tile> tilesRead;
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));
			tilesRead = (ArrayList<Tile>)ois.readObject();
			ois.close();
			return tilesRead;
		} catch (Exception ex) {
			return null;
		}
	}
	/**
	 * is the file is an XML
	 * @param f
	 * @return result
	 */
	public ArrayList<Tile> readFromXML(File f){
		  try{ 
				XMLDecoder dec = new XMLDecoder(new BufferedInputStream(new FileInputStream(f)));
				ArrayList<Tile> result = (ArrayList<Tile>)(dec.readObject());
				dec.close();
				return result;
			}catch(Exception ex){
				return null;
			}
	}
	/**
	 * 
	 * @param fname
	 * @return reads in file name from the users choice
	 */
	public ArrayList<Tile> read(String fname) {
		File f = new File(fname);
		return read(f);
	}
	/**
	 * 
	 * @param f
	 * @return which fucntion to call or null if there is no match
	 */
	public ArrayList<Tile> read(File f) {
		String fname = f.getName().toUpperCase();
		if (fname.endsWith(".TXT")) {
			return readFromText(f);
		}
		if (fname.endsWith(".BIN")) {
			return readFromBinary(f);
		}
		if (fname.endsWith(".XML")){
			return readFromXML(f);
		}
		return null;  // unrecognize file type.
	}
	
}