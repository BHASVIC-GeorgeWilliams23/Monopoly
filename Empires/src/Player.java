import java.util.List;

public class Player {
    private String pieceName;
    private int playerID;
    private String symbol;
    private int position;
    private boolean bankrupted;
    private int money =35000;
    public String getPieceName() {
        return pieceName;
    }
    public int getPlayerID() {
        return playerID;
    }
    public Player(int newID, String newName, String newSymbol) {
        playerID = newID;
        pieceName = newName;
        symbol = newSymbol;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int newPosition){
        position = newPosition;
    }
    public void bankrupt(Player player, List<Countries> countries) {
        System.out.println(pieceName + " ran out of money, bye bye....");
        setMoney(0);
        for (int j = 0; j < countries.size(); j++) {
            if (countries.get(j).getOwner() == player) {
                System.out.println(countries.get(j).getName() + " is now up for sale " + " at position "+countries.get(j).getPosition());
                countries.get(j).setStatus(false);
                bankrupted = true;
            }
        }
    }
    public boolean isBankrupt(){
        if(bankrupted == true){
            return true;
        }
        else{
            return false;
        }
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int newMoney){
        money = money+newMoney;
    }
    public void PrintPlayerDetails(){
        System.out.println("Player "+(playerID+1) +" is " + pieceName + "\nSymbol is "+ symbol+"\n");
    }
    public void move(int moveSpaces){
        position = position + moveSpaces;
        System.out.println(pieceName+ " landed on " + getPosition());
    }
    public String getSymbol(){
        return symbol;
    }
}