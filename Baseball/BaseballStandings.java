/**
 *@author Colin Grad
 *@date 10-04-2020
 *Baseball_Standings
 */
//import 
import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.util.concurrent.*;

//Start code
public class BaseballStandings{
	/**  
	 *This fucntion prints out the welcome banner
	 */
	public static void Welcome(){
		System.out.println("******************************************");
		System.out.println("       BASEBALL STANDING ANALYZER"         );
		System.out.println("******************************************");
	}//END welcome
	/**
	 *This fucntion Will take in The scanner tool
	 * Print out a list of choices to the user and then will ask the user for their choice
	 *This choice will then be returned to the main
	 *@return choice
	 */
	public static int MenuChoice(Scanner sc){
		System.out.println("Which Standings would you like to see?"); //ask user
		System.out.println("1. AL East\n2. Al Central\n3. AL West"); //AL
		System.out.println("4. NL East\n5. NL Central\n6. NL West"); //nl
		System.out.println("7. Overall\n8. Exit"); //other
		System.out.print("Enter your choice: "); //enter choice 
		int choice = sc.nextInt();
		return choice;
	}// end MenuChoice
	/**
	 *This function will take in a string caleld line and then compute the average
	 *It will do this by adding the wins and losses and then dividing wins by the total gamesPlayed
	 *@return avg
	 */
	public static double getAvg(String line){
		String[] parts = line.split("\t");
		double gamesPlayed = (Integer.parseInt(parts[1])) + (Integer.parseInt(parts[2]));
		double avg = (Integer.parseInt(parts[1])) / gamesPlayed;
		return avg;
	}//end getAvg
	/**
	 *This fucntion will take choice 1-6 and order the teams by their win vs loss Percentage
	 *This fucntion calls the fucntion getAvg to compute the averages and then order them.
	 *This Fucntion will also print the results out in a easy to read list.
	 */
	public static void displayStats(ArrayList<String> standings){
		String[] parts;
		double avg, gamesB; //variables for fucntion calls
		System.out.println("----------------------------------------------------------------");
		System.out.println("Teams:      Wins:     Loses:       Pct:     Games Behind:"       );
		System.out.println("----------------------------------------------------------------");
		for(String standing : standings){
			parts = standing.split("\t");
			avg = getAvg(standing);
			System.out.printf("%-15s%-8s%-8s%6.2f         \n ", parts[0], parts[1], parts[2], avg);
		}//end for 
//		System.out.println(standings);
	}//end displayStats
	/**
	 *displayStats2
	 *fucntion for ordering stats by winning percentage for option 7
	 *It will take in the Teams and then order the teams by the PCT
	 *It will print ou the team name which is aprts[0] and the average calculated by
	 *getAvg
	 */
	public static void displayStats2(ArrayList<String> standings){
			String[] parts;
			double avg;
			System.out.println("-----------------------------");
			System.out.println("Teams:            Pct:"        );
			System.out.println("-----------------------------");
			for(String standing : standings){
				parts = standing.split("\t");
				avg = getAvg(standing);
				System.out.printf("%-15s%6.2f\n ", parts[0], avg);
				//System.out.println(parts[1]);
				//System.out.println(parts[2]);
				
			}//end for 
	//		System.out.println(standings);
		}//end displayStats2
		/**
		 *This Fucntion will sort the list by the average
		 *It will use the fucntion getAvg to compare two averages and then order them
		 */
	public static void byAvg(ArrayList<String> teams, String line){
		double avg1 = getAvg(line); //fucntion call
		double avg2;
		int pos = -1;
		for(int i =0; i < teams.size(); i++){
			avg2 = getAvg(teams.get(i)); //fucntion call to getAvg to get average of two scores
			if(avg1 > avg2){
				pos = i;
				break;
			}//end if
		}
		if(pos < 0){
			teams.add(line);
		} else {
			teams.add(pos, line);
		}//end for Secondary if Loop
	}
	//gamesBehind function 
	/**
	 *Ill be 100% honest i coudln't figure out how to do the gamesBehind fucntions and everytime id try it woudn't take
	 *My return variable... I'm going to keep trying but the rest of the program works
	/*
	public static double gamesBehind(ArrayList<String> standings) {
		String [] parts;
		String leaderTeam;
		double holder1, holder2, holder3;
		double newLeader;
		double stats; //will be return variable
		for(int i = 0; i < standings.size(); i++){
			parts = standing.split("\t");
			holder1 = Integer.parseInt(parts[1]);
			holder2 = Integer.parseInt(parts[2]);
			holder3 = holder1 - holder2
		}
		//stats = 1; //test return 
		return lead1;
	}//end gamesBehind
	*/
	//main
	public static void main(String[] args) {
		/**
		 *This is the main part of the program and will open a file or reject it
		 *take in the user choice and call fucntins for this 
		 * It will also take the users choice and designate the correct parts of the file
		 *Fucntions used are: Welcome, menuChoice, byAvg, displayStats and displayStats2
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the name of the file: ");
		String fname = sc.nextLine(); //file name
		//create array lists
		ArrayList<String> aleast = new ArrayList<String>();
		ArrayList<String> alcentral = new ArrayList<String>();
		ArrayList<String> alwest = new ArrayList<String>();
		ArrayList<String> nleast = new ArrayList<String>();
		ArrayList<String> nlcentral = new ArrayList<String>();
		ArrayList<String> nlwest = new ArrayList<String>();
		ArrayList<String> target = null;
		ArrayList<String> overall = new ArrayList<String>(); //every team 
		//MenuChoice(sc);
		String line, sem;
		String[] parts;
		boolean goAhead;
		int choice;
		try{
			Scanner fsc = new Scanner(new File(fname));
			while(fsc.hasNextLine()){
				line = fsc.nextLine();
				parts = line.split("\t");
				if(parts[0].equalsIgnoreCase("LEAGUE")){
					sem = parts[1].toUpperCase();
					if(sem.equalsIgnoreCase("AL EAST")){
						target = aleast;
					} else if(sem.equalsIgnoreCase("AL CENTRAL")){
						target = alcentral;
					}else if(sem.equalsIgnoreCase("AL West")){
						target = alwest;
					}else if(sem.equalsIgnoreCase("NL EAST")){
						target = nleast;
					}else if(sem.equalsIgnoreCase("NL CENTRAL")){
						target = nlcentral;
					}else if(sem.equalsIgnoreCase("NL WEST")){
						target = nlwest;
					}
				} else{
					target.add(line);
					byAvg(overall, line); //function call//
				}//end if
			}//end while
			Welcome(); //welcome banner
			fsc.close(); //close scanner
			goAhead = true;	
		} catch(Exception ex){
			System.out.println("Couldn't read the file!");
			goAhead = false;		
		}//end catch
		if(goAhead){
			do{
				choice = MenuChoice(sc);
				if(choice == 1){
					displayStats(aleast);
				} else if(choice == 2){
					displayStats(alcentral);
					
				} else if(choice == 3){
					displayStats(alwest);
				} else if(choice == 4){
					displayStats(nleast);
				} else if(choice == 5){
					displayStats(nlcentral);
				} else if(choice == 6){
					displayStats(nlcentral);
				} else if(choice == 7){
					displayStats(overall);
				}//end else and if loop
			} while (choice != 8);
		}//end if
	}//end main
}//end program