public class RecursionHW{
    public static void main(String[] args){
        System.out.println(recursiveLinierSearch(new int[] {4,48,4,28,34,76,9,3}, 0, 28));
    }

    public static int recursiveLinierSearch(int [] arr, int i, int x){
        if(i > arr.length -1){
            return -1;
        }
        else if(arr[i] == x){
            return i;
        }
        else{
            System.out.println("index at: " + i); 
            return recursiveLinierSearch(arr, i+1, x);
        }
    }
}