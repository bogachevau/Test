package homeWork4;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
 * В этот телефонный справочник с помощью метода add() можно добавлять записи, а с помощью метода get()
 * искать номер телефона по фамилии. Следует учесть, что под одной фамилией может быть несколько телефонов
 * (в случае однофамильцев), тогда при запросе такой фамилии должны выводиться все телефоны.
 * Желательно не добавлять лишний функционал (дополнительные поля (имя, отчество, адрес),
 * взаимодействие с пользователем через консоль и т.д).
 * Консоль использовать только для вывода результатов проверки телефонного справочника.
 */

public class PhoneDirectory {
    private TreeMap<String, ArrayList<String>> phoneBook = new TreeMap<>();

    public void add(String lastname, String phoneNumber) {
        ArrayList<String> phoneForLastname = phoneBook.getOrDefault(lastname, new ArrayList<>());
        phoneForLastname.add(phoneNumber);
        phoneBook.put(lastname, phoneForLastname);
    }

    public ArrayList<String> get(String lastname) {
        if (phoneBook.get(lastname) == null){
            System.out.println("Абонента с такой фамилией нет в справочнике");
            return null;
        } else {
            return phoneBook.get(lastname);
        }
   }

    public static void main(String[] args) {
        PhoneDirectory phoneDirectory = new PhoneDirectory();
        phoneDirectory.add("Иванов", "95175325845");
        phoneDirectory.add("Петров", "11111111111");
        phoneDirectory.add("Сидоров", "25825825825");
        phoneDirectory.add("Семенов", "65465445665");
        phoneDirectory.add("Иванов", "75315935785");

        System.out.println(phoneDirectory.get("Иванов"));
    }
}
