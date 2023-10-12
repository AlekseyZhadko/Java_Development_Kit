package Seminar_3;

public class Hardworker implements Person{
    @Override
    public void doWork() {
        System.out.println("Working Hard!");
    }

    @Override
    public void haveRest() {
        System.out.println("Can't stop working!");
    }
}
