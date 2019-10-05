package ru.job4j.oop;

public class Library {
    public static void main(String[] args) {
        Book theLastWish = new Book("The Last Wish", 1000);
        Book swordOfDestiny = new Book("Sword of Destiny", 1000);
        Book bloodOfElves = new Book("Blood of Elves", 1000);
        Book cleanCode = new Book("Clean code", 1000);
        Book[] books = new Book[4];

        books[0] = theLastWish;
        books[1] = swordOfDestiny;
        books[2] = bloodOfElves;
        books[3] = cleanCode;

        System.out.println("4. Выведите содержимое массива на консоль через цикл for + index.");
        for (Book book : books) {
            System.out.println("Книга " + book.getName() + " Страниц " + book.getAmount());
        }

        System.out.println("5. Переставьте книгу с индексом 0 и 3. Выведите содержимое массива на консоль.");
        books[0] = cleanCode;
        books[3] = theLastWish;

        for (Book book : books) {
            System.out.println("Книга " + book.getName() + " Страниц " + book.getAmount());
        }

        System.out.println("6. Добавьте цикл с выводом книг с именем \"Clean code\".");
        for (Book book : books) {
            if (book.getName().equals("Clean code")) {
                System.out.println("Книга " + book.getName() + " Страниц " + book.getAmount());
            }
        }
    }
}
