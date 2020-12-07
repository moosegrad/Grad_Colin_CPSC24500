/**
 * OOP theory and concept QUestions
*/
//import
import java.util.Scanner; //scanner tool that allows to read in data
import java.io.File;
import java.util.ArrayList;
/**
 * main part of the program that runs the other files
 */
public class QuizApp{
    public static void Header(){
        System.out.println("*************************************");
        System.out.println("  OOP Theory and Concept Questions");
        System.out.println("*************************************");
    }//end welcome
    /**
     * creates the menu options that take in scanner to ask the user their choice
     * and return their choice 
     * @param sc
     * @return
     */
    public static int MenuChoice(Scanner sc){
        System.out.println("Here are your options");
        System.out.println("1. Take a quiz\n2. See questions and answers\n3. Exit "); //options 1-3
        System.out.print("Enter the number of your choice: "); 
        int choice = sc.nextInt(); //takes in input from the user
        //System.out.println("------------------------------------"); //divider 
        return choice; // return choice from scanner
    }
    /**
     * Creates the footer of the program when it ends
     */
    public static void Footer(){
        System.out.println("*************************************");
        System.out.println("  Thank you for taking CPSC 24500");
        System.out.println("*************************************");
    }
    /**
     * runs the program by talking in the options from scanner and allocating that information
     * to the corrisponding class
     * Displays the MEenuChoice, header and footer fucntions
     * @param args
     */
    public static void main(String[] args){ //main part of the program
        //File fname = new File("questions_without_answers.json");
        ArrayList<Question> questions = new ArrayList<Question>();
        //String fname = "questions_without_answers.json";
        String path = "questions.json";
        int choice; //place holder for choice from scanner i.e user
        boolean goAhead = true; // boolean for if statment 
        Scanner sc = new Scanner(System.in); //scanner for input data 
        QuestionReader qr = new QuestionReader();
        QuestionPrinter qp = new QuestionPrinter();
        Quizzer qz = new Quizzer();
        Question question;
        int choice2;
        //start code
        Header(); //display header
        if(goAhead){ //if goAhead == true this loop will work.
            do{ //proform this when 'if' variable is valid 
                choice = MenuChoice(sc); //set the choice to the input from user 
                if(choice == 1){ //taske the quiz
                    questions = qr.readFromJSON(path); //reads in data so it can be printed
                    System.out.print("\nHow many Questions would you like? ");
                    choice2 = sc.nextInt();
                    System.out.println("\n");
                    qz.quizzer(questions, choice2);
                    //qp.printQuestions(questions, choice2); //holder for testing
                }else if(choice == 2){ // see questions and answers
                    questions = qr.readFromJSON(path); //reads in data so it can be printed
                    choice2 = 18;
                    qp.printQuestions(questions);
                }
            }while(choice != 3);{ //choice == exit

            }//end do
            Footer(); //insert goodbye message
            goAhead = false; // exit if so it cannot repeat by seettering variable to false
        }// and if(goAhead)
    }//end main
}//end program