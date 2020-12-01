import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class TilePanel extends JPanel implements MouseListener {
	//privates
	private ArrayList<Tile> tiles;
	private Random rnd;
	private double money = 5.00; 
	//puiblic 

	//mouse listeners
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	public void mouseClicked(MouseEvent e) {
		int whichTile = e.getX()/(this.getWidth()/4);
		Tile tile = tiles.get(whichTile);
		tile.setRandomly(rnd);
		repaint();
	}
	public TilePanel() {
		tiles = new ArrayList<Tile>();
		Tile tile;
		rnd = new Random();
		for (int i = 0; i < 4; i++) {
			tile = new Tile();
			tile.setRandomly(rnd);
			tiles.add(tile);
		}
		addMouseListener(this);
	}
	/**
	 * return the tiles to be displayed
	 * @return
	 */
	public ArrayList<Tile> getTiles() {
		return tiles;
	}
	/**
	 * sets the tiles 
	 * @param tiles
	 */
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles;
	}
	/**
	 * sets the money to the variable 
	 * @param money
	 */
	public void setMoney(double money){
		this.money = money;
	}
	/**
	 * return get money
	 * @return
	 */
	public double getMoney(){
		return money;
	}
	/**
	 * paints the tiles in their respective panels along with the shape
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		int cellWidth = this.getWidth() / 4;
		int tileSize = 4*cellWidth/5;
		int shape;
		Color color;
		Tile tile;
		for (int i = 0; i < tiles.size(); i++) {
			tile = tiles.get(i);
			shape = tile.getShape();
			color = tile.getActualColor();
			g.setColor(color);
			if (shape == 0) {
				g.fillOval(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize); 
			} else if (shape == 1) {
				g.fillRect(i*cellWidth + cellWidth/10, cellWidth/10, tileSize, tileSize);
			} 
		}
	}
	//genTile
	public void genTile(){
		tiles = new ArrayList<Tile>();
		Tile tile;
		rnd = new Random();
		for (int i = 0; i < 4; i++) {
			tile = new Tile();
			tile.setRandomly(rnd);
			tiles.add(tile);
		}
	}
	public void genTile2(){
		tiles = new ArrayList<Tile>();
		Tile tile;
		rnd = new Random();
		for (int i = 0; i < 4; i++) {
			tile = new Tile();
			tile.setRandomly(rnd);
			tiles.add(tile);
		}
	}
	//TileChecker
	public void tileChecker(int m, int b){
		int sCountC = 0;
	int sCountS= 0;
	int cCountY = 0;
	int cCountG = 0;
	int cCountO = 0;
	int cCountR = 0;
	int cCountB = 0;
	boolean sWinner = false;
	boolean cWinner = false;
		int shape;
		Color color;
		Tile tile;
		for (int i = 0; i < tiles.size(); i++){
			tile = tiles.get(i);
			shape = tile.getShape();
			color = tile.getActualColor();
			if(shape == 0){
				sCountC += 1;
			} else if(shape == 1){
				sCountS += 1;
			}
			if(color == Color.YELLOW){
				cCountY +=1;
			}else if(color == Color.GREEN){
				cCountG +=1;
			}else if(color == Color.ORANGE){
				cCountO +=1;
			}else if(color == Color.RED){
				cCountR +=1;
			}else if(color == Color.BLUE){
				cCountB +=1;
			}
		}
		//shape
		if(sCountC == 4 && sCountS <= 4){
			sWinner = true;
		}else if(sCountS == 4 && sCountC <= 4){
			sWinner = true;
		}else{
			sWinner = false;
		}
		//color
		if(cCountY == 4){
			cWinner = true;
		}else if(cCountG == 4){
			cWinner = true;
		}else if(cCountO == 4){
			cWinner = true;
		}else if(cCountR == 4){
			cWinner = true;
		}else if(cCountB == 4){
			cWinner = true;
		}else{
			cWinner = false;
		}
		//money wagers
		if( m == 100 && b ==25){
			if(sWinner == true && cWinner == true){
				money *= 100;
			}else if(sWinner == false && cWinner == true){
				money *= 50;
			}else if (sWinner == false && cWinner == false){
				money *= 0;
			}
		}else if( m == 50 && b == 10){	
			if(sWinner == true && cWinner == true){
				money *= 50;
			}else if(sWinner == false && cWinner ==true){
				money *= 10;
			}else{
				money *= 0.50;
			}
		}else if( m == 10 && b == 5){
			if(sWinner == true && cWinner == true){
				money *= 50;
			}else if(sWinner == false && cWinner == true){
				money *= 10;
			}else{
				money *= 0.66;
			}
		}
		else if(m ==0 && b == 0){
			money = 5.00;
			repaint();
		}else{
			money *= 0;
		}

	}
	
	
}
