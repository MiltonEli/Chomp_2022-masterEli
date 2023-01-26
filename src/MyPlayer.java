import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class MyPlayer {
    public Chip[][] gameBoard;
    public int[] columns;
    int count=0;
    public Board testBoard;
    ArrayList<Board> WList = new ArrayList<>();
    public ArrayList<Board> LList = new ArrayList<>();
    boolean horay=true;
    public MyPlayer() {
//        columns = new int[10];
        BoardPrint();
        /***
         * This code will run just once, when the game opens.
         * Add your code here.
         */
    }

    public Point move(Chip[][] pBoard) {
        columns = new int[10];

        System.out.println("MyPlayer Move");

        gameBoard = pBoard;
        int column = 1;
        int row = 1;



        for (int k = 0;k<10;k++ ){
            for (int j = 0; j < 10; j++) {
                if (pBoard[j][k].isAlive == true) {
                    System.out.println(pBoard[j][k].xpos);
                    columns[k]++;
                }
            }
    }

        System.out.print(Arrays.toString(columns));

for(int t=0;t<WList.size(); t++){


        if(WList.get(t).boardState[0]==columns[0]&&WList.get(t).boardState[1]==columns[1]&&WList.get(t).boardState[2]==columns[2]){

            System.out.print("("+WList.get(t).xAxis+" "+WList.get(t).yAxis+")");
            row=WList.get(t).yAxis;
            column=WList.get(t).xAxis;

        }


}

//        for(int j=0;j<10;j++){
//            if (pBoard[j][1].isAlive==true) {
//                System.out.println(pBoard[j][1].xpos);
//                columns[1]++;
//            }
//        }

        /***
         * This code will run each time the "MyPlayer" button is pressed.
         * Add your code to return the row and the column of the chip you want to take.
         * You'll be returning a data type called Point which consists of two integers.
         */

        Point myMove = new Point(row, column);
        return myMove;
    }
    public void BoardPrint() {
        ArrayList <Board> RBoards = new ArrayList<>() ;
//        LList.add(new Board(1,0,0));




        for (int a = 1; a < 4; a++) {
            for (int b = 0; b <= a; b++) {
                for (int c = 0; c <= b; c++) {
                    System.out.println("board:"+a+" "+b+" "+c );
//                    Board.add(a,b,c);

                    PosRes3(a,b,c);
                    for(int i=0; i<RBoards.size(); i++){
                        RBoards = PosRes3(a, b, c);
                        RBoards.get(i).PrintInfo();

                    }

                }
            }
        }
    }

    //Possible Resulting Boards from a full 3x3 position and each coordinating click
    public ArrayList<Board>PosRes3(int a, int b, int c) {
        ArrayList<Board> RBList = new ArrayList<>();
        horay=false;


        int x = a;
        int y = b;
        int z = c;
        //use math to calculate coordinates for x and y instead of using counters t calculate coordinates.
        for (int z2 = z-1; z2 > -1; z2--) { // third col
            System.out.println("a"+ x + " " + y + " " + z2 );
            for (int h= 0;h< LList.size();h++) {

                if (x == LList.get(h).boardState[0] && y == LList.get(h).boardState[1] && z2 == LList.get(h).boardState[2]) {
                    System.out.println("horay! 2");
                    horay=true;
                    Board temp=new Board(a,b,c);
                    temp.xAxis=2;
                    temp.yAxis=z2;
                    WList.add(temp);

                }

            }
            int[] resInt = new int[]{x, y, z2};
            Board intBoard = new Board(resInt);
            RBList.add(intBoard);
        }
        x = a;
        y = b;
        z = c;
        for (int y2 = b - 1; y2 > -1; y2--) { // second col
            if (y2 < z) {
                z = y2;
            }

            System.out.println("b"+x + " " + y2 + " " + z );//second col
            for (int h= 0;h< LList.size();h++) {

                if (x == LList.get(h).boardState[0] && y2 == LList.get(h).boardState[1] && z == LList.get(h).boardState[2]) {
                    System.out.println("horay! 3");
                    horay = true;
                    Board temp=new Board(a,b,c);
                    temp.xAxis=1;
                    temp.yAxis=y2;
                    WList.add(temp);

                }
            }
            int[] resInt = new int[]{x, y2, z};
            Board intBoard = new Board(resInt);
            RBList.add(intBoard);
        }

        x = a;
        y = b;
        z = c;

        for (int x2 = a -1; x2 > -1; x2--) { // first col
            if (b > x2) {
                y = x2;
            }
            if (c > y) {
                z = y;
            }
            System.out.println("c" + x2 + " " + y + " " + z);
            for (int h = 0; h < LList.size(); h++) {

                if ((x2 == LList.get(h).boardState[0] && y == LList.get(h).boardState[1] && z == LList.get(h).boardState[2])) {
                    System.out.println("horay! 1");
                    horay = true;
                    Board temp=new Board(a,b,c);
                    temp.xAxis=0;
                    temp.yAxis=x2;
                    WList.add(temp);
                }
            }


            int[]resInt = new int[]{x2, y, z};
            Board intBoard = new Board(resInt);
            RBList.add(intBoard);
        }
        if(horay==false){
            LList.add(new Board(a,b,c));
            System.out.println("added new loser"+a+" "+b+" "+c);
        }



        return RBList;

    }
    public void PrintAllWin(){
        for(int d=0;d< WList.size();d++){
            WList.get(d).PrintInfoFull();

        }
    }
}
