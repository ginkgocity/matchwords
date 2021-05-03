package io.github.ginkgocity;

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
        String text = "С���󹷹�����";
        List<String> list = tree.simpleMatch(text);
        System.out.println(list);
    }
}
