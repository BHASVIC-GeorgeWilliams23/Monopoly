import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

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
        System.out.println("First dice rolled "+dice1value);
        sleep(500);
        System.out.println("\nSecond dice rolled "+dice2value);
        sleep(100);
        System.out.println("\nTotal spaces to move: "+diceTotalValue);
        int newPosition = player.getPosition() + diceTotalValue;
        sleep(500);
        System.out.println("Moving "+player.getPieceName()+" to "+ newPosition);
        player.setPosition(newPosition);
        String originalSpaceValue = Board.board[newPosition];
        Board.board[newPosition]=player.getSymbol();
        sleep(500);
        Board.PrintBoard();
        System.out.println(newPosition);
        for (Countries country : countries) {
            if (country.getPosition() == newPosition) {
                System.out.println(player.getPieceName() + " landed on " + country.getName());
                if (country.getOwner() == player) {
                    System.out.println("You already own this property.");
                } 
                else {
                    if(country.getStatus()==false){
                        sleep(500);
                        System.out.println("Would you like to buy this property for "+country.getCost()+" ? (Y/N) (You have "+player.getMoney()+" in the bank)");
                        String x;
                        country.countryCard();
                        Scanner propertyScanner = new Scanner(System.in);
                        x = propertyScanner.nextLine();
                        if (x.equals("Y")){
                            if(player.getMoney() >= country.getCost()){
                                sleep(1000);
                                System.out.println("You have successfully purchased " + country.getName() + " for " + country.getCost() + "!");
                                country.setOwner(player);
                                country.setStatus(true);
                                player.setMoney(-country.getCost());
                                sleep(500);
                                System.out.println(player.getPieceName()+" you now have "+player.getMoney());
                                break;
                            }
                            else{
                                System.out.println("You do not have enough money!");
                            }
                        }
                        else{
                            break;
                        }
                    }
                    else{
                        System.out.println("Unlucky!\n"+country.getOwner().getPieceName()+" owns this property!\n Pay "+country.getRent());
                        player.setMoney(-country.getRent());
                        country.getOwner().setMoney(country.getRent());

                        System.out.println(player.getPieceName()+" you now have "+player.getMoney());
                        System.out.println();
                }
                }
                
            
        
        }
        
    }
}
}