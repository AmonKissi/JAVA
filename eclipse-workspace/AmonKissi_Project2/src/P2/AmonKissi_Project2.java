package P2;

import java.util.Random;
import java.util.Scanner;

        // Author: Amon Kissi
        // Description: Developing a Program for Elementary Students that creates Math FlashCards

public class AmonKissi_Project2 {


    public static void main(String[] args) {

        //  Welcome Message
        System.out.print("\n Welcome To My Math FlashCard Learning");


        // Instantiate Scanner and Random objects
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        //  Variable to store data
        //  Stores user name

            String name;
            String probType = "E";
            String longProbType = "Error";
            String numberOfProblems = " ";
            String oper = " ";
            int numProb = 0;
            int loRange;
            int hiRange;
            int getFactor1;
            int getFactor2;
            int answer = 0;
            int response = 0;
            int score = 0;
            double scorePct;
            int a = 0, b = 0, c = 0;

            String corInc;
            String[] history;



        // Prompt for and read-in user entered parameters **************************************
            // Prompt for and read-in the student's name
            System.out.print("\n Enter your name: ");
            name = input.next();

            // Prompt for and read-in the problem type (A, S, M, D)
            System.out.print("\n What type of problem do you wish to work on? ");
            System.out.print("\n Enter \"A\" for Addition, \"S\" for Subtraction," + "\"M\" for Multiplication, \"D\" for Division: ");
            probType = input.next();
            probType = probType.toUpperCase(); // Convert the probType to uppercase

            // Use switch(probType) to update the longProbType var
        switch (probType) {
            case ("A") -> {
                longProbType = "Addition";
                oper = " + ";
            }
            case ("S") -> {
                longProbType = "Subtraction";
                oper = " - ";
            }
            case ("M") -> {
                longProbType = "Multiplication";
                oper = " * ";
            }
            case ("D") -> {
                longProbType = "Division";
                oper = " / ";
            }
        }
            // Prompt for and read-in the low and high factor range
            System.out.print("\n Enter the lowest factor value for your flashcard problems: ");
            loRange = input.nextInt();
            System.out.print("\n Enter the highest factor value for your flashcard problems: ");
            hiRange = input.nextInt();


            // Prompt for and read-in the number of problems to be worked
            System.out.print("\n Enter the number of problems you wish to work on: ");
            numProb = input.nextInt();
            history = new String[numProb];  // Need to set array size after read-in numProb
            System.out.println();
            System.out.println();

            // Display a summary of the student's choices - name, problem type, number of problems
            // and then start the FlashCard system
            System.out.println("          Hi " + name + ", and welcome to My Math FlashCard Learning!");
            System.out.println("              You have chosen the operation " + longProbType + ".");
            System.out.println("    The range of factors you have chosen is from " + loRange + " to " +
                    hiRange + ", inclusive.");
            System.out.println("                You have chosen to work " + numProb + " problems.");
            System.out.println("          Press any character key and then Enter to begin.");
            input.next();
            System.out.println();
            System.out.println();

            // Begin the process (loop) of presenting/working problems ***********************************

            for (int i = 0; i < numProb; i++) {

                // Get the random factor values
                getFactor1 = random.nextInt(hiRange - loRange + 1) + loRange;
                getFactor2 = random.nextInt(hiRange - loRange + 1) + loRange;

                //getFactor1 = 0;  // Used for interim test for the fix of division by 0

                // Create problems
                switch (probType) {
                    case "A" -> {
                        a = getFactor1;
                        b = getFactor2;
                        c = getFactor1 + getFactor2;
                        answer = c;
                    }
                    case "S" -> {
                        a = getFactor1 + getFactor2;
                        b = getFactor1;
                        c = getFactor2;
                        answer = c;
                    }
                    case "M" -> {
                        a = getFactor1;
                        b = getFactor2;
                        c = getFactor1 * getFactor2;
                        answer = c;
                    }
                    case "D" -> {
                        while (getFactor1 == 0) {
                            getFactor1 = random.nextInt(hiRange - loRange + 1) + loRange;
                        }
                        a = getFactor1 * getFactor2;
                        b = getFactor1;
                        c = getFactor2;
                        answer = c;
                    }
                }

                // Determine correct/incorrect answer, update running score
                System.out.print(a + oper + b + " = ");
                response = input.nextInt();
                if (response == answer) {
                    corInc = "Correct";
                    System.out.println(corInc + "!");
                    score++;
                } else {
                    corInc = "Incorrect";
                    System.out.println(corInc + "! Correct answer is " + answer);
                }

                // Add the problem to the history array
                history[i] = a + oper + b + " = " + response + ", " + corInc + ", correct answer is " + c;
                System.out.println();


            }  // End of loop for numProb ************************************************



            // End-of-session processing *****************************************************
            scorePct = (double) score / numProb * 100;
            System.out.println();
            System.out.print("\n * - Session Summary - *");
            System.out.print("\n\n Total Problem(s): " + numberOfProblems);
            System.out.println(numProb + " problems, " + score + " correct");
            System.out.printf("\n Your Average Score is %5.1f \n", scorePct);
            System.out.println();



            // Print the history array
            System.out.println("Problems");
            for (int i = 0; i < numProb; i++) {
                System.out.println(history[i]);
            }
            System.out.println();

            System.out.println("Thank you for using My Math FlashCard Learning, " + name + ".");
            System.out.println(" We hope to see you again!");
            System.out.print(" Session for " + name + " was " + longProbType +
                " on " + java.time.LocalDate.now() + " at " + java.time.LocalTime.now());
            System.out.println();



    }  // End of main method ***********************************************************

}  // End of class *************************************************************************


