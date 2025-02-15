import java.util.Random;

public class ComputerPlayer {

    public static void computerMove(String[][] board) {

        // 1.) GET CENTER SQUARE FIRST
        if (board[1][1].equals(" ")) {
            board[1][1] = "O";
            return;
        }

        // 2.) If a win presents itself, take it
        for (int i = 0; i < 3; i++) {
            // Check rows
            if (board[i][0].equals(board[i][1]) && board[i][0].equals("O") && board[i][2].equals(" ")) {
                board[i][2] = "O"; return;
            }
            if (board[i][0].equals(board[i][2]) && board[i][0].equals("O") && board[i][1].equals(" ")) {
                board[i][1] = "O"; return;
            }
            if (board[i][1].equals(board[i][2]) && board[i][1].equals("O") && board[i][0].equals(" ")) {
                board[i][0] = "O"; return;
            }

            // Check columns
            if (board[0][i].equals(board[1][i]) && board[0][i].equals("O") && board[2][i].equals(" ")) {
                board[2][i] = "O"; return;
            }
            if (board[0][i].equals(board[2][i]) && board[0][i].equals("O") && board[1][i].equals(" ")) {
                board[1][i] = "O"; return;
            }
            if (board[1][i].equals(board[2][i]) && board[1][i].equals("O") && board[0][i].equals(" ")) {
                board[0][i] = "O"; return;
            }
        }

        // Check diagonals for a win
        if (board[0][0].equals(board[1][1]) && board[0][0].equals("O") && board[2][2].equals(" ")) {
            board[2][2] = "O"; return;
        }
        if (board[1][1].equals(board[2][2]) && board[1][1].equals("O") && board[0][0].equals(" ")) {
            board[0][0] = "O"; return;
        }
        if (board[0][2].equals(board[1][1]) && board[0][2].equals("O") && board[2][0].equals(" ")) {
            board[2][0] = "O"; return;
        }
        if (board[1][1].equals(board[2][0]) && board[1][1].equals("O") && board[0][2].equals(" ")) {
            board[0][2] = "O"; return;
        }

        // 3.) If no win is possible, make a defensive move
        for (int i = 0; i < 3; i++) {
            // Check rows for defense
            if (board[i][0].equals(board[i][1]) && board[i][0].equals("X") && board[i][2].equals(" ")) {
                board[i][2] = "O"; return;
            }
            if (board[i][0].equals(board[i][2]) && board[i][0].equals("X") && board[i][1].equals(" ")) {
                board[i][1] = "O"; return;
            }
            if (board[i][1].equals(board[i][2]) && board[i][1].equals("X") && board[i][0].equals(" ")) {
                board[i][0] = "O"; return;
            }

            // Check columns for defense
            if (board[0][i].equals(board[1][i]) && board[0][i].equals("X") && board[2][i].equals(" ")) {
                board[2][i] = "O"; return;
            }
            if (board[0][i].equals(board[2][i]) && board[0][i].equals("X") && board[1][i].equals(" ")) {
                board[1][i] = "O"; return;
            }
            if (board[1][i].equals(board[2][i]) && board[1][i].equals("X") && board[0][i].equals(" ")) {
                board[0][i] = "O"; return;
            }
        }

        // Check diagonals for defense
        if (board[0][0].equals(board[1][1]) && board[0][0].equals("X") && board[2][2].equals(" ")) {
            board[2][2] = "O"; return;
        }
        if (board[1][1].equals(board[2][2]) && board[1][1].equals("X") && board[0][0].equals(" ")) {
            board[0][0] = "O"; return;
        }
        if (board[0][2].equals(board[1][1]) && board[0][2].equals("X") && board[2][0].equals(" ")) {
            board[2][0] = "O"; return;
        }
        if (board[1][1].equals(board[2][0]) && board[1][1].equals("X") && board[0][2].equals(" ")) {
            board[0][2] = "O"; return;
        }

        // 4.) If no defensive move is found, make a random move
        Random rand = new Random();
        int row, col;
        do {
            row = rand.nextInt(3);
            col = rand.nextInt(3);
        } while (!board[row][col].equals(" "));

        board[row][col] = "O"; // Place "O" in an empty spot
    }
}
