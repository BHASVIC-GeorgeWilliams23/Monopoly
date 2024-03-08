public class Player {
    private String pieceName;
    private int playerID;
    private String symbol;
    private int position;
    private int money = 1500;
    public String getPieceName() {
        return pieceName;
    }
    public int getPlayerID() {
        return playerID;
    }
    public Player(int newID, String newName, String symbol) {
        playerID = newID;
        pieceName = newName;
        symbol = this.symbol;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int newPosition){
        position = newPosition;
    }
    public int getMoney(){
        return money;
    }
    public void setMoney(int newMoney){
        money = newMoney;
    }
    public void PrintPlayerDetails(){
        System.out.println("Player "+(playerID+1) +" is " + pieceName + "\nSymbol is "+ symbol);
    }
    public void move(int moveSpaces){
        position = position + moveSpaces;
        System.out.println(pieceName+ " landed on " + getPosition());
    }
    public String getSymbol(){
        return symbol;
    }
}