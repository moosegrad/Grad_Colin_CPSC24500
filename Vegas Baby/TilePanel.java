
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.JPanel;
/**
 * This fucntions extends the jpanel to include p=mouse lsiteners
 * sorts through options for tile shape and colors along with their quadrants i.e. 1,2,3,4
 * populated an arraylist of tiles and sets and gets the tiles
 */
class TilePanel extends JPanel implements MouseListener{
	//mouse status
	private String mouseStatus;
	//top and left
	private int tLeft;
	private int tTop;
	
	//array list
	private ArrayList<Tile> tiles;
	//tile privates
	private Tile t1;
	private Tile t2;
	private Tile t3;
	private Tile t4;
	//shape and color
	private int tShape; //private shape
	private int tColor; //private color
	//getter
	public ArrayList<Tile> getTiles(){
		return tiles;
	}//end getter
	//setter
	//tiles
	public void setTiles(ArrayList<Tile> tiles) {
		this.tiles = tiles; //setter for Tiles
	}//end setter
	public void clearTiles() {
		tiles.clear();
	}//end setter
	//tile pannel
	public TilePanel() {
		addMouseListener(this);
		tTop = 50; //default
		tShape = 0; //default
		tColor = 0; //deafult

		//tiles  t1-t4 for arraylist
		
		t1 = new Tile(); //first quad
		t2 = new Tile(); //second quad
		t3 = new Tile(); //third quad
		t4 = new Tile(); //fourth quad
		
		//create array list of size 4 variables
		tiles = new ArrayList<Tile>(4); //0-3 --> 1-4
		//variables for array list t1-t4
		
		tiles.add(t1); //first quad
		tiles.add(t2); //second quad
		tiles.add(t3); //third quad
		tiles.add(t4); //fourth quad
		
	}//end TilePanel
	@Override
	/**
	 * this fucntion loops through a for loop for each tile to choose which 
	 * shape and color they will be based on given varibales,
	 * allows the program to paint the tiles to the screen, 
	 * sets a counter and then implements tat counter to dictate which quadrant 
	 * they will be allocated to
	 */
	public void paintComponent(Graphics p) {
		int counter = 0;
		super.paintComponent(p); //paint
		//loop through array list
		for (Tile tile : tiles){
			//circels and colors
			//yellow
			if(tile.getTShape() == 0 && tile.getTColor() == 0) {
				p.setColor(Color.YELLOW);
				if (counter == 0) {
					tLeft = 50;
					counter += 1;
				}
					//tLeft = getTLeft();//first quad
				else if(counter == 1) {
					tLeft = 250;
					counter += 1;
				} //second quad
				else if(counter == 2) {
					tLeft = 450;
					counter += 1;
				}//third quad
				else if(counter == 3) {
					tLeft = 650;
				} //fourth quad
				p.fillOval(tLeft, tTop, 100, 100);
			} //end yellow
			//green
			else if(tile.getTShape() == 0 && tile.getTColor() == 1) {
				p.setColor(Color.GREEN);
				if (counter == 0) {
					tLeft = 50;
					counter += 1;
				} else if(counter == 1) {
					tLeft = 250;
					counter += 1;
				}else if(counter == 2) {
					tLeft = 450;
					counter += 1;
				}else if(counter == 3) {
					tLeft = 650;
				}
				p.fillOval(tLeft, tTop, 100, 100);
			}//end green
			//orange
			else if(tile.getTShape() == 0 && tile.getTColor() == 2) {
				p.setColor(Color.ORANGE);
				if (counter == 0) {
					tLeft = 50;
					counter += 1;
				} else if(counter == 1) {
					tLeft = 250;
					counter += 1;
				}else if(counter == 2) {
					tLeft = 450;
					counter += 1;
				}else if(counter == 3) {
					tLeft = 650;
				}
				p.fillOval(tLeft, tTop, 100, 100);
			} //end orange
			//red
			else if (tile.getTShape() == 0 && tile.getTColor() == 3) {
				p.setColor(Color.RED);
				if (counter == 0) {
					tLeft = 50;
					counter += 1;
				} else if(counter == 1) {
					tLeft = 250;
					counter += 1;
				}else if(counter == 2) {
					tLeft = 450;
					counter += 1;
				}else if(counter == 3) {
					tLeft = 650;
				}
				p.fillOval(tLeft, tTop, 100, 100);
			}//end red
			//blue
			else if(tile.getTShape() == 0 && tile.getTColor() == 4) {
				p.setColor(Color.BLUE);
				if (counter == 0) {
					tLeft = 50;
					counter += 1;
				} else if(counter == 1) {
					tLeft = 250;
					counter += 1;
				}else if(counter == 2) {
					tLeft = 450;
					counter += 1;
				}else if(counter == 3) {
					tLeft = 650;
				}
				p.fillOval(tLeft, tTop, 100, 100);
			}//end blue
			//square and colors
			//yellow
			else if(tile.getTShape() == 1 && tile.getTColor() == 0) {
				p.setColor(Color.YELLOW);
				if (counter == 0) {
					tLeft = 50;
					counter += 1;
				} else if(counter == 1) {
					tLeft = 250;
					counter += 1;
				}else if(counter == 2) {
					tLeft = 450;
					counter += 1;
				}else if(counter == 3) {
					tLeft = 650;
				}
				p.fillRect(tLeft, tTop, 100, 100);
			}//end yellow
			//green
			else if(tile.getTShape() == 1 && tile.getTColor() == 1) {
				p.setColor(Color.GREEN);
				if (counter == 0) {
					tLeft = 50;
					counter += 1;
				} else if(counter == 1) {
					tLeft = 250;
					counter += 1;
				}else if(counter == 2) {
					tLeft = 450;
					counter += 1;
				}else if(counter == 3) {
					tLeft = 650;
				}
				p.fillRect(tLeft, tTop, 100, 100);
			}//end green
			//orange
			else if(tile.getTShape() == 1 && tile.getTColor() == 2) {
				p.setColor(Color.ORANGE);
				if (counter == 0) {
					tLeft = 50;
					counter += 1;
				} else if(counter == 1) {
					tLeft = 250;
					counter += 1;
				}else if(counter == 2) {
					tLeft = 450;
					counter += 1;
				}else if(counter == 3) {
					tLeft = 650;
				}
				p.fillRect(tLeft, tTop, 100, 100);
			}//end orange
			//red
			else if(tile.getTShape() == 1 && tile.getTColor() == 3) {
				p.setColor(Color.RED);
				if (counter == 0) {
					tLeft = 50;
					counter += 1;
				} else if(counter == 1) {
					tLeft = 250;
					counter += 1;
				}else if(counter == 2) {
					tLeft = 450;
					counter += 1;
				}else if(counter == 3) {
					tLeft = 650;
				}
				p.fillRect(tLeft, tTop, 100, 100);
			}//end red
			//blue
			else if(tile.getTShape() == 1 && tile.getTColor() == 4) {
				p.setColor(Color.BLUE);
				if (counter == 0) {
					tLeft = 50;
					counter += 1;
				} else if(counter == 1) {
					tLeft = 250;
					counter += 1;
				}else if(counter == 2) {
					tLeft = 450;
					counter += 1;
				}else if(counter == 3) {
					tLeft = 650;
				}
				p.fillRect(tLeft, tTop, 100, 100);
			}//end blue
		}//end for loop
	}//end paint
	
	
	/**
	 * gets the mouse on screen 
	 * @return mouseStats=us
	 */
	public String getMouseStatus() {
		return mouseStatus;
	}
	/**
	 * sets the mouse status
	 * @param ms
	 */
	public void setMouseStatus(String ms) {
		mouseStatus = ms;
	}
	@Override
	//divided into 4 quadrants (800/4) = 200
	/**
	 * this function listens for mouseEvents and then
	 * calls the override fucntion from tile.java to randomly 
	 * generate their shape and color
	 * cordinated the mouse click to the quadrant and then switches tiles
	 * in that quadrant
	 */
	public void mouseClicked(MouseEvent e) {
		if (e.getX() > 0 && e.getX() < 200) {
			t1.setOverRide();
			repaint();
		}else if(e.getX() > 201 && e.getX() < 400) {
			t2.setOverRide();
			repaint();
		}else if(e.getX() > 401 && e.getX() < 600) {
			t3.setOverRide();
			repaint();
		}else if(e.getX() > 601 && e.getX() < 800) {
			t4.setOverRide();
			repaint();
		}//end if
		
	}//end mouse event e
	
	public void mouseExited(MouseEvent e) {
		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
	
	}
	
	@Override
	public void mouseEntered(MouseEvent e) {
		
	}
	
}//end code
