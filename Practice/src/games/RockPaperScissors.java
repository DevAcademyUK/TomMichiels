package games;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    // define class-wide variables
    String playerName;
    String playerMove;
    String computerMove;
    int score;
    Scanner myScanner = new Scanner(System.in);

    //main method to create instance of class and run initialiseGame method
    public static void main(String[] args){
        RockPaperScissors rps = new RockPaperScissors();
        rps.initialiseGame();
    }

    //gets user name then runs playGame
    private void initialiseGame(){
        System.out.println("Enter your name: ");
        playerName = myScanner.nextLine();
        playGame();
    }


    private void playGame(){
        System.out.println("Enter your move: ");
        //read line input
        playerMove = myScanner.nextLine();
        //return player move to output
        System.out.println(playerName + " has selected " + playerMove + " as their move");
        //fill computerMove variable with output from generateComputerMove method
        computerMove = generateComputerMove();
        //define new variable to hold result determined by getWinner method
        //(not sure why passing directly when they are instance variables as well)
        String result = getWinner(playerMove, computerMove);
        //assign win or loss based on result, update score variable
        if(result.equalsIgnoreCase("Win")){
            System.out.println("Congratulations, you won this round!");
            score++;
        }
        else if(result.equalsIgnoreCase("Lose")){
            System.out.println("You lost this round!");
            score--;
        }
        else {
            System.out.println("This round was a draw!");
        }
        //if score is between 3 and -3, recurse on this method
        if(score < 3 && score > -3){
            playGame();
        }
        //if score reaches 3, return a win result to user
        else if(score == 3){
            System.out.println("Winner Winner!!");
        }
        //as above, but -3 and a loss
        else if(score == -3){
            System.out.println("You Looooooosssseeeee!");
        }

    }

    private String generateComputerMove() {
        //new instance of Random object set to r
        Random r = new Random();
        //empty string move
        String move = "";
        //get a random int (either 0,1, or 2)
        int i = r.nextInt(3);
        //switch cases to assign either rock, paper, or scissors to move depending on the random number
        switch(i){
            case 0:
                move = "Rock";
                break;

            case 1:
                move = "Paper";
                break;

            case 2:
                move = "Scissors";
                break;
        }
        //return the move
        return move;
    }

    private String getWinner(String playerMove, String computerMove){
        String outcome = "";
        //nested ifs compare player move to computer move then assigns result to outcome variable
        if(playerMove.equalsIgnoreCase("rock")){
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Draw";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Lose";
            }
            else{
                outcome = "Win";
            }
        }
        if(playerMove.equalsIgnoreCase("paper")){
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Win";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Draw";
            }
            else{
                outcome = "Lose";
            }
        }
        if(playerMove.equalsIgnoreCase("scissors")){
            if(computerMove.equalsIgnoreCase("rock")){
                outcome = "Lose";
            }
            else if(computerMove.equalsIgnoreCase("paper")){
                outcome = "Win";
            }
            else{
                outcome = "Draw";
            }
        }
        //note - if player income isn't either rock,scissors,paper (case insensitive) you'll get a blank result returned
        //return outcome
        return outcome;
    }
}
