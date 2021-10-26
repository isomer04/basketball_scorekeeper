import java.util.Scanner;

public class Main {

    // Scanner declared as static, so it can be used anywhere in this class
    // without having an instance of the class Driver.
    // In practice, it is similar to a global variable, but the underlying
    // concept is NOT the same.

    // static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {
        int team1[] = new int[4];
        int team2[] = new int[4];

        for (int qtr = 0; qtr < 4; qtr++) {
            quarterScoring(team1, team2, qtr);
        }

        int team1Total = teamTotal(team1);
        int team2Total = teamTotal(team2);


        displayGameResults(team1, team2, team1Total, team2Total);

        if (team1Total > team2Total) {
            System.out.println("\n\nTeam 1 has won the game!");
        } else {
            System.out.println("\n\nTeam 2 has won the game!");
        }
    }

    static int teamTotal(int[] team) {
        // This method will add the points a team has scored during all four quarters of a game.
        int teamTotal = 0;

        for(int qtr = 0; qtr < 4; qtr ++){
            teamTotal += team[qtr];
        }

        return teamTotal;
    }

    static void quarterScoring(int[] team1, int[] team2, int qtr) {
        // This method will continue to prompt user which team scored, and how many points are scored
        // When this method finishes, the appropriate team's score for the quarter will be assigned

        int userInput;
        int score;

        Scanner scanner = new Scanner(System.in);

        int qtrDisplay = qtr +1;
        System.out.println("\nQuarter: " + qtrDisplay);

        System.out.println("===========\n\n");

        for (int semiQtr = 0; semiQtr < 4; semiQtr++) {
            System.out.println("Which team scored (1 or 2):");
            userInput = scanner.nextInt();

            if (userInput == 1) {
                System.out.println("How many points did they score: ");
                score = scanner.nextInt();
                team1[qtr] += score;

            } else if (userInput == 2) {
                System.out.println("How many points did they score: ");
                score = scanner.nextInt();
                team2[qtr] += score;
            } else {
                System.out.println("There is no team " + userInput + ". It is an invalid team. The quarter has ended ");
                break;
            }
        }
    }


    static void displayGameResults(int[] team1, int[] team2, int team1Total, int team2Total) {
        // This method will display the scores for each team per quarter as well as the total score
        System.out.println(" \n\nTeam Scores by quarter: \nQ1 Q2 Q3 Q4 Total\n");

        for (int qtr = 0; qtr < 4; qtr++){
            System.out.print( team1[qtr] + " ");
        }
        System.out.print( team1Total+"\n");

        for (int qtr = 0; qtr < 4; qtr++){
            System.out.print( team2[qtr] + " ");
        }

        System.out.print(team2Total);

    }
}