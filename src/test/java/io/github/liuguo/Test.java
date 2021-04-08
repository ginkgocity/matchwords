package io.github.liuguo;

import java.util.List;

public class Test {
    private static String [] arr = {
            "小狗",
            "狗狗",
            "大侠"};

    public static void main(String[] args) {
        WordTree tree = new WordTree();
        tree.addWords(arr);
        String text = "狗小狗狗狗狗狗";
        List<String> list = tree.match(text);
        System.out.println(list);
    }
}
