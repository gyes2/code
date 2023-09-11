package sorting;

import java.util.*;
import java.io.*;

public class b_1181 {
    public static void main(String[] args){
        b_1181 b = new b_1181();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String[] str = new String[N];
        sc.nextLine();
        for(int i=0;i<N;i++){
            str[i] = sc.nextLine();
        }
        String[] result = b.choice(str);
        for(int i = 0;i<result.length;i++){
            if(result[i].equals("")){
                continue;
            }
            else{
                System.out.println(result[i]);
            }
            
        
        }
    }

    public String[] choice(String[] array){
        
        for(int i=0;i<array.length-1;i++){
            int minIndex = i;
            String min = array[i];
            int strLength = array[i].length();
            
            for(int j=i+1;j<array.length;j++){
                
                if(strLength > array[j].length()){
                    min = array[j];
                    minIndex = j;
                    strLength=array[j].length();
                }
                else if(strLength == array[j].length()){
                    if( min.compareTo(array[j]) > 0){
                        min = array[j];
                        minIndex = j;
                    }
                    else if(min.compareTo(array[j])== 0){
                         array[j] = "";
                    }
                }
            }
            String tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
            
        }
        return array;
    }
}