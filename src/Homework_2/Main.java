package Homework_2;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FullStack dev = new DeveloperFull();
        dev.createServer();
        dev.createFront();

        BackEnder backDev = new DeveloperBack();
        backDev.createServer();

        List<BackEnder> devList = Arrays.asList(dev, backDev);
        for (BackEnder developer : devList) {
            developer.createServer();
        }

        FrontEnder frontDev = new DeveloperFront();
        frontDev.createFront();

        List<FrontEnder> devList_2 = Arrays.asList(dev, frontDev);
        for (FrontEnder developer : devList_2) {
            developer.createFront();
        }

        if (dev instanceof FrontEnder) {
            ((FrontEnder) dev).createFront();
        }
    }
}

interface BackEnder {
    void createServer();
}

interface FrontEnder {
    void createFront();
}

interface FullStack extends BackEnder, FrontEnder {

}


class DeveloperFull implements FullStack {
    @Override
    public void createServer() {
        System.out.println("create server");
    }

    @Override
    public void createFront() {
        System.out.println("create design");
    }
}

class DeveloperBack implements BackEnder {

    @Override
    public void createServer() {
        System.out.println("crash server");
    }
}

class DeveloperFront implements FrontEnder {

    @Override
    public void createFront() {
        System.out.println("create button");
    }
}
