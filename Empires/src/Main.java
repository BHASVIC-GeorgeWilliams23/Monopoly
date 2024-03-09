import org.w3c.dom.ls.LSOutput;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        // Creating Country Objects
        Board.PrintBoard();
        Countries Sweden = new Countries("Sweden", 1, 400, 50, 60, 70, 80);
        Countries Argentina = new Countries("Argentina", 2, 450, 55, 65, 75, 85);
        Countries Belgium = new Countries("Belgium", 3, 500, 60, 70, 80, 90);
        Countries Taiwan = new Countries("Taiwan", 4, 550, 65, 75, 85, 95);
        Countries Poland = new Countries("Poland", 5, 600, 70, 80, 90, 100);
        Countries Switzerland = new Countries("Switzerland", 6, 650, 75, 85, 95, 105);
        Countries SaudiArabia = new Countries("Saudi Arabia", 7, 700, 80, 90, 100, 110);
        Countries Netherlands = new Countries("Netherlands", 8, 750, 85, 95, 105, 115);
        Countries Turkey = new Countries("Turkey", 9, 800, 90, 100, 110, 120);
        Countries Indonesia = new Countries("Indonesia", 10, 900, 95, 105, 115, 125);
        Countries Spain = new Countries("Spain", 11, 1000, 100, 110, 120, 130);
        Countries Australia = new Countries("Australia", 12, 1100, 105, 115, 125, 135);
        Countries Mexico = new Countries("Mexico", 14, 1300, 110, 120, 130, 140);
        Countries Russia = new Countries("Russia", 15, 1500, 115, 125, 135, 145);
        Countries Canada = new Countries("Canada", 16, 1700, 120, 130, 140, 150);
        Countries Brazil = new Countries("Brazil", 17, 1800, 125, 135, 145, 155);
        Countries Italy = new Countries("Italy", 18, 2000, 130, 140, 150, 160);
        Countries France = new Countries("France", 19, 2200, 135, 145, 155, 165);
        Countries UK = new Countries("United Kingdom", 20, 2300, 140, 150, 160, 170);
        Countries India = new Countries("India", 21, 2500, 145, 155, 165, 175);
        Countries Japan = new Countries("Japan", 22, 3500, 150, 160, 170, 180);
        Countries Germany = new Countries("Germany", 23, 4000, 155, 165, 175, 185);
        Countries China = new Countries("China", 24, 14000, 160, 170, 180, 190);
        Countries USA = new Countries("United States of America", 25, 20000, 165, 175, 185, 195);
        ArrayList<Countries> countries = new ArrayList<>();
        countries.add(Sweden);
        countries.add(Argentina);
        countries.add(Belgium);
        countries.add(Taiwan);
        countries.add(Poland);
        countries.add(Switzerland);
        countries.add(SaudiArabia);
        countries.add(Netherlands);
        countries.add(Turkey);
        countries.add(Indonesia);
        countries.add(Spain);
        countries.add(Australia);
        countries.add(Mexico);
        countries.add(Russia);
        countries.add(Canada);
        countries.add(Brazil);
        countries.add(Italy);
        countries.add(France);
        countries.add(UK);
        countries.add(India);
        countries.add(Japan);
        countries.add(Germany);
        countries.add(China);
        countries.add(USA);

        Scanner scan = new Scanner(System.in);

        int Characterselect[] = new int[4];
        Characterselect[0] = 0;
        Characterselect[1] = 0;
        Characterselect[2] = 0;
        Characterselect[3] = 0;
        ArrayList<Player> players = new ArrayList<Player>();
        for (int i = 0; i <= 3; i++) {
            System.out.println("Player " + (i + 1) + " Please select your character: \nPF - Pope Francis (\u002A\u002A) \nXI - Xi Jinping (^^) \nDT - Donald Trump ($$), \nBJ - Boris Johnson: (££)\n");
            String characterC = scan.nextLine();
            String character = "";
            String symbol = "";
            if (characterC.equals("PF")) {
                if (Characterselect[0] == 1) {
                    System.out.println("Character already taken.");
                    i--; // Decrement i to repeat the loop for correct input
                    continue;
                } else {
                    character = "Pope Francis";
                    symbol = "\u002A\u002A";
                    Characterselect[0] = 1;                }
            } else if (characterC.equals("XI")) {
                if (Characterselect[1] == 1) {
                    System.out.println("Character already taken.");
                    i--; // Decrement i to repeat the loop for correct input
                    continue;
                } else {
                    character = "Xi Jingping";
                    symbol = "^^";
                    Characterselect[1] = 1;
                }
            } else if (characterC.equals("DT")) {
                if (Characterselect[2] == 1) {
                    System.out.println("Character already taken.");
                    i--; // Decrement i to repeat the loop for correct input
                    continue;
                } else {
                    character = "Donald Trump";
                    symbol = "$$";
                    Characterselect[2] = 1;
                }
            } else if (characterC.equals("BJ")) {
                if (Characterselect[3] == 1) {
                    System.out.println("Character already taken.");
                    i--; // Decrement i to repeat the loop for correct input
                    continue;
                } else {
                    character = "Boris Johnson";
                    symbol = "££";
                    Characterselect[3] = 1;
                }
            }
            players.add(new Player(i, character,symbol));
            players.get(i).PrintPlayerDetails();
        }
        Taiwan.setStatus(true);
        Taiwan.setOwner(players.get(0));
        System.out.println(players.get(0).getSymbol());
        int currentPlayerIndex = 0; // Start with the first player
        Game game = new Game(players);
    
        while (true) {
            Player currentPlayer = players.get(currentPlayerIndex);
            game.turn(currentPlayer, countries);
            currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
        }
        

    }}