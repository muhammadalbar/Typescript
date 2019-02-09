public class App{
    public static void main(String[] args){

        int[] inputArray = {9,7,3,1,6,2,0};
        MergerSort sorter = new MergerSort();

        sorter.sort(inputArray);

        for(int i = 0; i < inputArray.length; i++){
            System.out.println(inputArray[i]);
        }
    }
}