public class Player {
    private String pieceName;
    private int playerID;
    private String symbol;
    private int position;
    private int money = 3000;
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
    public void bankrupt(){
        System.out.println("You ran out of money... better luck nexttime!");
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