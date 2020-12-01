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
import java.awt.print.*;

/**
 * 
 */
public class SlotMachineFrame extends JFrame {
	private TilePanel tpan;
	private JTextField txtBalance;
	private JButton btnMax, btnMid, btnMin;
	public void setupMenu() {
		JMenuBar mbar = new JMenuBar();
		JMenu mnuFile = new JMenu("File");
		JMenuItem miLoad = new JMenuItem("Load");
		JMenuItem miSave = new JMenuItem("Save");
		JMenuItem miPrint = new JMenuItem("Print");
		JMenuItem miRestart = new JMenuItem("Restart");
		JMenuItem miExit = new JMenuItem("Exit");
		//load action listener
		miLoad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileReader tr = new TileReader();
				ArrayList<Tile> tiles;
				if (jfc.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
					tiles = tr.read(jfc.getSelectedFile());
					if (tiles != null) {
						tpan.setTiles(tiles);
						repaint();
					} else {
						JOptionPane.showMessageDialog(null,"Tiles could not be read.");
					}
				}
			}
		});
		//save action listener
		miSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser jfc = new JFileChooser();
				TileWriter tw = new TileWriter();
				if (jfc.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
					if (tw.write(jfc.getSelectedFile(),tpan.getTiles())) {
						JOptionPane.showMessageDialog(null,"Wrote tiles successfully.");
					} else {
						JOptionPane.showMessageDialog(null,"Could not write tiles.");
					}
				}
			}
		});
		//priint
		
		miRestart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tpan.genTile();
				tpan.tileChecker(0,0);
				txtBalance.setText(String.format("%.2f", tpan.getMoney()));
				if(tpan.getMoney() == 5){
					btnMax.setEnabled(true);
					btnMid.setEnabled(true);
					btnMin.setEnabled(true);
				}
				repaint();
			}
		});
		
		
		mnuFile.add(miLoad);
		mnuFile.add(miSave);
		mnuFile.add(miPrint);
		mnuFile.add(miRestart);
		mnuFile.add(miExit);
		mbar.add(mnuFile);
		JMenu mnuHelp = new JMenu("Help");
		JMenuItem miAbout = new JMenuItem("About");
		miAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Vegas Baby Vegas by Colin Grad.\nhttps://github.com/moosegrad/Grad_Colin_CPSC24500");
			}
		});
		mnuHelp.add(miAbout);
		mbar.add(mnuHelp);
		setJMenuBar(mbar);
	}
	public void setupLook() {
		setBounds(100,100,750,300);
		setTitle("Vegas Baby Vegas Slot Machine");
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		JPanel panSouth = new JPanel();
		panSouth.setLayout(new FlowLayout());
		JPanel panCenter = new JPanel();
		btnMax = new JButton("Max");
		btnMax.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				tpan.genTile();
				tpan.tileChecker(100, 25);
				txtBalance.setText(String.format("%.2f", tpan.getMoney()));
				if(tpan.getMoney() == 0){
					btnMax.setEnabled(false);
					btnMid.setEnabled(false);
					btnMin.setEnabled(false);
				}else {

				}
				repaint();
			}
		});
		btnMid = new JButton("Mid");
		btnMid.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				tpan.genTile();
				tpan.tileChecker(50,10);
				txtBalance.setText(String.format("%.2f", tpan.getMoney()));
				if(tpan.getMoney() == 0){
					btnMax.setEnabled(false);
					btnMid.setEnabled(false);
					btnMin.setEnabled(false);
				}else {

				}
				repaint();
			}
		});
		btnMin = new JButton("Min");
		btnMin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				tpan.genTile();
				tpan.tileChecker(10,5);
				txtBalance.setText(String.format("%.2f", tpan.getMoney()));
				if(tpan.getMoney() == 0){
					btnMax.setEnabled(false);
					btnMid.setEnabled(false);
					btnMin.setEnabled(false);
				}else {

				}
				repaint();
			}
		});
		//add buttons
		panSouth.add(btnMax);
		panSouth.add(btnMid);
		panSouth.add(btnMin);
		c.add(panSouth,BorderLayout.SOUTH);
		tpan = new TilePanel();
		c.add(tpan,BorderLayout.CENTER);
		//take out for final
		JLabel lblBalance = new JLabel("$");
		panSouth.add(lblBalance);
		txtBalance = new JTextField(6);
		txtBalance.setEditable(false);
		txtBalance.setText(String.format("%.2f", tpan.getMoney()));
		panSouth.add(txtBalance);
		setupMenu();
	}
	public SlotMachineFrame() {
		setupLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}
