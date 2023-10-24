package Seminar_4.Task;

import org.jetbrains.annotations.NotNull;

import java.util.*;

public class NoteEmployee implements List<Employee> {

    private Employee[] employees;

    private int index = 0;
    private int initialCapacity = 100;

    public NoteEmployee(int capacity) {
        this.employees = new Employee[capacity];
    }

    public List<Employee> getEmployeE(int workingYear) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee != null && employee.getWorkingYears() == workingYear) {
                result.add(employee);
            }
        }
        return result;
    }

    public Map<String, String> getPhone(String name) {
        Map<String, String> result = new HashMap<>();
        for (Employee employee : employees) {
            if (employee != null && employee.getName().equals(name)) {
                result.put(employee.getName(), employee.getPhone());
            }
        }
        return result;
    }

    public Employee getEmployee(int number) {
        for (Employee employee : employees) {
            if (employee != null && employee.getId() == number) {
                return employee;
            }
        }
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @NotNull
    @Override
    public Iterator<Employee> iterator() {
        return null;
    }

    @NotNull
    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @NotNull
    @Override
    public <T> T[] toArray(@NotNull T[] a) {
        return null;
    }

    @Override
    public boolean add(Employee employee) {
        employees[this.index++] = employee;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(@NotNull Collection<? extends Employee> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, @NotNull Collection<? extends Employee> c) {
        return false;
    }

    @Override
    public boolean removeAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(@NotNull Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Employee get(int index) {
        return null;
    }

    @Override
    public Employee set(int index, Employee element) {
        return null;
    }

    @Override
    public void add(int index, Employee element) {

    }

    @Override
    public Employee remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @NotNull
    @Override
    public ListIterator<Employee> listIterator() {
        return null;
    }

    @NotNull
    @Override
    public ListIterator<Employee> listIterator(int index) {
        return null;
    }

    @NotNull
    @Override
    public List<Employee> subList(int fromIndex, int toIndex) {
        return null;
    }
}
