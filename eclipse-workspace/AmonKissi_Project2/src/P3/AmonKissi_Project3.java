package P3;


import java.util.Random;
import java.util.Scanner;


public class AmonKissi_Project3 {

    // Author: Amon Kissi
    // Description: This program generates flashcards for the user, evaluates the user's responses to the
    // flashcards, keeps a running score, and prints the final statistics for the user's session.
    // Refactoring for P3: broke single main program into 3 classes, driver/main, Cards, Session
    // Refactoring for P3: converted key code sets into methods



    Scanner sc = new Scanner(System.in);

    // return user choice
    char menu() {
        char choice;

// Loops valid choice entered by the user
        do {
// Displays the menu
            System.out.print("\n Enter the type of problems you wish to work - " +
                    "A, S, M, or D? ");
// Converts to upper case
            choice = Character.toUpperCase(sc.next().charAt(0));
            if (choice == 'A' || choice == 'S' || choice == 'M' || choice == 'D')
// Returns the choice
// Checks if user choice is either 'A' or 'S' or 'M' or 'D' then valid
                return choice;
// Otherwise displays error message
            else
                System.out.print("\n Entry must be A, S, M, or D. Try again.");
        } while (true);// End of do - while loop
    }// End of function

    // Function receives a message
// Accepts a number validates it and returns it
    int validNumber(String message) {
        int num;
// Loops till valid number entered by the user
        do {
// try block begins
            try {
// Displays the message
                System.out.print(message);
// Accepts a number
                String data = sc.next();
// Converts it to integer
                num = Integer.parseInt(data);

// Checks if number is less than or equals to 0 then
// throws NumberFormatException
                if (num <= 0)
                    throw new NumberFormatException();
// Otherwise valid number
                else
// returns the number
                    return num;
            }// End of try block

// Catch block to handle NumberFormatException
            catch (NumberFormatException ex) {
                System.out.print("\n Entry must be an integer. Try again");
            }// End of catch block

        } while (true);// End of do - while loop
    }// End of function


    public static void main(String[] s) {

        // Instantiate Scanner and Random objects
        Scanner input = new Scanner(System.in);
        Random random = new Random();

        String name;
        int numberOfProblems;
        int loFactor, hiFactor;
        int correct;
        int score;
        int computedAnswer, userAnswer;
        double computedAnswerD, userAnswerD;
        double scorePct;
        long startTime, endTime, duration;
        String summary;
        String longProbType;


// Creates an object of Random class
        Random rand = new Random();
// Creates an object of class FlashCards
        AmonKissi_Project3 fc = new AmonKissi_Project3();

// Loops till user choice is not 'N' or 'n'
        do {
// Resets summary and operation type to null for each game
            summary = longProbType = "";
// Resets correct answer and score to 0 for each game
            correct = score = 0;

// Accepts name of the player
            //  Welcome Message
            System.out.print("\n Welcome To My Math FlashCard Learning");
            System.out.print("\n Enter your name: ");
            name = fc.sc.next();

// Calls the function to accept user choice for operation
            char choice = fc.menu();

// Calls the function to accept number of problems
            numberOfProblems = fc.validNumber("\n Enter number of problems you wish to work: ");
// Need to set array size after read-in numberOfProblems

// Calls the function to accept lower limit
            loFactor = fc.validNumber("\n Enter the lowest factor value for your flashcard problems: ");

// Calls the function to accept higher limit
            hiFactor = fc.validNumber("\n Enter the highest factor value for your flashcard problems: ");


// Stores the start time
            startTime = System.currentTimeMillis();

// Loops till number of questions
            for (int c = 0; c < numberOfProblems; c++) {
// Generates a random number for first operand between low and high value
                int operandOne = rand.nextInt(hiFactor - loFactor + loFactor) + loFactor;
// Generates a random number for second operand between low and high value
                int operandTwo = rand.nextInt(hiFactor - loFactor + loFactor) + loFactor;

// Checks user selected operation
                switch (choice) {
                    case 'A':
// Stores the operation type
                        longProbType = "Addition";
// Calculates the sum
                        computedAnswer = operandOne + operandTwo;
// Calls the function to accept user answer passes question
// as parameter
                        userAnswer = fc.validNumber("\n " + operandOne +
                                " + " + operandTwo + " = ");

// Concatenates question, user answer, computed answer
                        summary += operandOne + " + " + operandTwo + " = " +
                                userAnswer + " A: " + computedAnswer;

// Checks if computed answer and user answer is same
                        if (computedAnswer == userAnswer) {
// Increase the correct answer counter by one
                            correct++;
// Adds score
                            score += 33;
// Concatenates status of answer as correct
                            summary += " correct \n ";
                            System.out.print("\n Correct!");
                        }// End of if condition

// Otherwise wrong answer
                        else {
// Concatenates status of answer as incorrect
                            summary += " incorrect \n ";
                            System.out.print("\n Incorrect");
                        }// End of else
                        break;
                    case 'S':
// Stores the operation type
                        longProbType = "Subtraction";
// Calculates the subtraction
                        computedAnswer = operandOne - operandTwo;
// Calls the function to accept user answer passes question
// as parameter
                        userAnswer = fc.validNumber("\n " + operandOne +
                                " - " + operandTwo + " = ");

// Concatenates question, user answer, computed answer
                        summary += operandOne + " - " + operandTwo + " = " +
                                userAnswer + " A: " + computedAnswer;

// Checks if computed answer and user answer is same
                        if (computedAnswer == userAnswer) {
// Increase the correct answer counter by one
                            correct++;
// Adds score
                            score += 33;
// Concatenates status of answer as correct
                            summary += " correct \n ";
                            System.out.print("\n Correct!");
                        }// End of if condition

// Otherwise wrong answer
                        else {
// Concatenates status of answer as incorrect
                            summary += " incorrect \n";
                            System.out.print("\n Incorrect");
                        }// End of else
                        break;
                    case 'M':
// Stores the operation type
                        longProbType = "Multiplication";
// Calculates the product
                        computedAnswer = operandOne * operandTwo;
// Calls the function to accept user answer passes question
// as parameter
                        userAnswer = fc.validNumber("\n " + operandOne +
                                " * " + operandTwo + " = ");

// Concatenates question, user answer, computed answer
                        summary += operandOne + " * " + operandTwo + " = " +
                                userAnswer + " A: " + computedAnswer;

// Checks if computed answer and user answer is same
                        if (computedAnswer == userAnswer) {
// Increase the correct answer counter by one
                            correct++;
// Adds score
                            score += 33;
// Concatenates status of answer as correct
                            summary += " correct \n ";
                            System.out.print("\n Correct!");
                        }// End of if condition

// Otherwise wrong answer
                        else {
// Concatenates status of answer as incorrect
                            summary += " incorrect \n";
                            System.out.print("\n Incorrect");
                        }// End of else
                        break;
                    case 'D':
// Stores the operation type
                        longProbType = "Division";
// Calculates the division
                        computedAnswerD = operandOne / operandTwo;
// Calls the function to accept user answer passes question
// as parameter
                        userAnswerD = fc.validNumber("\n " + operandOne +
                                " / " + operandTwo + " = ");

// Concatenates question, user answer, computed answer
                        summary += operandOne + " / " + operandTwo + " = " +
                                userAnswerD + " A: " + computedAnswerD;

// Checks if computed answer and user answer is same
                        if (computedAnswerD == userAnswerD) {
// Increase the correct answer counter by one
                            correct++;
// Adds score
                            score += 33;
// Concatenates status of answer as correct
                            summary += " correct \n ";
                            System.out.print("\n Correct!");
                            scorePct = (double) score / numberOfProblems * 100;
                            System.out.println();
                            System.out.print("\n * - Session Summary - *");
                            System.out.print("\n\n Total Problem(s): " + numberOfProblems);
                            System.out.println(numberOfProblems + " problems, " + score + " correct");
                            System.out.printf("\n Your Average Score is %5.1f \n", scorePct);
                            System.out.println();




                        }// End of if condition



// Otherwise wrong answer
                        else {
// Concatenates status of answer as incorrect
                            summary += " incorrect \n ";
                            System.out.print("\n Incorrect");
                        }// End of else
                        break;
                }// End of switch - case
            }// End of for loop

// Stores the stop time
            endTime = System.currentTimeMillis();
// Calculates time taken
            duration = (endTime - startTime) / 1000;

// Displays summary
            System.out.println("\n Thank you for using My Math FlashCard Learning, " + name + ".");
            System.out.println(" We hope to see you again!");
            System.out.print(" Session for " + name + " was " + longProbType +
                    " on " + java.time.LocalDate.now() + " at " + java.time.LocalTime.now());
            System.out.println();


// Accepts user choice to continue or not
            System.out.print("\n Would you like to try another set of problems? Y/N? ");
            char ch = fc.sc.next().charAt(0);

            // Converts to upper case
            ch = Character.toUpperCase(ch);
// Checks if user choice is 'N' then come out of the loop
            if (ch == 'N')
                break;
        } while (true);// End of do - while loop
        System.out.println("\n Thank you for using the 3312 FlashCard System, " + name + ".");
        System.out.println(" Come back and play again real soon!");
    }// End of main method
}// End of class



