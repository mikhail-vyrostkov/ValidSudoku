import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws ParseException {
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '.', '9'}};

        byte[] a;

       System.out.println(Solution.isValidSudoku(board));

    }

    public static class Solution {
        public static boolean isValidSudoku(char[][] board) {

            for (int i = 0; i < 9; i++) {
                if (!isValid(board, i, i, 0, board.length -1)) {
                    return false;
                }
                if (!isValid(board, 0, board.length -1, i, i)) {
                    return false;
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!isValid(board, 3 * i, 3 * i + 2, 3 * j, 3 * j + 2)) {
                        return false;
                    }
                }
            }
            return true;
        }
        private static boolean isValid(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {

            Set set = new HashSet();
            for (int i = rowStart; i <= rowEnd; i++) {
                for (int j = colStart; j <= colEnd; j++) {
                    if (set.contains(board[i][j])) {
                        return false;
                    } else if (board[i][j] != '.') {
                        set.add(board[i][j]);
                    }
                }
            }
            return true;
        }
    }
}

