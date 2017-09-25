//import java utilities and scanner Class
import java.util.Scanner;

// name Class based on what it will do
public class WeatherStats {

   //initiate keyboard as an input scanner
   static Scanner keyboard = new Scanner (System.in);

   // Main method will call the weather_entries method
   public static void main(String[] args) {
      weather_entries();
   }   
   
   public static void weather_entries() {
      //initiate variables
      // count to determine # of temperatures entered
      int countTemp = 1;

      //temp variable to store temperature
      int temp = 0;

      // use count variables to determine number of temps entered in each category
      int countOver100 = 0;
      int countOver90 = 0;
      int countOver80 = 0;
      int countOver70 = 0;
      int countOver60 = 0;
      int countUnder60 = 0;

      //boolean variable that determines if there is another temp
      boolean anotherTemp = true;

      //tell user to type negative number to exit
      System.out.println("Type negative number to end.\n");

      //write while statement to get all user input and run until negative number
      while (anotherTemp) {
         
         //ask user to input temerpature # _
         System.out.println("In ˚F, enter temperature " + countTemp + ": ");

         // try statement to see if it is numberic
         try {
         //store input into temp
            temp = keyboard.nextInt();
    
         }
         
         catch (Exception e) {
            System.out.println("Enter temperature in numeric values only.\n");
            keyboard.nextLine();
            temp = 706958493;
         }   

            //if/else statement to determine which category it falls into
            if (temp >120 && temp != 706958493){
            /*if temp is over 120, it is an error*/
               System.out.println("That's too hot!\nTry again");
            }

            else if (temp >= 100 && temp <= 120){
               System.out.println(temp + "˚F is in the 100's!\n");
               countTemp++; //count ++ to count how many temperatures we have
               countOver100++; // count ++ to determine how many in this category
            }

            else if (temp >= 90 && temp < 100){
               System.out.println(temp + "˚F is in the 90's!\n");
               countTemp++; //count ++ to count how many temperatures we have
               countOver90++; // count ++ to determine how many in this category
            }

            else if (temp >= 80 && temp < 90){
               System.out.println(temp + "˚F is in the 80's!\n");
               countTemp++; //count ++ to count how many temperatures we have
               countOver80++; // count ++ to determine how many in this category
            } 

            else if (temp >= 70 && temp < 80){
               System.out.println(temp + "˚F is in the 70's!\n");
               countTemp++; //count ++ to count how many temperatures we have
               countOver70++; // count ++ to determine how many in this category
            } 

            else if (temp >= 60 && temp < 70){
               System.out.println(temp + "˚F is in the 60's!\n");
               countTemp++; //count ++ to count how many temperatures we have
               countOver60++; // count ++ to determine how many in this category
            } 

            else if (temp < 60 && temp >= 0){
               System.out.println("Brrrr... " + temp + "˚F is under 60˚F...\n");
               countTemp++; //count ++ to count how many temperatures we have
               countUnder60++; // count ++ to determine how many in this category
            } 
               
           // if/else statement to determine if there is another number
            if (temp > -1) {
              anotherTemp = true;
            }
           
            else anotherTemp = false;
      } // end while loop
        
      //countTemp will be 1 higher than the number of inputs since the last input fails loop
      countTemp = countTemp-1;
     
      //Print out the counts for each category
      System.out.println("Temperatures in the 100's: " + countOver100);
      System.out.println("Temperatures in the 90's:  " + countOver90);
      System.out.println("Temperatures in the 80's:  " + countOver80);
      System.out.println("Temperatures in the 70's:  " + countOver70);
      System.out.println("Temperatures in the 60's:  " + countOver60);
      System.out.println("Temperatures below 60:     " + countUnder60);
      
      // Print number of temps entered   
      System.out.println("\nTotal number of temperatures enetered: " + countTemp);
   
   }// End Method*/ 
}//End Class
