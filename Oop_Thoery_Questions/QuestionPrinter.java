import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;

public class QuestionPrinter{
    public static void printQuestions(ArrayList<Question> questions) {
			for (Question question : questions) {
					System.out.println(question);
				}
	}
}