import java.io.IOException;
import java.util.List;

public class ProjectEuler {

    public static void main(String[] args) throws IOException {

        projectEuler();

    }


    public static void projectEuler() throws IOException {

        // Choose problem you want so solve
        // int[] solvedProblems = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 16, 20, 22, 25, 27, 29, 34, 35, 56}

        Problems problem = new Problems();
        System.out.println(problem.problem27());

    }

    static void swapInt(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void swapString(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static int[] toIntArray(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            array[i] = list.get(i);
        }
        return array;
    }
}