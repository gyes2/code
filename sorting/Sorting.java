package sorting;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Stream;


public class Sorting{
    public static void main(String[] args){
        Random random = new Random();
        int[] array = new int[10];
        for(int i=0;i<10;i++){
            array[i] = random.nextInt(100);
            System.out.print(array[i]+" ");
        }
        System.out.println();
        System.out.println("=====Bubble Sort=====");
        int[] result = bubble(array);
        for(int r : result){
            System.out.print(r+" ");
        }
        System.out.println();
        System.out.println("=====insert Sort=====");
        int[] result1 = insert(array);
        for(int r : result1){
            System.out.print(r+" ");
        }

        System.out.println();
        System.out.println("=====choice Sort=====");
        int[] result2 = choice(array);
        for(int r : result2){
            System.out.print(r+" ");
        }
        System.out.println();
        System.out.println("=====Quick Sort=====");
        int[] result3 = quick(array,0,array.length-1);
        for(int r : result3){
            System.out.print(r+" ");
        }
    }

    /*
     * 버블정렬
     */
    public static int[] bubble(int[] array){
        long before = System.currentTimeMillis();

        for(int i=array.length-1; i>-1; i--){
            for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }

        long after = System.currentTimeMillis();
        long time = (after-before);
        System.out.println("걸린시간: "+time);
        return array;
    }

    /*
     * 삽입정렬
     */
    public static int[] insert(int[] array){
        
        int cnt = array.length;
        int index = 0;
        int newArray[] =  new int[cnt];
        for(int i=0;i<array.length;i++){
            newArray[index] = array[i];
            for(int j=i;j>0;j--){
                if(newArray[j] < array[j-1]){
                    int tmp = newArray[j];
                    newArray[j] = array[j-1];
                    newArray[j-1] = tmp;
                }
            }
            index++;
            
        }

        return newArray;
    }

    /*
     * 선택정렬
     */
    public static int[] choice(int[] array){

        
        for(int i=0;i<array.length;i++){
            int minIndex = i;
            int min = array[i];
            for(int j=i;j<array.length;j++){
                if(min > array[j]){
                    min = array[j];
                    minIndex = j;
                }
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
        
        return array;
    }

    /*
     * 퀵정렬
     */
    public static int[] quick(int[] array, int start, int end){

        if(start<end){
            int pivot = start;
            int low=start+1;
            int high=end;
            while(low<high){
                if(array[low]<array[pivot]){
                    if(array[high]>array[pivot]){
                        int tmp = array[high];
                        array[high] = array[low];
                        array[low] = tmp;
                    }   
                    high -= 1;
                }
                low += 1;
            }

            int tmp = array[high];
            array[high] = array[pivot];
            array[pivot] = tmp;
            pivot = high;
            int[] newArray1 = quick(array, start, pivot-1);
            int[] newArray2 = quick(array, pivot, end);
            int[] newArray =new int[newArray1.length+newArray2.length];
            System.arraycopy(newArray1, 0, newArray, 0, newArray1.length);
            System.arraycopy(newArray2, 0, newArray, newArray1.length, newArray2.length);
            return newArray;
        }
        
        
        return array; 
    }
}
