public class App{
    public static void main(String[] args){
        int [] myArray = insertionSort(new int[] {9,8,99,110,8,87,3,13});

        for(int i = 0; i < myArray.length; i++){
            System.out.println(myArray[i]);
        }
    }
    
    public static int[] insertionSort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int element = arr[i];
            int j = i-1;
            while(j >= 0 && arr[j] > element){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = element;
        }
        return arr;
    }
}