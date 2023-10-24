package Seminar_4.Task;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        NoteEmployee note = new NoteEmployee(10);
        Employee emp1 = new Employee("123123121", "user1",
                LocalDateTime.of(2021, Month.APRIL, 5, 5, 5));
        Employee emp2 = new Employee("123123122", "user2",
                LocalDateTime.of(2022, Month.APRIL, 5, 5, 5));
        Employee emp3 = new Employee("123123123", "user3",
                LocalDateTime.of(2023, Month.APRIL, 5, 5, 5));
        Employee emp4 = new Employee("123123124", "user4",
                LocalDateTime.of(2019, Month.APRIL, 5, 5, 5));
        Employee emp5 = new Employee("123123125", "user5",
                LocalDateTime.of(2018, Month.APRIL, 5, 5, 5));
        note.add(emp1);
        note.add(emp2);
        note.add(emp3);
        note.add(emp4);
        note.add(emp5);

        System.out.println(note.getEmployeE(2));
        System.out.println(note.getPhone("user3"));
        System.out.println(note.getEmployee(2));

    }
}
