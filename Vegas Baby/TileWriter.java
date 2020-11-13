import java.io.BufferedWriter;
import java.beans.XMLEncoder;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
//code from class twitched to text
/**
 * delegation for write to text file
 */
public class TileWriter {
	public boolean writeToText(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToText(f,tiles);
	}//end tile writter
	/**
	 * writes to a text file
	 * @param f
	 * @param tiles
	 * @return
	 */
	public boolean writeToText(File f, ArrayList<Tile> tiles) {
		try {
			PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(f)));
			for (Tile tile : tiles) {
				pw.println(tile);  // dot's toString() will return a string
			}//end for
			pw.close();
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}//end try
	}//end write to text
	/**
	 * delegation for write to binary file 
	 * @param fname
	 * @param tiles
	 * @return
	 */
	public boolean writeToBinary(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToBinary(f,tiles);
	}
	/**
	 * if the file is an binary file it will write it as a binary file
	 * @param f
	 * @param tiles
	 * @return boolean 
	 */
	public boolean writeToBinary(File f, ArrayList<Tile> tiles) {
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f));
			oos.writeObject(tiles);
			oos.close();
			return true; // success
		} catch (Exception ex) {
			return false;
		}
	}
	/**
	 * delegation for below fucntion
	 * @param fname
	 * @param tiles
	 * @return
	 */
	public boolean writeToXML(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToXML(f,tiles);
	}
	/**
	 * if the file is a XML file this outputs it as a xml file
	 * @param f
	 * @param tiles
	 * @return
	 */
	public boolean writeToXML(File f, ArrayList<Tile> tiles) {
		try {
			XMLEncoder enc = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(f)));
			enc.writeObject(tiles);
			enc.close();			
			return true;
		} catch (Exception ex) {
			return false;
		}
	}
	/**
	 * write to a file but speciefies files in below fucntion ... delegation. 
	 * @param fname
	 * @param tiles
	 * @return
	 */
	public boolean write(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return write(f,tiles);
	}
	/**
	 * This writes tile data to whatever file format the user wants
	 * based on the extension of the file's name
	 * .txt - text
	 * .bin = binary
	 * .xml - xml
	 * @param f the file object
	 * @param tiles the list of tiles to write
	 * @return true if successful, false otherwise
	 */
	public boolean write(File f, ArrayList<Tile> tiles) {
		String fname = f.getName().toUpperCase();
		if (fname.endsWith(".TXT")) {
			return writeToText(f,tiles);
		}
		else if (fname.endsWith(".BIN")) {
			return writeToBinary(f,tiles);
		}
		else if (fname.endsWith(".XML")) {
			return writeToXML(f,tiles);
		}
		return false;  // invalid or unrecognized file type
	}
}//end code