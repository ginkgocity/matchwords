package io.github.ginkgocity;

import java.util.List;

public class Test {
    private static String [] arr = {
            "ะกนท",
            "นทนท",
            "ด๓ฯภ"};

    public static void main(String[] args) {
        WordTree tree = new WordTree();
        tree.addWords(arr);
        String text = "ะกนทนทนท";
        List<String> list = tree.simpleMatch(text);
        System.out.println(list);
    }
}
