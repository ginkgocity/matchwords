package io.github.ginkgocity;

import java.util.List;

public class Test {
    private static String [] arr = {
            "Ð¡¹·",
            "¹·¹·",
            "´óÏÀ"};

    private static String [] arr2 = {
            "´óÐ¡¹·",
            "´ó¹·¹·",
            "´ó´óÏÀ"};
    public static void main(String[] args) {
        WordTree tree = new WordTree();
        tree.addWords(arr);
        tree.addWhiteWords(arr2);
        String text = "Ð¡¹·´ó¹·¹·¹·¹·";
        List<String> list = tree.simpleMatch(text);
        System.out.println(list);
    }
}
