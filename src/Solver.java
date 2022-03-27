public class Solver {
    public static int[] getEmpty(int[][] board) {
        int[] solution = {-1,-1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 0) {
                    solution[0] = i;
                    solution[1] = j;
                    return solution;
                }
            }
        }
        return solution;
    }

    public static boolean inRow(int[][] board, int row, int num) {
        for (int i = 0; i < board[row].length; i++) {
            if(board[row][i] == num){
                return true;
            }
        }
        return false;
    }

    public static boolean inColumn(int[][] board, int column, int num){
        for(int i=0; i< board.length; i++){
            if(board[i][column] == num){
                return true;
            }
        }
        return false;
    }
    public static boolean inBox(int[][] board, int row, int column, int num){
        for(int i=0; i<3; i++){
            for(int j=0; j<3; j++){
                if(board[row+i][column+j] == num){
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean isOk(int[][] board, int row, int column, int num){
        if(!inRow(board,row,num) && !inColumn(board,column,num) && !inBox(board,row - row % 3,column - column % 3,num)){
            return true;
        }
        else{
            return false;
        }
    }

    public static boolean sudokuSolver(int[][] board){
        int[] coordinates = getEmpty(board);
        if(coordinates[0] == -1){
            return true;
        }
        else{
            int row = coordinates[0];
            int col = coordinates[1];
            for(int i=0; i<10; i++){
                if(isOk(board,row,col,i)){
                    board[row][col] = i;
                    if(sudokuSolver(board)){
                        return true;
                    }
                    board[row][col] = 0;
                }
            }
        }
        return false;
    }

    public static void printBoard(int[][] board){
        for(int i=0; i<board.length;i++){
            for(int j=0; j<board[i].length; j++){
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println();
    }

    public static void main(String[] args) {
        int[][] board = {{5, 8, 0, 2, 0, 0, 4, 7, 0},
                {0, 2, 0, 0, 0, 0, 0, 3, 0},
                {0, 3, 0, 0, 5, 4, 0, 0, 0},
                {0, 0, 0, 5, 6, 0, 0, 0, 0},
                {0, 0, 7, 0, 3, 0, 9, 0, 0},
                {0, 0, 0, 0, 9, 1, 0, 0, 0},
                {0, 0, 0, 8, 2, 0, 0, 6, 0},
                {0, 7, 0, 0, 0, 0, 0, 8, 0},
                {0, 9, 4, 0, 0, 6, 0, 1, 5}};
        printBoard(board);
        sudokuSolver(board);
        printBoard(board);
    }
}
