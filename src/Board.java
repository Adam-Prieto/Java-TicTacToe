import java.util.Scanner;
import java.util.Random;


public class Board {
    public static void resetBoard(String[][] workingBoard)
    {
        for (int i = 0; i < workingBoard.length; i++)
            for (int j = 0; j < workingBoard.length; j++)
                workingBoard[i][j] = " ";
    } // End resetBoard

    public static void showBoard(String[][] board2)
    {
        System.out.println("   0   1   2"); // column numbers

        // First row
        System.out.println("0  " + board2[0][0] + " | " + board2[0][1] + " | "
                + board2[0][2]);

        System.out.println("  ---+---+---"); //horizontal separator

        // Second row
        System.out.println("1  " + board2[1][0] + " | " + board2[1][1] + " | "
                + board2[1][2]);


        System.out.println("  ---+---+---"); // horizontal separator

        // Third row
        System.out.println("2  " + board2[2][0] + " | " + board2[2][1] +
                " | " + board2[2][2] + "\n");
    } // End showBoard

}
