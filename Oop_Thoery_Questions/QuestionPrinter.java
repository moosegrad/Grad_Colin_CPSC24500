import java.util.ArrayList;
/**
 * This class will allows the program to print out the Questions 
 * and answers from the ArrayList that has been concatinated
 */
public class QuestionPrinter{
	/**
	 * This fucntion will sort through the array List
	 * Prints out the question Number, answer and question 
	 * in a neat format
	 * @param questions
	 */
    public static void printQuestions(ArrayList<Question> questions) {
		int counter = 1;
		//Collections.shuffle(questions);
		for (Question question : questions) {
			String answer = question.viewAnswer();
			String question2 = question.viewQuestion();
				System.out.printf(counter+ ": " + answer + "  " + question2 + "\n");
				counter +=1;
				//System.out.println(question)
			}//end for loop
	}//ends main
}//ends code