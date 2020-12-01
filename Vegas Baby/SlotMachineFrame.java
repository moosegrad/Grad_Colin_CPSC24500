import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import javax.swing.*;
import java.awt.print.*;
//modified from class code
/**
 * TYhis fucntion creates the menu options for the user
 * takes in the user choice from those options 
 * saves tiles, read tiles, restart(Clear for now), exit
 * sets border constraints.
 */
class SlotMachineFrame extends JFrame{
	private TilePanel pan;
	private JTextField txtBalance;
	private JButton btnMax, btnMid, btnMin;
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File"); //tab at top

		JMenuItem miLoad = new JMenuItem("Load Tiles");
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileReader dr = new TileReader();
				JFileChooser jfc = new JFileChooser();
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					ArrayList<Tile> tilesRead = dr.read(jfc.getSelectedFile());
					if (tilesRead == null) {
						JOptionPane.showMessageDialog(null,"Could not read Tiles from file.");
					} else {
						//pan.clearTiles(); /used for debugging
						pan.setTiles(tilesRead);
						repaint();
					}
					//repaint();
				}
			}
		});
		mnuFile.add(miLoad);
		JMenuItem miSave = new JMenuItem("Save Tiles");
		miSave.addActionListener( new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter dw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) { // the user wants to go ahead
					if (dw.write(jfc.getSelectedFile(), pan.getTiles())) {
						JOptionPane.showMessageDialog(null,"Wrote Tiles to file.");
					} else {
						JOptionPane.showMessageDialog(null,"Could not write Tiles to file.");
					}
					
				}
			}
		});
		mnuFile.add(miSave);
		JMenuItem miPrint = new JMenuItem("Print");
		mnuFile.add(miPrint);
		//restart
		JMenuItem miRestart = new JMenuItem("Restart");
		miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//pan.clearTiles();
				//repaint();
			}
		});
		mnuFile.add(miRestart);
		JMenuItem miExit = new JMenuItem("Exit");
		miExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnuFile.add(miExit);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Colin Grad - https://github.com/moosegrad/Grad_Colin_CPSC24500");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuFile);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
		//print

	}
	//setUpLook modiefied from class
	/**
	 * this fucniton sets the bounds, jButtoms and the jTextField 
	 */
	public void setupLook(){
		
		//         L   t   w   h
		setBounds(100,100,800,400); //top, left
		setTitle("Vegas Baby Slot Machine"); //left, top, width, height
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		pan = new TilePanel();
		c.add(pan,BorderLayout.CENTER);
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		//max
		JButton btnMax = new JButton("Max");

		panSouth.add(btnMax);
		//Mid
		JButton btnMid = new JButton("Mid");
		panSouth.add(btnMid);
		//min
		JButton btnMin = new JButton("Min");
		panSouth.add(btnMin);
		//jLabel
		
		//panSouth.add(new JLabel("$"));
		JLabel lblBalance = new JLabel("$"); //create jlabel
		panSouth.add(lblBalance);
		txtBalance = new JTextField(6);
		txtBalance.setEditable(false);
		//txtBalance.setText(String.format("%0.2f",5));
		panSouth.add(txtBalance);
	
		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu();
	}//end setupLook
	//class
	/**
	 * sets the setUplook fucntion and the default close operation
	 */
	public SlotMachineFrame(){
		//setupMenu();
		setupLook(); //call fucntion
		setDefaultCloseOperation(EXIT_ON_CLOSE); //default close operation
		
	}//end frame
}//end code
