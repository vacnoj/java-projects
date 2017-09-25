import java.util.Scanner;
import java.io.File;
import java.io.IOException;

public class Airbnb {
// Airbnb will take in a file and read it. It will count the number
// of seesion numbers. It will calculate the maximum dim session number
// and the total number of session numbers and the average dim session
// number and the number who used an iPhone.       

    static int count = 0; 
    //variable that counts sessions
    static int dim_sess_num = 0;
    //variable that stores dim session number
    static int biggest_dim_sess = 0;
    //variable stores biggest dim number
    static double total_dim_sess = 0;
    //variable stores total of dim numbers
    static double average = 0.00;
    // variable stores average dim number
    static int iphone_count = 0;
    //variable counts iphones

    public static void main(String[] args) {
    // runs the main which calls multiple methods
        Scanner keyboard = new Scanner(System.in);
        // names keyboard as scanner that reads input
        File f; 
        // new file named F
        Scanner data; 
        // new scanner named data
        msg("Type in the name of the file: ");
        // tell user to type in the name of the file they want to read
        try {
        // try statement to make sure the file can be found 
            f = new File(keyboard.nextLine());
            // the file name typed in will be set to f
            data = new Scanner(f);
            // the scanner data will read file f
            process(data);
            // calls the method process on data
        } catch (IOException e) {
        // new exception e if the file can not be read in
            msg("Problem with FileIO:\n" + e);
            // tells user there is an error
            System.exit(12);
            // exits the program at 12
        }
        average = (total_dim_sess / count);
        //calculates average dim number
        msg("Number of Sessions: " + count);
        //prints number of sessions
        msg("The maximum dim session number: "+biggest_dim_sess);
        // prints the max dim session number
        System.out.printf("Total of numbers is %.0f \n" , total_dim_sess);
        // prints the total of session numbers
        System.out.printf("Average of numbers is %.2f \n" , average);
        // prints the average number
        msg("" + iphone_count + " iPhones");
        // prints the number of iphones used
    }

    public static void process(Scanner s) {
    // This will take Scanner s as an argument and break it up into lines
        for(int i = 0; i < 100; i++) {
        // for loop will interate through the lines of the file
            Scanner line = new Scanner(s.nextLine());
            // new Scanner named line to represent each line of the file
            processLine(line);
            // calls the meothod processLine on each line
            if (is_biggest()) {
            // if is_biggest is true, it will set the sess# as the biggest
                biggest_dim_sess = dim_sess_num;
            }    
            total_dim_sess += dim_sess_num;
            //adds the last session number to the total              
        }
    }

    public static void processLine(Scanner line) {
    /*This method will take each line and break up the line using the | 
    as the deliminator*/
        int dim_sess_count = 0;
        // variable that counts up each time deliminator is found
        line.useDelimiter("\\|");
        // breaks line up by the |
        while (line.hasNext() ) {
        // checks to see if there is still more in the line
            dim_sess_count++;
            // counts up every time there is more data
            if (dim_sess_count == 3) {
            // if it is the 3rd set of data, it is the session #                
                count++; 
                // counts # of dim sessions
                try {
                //try catch will check that the session # is an integer
                    dim_sess_num = Integer.parseInt(line.next());
                    // Turns the session number from String to an integer
                    msg("" + dim_sess_num);
                    // prints the session number
                } catch (Exception i) {
                // exception where session number cannot be converted to int
                    msg("Not a Number, Check format");
                    //tells user the error
                    System.exit(13);
                }                        
            }
            if (dim_sess_count == 4) {
            // checks to see if it is the 4th block of data
                String iphone_check = "";
                // initiates variable that will store the 4th block of data
                iphone_check= line.next();
                // variable that will store the 4th block of data
                    if(iphone_check.contains("iPhone")) {
                    // checks to see if an iPhone was used
                        iphone_count++;
                        // counts if the iPhone was used
                   }
            }                
            
            msg(line.next());
            // if it wasnt data we are looking at, it will still print it
            
        }
    }

    public static void msg(String m) {
    // makes it easy to type msg instead of System.out.println
        System.out.println(m);
    }
    
    public static boolean is_biggest() {
    /* a method that will compare session numbers to the biggest. If
    it is bigger than the previous biggest, it will return true and
    when it is called it will help to store it as the new biggest.*/
        
        if (dim_sess_num > biggest_dim_sess) {
        // compares session numbers
            return true;
        } return false;    
    }
}   


 