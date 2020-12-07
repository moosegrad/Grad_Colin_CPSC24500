import java.util.ArrayList;

public class QuestionPrinter{
    public static void printQuestions(ArrayList<Question> questions) {
		int counter = 1;
		//Collections.shuffle(questions);
		for (Question question : questions) {
			String answer = question.viewAnswer();
			String question2 = question.viewQuestion();
				System.out.printf(counter+ ": " + answer + " " + question2 + "\n");
				counter +=1;
				//System.out.println(question)
			}
	}
}