package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
        for (String element : value) {
            rsl++;
            if (element.equals(key)) {
                return rsl;
            }
        }
        if (rsl == (-1)) {
            throw new ElementNotFoundException();
        }
        return rsl;
    }

    public static void main(String[] args) {
        String[] mass = new String[] {"AAAAATAAAAAA", "asdasd", "FF", "GG"};
        String elem = "FF";
        try {
            System.out.println(indexOf(mass, elem));
        } catch (ElementNotFoundException e) {
            System.out.println("Такого элемента, как " + elem + " нет в массиве");
            e.printStackTrace();
        }
    }
}