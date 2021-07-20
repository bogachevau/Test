package homeWork2;

import java.util.Arrays;

/***
 * 1. Написать метод, на вход которому подается двумерный строковый массив размером 4х4.
 * При подаче массива другого размера необходимо бросить исключение MyArraySizeException.
 * 2. Далее метод должен пройтись по всем элементам массива, преобразовать в int и просуммировать.
 * Если в каком-то элементе преобразование не удалось (например, если в ячейке лежит символ или текст вместо числа),
 * надо бросить исключение MyArrayDataException с детализацией, в какой ячейке неверные данные.
 * 3. В методе main() вызвать полученный метод, обработать возможные исключения MySizeArrayException и
 * MyArrayDataException и вывести результат расчета.
 */

public class Main {
    public static void main(String[] args) throws MyArrayDataException, MyArraySizeException {
        String[][] array = {
                {"4", "5", "6", "7"},
                {"8", "9", "10", "11"},
                {"0", "1", "2", "3"},
                {"-4", "-3", "-2", "-1"}
        };
        arraySum(array);

    }

    public static String[][] arraySum(String[][] twoDimensionalArray) throws MyArraySizeException,
            MyArrayDataException {

        if (twoDimensionalArray.length != 4) {
            throw new MyArraySizeException("Неверная длина массива: " + twoDimensionalArray.length);
        }

        for (String[] arr : twoDimensionalArray) {
            if (arr.length != 4) {
                throw new MyArraySizeException("Неверная высота массива: " + arr.length);
            }
        }

        int sum = 0;

        for (int i = 0; i < twoDimensionalArray.length; i++) {
            for (int j = 0; j < twoDimensionalArray.length; j++) {
                try {
                    sum += Integer.parseInt(twoDimensionalArray[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Нельзя преобразовать ячейку " + i + "x" + j);
                }
            }
        }
        System.out.println("Сумма элементов массива: " + sum);

        return twoDimensionalArray;
    }
}
