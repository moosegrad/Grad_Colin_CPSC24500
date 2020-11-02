/**
 *@author Colin Grad
 *@version 1.1
 *@Name: PumpkinMakerGrad
 *@date 10/31/2020
 * I really couldn't get the eyes to be triangles...
 */
//import
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//extends jPanel
/**
 * this fucntrion makes up the getters and setters for the user input
 * it also draws the pumpkin throught if and elif statments to corrilate cordinates to the users choices
 * @param s,t,w,h,e,n,m
 * returns the variables with values inoutted by user
 */
class PumpkinDrawingPanel extends JPanel {
	//private variables for pumpkin
	private int pmkLeft;
	private int pmkTop;
	private int pmkWidth;
	private int pmkHeight;
	private String pmkEyes;
	private String pmkNose;
	private String pmkMouth;
	//set land get left
	public void setPLeft(int s) {
			pmkLeft = s;
		}
	public int getPLeft() {
		return pmkLeft;
	}
	//set and get Top
	public void setPTop(int t){
		pmkTop = t;
	}
	public int getPTop(){
		return pmkTop;
	}
	//set and get width
	public void setPWidth(int w){
		pmkWidth = w;
	}
	public int getPWidth(){
		return pmkWidth;
	}
	//set and get height
	public void setPHeight(int h){
		pmkHeight = h;
	}
	public int getPHeight(){
		return pmkHeight;
	}
	//eyes
	public void setPEyes(String e){
		if(!e.equalsIgnoreCase("c") && !e.equalsIgnoreCase("s") && e.equalsIgnoreCase("t")) {
			pmkEyes = "C"; //default error handling
		}//end if
		else{
			pmkEyes = e;
		}//end else
	}
	public String getPEyes(){
		return pmkEyes;
	}
	//set and get nose
	public void setPNose(String n){
		if (!n.equalsIgnoreCase("c") && !n.equalsIgnoreCase("s") && !n.equalsIgnoreCase("t")) {
			pmkNose = "s"; //default error handling
		}//end if 
		else {
			pmkNose = n;
		}//end else
	}
	public String getPNose(){
		return pmkNose;
	}
	//set and get mouth 
	public void setPMouth(String m){
		if (!m.equalsIgnoreCase("o") && !m.equalsIgnoreCase("r")) {
			pmkMouth = "o"; //default error handling
		}//end if
		else {
			pmkMouth = m;
		}//end else
	}
	public String getPMouth(){
		return pmkMouth;
	}
	//Stock Pumpkin Drawing Panel
	public PumpkinDrawingPanel(){
		pmkLeft = 200;
		pmkTop = 100;
		pmkWidth = 100;
		pmkHeight = 100;
		pmkEyes = "c";
		pmkNose = "s";
		pmkMouth = "o";
	}//end pumpkinDrawingPanel stock
	//Paint fucntion 
	/**
	 * Calculates the cordinates based off of user input
	 * Runs through if and else statments to match with user choices
	 */
	public void paint(Graphics p){
		super.paint(p);
		p.setColor(Color.ORANGE);
		p.fillOval(pmkLeft, pmkTop, pmkWidth, pmkHeight);
		p.setColor(Color.WHITE);
		//int arrays
		int px1[] = {pmkLeft+(pmkWidth/4)+(pmkWidth/16), pmkLeft+(pmkWidth/4)+(pmkWidth/4)+(pmkWidth/8)};
		int py1[] = {pmkTop+(pmkHeight/4), pmkTop+(pmkHeight/4)+(pmkHeight/8), pmkTop+(pmkHeight/4)+(pmkHeight/8)};
		int px2[] = {pmkLeft+(pmkWidth/2)+(pmkWidth/4)+(pmkWidth/16), pmkWidth+(pmkWidth/2)+(pmkWidth/4), pmkLeft+(pmkWidth/2) +(pmkWidth/4)+(pmkWidth/8)};
		int py2[] = {pmkTop+(pmkHeight/4), pmkTop+(pmkHeight/4)+(pmkHeight/8),pmkTop+(pmkHeight/4)+(pmkHeight/8)};
		int px3[] = {pmkLeft+(pmkWidth/2),pmkLeft+(pmkWidth/2)-(pmkWidth/8), pmkLeft+(pmkWidth/2)+(pmkWidth/8)};
		int py3[] = {pmkTop+(pmkHeight/2), pmkTop+(pmkHeight/2)+(pmkHeight/8), pmkTop+(pmkHeight/8)};
		//circle eyes
		if (pmkEyes.equalsIgnoreCase("c")) {
				p.fillOval(pmkLeft+(pmkWidth/4), pmkTop+(pmkHeight/4), pmkWidth/6, pmkHeight/8);
				p.fillOval(pmkLeft+(pmkWidth/2)+ pmkWidth/4, pmkTop+(pmkHeight/4), pmkWidth/6, pmkHeight/8);
			} 
			//square eyes
			else if (pmkEyes.equalsIgnoreCase("s")) {
				p.fillRect(pmkLeft+(pmkWidth/4), pmkTop+(pmkHeight/4), pmkWidth/6, pmkHeight/6);
				p.fillRect(pmkLeft+(pmkWidth/2)+(pmkWidth/4),pmkTop+(pmkHeight/4),pmkWidth/6,pmkHeight/6);
			}
			//triangle eyes
			else if (pmkEyes.equalsIgnoreCase("t")) {
				p.fillPolygon(px1,py1,3);
				p.fillPolygon(px2,py2,3);
			} //circle nose
			if (pmkNose.equalsIgnoreCase("c")) {
				p.fillOval(pmkLeft+(pmkWidth/2), pmkTop+(pmkHeight/2), pmkWidth/6,pmkHeight/8);
			}
			//square nose
			else if (pmkNose.equalsIgnoreCase("s")) {
				p.fillRect(pmkLeft+(pmkWidth/2), pmkTop+(pmkHeight/2),pmkWidth/6,pmkHeight/6);
			}
			//triangle nose
			else if (pmkNose.equalsIgnoreCase("t")) {
				p.fillPolygon(px3,py3,3);
			}
			//oval mouth
			if (pmkMouth.equalsIgnoreCase("o")) {
				p.fillOval(pmkLeft+(pmkWidth/4), pmkTop+(pmkHeight/2)+(pmkHeight/4), pmkWidth/3, pmkHeight/6);
			} 
			//rectangle mouth
			else if (pmkMouth.equalsIgnoreCase("r")) {
				p.fillRect(pmkLeft+(pmkWidth/4), pmkTop+(pmkHeight/2)+(pmkHeight/4), pmkWidth/3,pmkHeight/6);
			}//end if
	}//end paint
}//end jpanel
//jframe extension
/**
 * Sets the JFrames size and position on the screen
 */
class PkmMR extends JFrame {
	PumpkinDrawingPanel dPanel;
	//centerFrame stock
	public void centerFrame() {
		Toolkit tKit = Toolkit.getDefaultToolkit();
		Dimension dim = tKit.getScreenSize(); 
		int sWidth = (int)dim.getWidth();
		int sHeight = (int)dim.getHeight();
		int fWidth = 800;
		int fHeight = 480;
		int left = sWidth/2 - fWidth/2;
		int top = sHeight/2 - fHeight/2;
		setBounds(left,top,fWidth,fHeight);
	}
	/**
	 * This function prints out Jlables with Text boxes fir the user to input choices
	 * this fucntion also allows users to clock the button for the action listener to make changes
	 */
	//setLook
	 public void setLook(){
			setTitle("Pumpkin Maker");
			centerFrame();
			Container c = getContentPane();
			c.setLayout(new BorderLayout());
			dPanel = new PumpkinDrawingPanel();
			c.add(dPanel, BorderLayout.CENTER);
			//Jpanel
			JPanel pnSouth = new JPanel();
			pnSouth.setLayout(new FlowLayout());
			//left
			pnSouth.add(new JLabel("Left:"));
			JTextField txtSize1 = new JTextField(3);
			pnSouth.add(txtSize1);
			//top
			pnSouth.add(new JLabel("Top:"));
			JTextField txtSize2 = new JTextField(3);
			pnSouth.add(txtSize2);
			//width
			pnSouth.add(new JLabel("Width:"));
			JTextField txtSize3 = new JTextField(3);
			pnSouth.add(txtSize3);
			//Height
			pnSouth.add(new JLabel("Height:"));
			JTextField txtSize4 = new JTextField(3);
			pnSouth.add(txtSize4);
			//eye
			pnSouth.add(new JLabel("Eyes:(C S T)"));
			JTextField txtSize5 = new JTextField(1);
			pnSouth.add(txtSize5);
			//nose
			pnSouth.add(new JLabel("Nose: (C S T)"));
			JTextField txtSize6 = new JTextField(1);
			pnSouth.add(txtSize6);
			//mouth
			pnSouth.add(new JLabel("Mouth:(O R)"));
			JTextField txtSize7 = new JTextField(1);
			pnSouth.add(txtSize7);
			//button draw
			JButton btnChange = new JButton("Draw");
			
			btnChange.addActionListener( new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dPanel.setPLeft(Integer.parseInt(txtSize1.getText()));
					dPanel.setPTop(Integer.parseInt(txtSize2.getText()));
					dPanel.setPWidth(Integer.parseInt(txtSize3.getText()));
					dPanel.setPHeight(Integer.parseInt(txtSize4.getText()));
					dPanel.setPEyes(txtSize5.getText());
					dPanel.setPNose(txtSize6.getText());
					dPanel.setPMouth(txtSize7.getText());
					repaint();
				}
			}
			);
			
			pnSouth.add(btnChange);
			c.add(pnSouth,BorderLayout.SOUTH);
		}//end set look
		
	//PmkMR function
	/**
	 * Creates the default close operation and calls setLook()
	 */
	public PkmMR() {
		setLook();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
}//end extend
//begin code
/**
 * sets the panel to visable and calls the fucntion to create the JFrame
 */
public class PumpkinMakerGrad {
	//main
	public static void main(String[] args) {
		//main class to call pumpkins
		PkmMR frm = new PkmMR();
		frm.setVisible(true);
	}//end main
}//end code