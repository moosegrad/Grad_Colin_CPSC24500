import java.util.Collections;
import java.util.ArrayList;
import java.util.Scanner;

public class Quizzer{
    public static void quizzer(ArrayList<Question> questions, int c){
        String aC;
        int qNum = c;
        int counter = 0;
        Scanner sc = new Scanner(System.in);
        Collections.shuffle(questions);
        for (Question question : questions){
            //if(goAhead == true){
            System.out.println(question);
            while(counter != qNum){
                System.out.print("Enter the letter of your choice: ");
                aC = sc.nextLine().trim();
                String answer = question.viewAnswer();
                if(aC.equals(answer)){
                    System.out.println("Correct!");
                    counter += 1;
                }else if(aC != answer){
                    //String output = String.format("Sorry the correct answer is %s", answer);
                    System.out.printf("Sorry the correct answer is %s\n\n", answer);
                    counter += 1;
                }
            }
        //}
     }   
    }
}