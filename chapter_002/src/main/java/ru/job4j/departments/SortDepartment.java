package ru.job4j.departments;

import java.util.List;
import java.util.TreeSet;

public class SortDepartment {
    public TreeSet<String> abs(List<String> orgs) {
        TreeSet<String> tree = new TreeSet<>();
        for (String element : orgs) {
            fillTree(element, tree);
        }
        return tree;
    }

    public TreeSet<String> desc(List<String> orgs) {
        TreeSet<String> tree = new TreeSet<>(new ComparatorSort());
        for (String element : orgs) {
            fillTree(element, tree);
        }
        return tree;
    }

    public void fillTree(String d, TreeSet treeSet) {
        String symbol = "/";
        treeSet.add(d);
        if (d.contains(symbol)) {
            d = d.substring(0, d.lastIndexOf(symbol));
            fillTree(d, treeSet);
        }
    }

    public static String getHeadCode(String s) {
        String result;
        if (!s.contains("/")) {
            result = s;
        } else {
            result = s.substring(0, s.indexOf("/"));
        }
        return result;
    }
}
