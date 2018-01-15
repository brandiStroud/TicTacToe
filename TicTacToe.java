import java.awt.Graphics;
import java.awt.Color;
import java.util.Scanner;
import java.util.Arrays;
/**
 * This is a code that runs the game tic tac toe
 * this is a personal project
 * it will prompt the user for a move using text and a scanner
 * and then will use graphic objects to be a visual representation of the game
 */
public class TicTacToe{

    public static final int NUM_BOXES = 9;
    public static final int ROWS = 3;
    public static final int COLS = 3;
    public static final char PIECE_ONE = 'X';
    public static final char PIECE_TWO = 'O';

    public static void main(String[] args){
        char[] board = new char[ROWS * COLS];
        board = buildBoard(board);
        Scanner scan = new Scanner(System.in);
        //DrawingPanel drawPan = new DrawingPanel(900, 900);
        //Graphics g = drawPan.getGraphics();
        //drawPan.setBackground(Color.GREEN);
        //drawLines(g);
        //drawNums(g); 
        boolean computer = intro(scan);
        if(computer){
            runComputer(scan, board);
        } else {
            runTwoPlayers(scan, board);
        }
    }   

    public static char[] buildBoard(char[] board){
        for(int n = 1; n <= ROWS * COLS; n++){
            board[n - 1] = (char) n;
        }
        return board;
    }

    public static void drawLines(Graphics g){
        g.fillRect(290, 50, 20, 800);
        g.fillRect(590, 50, 20, 800);
        g.fillRect(50, 290, 800, 20);
        g.fillRect(50, 590, 800, 20);
    }
    
    public static void drawNums(Graphics g){
        for(int r = 1; r <= ROWS; r++){
            for(int c = 1; c <= COLS; c++){
                g.drawString("" + (r * c), 850 - 175 * c, 850 - 175 * r);
            }
        }
    }
// 
//     public static void printNumbers(char[] board){
//         for(int r = 0; r < ROWS; r++){
//             for(int c = 0; c < COLS; c++){
//                 System.out.print(board[r][c]);
//             }
//             System.out.println();
//         }
//     }

    public static boolean intro(Scanner scan){
        System.out.println("This is Tic Tac Toe");
        System.out.println("You can play with another player,");
        System.out.println("or you can play against the computer");
        System.out.println("Input TWO PLAYERS and hit enter, if you would like to play against someone.");
        System.out.println("Otherwise, enter COMPUTER to play against the computer.");
        String answer = scan.nextLine().toUpperCase();
        return answer.equals("COMPUTER");
    }

    public static int getInput(Scanner scan, String name, char[] board){
        int choice = 0;
        System.out.println(name + ", enter which square you would like to play.");
        choice = scan.nextInt();
        scan.nextLine();
        choice = checkChoice(choice, scan, name, board);
        return choice;
    }

    public static int checkChoice(int choice, Scanner scan, String name, char[] board){
        for(int n = 0; n < ROWS * COLS; n++){
            if(board[n] == choice){
                return choice;
            }
        }
        return getInput(scan, name, board);
    }

    public static String getName(Scanner scan, String numPlayer){
        System.out.println("Player " + numPlayer + ", please enter your name.");
        return scan.nextLine();
    }

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

    public static boolean winner(char[] board){
        return true;
    }

    public static void runTwoPlayers(Scanner scan, char[] board){
        System.out.println("You chose to play with two players.");
        System.out.println("Player 1 will be " + PIECE_ONE + ", and Player 2");
        System.out.println("will be " + PIECE_TWO + ".");
        String nameOne = getName(scan, "1");
        String nameTwo = getName(scan, "2");
        int choice = getInput(scan, nameOne, board);
        updateBoard(choice);
        if(!winner(board)){
            choice = getInput(scan, nameTwo, board);
        }
    }
}
