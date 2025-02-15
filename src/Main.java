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
        } while (playAgain == 'Y');

        System.out.println("Have a nice day!");
    } // End main

    public static void playMatch()
    {
        boolean isNextTurn;

        resetBoard(board);
        showBoard(board);
        isNextTurn=whoGoesFirst(board);
        showBoard(board);

        int moveNumber;
        for(moveNumber = 0; moveNumber < 8; moveNumber++)
        {
            if(isNextTurn)
            {
                ComputerPlayer.computerMove(board);

                isNextTurn = false;
            }//end if
            else
            {
                playerMove(board);
                isNextTurn=true;
            }//end else
            showBoard(board);
            if (WinnerChecker.checkWinner(board))
                break;
        }//end for

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
    }//end conversionFunction

//****************************************************************************

    public static void playerMove(String[][] game)
    {
        System.out.println("Please enter your move. \nEnter the row number" +
                " first \nand column number second.");
        char moveNumber1 = userInput.next().charAt(0);

        //validate input
        while(moveNumber1 < '0' || moveNumber1 > '2')
        {
            System.out.println("Invalid input \nPlease make sure that the" +
                    " space you want to move is empty.\n");
            moveNumber1=userInput.next().charAt(0);
        }//end while

        char moveNumber2=userInput.next().charAt(0);
        while(moveNumber2<'0' && moveNumber2>'2')
        {
            System.out.println("Invalid input \nPlease make sure that the" +
                    " space you want to move is empty.");
            moveNumber2=userInput.next().charAt(0);
        }//end of while

        //make sure the spot is empty
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
            }//end inner while

            moveNumber2=userInput.next().charAt(0);

            while(moveNumber2<'0' && moveNumber2>'2')
            {
                System.out.println("Invalid input \nPlease make sure that the" +
                        " space you want to move is empty.");
                moveNumber2=userInput.next().charAt(0);
            }//end second inner while
        }//end while
        game[conversionFunction(moveNumber1)][conversionFunction(moveNumber2)]
                = "X";
    }//end playerMove

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
        }//end if
        else
        {
            playerMovesFirst=false;
            System.out.println("I will go first.");
            board[1][1]="O";
        } // End else

        return playerMovesFirst;
    }//end whoGoesFirst

//****************************************************************************

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

//****************************************************************************

    public static void resetBoard(String[][] workingBoard)
    {
        for (int i = 0; i < workingBoard.length; i++)
            for (int j = 0; j < workingBoard.length; j++)
                workingBoard[i][j] = " ";
    } // End resetBoard

} // End Main