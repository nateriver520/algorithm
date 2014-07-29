package com.nateriver.app.quiz;



public class FindN {

    /**
     * Find top n from one array without sort
     */
    public static int findN(int[] arr, int n, int low, int high){
        if(low >= high)
            return arr[low];

        int pivotpos = partition(arr, low, high);

        if(pivotpos == n -1){
            return arr[pivotpos];
        }
        else if(n <= pivotpos)
            return findN(arr, n, low , pivotpos -1);
        else
            return findN(arr, n - (pivotpos +1) , pivotpos +1, high);
    }

    static void exchange(int[] arr, int i,int j)
    {
        int temp;
        temp= arr[i];
        arr[i]= arr[j];
        arr[j] = temp;
    }

    static int partition(int[]a, int l,int r)
    {
        int i=l-1, j;
        int x=a[r];

        for(j=l; j<r; j++)
        {
            if(a[j] >= x)
            {
                exchange(a, j , i +1);
                i++;
            }
        }
        exchange(a, r, i+1);
        return i+1;
    }

    public static int findKInTwoSortArrat(int[] a, int[] b, int aLeft, int aRight, int bLeft, int bRight, int k) throws Exception{
        if(a.length + b.length < k) return  -1; // cannot find response n
        int aMid = (aLeft + aRight) / 2;
        int bMid = (bLeft + bRight) / 2;

        if (aLeft > aRight)
            return b[bLeft+k-1];
        if (bLeft > bRight)
            return a[aLeft+k-1];

        if (a[aMid] <= b[bMid]) {
            if (k <= (aMid-aLeft) + (bMid-bLeft) + 1)
                return findKInTwoSortArrat(a, b, aLeft, aRight, bLeft, bMid-1, k);
            else
                return findKInTwoSortArrat(a, b, aMid+1, aRight, bLeft, bRight, k-(aMid-aLeft)-1);
        } else {
            if (k <= (aMid-aLeft) + (bMid-bLeft) + 1)
                return findKInTwoSortArrat(a, b, aLeft, aMid-1, bLeft, bRight, k);
            else
                return findKInTwoSortArrat(a, b, aLeft, aRight, bMid+1, bRight, k-(bMid-bLeft)-1);
        }


    }

    public static void main(String[] args) throws Exception {
        int res =  FindN.findN(new int[]{1,2,5,7,2,8}, 2 ,0,5);
        System.out.println(res);

        int[] a = new int[] {1, 4, 6};
        int[] b = new int[] {5, 8, 9};
        System.out.println(findKInTwoSortArrat(a, b, 0, 2, 0, 2, 3));
    }
}
