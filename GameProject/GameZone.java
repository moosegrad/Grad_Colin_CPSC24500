/* 
*Colin Grad
*09-18-2020
*Project 3
This project will allow the user to plau 21 and rock paper scissors
*/
//import 
import java.util.Random; //gereate random number
import java.util.Scanner; import java.nio.file.attribute.*;

//scanner for user input
//main 
public class GameZone{
	//print banner
	public static void Welcome(){
		//print statment
		System.out.println("         Welcome Gamezone! "); // welcome user
		System.out.println("**********************************");//line for seperation
	}
	//print menu
	public static void Menu(){
		//print statments
		System.out.println("----------------------------------");
		System.out.println("          * Main Menu * "); //print menu title
		System.out.println("----------------------------------"); //line for seperation
		System.out.println("Type: '1' for 21\nType: '2' for Rock paper Scissors\nType: '3' to exit game"); //options
		System.out.println("----------------------------------"); //line for seperation
	}
	//fucntion to deside winner for 21 game
	public static void Winner21(int a, int b){
		//int a = user
		//int b = computer
		if(a > b){
			System.out.println("You won!");
			System.out.println("______________________________________");
		}//end if
		else if( a < b){
			System.out.println("The Computer Won!");
			System.out.println("______________________________________");
		}//end else if
		else if(a == b){
			System.out.println("It's a Tie!");
			System.out.println("______________________________________");
		}//end else
	}
	public static void WinnerRps(int c, int d){
		//int c = user 
		//int d = computer
		if(c== 1 && d == 1 || c == 2 && d == 2 || c == 3 && d == 3){
			System.out.println("It's a Tie!");
		}//end if 
		//user won
		else if(c == 1 && d == 3 || c == 2 && d ==1 || c == 3 && d == 2){
			System.out.println("You won!");
		}//end elif
		//else for computer wins
		else if(c == 3 && d == 1 || c == 1 && d == 2 || c == 2 && d == 3){
			System.out.println("The compter won");
		}//end elif
	}
	//main class
	public static void main(String[] args) {
		Random rand = new Random(); //generate random number initilization
		Scanner sc = new Scanner(System.in);
		//main class global variables
		int userInput; //answer from userInput initilized to zero 
		//fucntions 
		Welcome(); //function to welcome the user
		boolean quit = false;
		do{
			Menu();
			userInput = sc.nextInt(); //takes inpt from user
			//if user choices to play 21
			if(userInput == 1){
				int userHand21 = 1 + rand.nextInt(11); //generate random number out of 11
				int compHand21 = 13 + rand.nextInt(8); //generates random number out of 11
				boolean play21 = true;
				while(play21 = true){
					if(userHand21 == 21 && compHand21 < 21){
						System.out.println("Your hand is: " + userHand21);
						System.out.println("The Computers hand is: " + compHand21);
						System.out.println("You won!");
						userHand21 = 1 + rand.nextInt(11);
						compHand21 = 13 + rand.nextInt(8);
					}//end if 
					else if(userHand21 == 21 && compHand21 == 21){
						System.out.println("Your hand is: " + userHand21);
						System.out.println("The Computers hand is: " + compHand21);
						System.out.println("Its a tie!");
						userHand21 = 0;
						compHand21 = 0;
						userHand21 = 1 + rand.nextInt(11);
						compHand21 = 13 + rand.nextInt(8);
					}//end else if 
					else if(userHand21 > 21){
						System.out.println("You busted!");
						System.out.println("Your hand is: " + userHand21);
						System.out.println("The Computers hand is: " + compHand21);
						System.out.println("______________________________________");
						userHand21 = 0;
						compHand21 = 0;
						userHand21 = 1 + rand.nextInt(11);
						compHand21 = 13 + rand.nextInt(8);
					}
					System.out.println("Your hand is:" + userHand21);
					System.out.println("---------------------------");

					System.out.println("Press '1' to Hit\nPress '2' to hold\nPress '3' to exit\n");
					int userA21 = sc.nextInt();
					if(userA21 == 1){
						System.out.println("---------------------------");
						System.out.println("You selected to hit");
						int aNTU = 1 + rand.nextInt(11);
						userHand21 = userHand21 + aNTU;
					}//end if 
					else if(userA21 == 2){
						System.out.println("You selected to hold");
						System.out.println("Your hand is: " + userHand21);
						System.out.println("The Computers hand is: " + compHand21);
					Winner21(userHand21, compHand21);//end else
					}// end else if
					else if(userA21 == 3){
						System.out.println("Thank you for playing 21!");
						play21 = false;
						break;
					}//end else if
				}//end while loop	
			}// end if
			//user choice is to play rock paper scissors
			else if(userInput == 2){
				boolean playRps = true;
				while(playRps == true){
					System.out.println("---------------------------------------");
					System.out.println("Press '1' for rock\nPress '2' for paper\nPress '3' for scissors\nPress any other number to quit\n");
					int rpsUserA = sc.nextInt(); 
					int computerAnswer = rand.nextInt(3) + 1;
					String cc;
					if(rpsUserA == 1){
						System.out.println("You picked: Rock");
						//cc = ComputerChoice(computerAnswer);
						if(computerAnswer == 1){
							cc = "Rock";
						}//end if 
						else if(computerAnswer== 2){
							cc = "Paper";
						} //end else if
						else{
							cc = "Scissors";
						} //end else
						System.out.println("The computer picked: " + cc +"\n");
						// -----------------winner if statments-----------------------
						if(rpsUserA == 1 && computerAnswer == 1 || rpsUserA == 2 && computerAnswer == 2 || rpsUserA == 3 && computerAnswer == 3){
							System.out.println("It's a Tie!");
						}//end if 
						//user won
						else if(rpsUserA == 1 && computerAnswer == 3 || rpsUserA == 2 && computerAnswer ==1 || rpsUserA == 2 && computerAnswer == 3){
							System.out.println("You won!");
						}//end elif
						//else for computer wins
						else if(rpsUserA == 3 && computerAnswer == 1 || rpsUserA == 1 && computerAnswer == 2 || rpsUserA == 2 && computerAnswer == 3){
							System.out.println("The compter won");
						}//end elif
						//-----------------------------------------------------
					} //if statatment end
					else if(rpsUserA == 2){
						System.out.println("You picked: Paper");
						if(computerAnswer == 1){
							cc = "Rock";
						}//end if 
						else if(computerAnswer== 2){
							cc = "Paper";
						} //end else if
						else{
							cc = "Scissors";
						} //end else
						System.out.println("The computer picked: " + cc +"\n");
						// -----------------winner if statments-----------------------
					WinnerRps(rpsUserA, computerAnswer);
						//-----------------------------------------------------
					}//end else if 1
					else if(rpsUserA == 3){
						System.out.println("You picked: Scissors");
						if(computerAnswer == 1){
							cc = "Rock";
						}//end if 
						else if(computerAnswer== 2){
							cc = "Paper";
						} //end else if
						else{
							cc = "Scissors";
						} //end else
						System.out.println("The computer picked: " + cc +"\n");
						// -----------------winner if statments-----------------------
						
						//-----------------------------------------------------
					} //end else if 2
					else if(rpsUserA != 1 || rpsUserA != 2 || rpsUserA != 3){
						System.out.println("Thanks for playing Rock Paper Scissors!");
						playRps = false;
					}//end else
					
				} //while statment end
				userInput = userInput + 5;
			}//end else 2 
			else if(userInput == 3){
				System.out.println("Thanks for playing GameZone!");
				quit = true;
			}//else 3
			else{
				System.out.println("Please Enter: 1, 2 or 3");
			}
		} while(quit != true);
		sc.close();
	}//mian class
} //main 