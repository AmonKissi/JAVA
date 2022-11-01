import java.util.Random;
import java.util.Scanner;

    /* Developing a Program for Elementary Students that creates Math FlashCards
    & I'm Amon Kissi the brains behind this project */

public class AmonKissi_Projecth2 {

    //  Range Value of Problems between low and high
    static int generateRandomNumber(int low, int high) {
        Random random = new Random();
        return random.nextInt(high - low + low) + low;
    }

    //  Main method created for information
    public static void main(String[] args) {

        //  Welcome Message
        System.out.print("Welcome To My Math FlashCard Learning");

        //  Scanner class created
        Scanner sc = new Scanner(System.in);

        //  Variable to store data
        //  Stores user name
        String name;
        //  Store operation type
        String longProbType = "";
        //  Stores operation type first character
        char operationType;
        //  Stores number of problems
        int numberOfProblems;
        //  Stores upper and lower limit of random numbers
        int upperLimit, lowerLimit;
        //  Stores operands of expression
        int operandOne, operandTwo;
        //  Stores answers
        double computerResult = 0.0, userResult = 0.0;
        //  Stores number of correct answer
        double correct;
        //  Stores user choice to continue
        char choice;

        //  Loops for user choice
        do {

            // Reset answer for every session
            correct = 0;
            // User prompt to enter name
            System.out.print("\n Enter your name: ");
            name = sc.next();

            // Basic math operations which the user chooses to work
            // ( 'A' Addition, 'S' Subtraction, 'M' Multiplication & 'D' Division )
            System.out.print("\n What type of problem do you wish to work on? ");
            System.out.print("\n Enter \"A\" for Addition, \"S\" for Subtraction," + "\"M\" for Multiplication, \"D\" for Division: ");
            // User proceeds
            operationType = sc.next().charAt(0);
            // Lowest and highest number user chooses to work
            System.out.print("\n Enter the lowest factor value for your flashcard problems: ");
            lowerLimit = sc.nextInt();
            System.out.print("\n Enter the highest factor value for your flashcard problems: ");
            upperLimit = sc.nextInt();
            // Number of operations user chooses to work
            System.out.print("\n Enter the number of problems you wish to work on: ");
            numberOfProblems = sc.nextInt();


            // Loop until number of operations
            for (int c = 0; c < numberOfProblems; c++) {

                // Generate random number between lower and upper limit
                operandOne = generateRandomNumber(lowerLimit, upperLimit);
                operandTwo = generateRandomNumber(lowerLimit, upperLimit);
                // Validate the operation type and performs operations
                switch (operationType) {

                    case 'a':
                    case 'A':
                        // Stores operation type
                        longProbType = "Addition";
                        // Calculates expression
                        computerResult = operandOne + operandTwo;
                        System.out.print("\n " + operandOne + " + " + operandTwo + " = ");
                        // Accepts user result
                        userResult = sc.nextDouble();
                        break;

                    case 's':
                    case 'S':
                        // Stores operation type
                        longProbType = "Subtraction";
                        // Calculates expression
                        computerResult = operandOne - operandTwo;
                        System.out.print("\n " + operandOne + " - " + operandTwo + " = ");
                        // Accepts user result
                        userResult = sc.nextDouble();
                        break;

                    case 'm':
                    case 'M':
                        // Stores operation type
                        longProbType = "Multiplication";
                        // Calculates expression
                        computerResult = operandOne * operandTwo;
                        System.out.print("\n " + operandOne + " * " + operandTwo + " = ");
                        // Accepts user result
                        userResult = sc.nextDouble();
                        break;

                    case 'd':
                    case 'D':
                        // Stores operation type

                        longProbType = "Division";
                        // Calculates expression
                        computerResult = operandOne / operandTwo;
                        System.out.print("\n " + operandOne + " / " + operandTwo + " = ");
                        // Accepts user result
                        userResult = sc.nextDouble();
                        break;

                    default:
                        // Populates Wrong Answer
                        System.out.print("\n\t Incorrect!");
                }

                // End of switch case
                if (computerResult == userResult) {
                    // Populates Right Answer
                    System.out.print("\n Correct!");

                    // Increase correct counter
                    correct++;
                } else
                    // Wrong answer display correct answer
                    System.out.print("\n Incorrect! \n The Correct Answer is " + computerResult);
            }

            // Session Summary of User
            System.out.print("\n\n * - Session Summary - *");
            System.out.print("\n\n Total Problem(s): " + numberOfProblems);
            System.out.print("\n Total Correct Answer(s): " + correct);
            System.out.print("\n Your Average Score is " + (correct / numberOfProblems) * 100);
            System.out.print("\n\n Thank you for choosing My Math FlashCard Learning, " + name + ".");
            System.out.print("\n We hope to see you soon!");
            System.out.print("\n Session for " + name + " was " + longProbType +
                    " on " + java.time.LocalDate.now() + " at " + java.time.LocalTime.now());

            // Confirm user choice to continue or to stop
            System.out.print("\n\n Would you like to Continue My Math FlashCard Learning?");
            System.out.print("\n Enter (Y) for Yes & (N) for No: ");
            choice = sc.next().charAt(0);

            // Check user choice to end loop
            if (choice == 'N' || choice == 'n')
                break;

        }
        while (true);
        // End loop closing message
        System.out.print("\n\t\t The Session has ended. We hope to see you soon, " + name + ". Bye Bye!");
    }
}
