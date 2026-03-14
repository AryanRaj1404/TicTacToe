import java.util.*;

class Main{
    static String[] board;
    static String turn;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        board= new String[9];
        turn = "X";
        String winner = null;

        for(int i = 0; i < 9; i++){
            board[i] = String.valueOf(i+1);
        }
        // System.out.print(board[2]);

        System.out.println("Welcome to Tic Tac Toe Game");
        System.out.println("X will make the first move");
        System.out.println("Enter the box number you want to fill");
        PrintBoard.printBoard(board);
        while(winner==null){
            int numInput;
            try {
                numInput = sc.nextInt();
                if(!(numInput > 0 && numInput <= 9)){
                    System.out.println("Please enter a valid number");
                }
                if(board[numInput-1].equals(String.valueOf(numInput))){
                    board[numInput-1] = turn;
                    turn = turn.equals("X")?"O" : "X";
                    PrintBoard.printBoard(board);
                    winner=Winner.checkWinner(board, turn);
                }
            } catch(InputMismatchException e){
                System.out.println("Enter a valid number, retry!");
                sc.nextLine();
            }
        }

        if(winner.equalsIgnoreCase("draw")){
            System.out.println("It's DRAW");
        }
        else{
            System.out.println("Congratualations "+ winner +"'s have won");
        }
    }
}