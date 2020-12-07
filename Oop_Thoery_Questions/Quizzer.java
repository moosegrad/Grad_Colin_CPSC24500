import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Quizzer{
    public static void quizzer(ArrayList<Question> questions, int c){
        String aC;
        int qNum = c;
        int counter = 0;
        //Question question;
        Scanner sc = new Scanner(System.in);
        ArrayList<Question> questions2 = (ArrayList<Question>)questions;
		Collections.shuffle(questions);
        for (Question question : questions){
            while(counter != qNum){
                System.out.println(question);
                System.out.print("Enter the letter of your choice: ");
                aC = sc.nextLine().trim();
                String answer = question.viewAnswer();
                if(aC == answer){
                    System.out.println("Correct!");
                    counter += 1;
                }else if(aC != answer){
                    //String output = String.format("Sorry the correct answer is %s", answer);
                    System.out.printf("Sorry the correct answer is %s\n\n", answer);
                    counter += 1;
                }
            }
        }
    }
}