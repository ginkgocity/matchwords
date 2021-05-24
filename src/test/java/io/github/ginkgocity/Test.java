package io.github.ginkgocity;

import java.util.Arrays;
import java.util.List;

public class Test {
    private static String [] arr = {
            "С��",
            "����",
            "����"};

    private static String [] arr2 = {
            "��С��",
            "�󹷹�",
            "�����"};
    public static void main(String[] args) {
        WordTree tree = new WordTree();
        tree.addWords(arr);
        tree.addWhiteWords(arr2);
        String text = "С����С������";
        long l = System.currentTimeMillis();
        List<String> list = null;
        for (int i=0;i<1;i++){
            list = tree.match(text);
        }
        for (String s : list)
            System.out.println(s);

    }
}
