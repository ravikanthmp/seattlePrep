package stack.design;

import arrays.v2.searchingSorting.q5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Ravikanth on 4/30/2018.
 */
class MyTwoStack
{
    int size;
    int top1,top2;
    int arr[] = new int[100];

    MyTwoStack()
    {
        size = 100;
        top1 = -1;
        top2 = size;
    }

    private void resize(int newLength){
        int[] newArray = new int[newLength];
        System.arraycopy(arr, 0, newArray, 0, top1 );
        int secondArraySize = arr.length - 1 - top2;
        System.arraycopy(arr, top2, newArray, newArray.length - secondArraySize - 1, secondArraySize);
        top2 = newLength - 1 - secondArraySize;
        arr = newArray;
    }

    private void resizeIfNeeded(int newLength){
        if (newLength > 10){
            if ( gap() > arr.length/2 || gap() < arr.length/4){
                resize(newLength);
            }
        }
    }

    private int gap(){
        return (top2 - top1 - 1);
    }

    public void push1(int data){
        resizeIfNeeded(2*arr.length);
        arr[top1++] = data;
    }
    public void push2(int data){
        resizeIfNeeded(2*arr.length);
        arr[top2--] = data;
    }

    public boolean isEmpty1(){
        return top1 == 0;
    }
    
    public boolean isEmpty2(){
        return top2 == arr.length -1 ;
    }
    
    public int pop1(){
        if (isEmpty1()) return -1;
        resizeIfNeeded(arr.length/2);
        
        return arr[top1--];
    }

    public int pop2(){
        if (isEmpty2()) return -1;
        resizeIfNeeded(arr.length/2);
        return arr[top2++];
    }



}


