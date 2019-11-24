package ru.job4j.departments;

import java.util.List;
import java.util.TreeSet;

public class SortDepartment {
    //TreeSet<String> treeDepartment = new TreeSet<>(); // это дерево будет заполняться по умолчанию встроенным комп

    // метод прямой сортировки
    // abs(List<String> orgs) - прямой порядок.
    public TreeSet<String> abs(List<String> orgs) {
        TreeSet<String> tree = new TreeSet<>();
        for (String element : orgs) {
            fillTree(element, tree);
        }
        return tree;
    }

    // метод обратной сортировки, работает с компаратором
    // desc(List<String> orgs) - обратный порядок.
    public TreeSet<String> desc(List<String> orgs) {
        TreeSet<String> tree = new TreeSet<>(new ComparatorSort());
        for (String element : orgs) {
            fillTree(element, tree);
        }
        return tree;
    }

    // метод для разделения строки на отделы  !!! - переделать в рекурсию
    // будет добавлять в дерево уникальные элементы кусками пока не добавится головной отдел
    public void fillTree(String d, TreeSet treeSet) {
        String symbol = "/"; // сделать передаваемым параметром?
        treeSet.add(d);
        if (d.contains(symbol)) {
            d = d.substring(0, d.lastIndexOf(symbol));
            fillTree(d, treeSet);
        }
        /*
        do {
            treeDepartment.add(d);
            if (d.contains(symbol)) {
                d = d.substring(0, d.lastIndexOf(symbol));
            }
            treeDepartment.add(d);
        } while (d.contains(symbol));
         */
    }
    /*
    beginIndex — начальный индекс, включительно;
    endIndex — конечный индекс, не включая.
     */


    //для компаратора написать метод для выделения главных отделов - групп k1 - k2 - ... !!!!!!!!
    public static String getHeadCode(String s) {
        String result;
        if (!s.contains("/")) {
            result = s;
        } else {
            result = s.substring(0, s.indexOf("/"));
        }
        return result;
    }


    // fillGaps(List<String> orgs): List<String> - добавить недостающие элементы.
    public static void fillGaps(List<String> list) {
        //TreeSet<String> tree = new TreeSet<>();
    }
    //
}
