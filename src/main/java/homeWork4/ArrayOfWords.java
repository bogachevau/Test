package homeWork4;

import java.util.*;

/**
 * Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 * Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 * Посчитать, сколько раз встречается каждое слово.
 */

public class ArrayOfWords {
    public static void main(String[] args) {
        ArrayList<String> stringArrayList = new ArrayList<>(Arrays.asList("home", "cat", "dog", "mouse",
                "car", "yard", "lawn", "apple", "cherry", "grape", "aviary", "shed", "home", "cat", "dog",
                "car", "yard", "apple", "cherry", "grape", "home", "cat", "dog"));
        System.out.println("Исходный набор слов: " + stringArrayList);

        // подсчет дублирующихся элементов
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String tmp : stringArrayList) {
            Integer count = map.get(tmp);
            map.put(tmp, (count == null) ? 1 : count + 1);
        }
        System.out.println("Подсчет количества дубликатов в наборе слов: " + map);

        // вывод уникальных элементов списка
        HashSet<String> stringHashSet = new HashSet<>();
        stringHashSet.addAll(stringArrayList);
        System.out.println("Список уникальных слов в наборе: " + stringHashSet);
    }
}
