import org.w3c.dom.ls.LSOutput;

public class Countries {
    private String name;
    private int position;
    private long cost;
    private int owner;
    private boolean status;
    private int level;

    public void levelUp() {
        if (level < 3) {
            level = level + 1;
        }
    }

    public void setStatus(boolean newStatus) {
        status = newStatus;
    }

    public void setOwner(int newOwner) {
        owner = newOwner;
    }
    public boolean getStatus(){
        return status;
    }

    public int getPosition() {
        return position;
    }

    public int getOwner() {
        return owner;
    }

    public String getName() {
        return name;
    }

    public long getCost() {
        return cost;
    }

    public int getLevel() {
        return level;
    }

    public void setPosition(int position) {
        position = position;
    }

    public Countries(String newName, int newPosition, long newCost) {
        name = newName;
        position = newPosition;
        cost = newCost;
    }
    public void countryCard(){
        System.out.println("---------------------------------------");
        System.out.println("Name of Country: "+name);
        System.out.println("Cost of Country: "+cost);
        if(status==true){
            System.out.println("Status: Owned by: "+getOwner());
            System.out.println("---------------------------------------");
        }
        else{
            System.out.println("Status: Unowned");
            System.out.println("---------------------------------------");
        }
    }
}


