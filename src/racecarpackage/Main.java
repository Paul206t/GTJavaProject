package racecarpackage;

import java.util.Scanner;
import java.time.LocalDate;

public class Main {
    // Creating a new scanner and defining variables
    static Scanner scan = new Scanner(System.in);
    static int carCrash = 0;
    static int horsePower = 100;
    static LocalDate todayDate = LocalDate.now();

    // I plan on having random available weather conditions so this will change once I figure out how to do this
    static String weatherCondition = "Sunny";

    public static void main(String[] args) {

        System.out.println("Welcome to Gran Turismo: Java Edition! \n");
        System.out.println("Today's date is " + todayDate + ".");
        System.out.println("The current weather condition is: " + weatherCondition + ".\n");

        // Call chooseCar method
        chooseCar();
        // Call laps method
        laps();

        System.out.println("\nThanks for playing!");
    }



    public static void chooseCar() {

        // Print out the cars available to you
        System.out.println("The following cars are available to you.");
        System.out.println("1. " + car1.name);
        System.out.println("2. " + car2.name);
        System.out.println("3. " + car3.name);
        System.out.print("\nPlease tell me which car you would like to drive: ");
        int carChosen = scan.nextInt();
        System.out.println(" ");

        // Switch statement to determine which car to assign you based on the number you chose
        switch (carChosen) {
            case 1:
                horsePower = car1.horsePower;
                System.out.println("You have chosen the " + car1.name);
                System.out.println("You car has a horsepower of " + horsePower + ".");
                break;
            case 2:
                horsePower = car2.horsePower;
                System.out.println("You have chosen the " + car2.name);
                System.out.println("You car has a horsepower of " + horsePower + ".");
                break;
            case 3:
                horsePower = car3.horsePower;
                System.out.println("You have chosen the " + car3.name);
                System.out.println("You car has a horsepower of " + horsePower + ".");
                break;
            default:
                System.out.println("Because you can't follow directions I have given you a 1972 AMC Gremlin. Enjoy. ");
                carCrash = 1;
                break;
        }
    }


    public static void laps() {
        // Asking for number of laps
        System.out.print("\nEnter the number of laps in this race: ");
        int numLaps = scan.nextInt();

        if (numLaps > 10) {
            System.out.println("That's a lot of laps, you should probably dial it back a bit. Let's try 10 or less okay? ");
            laps();
        }
        else if (numLaps < 1) {
            System.out.println("You've put in less than 1. Let's try this again please. ");
            laps();
        }
        else {
            // Asking for each lap time
            System.out.println("Please input how many seconds each one of your laps were. \n");
            // Created double type array to store size of it based on what was entered for numLaps
            double[] lapTimes = new double[numLaps];

            // For loop to ask for each Lap time only up to the number of laps that was inputted (lapTimes.length)
            // and stores each lap time that's been input in each next iterated element of the lapTimes Array
            for (int i = 0; i < lapTimes.length; i++) {
                System.out.print("Lap time: ");
                lapTimes[i] = scan.nextDouble();
            }

            // Sets fastest lap initially to first element of lapTimes array
            double fastestTime = lapTimes[0];

            // For loop to compare each element of the array to the next until it gets to the end and sets
            // fastestTime from that element of the lapTimes array, int i starts at index 1 because fastestTime
            // was already set to index 0 for comparison
            for (int i = 1; i < lapTimes.length; i++) {
                if (lapTimes[i] < fastestTime) {
                    fastestTime = lapTimes[i];
                }
            }

            // Print fastestTime
            if (carCrash == 1) {
                System.out.println("\nYou crashed at the finish line because you were driving a 1972 AMC Gremlin.");
                System.out.print("Do ywe have a pre-need funeral policy on file in the event that your loved ones are left behind (y/n)? ");
                String funeralConfirm = scan.next();

                if (funeralConfirm.equals("y") || funeralConfirm.equals("yes") || funeralConfirm.equals("Y") || funeralConfirm.equals("Yes")) {
                    System.out.println("\nGreat! We will be contacting your family shortly. ");
                }
                else {
                    System.out.println("\nOur sponsor, Hamilton Funeral Home will be contacting your family shortly to talk about at-need arrangements. ");
                }
            }
            else {
                System.out.format("\nYour fastest lap was: %.1f seconds.\n", fastestTime);
            }

            // Get sum of all lap times and calculate + print the average lap time
            double sumLaps = 0;
            double lengthLapTimes = lapTimes.length;
            for(int i = 0; i < lapTimes.length; i++){
                sumLaps += lapTimes[i];
            }
            double avgLapTimes = sumLaps / lengthLapTimes;
            System.out.format("Your average lap time was: %.1f seconds.\n", avgLapTimes);
        }
    }
}
