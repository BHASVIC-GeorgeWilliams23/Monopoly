import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {
    private int diceValue;
    int dice1value;
    int dice2value;
    public int diceRoll(){
        diceValue = (int) (Math.random() * 6) + 1;
        return diceValue;
    }
    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    private ArrayList<Player> players = new ArrayList<Player>();

    public Game(ArrayList<Player> players){

        this.players = players;
    }
    public ArrayList<Player> getPlayers (){
        return players;
    }
    public void turn(Player player, List<Countries> countries) {
        if(player.isBankrupt() == false) {
            System.out.println("\n" + player.getPieceName() + "'s turn!\nMoney: $" + player.getMoney());
            dice1value = diceRoll();
            dice2value = diceRoll();
            int diceTotalValue = dice1value + dice2value;
            String typeToRoll = "";
            Scanner scanner = new Scanner(System.in);
            while (!typeToRoll.equals("R")) {
                System.out.println("Type \"R\" to roll your dice");
                typeToRoll = scanner.next();
            }
            System.out.println("First dice rolled " + dice1value);
            sleep(500);
            System.out.println("\nSecond dice rolled " + dice2value);
            sleep(100);
            System.out.println("\nTotal spaces to move: " + diceTotalValue);
            int originalPosition = player.getPosition();
            String originalSpaceValue = Board.boardPlaces[originalPosition];

            // Chance Cards
            if (dice1value == dice2value) {
                System.out.println("Double! \nYou get a chance card:");
                Random pickCard = new Random();
                int card = pickCard.nextInt(10);
                if (card == 0) {
                    System.out.println("\nFree trip to Poland.");
                    player.setPosition(5);
                    diceTotalValue = 0;
                } else if (card == 1) {
                    System.out.println("\nFree trip to Mexico.");
                    player.setPosition(14);
                    diceTotalValue = 0;
                } else if (card == 2) {
                    System.out.println("\nFree trip to India.");
                    player.setPosition(21);
                    diceTotalValue = 0;
                } else if (card == 3) {
                    System.out.println("\nFlown forward 1 space.");
                    diceTotalValue = 1;
                } else if (card == 4) {
                    System.out.println("\nFlown back 3 spaces.");
                    player.setPosition(originalPosition - 3);
                } else if (card == 5) {
                    System.out.println("\nSued, lose 300.");
                    player.setMoney(-300);
                    System.out.println("Money: $" + player.getMoney());
                } else if (card == 6) {
                    System.out.println("\nRaised your own salary, collect 300.");
                    player.setMoney(300);
                    System.out.println("Money: $" + player.getMoney());
                } else if (card == 7) {
                    System.out.println("\nRecession, lose 200.");
                    player.setMoney(-200);
                    System.out.println("Money: $" + player.getMoney());
                } else if (card == 8) {
                    System.out.println("\nYou win the election, collect 500.");
                    player.setMoney(500);
                    System.out.println("Money: $" + player.getMoney());
                } else if (card == 9) {
                    System.out.println("\nRigged election, lose 500.");
                    player.setMoney(-500);
                    System.out.println("Money: $" + player.getMoney());
                } else if (card == 10) {
                    System.out.println("\nYou win the election, collect 200.");
                    player.setMoney(200);
                    System.out.println("Money: $" + player.getMoney());
                } else {
                    int newPosition = player.getPosition() + diceTotalValue;
                    System.out.println("Moving " + player.getPieceName() + " to " + newPosition);
                    player.setPosition(newPosition);
                }
            }
            //   Passing Go Logic
            int newPosition = player.getPosition() + diceTotalValue;
            if (newPosition > 25) {
                diceTotalValue = newPosition - 26;
                player.setPosition(0);
                newPosition = player.getPosition() + diceTotalValue;
                player.setMoney(500);
                System.out.println("\nPassed go collect 500");
                System.out.println("Money: $" + player.getMoney());
            }
            if (newPosition == 0) {
                player.setMoney(1000);
                System.out.println("\nYou landed on GO!\nCollect 1000");
                System.out.println("Money: $" + player.getMoney());
            }
            sleep(500);
            player.setPosition(newPosition);
            Board.board[newPosition] = player.getSymbol();
            Board.board[originalPosition] = originalSpaceValue;
            sleep(500);
            Board.PrintBoard();
            System.out.println(newPosition);
            // Landing on countries and buying or not
            for (Countries country : countries) {
                if (country.getPosition() == newPosition) {
                    System.out.println(player.getPieceName() + " landed on " + country.getName());
                    if (country.getOwner() == player) {
                        System.out.println("You already own this property.");
                    } else if (newPosition == 13) {
                        System.out.println("Miss a turn! You landed on position 13!");
                    } else {
                        if (country.getStatus() == false) {
                            sleep(500);
                            String x = "";
                            while (!x.equals("Y") && !x.equals("N")) {
                                System.out.println("Would you like to buy this property for " + country.getCost() + " ? (Y/N) (You have " + player.getMoney() + " in the bank)");
                                country.countryCard();
                                Scanner propertyScanner = new Scanner(System.in);
                                x = propertyScanner.nextLine();
                                if (!x.equals("Y") && !x.equals("N")) {
                                    System.out.println("Invalid input. Please try  again.");
                                } else if (x.equals("Y")) {
                                    if (player.getMoney() >= country.getCost()) {
                                        sleep(1000);
                                        System.out.println("You have successfully purchased " + country.getName() + " for " + country.getCost() + "!");
                                        country.setOwner(player);
                                        country.setStatus(true);
                                        player.setMoney(-country.getCost());
                                        sleep(500);
                                        System.out.println(player.getPieceName() + " you now have " + player.getMoney());
                                        break;
                                    } else {
                                        System.out.println("You do not have enough money!");
                                    }
                                } else {
                                    String upgradeYesOrNo = "";
                                    //                          upgrading properties
                                    System.out.println("Would you like to upgrade one of your properties? (Y/N)");
                                    upgradeYesOrNo = propertyScanner.nextLine();
                                    if (!upgradeYesOrNo.equals("Y") && !upgradeYesOrNo.equals("N")) {
                                        System.out.println("Invalid input. Please try  again.");
                                    } else if (upgradeYesOrNo.equals("Y")) {
                                        System.out.println("Here are your owned properties: ");
                                        for (int j = 0; j < countries.size(); j++) {
                                            if (countries.get(j).getOwner() == player) {
                                                System.out.println(countries.get(j).getName() + "\n--Position: " + countries.get(j).getPosition());
                                                System.out.println("--Current Level: " + countries.get(j).getLevel());
                                                System.out.println("--Cost to level-up: " + countries.get(j).getCost());
                                            }
                                        }
                                        System.out.println("Which country would you like to upgrade? \nYou must pay the original cost again to upgrade the level.\nIf you decide not to, enter 0.");
                                        int y;
                                        y = Integer.valueOf(propertyScanner.nextLine());
                                        int index = y - 1;
                                        if (y > 0 && y < countries.size() && countries.get(index).getOwner() == player && player.getMoney() >= countries.get(index).getCost()) {

                                            System.out.println("Upgrading " + countries.get(index).getName());
                                            countries.get(index).levelUp();
                                            System.out.println(countries.get(index).getName() + " is now level " + countries.get(index).getLevel());
                                        } else if (y == 0) {
                                            break;
                                        } else if (player.getMoney() < countries.get(index).getCost()) {
                                            System.out.println("You do not have enough money!");
                                        } else {
                                            System.out.println("Invalid country selection. Please try again.");
                                        }


                                    }
                                }
                            }
                        }
                        // Paying Rent
                        else {
                            System.out.println("Unlucky!\n" + country.getOwner().getPieceName() + " owns this property!\n Pay " + country.getRent());
                            player.setMoney(-country.getRent());
                            country.getOwner().setMoney(country.getRent());

                            System.out.println(player.getPieceName() + " you now have " + player.getMoney());
                            System.out.println();
                        }
                    }
                }

            }
            if(player.getMoney() < 0){
                player.bankrupt(player, countries);
            }
        }
        else if(player.isBankrupt()==true){
            System.out.println(player.getPieceName()+ " is out of the game!");
        }
    }
}