package sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

class Coordinate implements Comparable<Coordinate>{
    private int x;
    private int y;

    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }

    @Override
    public int compareTo(Coordinate o) {
        int result = 0;
        if(this.x == o.x){
            result = this.y -o.y;
        }
        else{
            result = this.x - o.x;
        }
        return result;
    }
}

public class b_11650_comparable {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        List<Coordinate> coords = new ArrayList<Coordinate>();
        
        for(int i =0; i<N;i++){
            String[] tmp = sc.nextLine().split(" ");
            int[] t = new int[2];
            Coordinate new_C = new Coordinate(Integer.parseInt(tmp[0]),Integer.parseInt(tmp[1]));
            
            coords.add(new_C);
        }
        Collections.sort(coords);
        for(Coordinate c : coords){
            System.out.println(c.getX()+" "+c.getY());
        }
    }
    
}
