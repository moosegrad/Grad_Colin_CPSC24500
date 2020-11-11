import java.io.BufferedWriter;
import java.io.File;
//import java.io.FileOutputStream;
import java.io.FileWriter;
//import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
//code from class twitched to text
public class TileWriter {
	public boolean writeToText(String fname, ArrayList<Tile> tiles) {
		File f = new File(fname);
		return writeToText(f,tiles);
	}//end tile writter
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
}//end code