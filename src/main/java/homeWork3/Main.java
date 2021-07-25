package homeWork3;

/**
 *Даны классы: Fruit, Apple extends Fruit, Orange extends Fruit.
 *
 * - Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну
 * коробку нельзя сложить и яблоки, и апельсины;
 * - Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество:
 * вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
 * - Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той,
 * которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае.
 * Можно сравнивать коробки с яблоками и апельсинами;
 * - Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов:
 * нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается,
 * а в другую перекидываются объекты, которые были в первой;
 * - Не забываем про метод добавления фрукта в коробку.
 */

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();
        appleBox.addFruit(new Apple(1.0f));
        appleBox.addFruit(new Apple(1.0f));
        appleBox.addFruit(new Apple(1.0f));
        appleBox.addFruit(new Apple(1.0f));
        System.out.println("Вес коробки яблок: " + appleBox.getWeight());
        orangeBox.addFruit(new Orange(1.5f));
        orangeBox.addFruit(new Orange(1.5f));
        orangeBox.addFruit(new Orange(1.5f));
        orangeBox.addFruit(new Orange(1.5f));
        System.out.println("Вес коробки апельсин: " + orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));
        Box<Apple> appleBox1 = new Box<>();
        appleBox.pourOver(appleBox1);
        System.out.println("Вес второй коробки яблок: " + appleBox1.getWeight());





    }
}
