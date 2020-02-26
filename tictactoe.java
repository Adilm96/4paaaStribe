import java.util.Scanner;

public class tictactoe {

    private char[][] board;   //game board som 2d array
    private char currentPlayer; //nuvaerende spiller x eller o
    private int rows = 3;
    private int colums = 3;

    Scanner sc = new Scanner(System.in);

    public tictactoe() {
        board = new char[rows][colums];
        currentPlayer = 'x';    //x starter
        initializeBoard();

    }

    // Denne metode resetter boarded til at alle values er tomme
    public void initializeBoard() {
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < colums; j++){
                board[i][j] = '-';
            }
        }
    }

    //Printer nuværende board
    public void printBoard() {
        System.out.println("--------------");
        for (int i = 0; i < rows; i++){
            System.out.println("| ");
            for (int j = 0; j < colums; j++) {
                System.out.println(board[i][j] + " | ");
            }
            System.out.println("");
            System.out.println("----------------");
        }
    }

    /** herunder loopes der igennem alle cellerne på boarded for at se om boarded er tomt.
     * hvis den er tom med value (-), så returnes false-
     * ellers returnes true.
     */
    public boolean isBoardEmpty(){
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }

        return true;
    }

    //Returner true hvis der er win ellers false
    public boolean checkWinner() {
        return (checkRows() || checkColums() || checkDia());
    }

    //Looper igennem rows og ser om der er en vinder.
    private boolean checkRows() {
        for (int i = 0; i < rows; i++){
            if (board[i][0] != '-' && board[i][0] == board [i][1] &&
            board[i][0] == board[i][2]){
                return true;
            }
        }

        return false;
    }

    // looper gennem rows og col for at se efter vinder.
    private boolean checkColums(){
        for (int i = 0; i < colums; i++){
            if (board[0][i] != '-' && board[0][i] == board[1][i] &&
            board[0][i] == board[2][i]){
                return true;
            }
        }

        return false;
    }

    //Checker de to diagonaler for at se om de er en i vinder.
    private boolean checkDia() {
      return (board[0][0] != '-' && board[0][0] == board[1][1] &&
                board[0][0] == board[2][2])||
                (board[0][2] != '-' && board[0][2] == board[1][1]
                        && board[0][2] == board[2][0]);
    }

    //aendre spillerbrikkerne frem og tilbage.
    public void changePlayer() {
        currentPlayer = (currentPlayer == 'x') ? 'o' : 'x';
    }

    /** placerer spillerbrikkerne til paagaeldende celle specificeret via row og col
     */

    public void updateBoard(){
        boolean validInput = false; // hvis true, så er input valid
        do {
            if (currentPlayer == 'x'){
                System.out.println("Player 'X, enter move");
            } else {
                System.out.println("Player 'O, enter move");
            }
            int row = sc.nextInt() - 1; //array index starter på 0 istedet for 1
            int col = sc.nextInt() - 1;

            if (row >= 0 && row < rows && col >= 0 && col < colums
             && board[row][col] == '-'){
             board[row][col] = currentPlayer; //updater board
             validInput = true; //hvis input er iorden saa exites loop
            }else {
                System.out.println("Move at ("+ (row + 1) + ", " + (col +1) + ") is not valid");
            }
        } while (!validInput); // repeat til input er valid.
    }
}
