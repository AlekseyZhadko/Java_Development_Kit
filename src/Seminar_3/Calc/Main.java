package Seminar_3.Calc;

public class Main {
    public static void main(String[] args) {
        System.out.println(Calculator.sum(123, 5L));
        System.out.println(Calculator.multiply(123, 5L));
        System.out.println(Calculator.minus(123, 5L));
        System.out.println(Calculator.div(123, 5L));

        String[] array1 = {"1", "a", "2"};
        String[] array2 = {"1", "a", "2"};
        String[] array3 = {"2", "a", "2"};
        System.out.println(compareArrays(array1, array2));
        System.out.println(compareArrays(array1, array3));


        Pair<?, ?> p = new Pair<>(1, "2");
        System.out.println(p.getItem_1());
        System.out.println(p.getItem_2());
        System.out.println(p);

    }

    //    3. Напишите обобщенный метод compareArrays(), который принимает два массива и
//    возвращает true, если они одинаковые, и false в противном случае. Массивы могут быть
//    любого типа данных, но должны иметь одинаковую длину и содержать элементы одного
//    типа.
    public static <T> boolean compareArrays(T[] array1, T[] array2) {
        for (int i = 0; i < array1.length; i++) {
            if (!array1[i].equals(array2[i])) {
                return false;
            }
        }
        return true;
    }

    //    4. Напишите обобщенный класс Pair, который представляет собой пару значений разного типа.
//    Класс должен иметь методы getFirst(), getSecond() для получения значений
//    пары, а также переопределение метода toString(), возвращающее строковое представление
//    пары.
    static class Pair<T, E> {
        T item_1;
        E item_2;

        public Pair(T item_1, E item_2) {
            this.item_1 = item_1;
            this.item_2 = item_2;
        }

        public T getItem_1() {
            return item_1;
        }

        public E getItem_2() {
            return item_2;
        }

        @Override
        public String toString() {
            return "Pair{" +
                    "item_1=" + item_1 +
                    ", item_2=" + item_2 +
                    '}';
        }
    }
}
