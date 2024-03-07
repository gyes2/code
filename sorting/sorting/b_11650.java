package sorting;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.IntUnaryOperator;
import java.util.stream.IntStream;

public class b_11650 {
    public static void main(String[] args){
        b_11650 b = new b_11650();
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[][] co = new int[N][2];
        for(int i=0; i<N;i++){
            String[] tmp = sc.nextLine().split(" ");
            co[i][0] = Integer.parseInt(tmp[0]);
            co[i][1] = Integer.parseInt(tmp[1]);  
        }

        //퀵정렬
        int[][] result = b.quick(co, 0, N-1);
        for(int[] r : result){
            System.out.println(r[0]+" "+r[1]);;
        }

    }

    public int[][] quick(int[][] array,int start,int end){
        b_11650 b = new b_11650();
        System.out.println("quick 들어오자마자: "+Arrays.deepToString(array));
        if(start<end){
        
            int pivot = (start+end)/2;
            int low = start;
            int high = end;
            System.out.println("low: "+low+" high: "+high);
            while(low<pivot && high>pivot){
                
                if(array[low][0] > array[pivot][0]){
                    if(array[high][0]<array[pivot][0]){
                        int tmp0 = array[high][0];
                        int tmp1 = array[high][1];
                        array[high][0] = array[low][0];
                        array[high][1] = array[low][1];
                        array[low][0] = tmp0;
                        array[low][1] = tmp1;
                    }
                    else{
                        high -= 1;
                    }
                }
                else if(array[low][0] == array[pivot][0]){
                    if(array[low][1] > array[pivot][1]){
                        if(array[high][0]<array[pivot][0]){
                            int tmp0 = array[pivot][0];
                            int tmp1 = array[pivot][1];
                            array[pivot][0] = array[low][0];
                            array[pivot][1] = array[low][1];
                            array[low][0] = tmp0;
                            array[low][1] = tmp1;
                        }
                    }
                    else{
                        high -= 1;
                    }
                }
                else{
                    low +=1;
                }
                
            }
            System.out.println("pivot 제외 나머지 크기 나누기 후 배열: "+Arrays.deepToString(array));
            System.out.println("교환전 pivot: "+pivot);
            if(array[pivot][0]<array[0][0]){
                array = b.change(array, 0,pivot);
                pivot = 0;
                

            }
            else if(array[pivot][0]==array[0][0]){
                if(array[pivot][1]<array[0][1]){
                    array = b.change(array, 0,pivot);
                    pivot = 0;
                }

            }
            else if(array[pivot][0]>array[end][0]) {
                array = b.change(array, pivot, end);
                pivot = end;
                
            }
            else if(array[pivot][0]==array[end][0]) {
                if(array[pivot][1]>array[end][1]){
                    array = b.change(array, pivot, end);
                    pivot = end;
                }
                
            }
            
            
            System.out.println("재귀전 배열 값: "+Arrays.deepToString(array));
            System.out.println("pivot: "+pivot);

            int[][] newArray1 = quick(b.slice(array, start, pivot-1),0, b.slice(array,start,pivot-1).length-1);
            System.out.println("1: "+Arrays.deepToString(newArray1));

            int[][] newArray2 = quick(b.slice(array,pivot+1, end), 0, b.slice(array,pivot+1, end).length-1);
            System.out.println("2: "+Arrays.deepToString(newArray2));

            int[][] newArray =new int[newArray1.length+newArray2.length+1][2];
            System.arraycopy(newArray1, 0, newArray, 0, newArray1.length);
            newArray[newArray1.length] = array[pivot];
            System.arraycopy(newArray2, 0, newArray, newArray1.length+1, newArray2.length);

            System.out.println("new: "+Arrays.deepToString(newArray));
            return newArray;
            
        }
        
        return array;
    }
    public int[][] slice(int[][] array, int start, int end){
        
        int[][] slice_arr = new int[end-start+1][2];
        int index = 0;
        for(int i=start;i<end+1;i++){
            slice_arr[index] = array[i];
            index++;
        }
        

        return slice_arr;
    }
    public int[][] change(int[][] array, int low, int high){
        int tmp0 = array[low][0];
        int tmp1 = array[low][1];
        array[low][0] = array[high][0];
        array[low][1] = array[high][1];
        array[high][0] = tmp0;
        array[high][1] = tmp1;
        return array;
    }
    
}
