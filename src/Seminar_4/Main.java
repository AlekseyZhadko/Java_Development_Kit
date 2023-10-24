package Seminar_4;

//В рамках выполнения задачи необходимо:
//        ● Создайте коллекцию мужских и женских имен с помощью интерфейса List
//        ● Отсортируйте коллекцию в алфавитном порядке
//        ● Отсортируйте коллекцию по количеству букв в слове
//        ● Разверните коллекцию

//В рамках выполнения задачи необходимо:
//        ● Создайте коллекцию мужских и женских имен с помощью интерфейса List - добавьте повторяющиеся значения
//        ● Получите уникальный список Set на основании List
//        ● Определите наименьший элемент (алфавитный порядок)
//        ● Определите наибольший элемент (по количеству букв в слове но в обратном порядке)
//        ● Удалите все элементы содержащие букву ‘A’

import java.util.*;

//В рамках выполнения задачи необходимо:
//        ● Создайте телефонный справочник с помощью Map - телефон это ключ, а имя значение
//        ● Найдите человека с самым маленьким номером телефона
//        ● Найдите номер телефона человека чье имя самое большое в алфавитном порядке
public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Алексей");
        names.add("Иван");
        names.add("Олег");
        names.add("Максим");
        names.add("Анна");
        names.add("Ольга");
        names.add("Ксения");
        names.add("Анастасия");
        names.add("Светлана");
        names.sort(String::compareTo);
        System.out.println(names);

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() < o2.length())
                    return 1;
                else if (o2.length() < o1.length())
                    return -1;
                return 0;
            }
        };
        names.sort(comparator);
        System.out.println(names);
        names.sort(Comparator.reverseOrder());
        System.out.println(names);

        Set<String> setStr = new HashSet<>(names);
        System.out.println(setStr);
        names.sort(String::compareTo);
        String name = names.get(0);
        System.out.println(name);
        List<String> namesList = new ArrayList<>();
        for (String n : names) {
            if (!n.contains("а") && !n.contains("А")) {
                namesList.add(n);
            }
        }
        System.out.println(namesList);

        Map<String, String> phoneBook = new HashMap<>();
        phoneBook.put("1235", "User1");
        phoneBook.put("1234", "Aser2");
        phoneBook.put("1236", "User3");
        phoneBook.put("1237", "User4");
        phoneBook.put("1238", "User5");
        phoneBook.put("1239", "User6");
        int numMax = 0;

        for (String s : phoneBook.keySet()) {
            if (Integer.parseInt(s) > numMax)
                numMax = Integer.parseInt(s);
        }
        System.out.println(numMax);

        List<Map.Entry<String, String>> value = new ArrayList<>(phoneBook.entrySet());
        value.sort(Map.Entry.comparingByValue());
        System.out.println(value);
    }
}


