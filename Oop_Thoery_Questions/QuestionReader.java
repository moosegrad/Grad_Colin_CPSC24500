//import
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
//json
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * This class allows the program to read in data from a JSON Dodument
 */
public class QuestionReader{
    /**
     * This will allows the program to Take out the Questions, 
     * options for a-d and the answer from thr json docuemnt
     * concatinated the arraylist
     * @param fname
     * @return
     */
    public ArrayList<Question>  readFromJSON(String fname){
        ArrayList<Question> questions = new ArrayList<Question>(); //create array
        //ArrayList<Question> questions2 = new ArrayList<Question>(); //create array
       
        String question, a, b, c, d, answer; //vartiables for the values to be held
        try{
            FileReader reader = new FileReader(new File(fname));
            JSONParser parser = new JSONParser();
            JSONObject all = (JSONObject)parser.parse(reader);
            JSONArray arr = (JSONArray)all.get("questions");
            Iterator itr = arr.iterator();
            JSONObject questionObject;
            while(itr.hasNext()){
                questionObject = (JSONObject)itr.next();
                question = questionObject.get("question").toString();
                a = questionObject.get("a").toString();
                b = questionObject.get("b").toString();
                c = questionObject.get("c").toString();
                d = questionObject.get("d").toString();
                answer = questionObject.get("answer").toString();
                questions.add(new Question(question, a, b, c ,d, answer));
            }
            reader.close();
            return questions;
        }catch(Exception ex){
            return null; //return null value if try fails
        } //end try catch
    
    }//end main
}//end program 