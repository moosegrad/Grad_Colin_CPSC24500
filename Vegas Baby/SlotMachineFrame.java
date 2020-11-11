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
//modified from class code
class SlotMachineFrame extends JFrame{
	private TilePanel pan;
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File"); //tab at top

		JMenuItem miLoad = new JMenuItem("Load Tiles");
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TileReader dr = new TileReader();
				JFileChooser jfc = new JFileChooser();
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					ArrayList<Tile> tilesRead = dr.readFromText(jfc.getSelectedFile());
					if (tilesRead == null) {
						JOptionPane.showMessageDialog(null,"Could not read Tiles from file.");
					} else {
						pan.setTiles(tilesRead);
						repaint();
					}
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
					if (dw.writeToText(jfc.getSelectedFile(), pan.getTiles())) {
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
		JMenuItem miRestart = new JMenuItem("Restart");
		mnuFile.add(miRestart);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"Colin");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuFile);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
		//print

	}
	//setUpLook modiefied from class
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
		panSouth.add(new JLabel("$"));
		JTextField txtSize = new JTextField(6);
		panSouth.add(txtSize);
		//add pansouth
		c.add(panSouth,BorderLayout.SOUTH);
		setupMenu();
	}//end setupLook
	//class
	public SlotMachineFrame(){
		//setupMenu();
		setupLook(); //call fucntion
		setDefaultCloseOperation(EXIT_ON_CLOSE); //default close operation
		
	}//end frame
}//end code