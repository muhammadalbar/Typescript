public class BinarySearch{
    public static void main(String[] args){
        System.out.println(Search(new int[] {1,2,3,4,7,9,12,18}, 0));
    }

    public static int Search(int [] arr, int x){
        int p = 0; // starting point
        int r = arr.length-1; // last point

        while(p <= r){
            int q = (p+r)/2; // middle point
            if(arr[q] == x){
                return q;
            }
            if(arr[q] > x){
                r = q-1;
            }
            else{
                p = q+1;
            }
        }
        return -1;
    }
}