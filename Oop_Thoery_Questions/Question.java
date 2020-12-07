/**
 * this fucntion creates the questions class and model class
 * holds the data to be printer
 */
public class Question{
    private String question; //holder for question
    private String a; //holder for a
    private String b; //holder fot b
    private String c; //holder for c
    private String d; //holder for d
    private String answer; //holder for answer
    /**
     * return the qestion as a string to be used
     * @return
     */
    public String getQuestion(){
        return question;
    }
    /**
     * sets question to the input that it is provided 
     * @param question
     */
    public void setQuestion(String question){
        this.question = question;
    }
    /**
     * Takin in a string and returns that string to the private variuable
     * @return
     */
    public String getA(){
        return a;
    }
    /**
     * takin is a sring and set it to ta private variable
     * @param a
     */
    public void setA(String a){
        this.a = a;
    }
    /**
     * returns the variable b
     * @return
     */
    public String getB(){
        return b;
    }
    /**
     * sets the variableit takes in to the private variable
     * @param b
     */ 
    public void setB(String b){
        this.b = b;
    }
    /**
     * returns the variable c
     * @return
     */
    public String getC(){
        return c;
    }
    /**
     * sets the variable it takes in ot the privte variable 
     * @param c
     */
    public void setC(String c){
        this.c = c;
    }
    /**
     * returns the variaable d
     * @return
     */
    public String getD(){
        return d;
    }
    /**
     * sets the variable it takes in to the private variable
     * @param d
     */
    public void setD(String d){
        this.d = d;
    }
    /**
     * sets the variable it takes in to the private variable
     * @param answer
     */
    public void setAnswer(String answer){
        this.answer = answer;
    }
    /**
     * returns the variable answer
     * @return
     */
    public String getAnswer(){
        return answer;
    }
    /**
     * takin in string in order to to call the Set fucntions for 
     * the corispondingh variables
     * @param question
     * @param a
     * @param b
     * @param c
     * @param d
     * @param answer
     */
    public Question(String question, String a, String b, String c, String d, String answer){
        setQuestion(question);
        setA(a);
        setB(b);
        setC(c);
        setD(d);
        setAnswer(answer);
    }
    /*
    public Question(String answer, String question){
        setAnswer(answer);
        setQuestion(question);
    }
    */
    /**
     * Allows the answer to be formatted and printed out when it is called in the 
     * QuestionPrinter class
     * @return
     */
    public String viewAnswer(){
        return String.format("%s", answer);
    }
    /**
     * Allows the question to be formatted and printed out when it is called in the 
     * QuestionPrinter class
     * @return
     */
    public String viewQuestion(){
        return String.format("%s", question);
    }
    /**
     * formats the string to be printed 
     * @return String of questions and answers
     */
    public String toString(){
        return String.format("%s\nA. %s\nB. %s\nC. %s\nD. %s\n", question, a, b,c, d);
    }//end too string
} //end code