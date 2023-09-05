package sorting;

import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class Sorting{
    public static void main(String[] args){
        Sorting sort = new Sorting();

        System.out.println();
        System.out.println("=====Bubble Sort=====");
        int[] result = sort.bubble(sort.random());
        for(int r : result){
            System.out.print(r+" ");
        }
        System.out.println();
        System.out.println("=====insert Sort=====");
        int[] result1 = sort.insert(sort.random());
        for(int r : result1){
            System.out.print(r+" ");
        }

        System.out.println();
        System.out.println("=====choice Sort=====");
        int[] result2 = sort.choice(sort.random());
        for(int r : result2){
            System.out.print(r+" ");
        }
        System.out.println();
        System.out.println("=====Quick Sort=====");
        int[] arr = sort.random();
        int[] result3 = sort.quick(arr,0,arr.length-1);
        for(int r : result3){
            System.out.print(r+" ");
        }
    }

    public int[] random(){
        Random random = new Random();
        int[] array = new int[5];
        for(int i=0;i<5;i++){
            array[i] = random.nextInt(100);
            System.out.print(array[i]+" ");
        }
        return array;
    }

    
    public int[] bubble(int[] array){
        
        System.out.println("\narray: "+Arrays.toString(array));
        for(int i=array.length-1; i>-1; i--){
            for(int j=0;j<i;j++){
                if(array[j]>array[j+1]){
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }

        return array;
    }

    
    public int[] insert(int[] array){
        System.out.println("\narray: "+Arrays.toString(array));
        int cnt = array.length;
        int index = 0;
        int newArray[] =  new int[cnt];
        newArray[0] = array[0];
        for(int i=1;i<array.length;i++){
            newArray[i] = array[i];
            for(int j=i;j>0;j--){
                if(newArray[j] > newArray[j-1]){
                    break;
                }
                else{
                    int tmp = newArray[j];
                    newArray[j] = newArray[j-1];
                    newArray[j-1] = tmp;
                }
            }
        }
        return newArray;
    }

    
    public int[] choice(int[] array){
        System.out.println("\narray: "+Arrays.toString(array));
        for(int i=0;i<array.length-1;i++){
            int minIndex = i;
            int min = array[i];
            for(int j=i+1;j<array.length;j++){
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

    public int[] quick(int[] array, int start, int end){
        Sorting sor = new Sorting();
        
        System.out.println("\narray: "+Arrays.toString(array)+" start: "+start+" end: "+end);
        if(start<end){
            int[] newArray1;
            int pivot = start;
            int low=start+1;
            int high=end;
            while(low<high){
                System.out.println("arrayLength: "+array.length+" end: "+end+" high: "+high+" low: "+low+ " pivout: "+pivot);
                if(array[low]>array[pivot] ){
                    if(array[high]<array[pivot]){
                        int tmp = array[high];
                        array[high] = array[low];
                        array[low] = tmp;
                    }
                    else{
                        high -= 1;
                    }   
                    
                }
                else{
                    low += 1;
                }
                
            }
            if(array[low]<array[pivot]){
                int tmp = array[low];
                array[low] = array[pivot];
                array[pivot] = tmp;
            }
            pivot =low;
            System.out.println("pivot: "+pivot);
            System.out.println("before array: "+Arrays.toString(array));
            
            newArray1 = quick(sor.slice(array,start,pivot),0, sor.slice(array,start,pivot).length-1);
            System.out.println("1: "+Arrays.toString(newArray1));
            int[] newArray2 = quick(sor.slice(array,pivot, end+1), 0, sor.slice(array,pivot, end+1).length-1);
            System.out.println("2: "+Arrays.toString(newArray2));
            int[] newArray =new int[newArray1.length+newArray2.length];
            System.arraycopy(newArray1, 0, newArray, 0, newArray1.length);
            System.arraycopy(newArray2, 0, newArray, newArray1.length, newArray2.length);
            System.out.println("new: "+Arrays.toString(newArray));
            return newArray;
            
        }

        return array; 
    }

    public int[] slice(int[] array, int start, int end){
        int[] slice_arr = IntStream.range(start, end).map(i -> array[i]).toArray();

        return slice_arr;
    }
}
