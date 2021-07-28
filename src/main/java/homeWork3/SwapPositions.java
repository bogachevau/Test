package homeWork3;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 *Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
 */

public class SwapPositions implements Comparator<String> {

    private static void sortArray() {
        ArrayList<String> stringArrayList = new ArrayList<>();
        stringArrayList.add("test");
        stringArrayList.add("test1");
        stringArrayList.add("test2");
        stringArrayList.add("test3");
        System.out.println(stringArrayList);
        stringArrayList.sort((String o1, String o2) -> o2.compareTo(o1));
        System.out.println(stringArrayList);

    }


    private static String[] swapPositionsArray(String array[], int x, int y) {

        System.out.println(Arrays.toString(array));
        String tmp = array[x];
        array[x] = array[y];
        array[y] = tmp;
        System.out.println(Arrays.toString(array));

        return array;
    }

    public static void main(String[] args) {
        String[] stringArray = {"A", "B", "C", "D"};
        swapPositionsArray(stringArray, 0, 2);
        sortArray();
    }

    @Override
    public int compare(String o1, String o2) {
        return o2.compareTo(o1);
    }
}
