package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book book1 = new Book("Clean code", 180);
        Book book2 = new Book("Andalucia", 106);
        Book book3 = new Book("The call of the wild", 201);
        Book book4 = new Book("Ghost", 302);
        Book bookTemp;
        Book[] lib = new Book[4];
        lib[0] = book1;
        lib[1] = book2;
        lib[2] = book3;
        lib[3] = book4;
        for (int index = 0; index < lib.length; index++) {
            System.out.println(lib[index].getName() + " "
                    + lib[index].getCount());
        }
        bookTemp = lib[0];
        lib[0] = lib[3];
        lib[3] = bookTemp;
        System.out.println();
        for (Book book : lib) {
            if (book.getName().equals("Clean code")) {
                System.out.println(book.getName()
                        + " " + book.getCount());
            }
        }
    }
}
