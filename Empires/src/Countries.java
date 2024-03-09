    import org.w3c.dom.ls.LSOutput;

    public class Countries {
        private String name;
        private int position;
        private int cost;
        private Player owner;
        private boolean status=false;
        private int level;
        private int l0rent;
        private int l1rent;
        private int l2rent;
        private int l3rent;

        public void levelUp() {
            if (level < 3) {
                level = level + 1;
            }
        }

        public void setStatus(boolean newStatus) {
            status = newStatus;
        }

        public void setOwner(Player newOwner) {
            owner = newOwner;
        }
        public boolean getStatus(){
            return status;
        }

        public int getPosition() {
            return position;
        }

        public Player getOwner() {
            return owner;
        }

        public String getName() {
            return name;
        }

        public int getCost() {
            return cost;
        }

        public int getL0rent(){ return l0rent;}
        public int getL1rent(){ return l1rent;}
        public int getL2rent(){ return l2rent;}
        public int getL3rent(){ return l3rent;}


        public int getLevel() {
            return level;
        }

        public void setPosition(int position) {
            position = position;
        }
        public int getRent(){
            int rent = 0;
            switch (level) {
                case 0:
                    rent =l0rent;
                    break;
                case 1:
                    rent = l1rent;
                    break;
                case 2:
                    rent = l2rent;
                    break;
                case 3:
                    rent = l3rent;
                    break;
            }
            return rent;
        }
        public Countries(String newName, int newPosition, int newCost, int l0rent, int l1rent, int l2rent, int l3rent) {
            this.name = newName;
            this.position = newPosition;
            this.cost = newCost;
            this.l0rent = l0rent;
            this.l1rent = l1rent;
            this.l2rent = l2rent;
            this.l3rent = l3rent;
        }
        public void countryCard() {
            System.out.println("---------------------------------------");
            System.out.println("Name of Country: " + name);
            System.out.println("Level: " + level);
            System.out.println("---------------------------------------");
            System.out.println("Level 0 Stop: " + l0rent);
            System.out.println("Level 1 Stop: " + l1rent);
            System.out.println("Level 2 Stop: " + l2rent);
            System.out.println("Level 3 Stop: " + l3rent);
            System.out.println("---------------------------------------");
            System.out.println("Cost of Country: " + cost);
            
            if (status) {
                System.out.println("Status: Owned by: " + (owner != null ? owner.getPieceName() : "None"));
                int rent = 0;
                switch (level) {
                    case 1:
                        rent = l1rent;
                        break;
                    case 2:
                        rent = l2rent;
                        break;
                    case 3:
                        rent = l3rent;
                        break;
                }
                if (level == 0) {
                    System.out.println("The rent for this country is " + l0rent);
                } else {
                    System.out.println("Player " + (owner != null ? owner.getPieceName() : "None") + " has upgraded this country to level " + level + "...\nPay " + rent);
                }
                System.out.println("---------------------------------------");
            } else {
                System.out.println("Status: Unowned");
                System.out.println("---------------------------------------");
            }
        }
        
    }


