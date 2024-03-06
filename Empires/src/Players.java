public class Players {
    private String pieceName;
    int playerID;
    public String getPieceName(){
        return pieceName;
    }
    public int getPlayerID(){
        return playerID;
    }
    public Players(int newID, String newName){
        playerID = newID;
        pieceName = newName;
    }
}
