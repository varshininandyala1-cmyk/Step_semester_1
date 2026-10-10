import java.util.Scanner;
import java.util.Random;

public class RockPaperScissorsGame {

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }

        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }

        return "Computer Wins";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        String[] moves = {"Rock", "Paper", "Scissors"};

        int n = sc.nextInt();

        String[] playerMoves = new String[n];
        String[] computerMoves = new String[n];
        String[] results = new String[n];

        int wins = 0, losses = 0, draws = 0;

        for (int i = 0; i < n; i++) {
            playerMoves[i] = sc.next();

            computerMoves[i] = moves[random.nextInt(3)];

            results[i] = playRound(
                playerMoves[i], computerMoves[i]
            );

            if (results[i].equals("Player Wins")) {
                wins++;
            } else if (results[i].equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }
        }

        System.out.println("Round | Player Move | Computer Move | Result");

        for (int i = 0; i < n; i++) {
            System.out.println(
                (i + 1) + " | " + playerMoves[i] +
                " | " + computerMoves[i] +
                " | " + results[i]
            );
        }

        double percentage = (wins * 100.0) / n;

        System.out.println("Wins: " + wins);
        System.out.println("Losses: " + losses);
        System.out.println("Draws: " + draws);
        System.out.printf("Win Percentage: %.1f%%%n", percentage);

        sc.close();
    }
}