package Seminar_3;

import java.util.Iterator;

//Описать собственную коллекцию – список на основе массива. Коллекция должна иметь
//        возможность хранить любые типы данных, иметь методы добавления и удаления элементов.
public class ParamCollection<T> implements Iterable<T> {
    private T[] array;
    private int index = 0;
    private int size;

    public ParamCollection(T[] array) {
        this.array = array;
        this.size = array.length;
    }

    public void add(T item) {
        if (index < size) {
            array[index] = item;
            index++;
        } else {
            throw new RuntimeException("Array is Full");
        }
    }

    public void delete(int index) {
        array[index] = null;
    }

    public void print() {
        for (T t : array) {
            System.out.printf(t + " ");
        }
    }

    public int getSize() {
        return size;
    }

    public T getByIndex(int index) {
        return array[index];
    }

    @Override
    public Iterator<T> iterator() {
        return new ParamIterator<>(this);
    }
}
