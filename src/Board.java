import java.util.Arrays;

public class Board {
    int[]boardState= new int [3];
    int xAxis;
    int yAxis;

    public Board(int[] pboardState){
        boardState=pboardState;
    }

    public Board(int a, int b, int c) {
        boardState[0]=a;
        boardState[1]=b;
        boardState[2]=c;

    }


    public void PrintInfo(){
        System.out.println(Arrays.toString(boardState));


    }
    public void PrintInfoFull(){
        System.out.print(Arrays.toString(boardState));
        System.out.println("(" +xAxis+","+yAxis+")");

    }


}


