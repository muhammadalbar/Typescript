public class RecursionHW2{
    public static void main(String[] args){
        System.out.println(recursiveBinarySearch(new int[] {1,2,3,4,7,9,12,18}, 0, 7, 9));
    }

    // p is the starting point
    // r is the last point
    // x is the number that we looking for
    public static int recursiveBinarySearch(int [] arr, int p, int r, int x){
        if(p > r){
            return -1;
        }
        else{
            int q = (p+r)/2;
            if(arr[q] == x){
                return q;
            }
            else if(arr[q] > x){
                return recursiveBinarySearch(arr, p, q-1, x);
            }
            else{
                return recursiveBinarySearch(arr, q+1, r, x);
            }
        }    
    }
}