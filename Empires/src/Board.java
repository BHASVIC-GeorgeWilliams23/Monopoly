import java.util.Random;
public class Board {
    static final String P1 = "GO";
    static final String P2 = "01";
    static final String P3 = "02";
    static final String P4 = "03";
    static final String P5 = "04";
    static final String P6 = "05";
    static final String P7 = "06";
    static final String P8 = "07";
    static final String P9 = "08";
    static final String P10 = "09";
    static final String P11 = "10";
    static final String P12 = "11";
    static final String P13 = "12";
    static final String P14 = "MT";
    static final String P15 = "14";
    static final String P16 = "15";
    static final String P17 = "16";
    static final String P18 = "17";
    static final String P19 = "18";
    static final String P20 = "19";
    static final String P21 = "20";
    static final String P22 = "21";
    static final String P23 = "22";
    static final String P24 = "23";
    static final String P25 = "24";
    static final String P26 = "25";
    static final String P27 = "26";

    static String[] board = new String[]{P1, P2, P3, P4, P5, P6, P7, P8, P9, P10, P11, P12, P13, P14, P15, P16, P17, P18, P19, P20, P21, P22, P23, P24, P25, P26, P27};
    static String[] boardPlaces = new String[]{"GO", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "MT", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26"};


    public static void PrintBoard() {
        //String[] board = new String[]{"GO", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "MT", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27"};
        System.out.println("-----------------------------------------");
        System.out.println("| " + board[0] + " | " + board[1] + " | " + board[2] + " | " + board[3] + " | " + board[4] + " | " + board[5] + " | " + board[6] + " | " + board[7] + " |");
        System.out.println("| " + board[25] + " |                             " + "| " + board[8] + " |");
        System.out.println("| " + board[24] + " |                             " + "| " + board[9] + " |");
        System.out.println("| " + board[23] + " |                             " + "| " + board[10] + " |");
        System.out.println("| " + board[22] + " |                             " + "| " + board[11] + " |");
        System.out.println("| " + board[21] + " |                             " + "| " + board[12] + " |");
        System.out.println("| " + board[20] + " | " + board[19] + " | " + board[18] + " | " + board[17] + " | " + board[16] + " | " + board[15] + " | " + board[14] + " | " + board[13] + " |");
        System.out.println("-----------------------------------------");
    }

    public static void chanceCards() {
        //only run if player rolls a double
        Random pickCard = new Random();
        int card = pickCard.nextInt(10);
        System.out.println(card);
        String[] Cards = new String[]{"free trip to Poland", "free trip to Mexico", "free trip to India", "Flown forward 1 space", "flown back 3 spaces", "Sued, lose 100", "Recession lose 200", "You raised you salary, collect 100", "Fly to GO", "you win the election collect 200"};
        System.out.println(Cards[card]);
    }
    public void move(){
        
    }
   // public static void PassGo(){
    //    int Pos = Integer.valueOf(board[22]);
     //   if (Pos + total > 25){
    //        getMoney=getMoney + 200;
     //   }
    }
//}

 