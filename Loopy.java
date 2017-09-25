import java.util.Scanner; // allow Scanner class for user input

public class Loopy { /* Class named Loopy will call the main method and go through
   problem 1, 2, and 3. Problem 1 will take k and add the invert of all even k's and
   subtract the invert of all odd k's. It will go k times. Problem 2 will take a 
   String and check if it is a palindrome. Problem 3 will add each number entered until
   the user types a 0.*/
   
   static Scanner keyboard = new Scanner (System.in); // keyboard as input scanner
   
   public static void main(String[] args) { //main method will run problem1-3
      
      boolean another = false;// boolean to determine if each problem needs to be run again
      
      do { // do problem 1 atleast once
         
         System.out.println(1 + problem1()); // prints out result of 1 + problem1 method
            
         System.out.println("\nType '1' to do another or '2' to continue."); // ask user to do another
         
         if (keyboard.nextInt() == 1) { // if user types 1
      
         another = true; // user wants another
         }
         else another = false; // otherwise they dont
      
      } while (another == true); // run do loop again if they pressed 1
      
      System.out.println("End of problem 1.");// tells user problem 1 is done
      
      System.out.println("\n"+"Press enter to continue to the next problem:");/* tells user
         to press enter to go to the next problem.*/
     
      keyboard.nextLine();// defaults keyboard to no value for next problem
      
      do { // do problem 2 atleast once
      
         System.out.println("\n"+problem2()+"\n"); // prints out result of problem2 method
            
         System.out.println("Type '1' to do another or '2' to continue."); // ask user to do another
         
         if (keyboard.nextInt() == 1) { // if user types 1
         
         another = true; // they want another
         }
         else another = false; // otherwise they dont
      
      } while (another == true); // run do loop again if they pressed 1
            
      System.out.println("End of problem 2.\n");// tells user problem 2 is done     
      
      System.out.println("press enter to continue to the next problem:");/* tells user
         to press enter to go to the next problem.*/
      
      keyboard.nextLine();// clears the keyboard variable
      
      do { // do problem 3 atleast once
         
         System.out.println(problem3()); // prints out result of problem3 method
            
         System.out.println("\nType '1' to do another or '2' to continue."); // ask user to do another
   
         if (keyboard.nextInt() == 1) { // if user types 1
      
         another = true; // they want another
         }
         else another = false; // otherwise they dont
      
      } while (another == true); // run do loop again if they pressed 1      
      
      System.out.println("The end."); // Tells user the program is done.
      
   } //ends main method  
   
   public static double problem1() { /*Problem 1 will take k and add the invert
      of all even k's and subtract the invert of all odd k's. It will go k times.*/
      
      // initiate variables
      int count = 1; //counts the number of times to run = k
      int k = 0; //user imput for K
      double d = 2;// variable to determine if we need to add or subtract next
      double result = 0;// stores the running total
      boolean error = false; //decides if there is an error so user can try again
      
      System.out.println("Type in a number for k: "); //ask user for K variable
      
      do { //do while loop to catch non numeric values
         
         try { // starts try looking for errors
            k = keyboard.nextInt(); //tells program where it might expect an error
            error = false; // if no errors, it exits do while loop
         } //ends try
         catch (Exception a) { // catches error and allows exception
            System.out.println("Only insert numeric values.");/* tell
               user to use numbers*/
            keyboard.nextLine(); //clear keyboard
            error = true; //loops back to the 'do'
         } //ends catch
      } while (error == true); // if error is true, it will allow another input  
      
      for (k = k; Math.abs(count) < Math.abs(k); count++) { /*for loop to compute
       value of result*/
         
         if (d % 2 == 0 && k < 0) { // if k is negative and even, subtract 1/d
            result += -(1/d); // stores the running total for the final result
            System.out.println("-1/" + (int)d); // shows user how it is computed
            d++; // adds to d while k < count of k
         } // ends if block
         
         else if (d % 2 == 1 && k < 0) { // if k is negative and odd, add 1/d
            result += (1/d); // stores the running total for the final result
            System.out.println("+1/" +(int)d); // shows user how it is computed
            d++; // adds to d while k < count of k
         } // ends if block
         
         else if (d % 2 == 0) { // if k is postive and even, add 1/d
            result += (1/d); // stores the running total for the final result
            System.out.println("+1/" + (int)d); // shows user how it is computed
            d++; // adds to d while k < count of k
         } // ends if block
         
         else if (d % 2 == 1) { // if k is postive and odd, subtract 1/d
            result += -(1/d); // stores the running total for the final result
            System.out.println("-1/" +(int)d); // shows user how it is computed
            d++; // adds to d while k < count of k
         } // ends if block
      } //ends for block      
   return result; // returns result as value of problem1 method
   }// end of problem1 method


   public static boolean problem2() { /*Method problem 2 will take a String and
      check if it is a palindrome.*/
      
      int count = 0; // count variable will count to the length of the String
      keyboard.nextLine(); // clears the keyboard to accept another input
      System.out.println("Type in the words you want to check!"); /* tells user
         to enter the String they want to check.*/
      
      String pal = ""; // variable pal stores the String the user enters
      
      for (pal = keyboard.nextLine(); count < pal.length(); count++) { /* for loop 
         will take pal, while the count is less than the length of pal, it will check 
         the char at the position of count and compare to the same position counting 
         backward. count goes up by 1 after each time it runs.*/
         
         pal = pal.replaceAll("[^a-zA-Z0-9]", ""); // only keeps the alphanumberic chars
         
         pal = pal.toLowerCase(); //makes the String lowercase so A and a will be equal
                  
         System.out.print(pal.charAt(count)); // pirnts out the char counting up
         
         System.out.print(pal.charAt(pal.length()-1 -count)); //prints char counting backward
         
         System.out.println(""); // prints out a new line for better show
         
         if (pal.charAt(count) == pal.charAt(pal.length()-1-count)) { /* If the
            char at the count from the beginning equals the char at the count from the
            end, return to the top of the for loop and count ++.*/
            
         } // end of if block
         else break; /* if the chars are not equal, it will break out of the for loop
            then return false*/
         
         if (count + 1 == pal.length()) { /* if the count is able to reach the length
            of the String, it must be a palindrome*/
            return true; // returns true for the Method problem2
         } // end of if block
            
      } return false; // end of for loop, if it has not returned true by now, it is false
         
   }// end of Method problem2
      
   public static int problem3() {/* beginning of Method problem3. It will add all numbers
      entered into a running total, then return it when user enters 0.*/
      
      keyboard.nextLine(); // clears keyboard for new input
      int total = 0; // variable total will keep running total of numbers entered   
      int n = 0; // variable n will store user input
      
      System.out.println("Type '0' when you are done."); //tells user to typ 0 when done
      do { /* do loop will execute atleast once. It will keep running while input is
         not 0.*/
      
         System.out.println("Enter a number that you want to add: "); // ask for input
   
         n = keyboard.nextInt();// store input in variable n
         
         total += n; // total plus next input equals new total
      
      } while (n != 0);// if n is 0, break do loop
      
      return total;// returns total after 0 is entered
   
   }// end of Method problem3

}// end of class Loopy



