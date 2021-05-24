package io.github.ginkgocity;

import java.util.Arrays;
import java.util.List;

public class Test {
    private static String [] arr = {
            "小狗",
            "狗狗",
            "狗大"};

    private static String [] arr2 = {
            "大小狗",
            "大狗狗",
            "大大侠"};
    public static void main(String[] args) {
        WordTree tree = new WordTree();
        tree.addWords(arr);
        tree.addWhiteWords(arr2);
        String text = "小狗大小狗狗狗";
        long l = System.currentTimeMillis();
        List<String> list = null;
        for (int i=0;i<1;i++){
            list = tree.match(text);
        }
        for (String s : list)
            System.out.println(s);

    }
}
