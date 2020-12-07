/**
 * this fucntion creates the questions class and model class
 * holds the data to be printer
 */
public class Question{
    private String question;
    private String a;
    private String b;
    private String c;
    private String d;
    private String answer;
    // get question
    public String setQuestion(){
        return question;
    }
    //set question
    public void setQuestion(String question){
        this.question = question;
    }
    //get a
    public String getA(){
        return a;
    }
    //set a 
    public void setA(String a){
        this.a = a;
    }
    //get b
    public String getB(){
        return b;
    }
    //set b 
    public void setB(String b){
        this.b = b;
    }
    //get c
    public String getC(){
        return c;
    }
    //set c
    public void setC(String c){
        this.c = c;
    }
    //get d
    public String getD(){
        return d;
    }
    //set d
    public void setD(String d){
        this.d = d;
    }
    //set answer
    public void setAnswer(String answer){
        this.answer = answer;
    }
    public String getAnswer(){
        return answer;
    }
    public Question(String question, String a, String b, String c, String d, String answer){
        setQuestion(question);
        setA(a);
        setB(b);
        setC(c);
        setD(d);
        setAnswer(answer);
    }
    public String viewAnswer(){
        return String.format("%s", answer);
    }
    /**
     * formats the string to be printed 
     * @return String of questions and answers
     */
    public String toString(){
        return String.format("%s\nA. %s\nB. %s\nC. %s\nD. %s\n", question, a, b,c, d);
    }
}