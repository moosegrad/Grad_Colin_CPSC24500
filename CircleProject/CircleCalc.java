package CircleProject;

/**
*
*this program will take random radiuses and calculate the area and circumfrance.
*
*@author Colin Grad
*@since 2020-09-15
*@version 1.0
*
*
* */
//Import 
import java.util.Random; //import the random fucnntion
//main class
public class CircleCalc{
	//functions
	public static double mathForArea(double a){
		double area_Circle = Math.PI * (a * a); //math for area
		return area_Circle; //return result of area
			
		} //end function
	//main
	public static double mathForCircum(double b){
		double circum_Circle = 2 * Math.PI * b; //circumfrence calculation
		return circum_Circle; //return result for circumfrence
	}
	//main
	public static void main(String[] args){
		//class for arithmatic
		Random rand = new Random(); //generate random number initilization
		//Variables
		int rand_Number_Radius =  rand.nextInt(100); //generate random number
		double circum_Circle, areaCircle; //doubles for fucntion results to be stored in.
		//Fucntions
		circum_Circle = mathForCircum (rand_Number_Radius); //function of Circumfrence
		areaCircle = mathForArea(rand_Number_Radius); //fucntion for area
		//Print statments
		System.out.println("The raidus of the circle is: "+ rand_Number_Radius +"\n"); //print random number
		System.out.println("The Circumfrence of the Circle is: "+ circum_Circle + "\n");//print Circumfrence
		System.out.println("The area of the cicle is: " + areaCircle +"\n"); //print the area
		//end program 
	}
}//end main