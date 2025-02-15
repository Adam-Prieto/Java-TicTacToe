public class WinnerChecker {
    public static boolean checkWinner(String[][] board) {
        String line;
        for (int a = 0; a < 8; a++) {
            line = "";
            switch (a) {
                case 0: line = board[0][0] + board[0][1] + board[0][2]; break;
                case 1: line = board[1][0] + board[1][1] + board[1][2]; break;
                case 2: line = board[2][0] + board[2][1] + board[2][2]; break;
                case 3: line = board[0][0] + board[1][0] + board[2][0]; break;
                case 4: line = board[0][1] + board[1][1] + board[2][1]; break;
                case 5: line = board[0][2] + board[1][2] + board[2][2]; break;
                case 6: line = board[0][0] + board[1][1] + board[2][2]; break;
                case 7: line = board[2][0] + board[1][1] + board[0][2]; break;
            }

            if (line.equals("XXX")) {
                System.out.println("You win!");
                return true;
            } else if (line.equals("OOO")) {
                System.out.println("I win!");
                return true;
            }
        }
        return false;
    }
}
