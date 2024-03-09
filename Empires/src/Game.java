import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
public class Game {
    private int diceValue;
    int dice1value;
    int dice2value;
    public int diceRoll(){
        diceValue = (int) (Math.random() * 6) + 1;
        return diceValue;
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
        System.out.println("First dice rolled "+dice1value);
        System.out.println("\nSecond dice rolled "+dice2value);
        System.out.println("\nTotal spaces to move: "+diceTotalValue);
        int newPosition = player.getPosition() + diceTotalValue;
        System.out.println("Moving "+player.getPieceName()+" to "+ newPosition);
        player.setPosition(newPosition);
        String originalSpaceValue = Board.board[newPosition];
        Board.board[newPosition]=player.getSymbol();
        Board.PrintBoard();
        System.out.println(newPosition);
        for (Countries country : countries) {
            if (country.getPosition() == newPosition) {
                System.out.println(player.getPieceName()+" landed on " + country.getName());
                country.countryCard();
                String x = "";
                Scanner propertyScanner = new Scanner(System.in);
                if(country.getStatus()==false){
                    System.out.println("Would you like to buy this property for "+country.getCost()+" ? (Y/N)");
                    x = propertyScanner.nextLine();
                    if (x.equals("Y")){
                        if(player.getMoney() >= country.getCost()){
                            System.out.println("You have successfully purchased " + country.getName() + " for " + country.getCost() + "!");
                            country.setOwner(player);
                            country.setStatus(true);
                            player.setMoney(-country.getCost());
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
                    System.out.println(player.getPieceName()+" you now have "+player.getMoney());
                }
                }
                
            
        
        }
        
    }
}
