package Seminar_3.Calc;

import Seminar_3.NightClub;

public class Calculator {

//    . Написать класс Калькулятор (необобщенный), который содержит обобщенные
//    статические методы: sum(), multiply(), divide(), subtract(). Параметры этих методов –два
//    числа разного типа, над которыми должна быть произведена операция.
    public static <T extends Number, E extends Number> Double sum(T first, E second) {
        return first.doubleValue() + second.doubleValue();
    }

    public static <T extends Number, E extends Number> Double minus(T first, E second) {
        return first.doubleValue() - second.doubleValue();
    }

    public static <T extends Number, E extends Number> Double multiply(T first, E second) {
        return first.doubleValue() * second.doubleValue();
    }

    public static <T extends Number, E extends Number> Double div(T first, E second) {
        return first.doubleValue() / second.doubleValue();
    }
}
