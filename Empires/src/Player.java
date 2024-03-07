public class Player {
    private String pieceName;
    int playerID;
    int position;
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
    public void PrintPlayerDetails(){
        System.out.println("Player "+(playerID+1) +" is " + pieceName);
    }
}