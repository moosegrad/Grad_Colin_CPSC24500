/**
 * @author Colin Grad
 * @date 10/15/2020 - 10-/18/2020
 * @version 1.0
 * This program will take in data from a file and plot the results from the users choice
 */
import java.awt.Container;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Scanner;
import javax.swing.JFrame;
import org.math.plot.Plot2DPanel;
import org.math.plot.plotObjects.BaseLabel;
import java.awt.BorderLayout;
import java.awt.Color;

public class CovidPlotter {
	/**
	 * Allows the program to create the LinkedHash Map and return  the names and values
	 * @param fsc
	 * @return
	 */
	/**
	 * Werlcome fucntion
	 */
	public static void Intro(){
		System.out.println("*********************************************************");
		System.out.println("*      International Covid-19 Mortality Rates    *");
		System.out.println("*********************************************************");
	}
    public static LinkedHashMap<String,double[]> readData(Scanner fsc) {
        // declare the data structure I'll return
        LinkedHashMap<String,double[]> result = new LinkedHashMap<String,double[]>();
        fsc.nextLine();  // grab the header line
        String[] parts;
        String line; 
        double[] values;   // the values I read from each line
        String name; // the name from the line
        while (fsc.hasNextLine()) {
            line = fsc.nextLine();
            parts = line.split("\t");
            name = parts[0];
            // the rest of the line are the values
            values = new double[parts.length-1];
            for (int i = 1; i < parts.length; i++) {
                values[i-1] = Double.parseDouble(parts[i]);
            }
            result.put(name,values);
        }
        return result;
    }
    /**
     * This function builds an array of day numbers that I can use to plot
     * countries values for days
     */
    public static double[] getDays(int howMany) {
        double[] result = new double[howMany];
        for (int i = 0; i < howMany; i++) {
            result[i] = i;
        }
        return result;
	}
	/**
	 * This fucntion provides an arrray of number to plot for deaths per day aka stats
	 * uses the same set up as getDays but modified to get the number of deaths
	 * @param stats
	 * @return
	 */
	public static double[] getStats(double[] stats){
		int stat = stats.length;
		double[] results = new double[stat];
		for (int i = 1; i < stat; i++) {
			results[i] = stats[i] - stats[i-1];
		}
		return results;
	}
	/**
	 * This fucntion allows me to Plot the Graph for Cummulitive 
	 * sets the title and the params
	 * @param plot
	 */
    public static void setUpAndShowFrameC(Plot2DPanel plot) {
        JFrame frm = new JFrame();
        frm.setTitle("Cumulitive Deaths");
		frm.setBounds(100,100,500,500);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // just get rid of frame
        Container c = frm.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(plot,BorderLayout.CENTER);
        frm.setVisible(true);
	}
	/**
	 * This fucntion allows me to plot the graph for Daily
	 * sets the title and params
	 * @param plot
	 */
	public static void setUpAndShowFrameD(Plot2DPanel plot) {
        JFrame frm = new JFrame();
        frm.setTitle("Daily Deaths");
        frm.setBounds(100,100,500,500);
        frm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // just get rid of frame
        Container c = frm.getContentPane();
        c.setLayout(new BorderLayout());
        c.add(plot,BorderLayout.CENTER);
        frm.setVisible(true);
	}
	/**
	 * Main of the program that allows the user to take choices 
	 * interacts with the user and calls fucntions for computation
	 * @param args
	 */
	public static void main(String[] args) {
        LinkedHashMap<String,double[]> countries = null;
        String names, dailyCumu;
        String[] parts;
		double[] data; // each countries data
		Intro();
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the name of the file: ");
		String fname = sc.nextLine();
        try {
            Scanner fsc = new Scanner(new File(fname));
            countries = readData(fsc);
            fsc.close();
        } catch (Exception ex) {
            countries = null;
        }
        if (countries == null) {
            System.out.println("Boo. Couldn't read the account data.");
        } else {
            // the data has been successfully loaded in
            do {
				
                System.out.println("Enter countries to plot, separated by commas: (or 'quit' to end)");
				names = sc.nextLine();
                if (!names.equalsIgnoreCase("quit")) {
					System.out.print("[D]aily or [C]umulitive?"); //ask user for daily or cumulitive
					dailyCumu = sc.nextLine(); //daily or cumulitive choice
				//-----------------------------------------------------------------------------------------
					//This will display the plot in Cumulitive
					if(dailyCumu.equalsIgnoreCase("C")){
						Plot2DPanel plot = new Plot2DPanel(); // will contain the countries curves
						plot.setAxisLabels("Day", "Deaths");
						plot.addLegend("SOUTH");
						BaseLabel title = new BaseLabel("Cumulitive Deaths",Color.RED,0.5,1.1);
						plot.addPlotable(title);
						parts = names.split(",");
						// add line plots for each person the user named
						for (String part : parts) {
							part = part.trim();  // get rid of leading and trailing spaces
							if (countries.containsKey(part) == false) {
								System.out.printf("%s was not found.\n",part);
							} else {
								data = countries.get(part); // grab the countries values
								// now plot the data
								plot.addLinePlot(part,getDays(data.length), data);
							}//end if else
						}//end for loop
						// plot will have the investement curves. Let's show it.
						setUpAndShowFrameC(plot);
					}//end if 
				//-----------------------------------------------------------------------------------------
					 //This will display the results in daily
					else if(dailyCumu.equalsIgnoreCase("D")){
						Plot2DPanel plot = new Plot2DPanel(); // will contain the countries curves
						plot.setAxisLabels("Day", "Deaths");
						plot.addLegend("SOUTH");
						BaseLabel title = new BaseLabel("Cumulitive Deaths",Color.RED,0.5,1.1);
						plot.addPlotable(title);
						parts = names.split(",");
						// add line plots for each person the user named
						for (String part : parts) {
							part = part.trim();  // get rid of leading and trailing spaces
							if (countries.containsKey(part) == false) {
								System.out.printf("%s was not found.\n",part);
							} else {
								data = countries.get(part); // grab the countries values
								// now plot the data
								plot.addLinePlot(part,getDays(data.length),getStats(data));
							}//end if else
						}//end for loop
						// plot will have the countries curves.
						setUpAndShowFrameD(plot);
					}//end else
				//-----------------------------------------------------------------------------------------
				}//end if
			} while (!names.equalsIgnoreCase("quit"));
		}//end while
		System.out.println("Your only job...\n              ...is to wear a mask!");
    }//end main
}//end program