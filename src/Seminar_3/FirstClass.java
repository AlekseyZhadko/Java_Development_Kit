package Seminar_3;
import java.io.DataInput;

//Создать обобщенный класс с тремя параметрами (T, V, K). Класс содержит три переменные типа
// (T, V, K), конструктор, принимающий на вход параметры типа (T, V, K), методы
//        возвращающие значения трех переменных. Создать метод, выводящий на консоль имена
//        классов для трех переменных класса. Наложить ограничения на параметры типа: T
//        должен реализовать интерфейс Comparable (классы оболочки, String), V должен
//        реализовать интерфейс DataInput и расширять класс InputStream, K должен расширять класс
//        Number.

//– Написать итератор по массиву. Итератор – это объект, осуществляющий движение по коллекциям
//        любого типа, содержащим любые типы данных. Итераторы обычно имеют только
//        два метода – проверка на наличие следующего элемента и переход к следующему элементу.
//        Но также, особенно в других языках программирования, возможно встретить итераторы,
//        реализующие дополнительную логику.

public class FirstClass<T extends Comparable,
        V extends DataInput,
        K extends Number> {
    T comparableItem;
    V dataItem;
    K numberItem;

    FirstClass(T comparableItem,
               V dataItem,
               K numberItem) {
        this.comparableItem = comparableItem;
        this.dataItem = dataItem;
        this.numberItem = numberItem;
    }

    void getNameClass() {
        System.out.println(comparableItem.getClass().getName());
        System.out.println(dataItem.getClass().getName());
        System.out.println(numberItem.getClass().getName());
    }
}
