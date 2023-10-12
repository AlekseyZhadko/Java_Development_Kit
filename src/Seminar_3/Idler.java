package Seminar_3;

public class Idler implements Person{
    @Override
    public void doWork() {
        System.out.println("I don't want to work");
    }

    @Override
    public void haveRest() {
        System.out.println("Party Hard!");
    }
}
