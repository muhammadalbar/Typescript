public class LinierSearch{
    public static void main(String[] args){
        linierSearch([2] , 3);
    }

    public static int linierSearch(int [] a, int x){
        int value = -1;
        for(int i = 0; i < a.length; i++){
            if(a[i] == x){
                return i;
            }
        }
        return -1;
    }
}