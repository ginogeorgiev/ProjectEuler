public class SelectionSort {

    public void sortInt(int[] array) {
        for( int i = 0; i < array.length-1; i++){
            int placeholder = i;
            for (int j = i + 1; j < array.length; j++){
                if (array[placeholder] > array[j]){
                    placeholder = j;
                }
            }
            ProjectEuler.swapInt(array, i, placeholder);
        }
    }

    public static void sortString(String[] a) {
        for( int i = 0; i < a.length-1; i++){
            int placeholder = i;
            for (int j = i + 1; j < a.length; j++){
                if (a[placeholder].compareTo(a[j]) > 0){
                    placeholder = j;
                }
            }
            ProjectEuler.swapString(a, i, placeholder);
        }
    }
}
