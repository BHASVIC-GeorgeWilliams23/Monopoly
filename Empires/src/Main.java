import org.w3c.dom.ls.LSOutput;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Countries Sweden = new Countries("Sweden", 1, 400000000000L);
        Countries Argentina = new Countries("Argentina", 2, 450000000000L);
        Countries Belgium = new Countries("Belgium", 3, 500000000000L);
        Countries Taiwan = new Countries("Taiwan", 4, 550000000000L);
        Countries Poland = new Countries("Poland", 5, 600000000000L);
        Countries Switzerland = new Countries("Switzerland", 6, 650000000000L);
        Countries SaudiArabia = new Countries("Saudi Arabia", 7, 700000000000L);
        Countries Netherlands = new Countries("Netherlands", 8, 750000000000L);
        Countries Turkey = new Countries("Turkey", 9, 800000000000L);
        Countries Indonesia = new Countries("Indonesia", 10, 900000000000L);
        Countries Spain = new Countries("Spain", 11, 1000000000000L);
        Countries Australia = new Countries("Australia", 12, 1100000000000L);
        Countries Mexico = new Countries("Mexico", 14, 1300000000000L);
        Countries Russia = new Countries("Russia", 15, 1500000000000L);
        Countries Canada = new Countries("Canada", 16, 1700000000000L);
        Countries Brazil = new Countries("Brazil", 17, 1800000000000L);
        Countries Italy = new Countries("Italy", 18, 2000000000000L);
        Countries France = new Countries("France", 19, 2200000000000L);
        Countries UK = new Countries("United Kingdom", 20, 2300000000000L);
        Countries India = new Countries("India", 21, 2500000000000L);
        Countries Japan = new Countries("Japan", 22, 3500000000000L);
        Countries Germany = new Countries("Germany", 23, 4000000000000L);
        Countries China = new Countries("China", 24, 14000000000000L);
        Countries USA = new Countries("United States of America", 25, 20000000000000L);
        Canada.setStatus(false);
        Canada.setOwner(1);
        Canada.countryCard();

        Scanner scan = new Scanner(System.in);
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i <= 3; i++) {
            System.out.println("Player " + (i+1)+ " Please select your character: PF - Pope Francis, XI - Xi Jinping, DT - Donald Trump, BJ - Boris Johnson: \n");
            String characterC = scan.nextLine();
            String character = "";
            if (characterC.equals("PF")) {
                character = "Pope Francis";
            } else if (characterC.equals("XI")) {
                character = "Xi Jinping";
            } else if (characterC.equals("DT")) {
                character = "Donald Trump";
            } else if (characterC.equals("BJ")) {
                character = "Boris Johnson";
            } else {
                System.out.println("Invalid input. Please try again.");
                i--; // Decrement i to repeat the loop for correct input
                continue;
            }
            players.add(new Player(i, character));
            players.get(i).PrintPlayerDetails();
        }




       // System.out.println(Sweden.getCost());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Press 0 to roll your two dice...");
        int input = scanner.nextInt();

        if (input == 0) {
            Dice dice1 = new Dice();
            Dice dice2 = new Dice();
            dice1.roll();
            System.out.println("First dice rolled a "+dice1.getValue());
            dice2.roll();
            System.out.println("Your second dice rolled a "+dice2.getValue());
            int total = dice1.getValue() + dice2.getValue();
            System.out.println("The total of the two dice rolls is: " + total);
        } else {
            System.out.println("Invalid input. Please press 0 to roll the dice.");
        }
        players.get(1).PrintPlayerDetails(); // Assuming PrintPlayerDetails() prints details internally

    }
}