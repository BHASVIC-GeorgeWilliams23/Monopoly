import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Game {
    private int diceValue;
    int dice1value;
    int dice2value;
    public void diceRoll(){
        diceValue = (int) (Math.random() * 6) + 1;

    }
    public int getDiceValue() {
        return diceValue;
    }
    private ArrayList<Player> players = new ArrayList<Player>();

    public Game(ArrayList<Player> players){

        this.players = players;
    }
    public ArrayList<Player> getPlayers (){
        return players;
    }
    public void turn(Player player){
        System.out.println("\n" + player.getPieceName() + "'s turn!\nMoney: $" + player.getMoney());
        diceRoll();
        dice1value = getDiceValue();
        diceRoll();
        dice2value = getDiceValue();
        int diceTotalValue = dice1value+dice2value;
        System.out.println("First dice rolled "+dice1value+"\nSecond dice rolled "+dice2value+"\nTotal spaces to move: "+diceTotalValue);
        int newPosition = player.getPosition() + diceTotalValue;
        System.out.println("Moving "+player.getPieceName()+" to "+ newPosition);
        player.setPosition(newPosition);
        Board.board[newPosition]=
        Board.PrintBoard();
    }
}
