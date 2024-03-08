public class Player {
    private String pieceName;
    private int playerID;
    private int position;
    private int money = 1500;
    public String getPieceName() {
        return pieceName;
    }
    public int getPlayerID() {
        return playerID;
    }
    public Player(int newID, String newName) {
        playerID = newID;
        pieceName = newName;
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
    public void PrintPlayerDetails(){
        System.out.println("Player "+(playerID+1) +" is " + pieceName);
    }
    public void move(int moveSpaces){
        position = position + moveSpaces;
        System.out.println(pieceName+ " landed on " + getPosition());
    }
    public void takeTurn(Player player, int moveSpaces){

    }
}