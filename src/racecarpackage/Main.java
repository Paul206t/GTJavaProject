package racecarpackage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Creating a new scanner and defining to scan
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Gran Turismo: Java Edition!\n");

        // Print out the cars available to you
        System.out.println("1. " + cars_bmw_m3_gt.name);
        System.out.println("2. " + cars_dodge_viper_gts.name);
        System.out.println("3. " + cars_nissan_skyline_gtr.name);
        System.out.print("\nPlease tell me which car you would like to drive: ");
        int carCrash = 0;
        int carChosen = scan.nextInt();

        // Switch statement to determine which car to assign you based on the number you chose
        switch (carChosen) {
            case 1:
                System.out.println("You have chosen the " + cars_bmw_m3_gt.name);
                break;
            case 2:
                System.out.println("You have chosen the " + cars_dodge_viper_gts.name);
                break;
            case 3:
                System.out.println("You have chosen the " + cars_nissan_skyline_gtr.name);
                break;
            default:
                System.out.println("Because you can't follow directions I have given you a 1972 AMC Gremlin. Enjoy. ");
                carCrash = 1;
                break;
        }

        // Asking for number of laps
        System.out.print("\nEnter the number of laps in this race: ");
        int numLaps = scan.nextInt();

        // Created double type array to store size of it based on what was entered for numLaps
        double[] lapTimes = new double[numLaps];

        // For loop to ask for each Lap time only up to the number of laps that was inputted (lapTimes.length)
        // and stores each laptime that's been input in each next iterated element of the lapTimes Array
        for (int i = 0; i < lapTimes.length; i++) {
            System.out.print("Lap time: ");
            lapTimes[i] = scan.nextDouble();
        }

        // Sets fastest lap initially to first element of lapTimes array
        double fastestTime = lapTimes[0];
        // For loop to compare each element of the array to the next until it gets to the end and sets
        // fastestTime from that element of the lapTimes array, i starts at index 1 because fastestTime
        // was already set to index 0 for comparison
        for (int i = 1; i < lapTimes.length; i++) {
            if (lapTimes[i] < fastestTime) {
                fastestTime = lapTimes[i];}
        }

        // Print fastestTime
        if (carCrash == 1) {
            System.out.println("\nYou crashed at the finish line because you were driving a 1972 AMC Gremlin.");
            System.out.print("Do ywe have a pre-need funeral policy on file in the event that your loved ones are left behind? ");
            String funeralConfirm = scan.next();

            if (funeralConfirm.equals("y") || funeralConfirm.equals("yes") || funeralConfirm.equals("Y") || funeralConfirm.equals("Yes")){
                System.out.println("\nGreat! We will be contacting your family shortly. ");
            }
            else {
                System.out.println("\nOur sponsor, Hamilton Funeral Home will be contracting your family shortly to talk about at-need arrangements. ");
            }

        }
        else {
            System.out.println("\nYour fastest lap was: " + fastestTime);
        }
    }
}