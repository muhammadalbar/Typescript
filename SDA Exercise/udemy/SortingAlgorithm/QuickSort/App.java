import java.util.Arrays;

public class App{
    public static void main(String[] args){
        int[] inputArray = {12,81,74,43,1098,0,92};
        quickSort(inputArray, 0, inputArray.length-1);

        System.out.println(Arrays.toString(inputArray));
    }

    public static void quickSort(int[] inputArray, int start, int end){
        if(start < end){
            int part = partition(inputArray, start, end); // index position of the correctly pivot value
            quickSort(inputArray, start, part-1); // sort the left half part of the array
            quickSort(inputArray, part+1, end); // sort the right half of the array
        }
    }

    public static int partition(int[] inputArray, int start, int end){
        int pivot = inputArray[end];
        int i = start - 1; // in first iteration i start from -1
        for(int j = start; j <= end-1; j++){
            if(inputArray[j] <= pivot){
                i++;
                // swapping here
                int itemp = inputArray[i];
                int jtemp = inputArray[j];
                inputArray[i] = jtemp;
                inputArray[j] = itemp;
            }
        }
        int itemp = inputArray[i+1];
        inputArray[end] = itemp;
        inputArray[i+1] = pivot;

        return i+1;

    }
}