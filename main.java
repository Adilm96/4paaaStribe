public class main {

    public static void main(String[]args){
        //initialisere game-board
        tictactoe t = new tictactoe();
        boolean gStatus = false; // hvis sandt vinder en spiller
        // spillet spilles til en spiller vinder
        do {
            t.updateBoard();
            t.printBoard();
            //Printer besked hvis spillet er slut
            if (t.checkWinner()){
                System.out.println("You won congratulations");
                gStatus = true;
            }
            if (t.isBoardEmpty()) {
                System.out.println("The game was a draw");
                gStatus = true;
            }
            t.changePlayer();
        }while (gStatus == false); // repeates til spil er ovre
    }
}
