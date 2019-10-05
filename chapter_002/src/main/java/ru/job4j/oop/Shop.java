package ru.job4j.oop;

public class Shop {
    public Product[] delete(Product[] products, int index) {
        for (int i = index; i < products.length - 1; i++) {
            products[i] = products[i + 1];
            products[i + 1] = null;
        }
        return products;
    }

    public static void main(String[] args) {
        Product[] products = new Product[5];
        products[0] = new Product("Milk", 5);
        products[1] = new Product("Egg", 5);
        products[2] = new Product("Orange", 5);
        products[3] = new Product("Ice cream", 5);
        products[4] = new Product("Bread", 5);

        for (Product product : products) {
            System.out.println(product.getName());
        }

        System.out.println();
        System.out.println("Удаляем из ячейки значение с индексом 1");
        System.out.println();
        Shop shop = new Shop();
        Product[] pr = shop.delete(products, 1);

        for (Product product : pr) {
            if (product != null) {
                System.out.println(product.getName());
            } else {
                System.out.println("null");
            }
        }
    }
}
