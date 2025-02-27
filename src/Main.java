import java.util.Scanner;
import java.util.Random;

public class Main {


    //BOARD STUFF
    public static final int SIZE = 3;
    public static String[][] board = new String[SIZE][SIZE];

    //input object
    public static Scanner userInput = new Scanner(System.in);


    public static void main(String[] args) {
        char playAgain;

        // Message and match
        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Here is the board we will use:");

        do {
            playMatch();

            // Play again?
            System.out.println("\nPlay again? (Y/N): ");
            playAgain = userInput.next().charAt(0);
            playAgain = Character.toUpperCase(playAgain);
        } while (playAgain == 'Y'); // End do while

        System.out.println("Have a nice day!");
    } // End main

    public static void playMatch()
    {
        boolean isNextTurn;

        Board.resetBoard(board);
        Board.showBoard(board);
        isNextTurn=whoGoesFirst(board);

        Board.showBoard(board);
        int moveNumber;
        for(moveNumber = 0; moveNumber < 8; moveNumber++)
        {
            if(isNextTurn)
            {
                ComputerPlayer.computerMove(board);

                isNextTurn = false;
            } // End if
            else
            {
                playerMove(board);
                isNextTurn=true;
            } // End else
            Board.showBoard(board);
            if (WinnerChecker.checkWinner(board))
                break;
        } // End for

        if(moveNumber == 8)
            System.out.print("Draw");
    } // End playMatch

//****************************************************************************

    public static int conversionFunction(char input)
    {
        int variable = 0;

        if(input == '1')
            variable= 1;

        else if(input == '2')
            variable = 2;

        return variable;
    } // End conversionFunction

//****************************************************************************

    public static void playerMove(String[][] game)
    {
        System.out.println("Please enter your move. \nEnter the row number" +
                " first \nand column number second.");
        char moveNumber1 = userInput.next().charAt(0);

        // Validate input
        while(moveNumber1 < '0' || moveNumber1 > '2')
        {
            System.out.println("Invalid input \nPlease make sure that the" +
                    " space you want to move is empty.\n");
            moveNumber1=userInput.next().charAt(0);
        } // End while

        char moveNumber2=userInput.next().charAt(0);

        // Make sure the spot is empty
        while(!(game[conversionFunction(moveNumber1)][conversionFunction(moveNumber2)]
                        ==" "))
        {
            System.out.println("Invalid input \nPlease make sure that the" +
                    " space\n you want to move is empty.\nEnter" +
                    " the row number.");
            moveNumber1=userInput.next().charAt(0);

            while(moveNumber1<'0' || moveNumber1>'2')
            {
                System.out.println("Invalid input \nPlease make sure that the" +
                        " space you want to move is empty.");
                moveNumber1=userInput.next().charAt(0);
            } // End inner while

            moveNumber2=userInput.next().charAt(0);

            while(moveNumber2<'0' && moveNumber2>'2')
            {
                System.out.println("Invalid input \nPlease make sure that the" +
                        " space you want to move is empty.");
                moveNumber2=userInput.next().charAt(0);
            } // End second inner while
        } // End while
        game[conversionFunction(moveNumber1)][conversionFunction(moveNumber2)]
                = "X";
    } //End playerMove

//****************************************************************************

    public static boolean whoGoesFirst(String[][] game)
    {
        boolean playerMovesFirst;

        //Random object
        Random choice = new Random();

        int firstMove = choice.nextInt(2);

        if(firstMove == 1)
        {
            playerMovesFirst = true;
            System.out.println("You will go first.");
            playerMove(game);
        } // End if
        else
        {
            playerMovesFirst=false;
            System.out.println("I will go first.");
            board[1][1]="O";
        } // End else

        return playerMovesFirst;
    } // End whoGoesFirst
} // End Main