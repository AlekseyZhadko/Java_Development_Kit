package Seminar_3;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        InputStream is = new DataInputStream(new FileInputStream("src/Seminar_3/test.txt"));
        FirstClass<String, DataInputStream, Number> fc =
                new FirstClass<>("any",
                        new DataInputStream(is),
                        3);
        fc.getNameClass();


        ParamCollection<Double> paramCollection =
                new ParamCollection<>(new Double[10]);
        paramCollection.print();
        System.out.println();
        paramCollection.add(2.0);
        paramCollection.add(2.0);
        paramCollection.add(2.0);
        paramCollection.add(2.0);
        paramCollection.add(2.0);
        paramCollection.add(2.0);
        paramCollection.print();
        System.out.println();
        paramCollection.delete(0);
        paramCollection.print();
        System.out.println();
        for (Double aDouble : paramCollection) {
            System.out.print(aDouble + " ");
        }

//        – Описать интерфейс Person с методами doWork() и haveRest(). Написать два класса
//        работник и бездельник, реализующих интерфейс. Работник работает, и не умеет
//        бездельничать, в то время как бездельник не умеет работать, но умеет отдыхать.
//        Написать обобщённые классы Workplace и Club, содержащие массив из Person. В классах
//        необходимо вызывать у всего массива людей вызывать соответствующие методы.

        Person person1 = new Hardworker();
        Person person2 = new Hardworker();
        Person person3 = new Hardworker();
        Person person4 = new Hardworker();
        Person person5 = new Hardworker();
        Person person6 = new Idler();
        Person person7 = new Idler();
        Person person8 = new Idler();
        Person person9 = new Idler();
        Person person10 = new Idler();

        Person[] workers = {person1, person2, person3, person4, person5,
                person6, person7, person8, person9, person10};

        WorkPlace<? extends Person> factory = new WorkPlace<>(workers);
        NightClub<? extends Person> club = new NightClub<>(workers);

        factory.workForAll();
        club.clubForAll();

//        1. Внедрить итератор из задания 2 в коллекцию, написанную в задании 3 таким образом,
//        чтобы итератор был внутренним классом и, соответственно, объектом в коллекции.

        for (Person worker: workers) {
            System.out.println(worker);
        }
    }
}
