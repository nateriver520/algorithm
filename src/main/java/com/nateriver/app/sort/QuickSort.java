package com.nateriver.app.sort;


public class QuickSort {
    public static int partition(int[] arr, int low, int high){
        int pivot= arr[low];
        while(low < high){
            while(low < high && arr[high]>= pivot)
                high--;
            if(low < high)
                arr[low ++]= arr[high];
            while(low < high && arr[low] <= pivot)
                low ++;
            if(low < high)
                arr[high--]= arr[low];
        }
        arr[low] = pivot;
        return low;
    }


    public static void quickSort(int[] arr, int low, int high)
    {
        int pivotpos;
        if(low < high){
            pivotpos= partition(arr, low, high);
            quickSort(arr, low, pivotpos - 1);
            quickSort(arr, pivotpos + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr =new int[]{3,1,2,9,12,20,5,99};
        quickSort(arr, 0, arr.length - 1);
        for(int i: arr){
            System.out.print(i + " ");
        }
    }
}
