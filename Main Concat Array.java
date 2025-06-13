public class Main {
    public static void main(String[] args){
        int[] arr1 = {-2, -1, 0, 4, 7, 10, 12};
        int[] arr2 = {-10, 1, 1, 1, 2, 3, 6, 7, 10, 100, 1000};

        int[] arr3 = concat(arr1,arr2);
        for (int i = 0; i < arr3.length; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
    public static int[] concat(int[] one, int[] two){
        int[] result = new int[one.length + two.length];
        for (int i = 0, j = 0, r = 0; r < result.length; r++) {
            if (i < one.length && (j >= two.length || one[i] < two[j])){
                result[r] = one[i];
                i++;
            }else{
                result[r] = two[j];
                j++;
            }
        }
        return result;
    }

}