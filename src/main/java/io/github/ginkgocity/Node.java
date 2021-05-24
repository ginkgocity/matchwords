package io.github.ginkgocity;

public interface Node {
    public NodeTypeEnum getType();


    public Node get(char word);

    public boolean exist(char word);

    public boolean existChild();

    public Node addChild(char word,NodeTypeEnum type);

    public Node addChild(char word,NodeTypeEnum type,String wordsString);

    public String getWordsString();
}
