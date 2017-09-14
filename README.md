import java.util.Scanner;
import java.util.Arrays;
/**
 * This is a code that runs the game tic tac toe
 * this is a personal project
 * it will prompt the user for a move using text and a scanner
 * and then will use graphic objects to be a visual representation of the game
 */
public class TicTacToe{

    // final variables for the program
    public static final int NUM_BOXES = 9;
    public static final int ROWS = 3;
    public static final int COLS = 3;
    public static final char PIECE_ONE = 'X';
    public static final char PIECE_TWO = 'O';
    
    public static void main(String[] args){
        char[] board = new char[ROWS * COLS];
        board = buildBoard(board);
        Scanner scan = new Scanner(System.in); 
        boolean computer = intro(scan);
        if(computer){
            runComputer(scan, board);
        } else {
            runTwoPlayers(scan, board);
        }
    }   

    // sets up the array used as the game board 
    // by initializing each index as the char 
    // representation of the numbers 1 - 9
    // returns the board
    public static char[] buildBoard(char[] board){
        for(int n = 1; n <= ROWS * COLS; n++){
            board[n - 1] = (char) n;
        }
        return board;
    }

    // prints out the intro and prompts the user
    // to determine whether the user will play against 
    // another the person or against the person
    // and then returns the answer
    public static boolean intro(Scanner scan){
        System.out.println("This is Tic Tac Toe");
        System.out.println("You can play with another player,");
        System.out.println("or you can play against the computer");
        System.out.println("Input TWO PLAYERS and hit enter, if you would like to play against someone.");
        System.out.println("Otherwise, enter COMPUTER to play against the computer.");
        String answer = scan.nextLine().toUpperCase();
        return answer.equals("COMPUTER");
    }

    // prompts each user for their choice
    // calls check choice to ensure that the chouce is valid
    // then returns the choice
    public static int getInput(Scanner scan, String name, char[] board){
        int choice = 0;
        System.out.println(name + ", enter which square you would like to play.");
        choice = scan.nextInt();
        scan.nextLine();
        choice = checkChoice(choice, scan, name, board);
        return choice;
    }

    // checks to make sure that the choice is
    // valid and within the boundaries of the game
    // returns choice if valid, otherwise it calls 
    // the method to get a new input, and returns 
    // the value of that method call
    public static int checkChoice(int choice, Scanner scan, String name, char[] board){
        for(int n = 0; n < ROWS * COLS; n++){
            if(board[n] == choice){
                return choice;
            }
        }
        return getInput(scan, name, board);
    }

    // gets and returns the name of the users
    public static String getName(Scanner scan, String numPlayer){
        System.out.println("Player " + numPlayer + ", please enter your name.");
        return scan.nextLine();
    }

    // this method is called if the user wants to play against
    // the computer, it runs the entire game by calling all 
    // of the needed methods in a while loop until the game
    // is won
    public static void runComputer(Scanner scan, char[] board){
        System.out.println("You chose to play against the computer.");
        System.out.println("You will be " + PIECE_ONE + ", and the");
        System.out.println(" computer will be " + PIECE_TWO + ".");
        String playerName = getName(scan, "1");
        //while(!winner(board)){
        int choice = getInput(scan, playerName, board);
        checkChoice(choice, scan, playerName, board);
        
        //}
    }

    // this method checks to see if there is a winner
    // or a draw, then returns the result
    public static boolean winner(char[] board){
        // TODO: this method needs to be completed
        return true;
    }

    // this method is called if the user wants to play against
    // the computer, it runs the entire game by calling all 
    // of the needed methods in a while loop until the game
    // is won, similr to runComputer method
    public static void runTwoPlayers(Scanner scan, char[] board){
        System.out.println("You chose to play with two players.");
        System.out.println("Player 1 will be " + PIECE_ONE + ", and Player 2");
        System.out.println("will be " + PIECE_TWO + ".");
        String nameOne = getName(scan, "1");
        String nameTwo = getName(scan, "2");
        int choice = getInput(scan, nameOne, board);
        choice = checkChoice(choice);
        updateBoard(choice);
        if(!winner(board)){
            choice = getInput(scan, nameTwo, board);
        }
    }
}
