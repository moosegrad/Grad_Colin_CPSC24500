import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Allows the user to take the quiz by 
 */
public class Quizzer{
    /**
     * This fucntion takes in the array lsit of questions
     * Concatinates string and variables to be used
     * Takes in the number of questions the user wants,
     * Randomizes the arraylsit, Tests to see if there is another 
     * question to be asked by the qNum
     * Increments the counter when a question is asked, and compares the 
     * users answer to the real answer in order to compare if it is correct or wrong
     * then displays the actual answer if they get it wrong
     * At the end it will print out your correct answers vs the corrections asked
     * @param questions
     * @param c
     */
    public static void quizzer(ArrayList<Question> questions, int c){
        String aC; //Answer from user
        int qNum = c; //number of questions asked for by the user
        int counter = 0; //counter to allows the if for quesions to work
        int score = 0; //score of correct aswers
        Scanner sc = new Scanner(System.in);
        Collections.shuffle(questions); //randomizes the array list order
        for (Question question : questions){
            //if(goAhead == true){
            //System.out.println(question);
            if(counter != qNum){ //answer is correct and corresponds to JSON ansewer
                System.out.println(question); //prints question
                System.out.print("Enter the letter of your choice: ");
                aC = sc.nextLine().trim(); //take in user input and trim white space
                String answer = question.viewAnswer(); //stores JSONanswer as a String 
                if(aC.equals(answer)){ //comapres answer to the real answer
                    System.out.println("Correct!");
                    score += 1; //increments score
                    counter += 1; //increments counter
                }else if(aC != answer){ //answer is wrong != JSON answer
                    //String output = String.format("Sorry the correct answer is %s", answer);
                    System.out.printf("Sorry the correct answer is %s\n\n", answer);
                    counter += 1;
                } //ends if else if
            }//ends if
        }//end for looop
        //Score / number of questions asked for
        System.out.printf("Your score is " + score + "/" + qNum + "\n\n"); 
    } //ends code
}