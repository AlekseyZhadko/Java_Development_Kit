package Lection_3;

public class Main {
    private static class Box {
        private Object obj;

        public Box(Object obj) {
            this.obj = obj;
        }

        public Object getObj() {
            return obj;
        }

        public void setObj(Object obj) {
            this.obj = obj;
        }

        public void printInfo() {
            System.out.printf("Box (%s) : %S",
                    obj.getClass().getSimpleName(), obj.toString());
        }
    }


    private static class GBox<T> {
        private T value;

        public GBox(T value) {
            this.value = value;
        }

        public void showType() {
            System.out.println(this.value);
        }
    }

    private static class KVBox<K, V> {
        private K key;
        private V value;

        public KVBox(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        public K getKey() {
            return key;
        }

        public void showType() {
            System.out.printf("Type of key is %s, key = %s" +
                    "type of value is %s, value = %s\n",
                    key.getClass().getName(), getKey(),
                    value.getClass().getName(), getValue());
        }
    }

    public static void main(String[] args) {
        Box b1 = new Box(20);
        Box b2 = new Box(30);
        System.out.println((Integer) b1.getObj() + (Integer) b2.getObj());
        Box b3 = new Box("Hello, ");
        Box b4 = new Box("World!");
        System.out.println((String) b3.getObj() + (String) b4.getObj());

        Box iBox1 = new Box(20);
        Box iBox2 = new Box(30);
        if (iBox1.getObj() instanceof Integer && iBox2.getObj() instanceof Integer) {
            int sum = (Integer) iBox1.getObj() + (Integer) iBox2.getObj();
            System.out.println("sum = " + sum);
        } else {
            System.out.println("The contents of the boxes differ by type");
        }
        iBox1.setObj("sdf"); // Java: "What can go wrong here? You can do it!"


        GBox<String> stringBox = new GBox<>("Hello!");
        stringBox.showType();
        GBox<Integer> integerBox = new GBox<>(12);
        integerBox.showType();
//        GBox<Integer> newBox = new GBox<>();

        KVBox<Integer, String> kvbe = new KVBox<>(1, "Hello");
        kvbe.showType();
        KVBox<String, GBox<String>> kvb1 = new KVBox<>("World", new GBox<>("Java"));
    }

}