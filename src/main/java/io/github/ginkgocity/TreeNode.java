package io.github.ginkgocity;

import java.util.HashMap;
import java.util.Map;

public class TreeNode implements Node{
    private char word;
    private NodeTypeEnum type;
    private Map<Character,TreeNode> child = null;
    private String wordsString = null;
    TreeNode(){
        this.word = '0';
        this.type = NodeTypeEnum.ROOT;
        this.child = new HashMap<Character,TreeNode>();;
    }

    TreeNode(char word,NodeTypeEnum type){
        this.word = word;
        this.type = type;
        this.child = new HashMap<Character,TreeNode>();;
    }

    public NodeTypeEnum getType(){
        return this.type;
    }


    public TreeNode get(char word){
        return child.get(word);
    }

    public boolean exist(char word){
        return child.get(word) != null;
    }

    public boolean existChild(){
        return this.child==null || this.child.size()>0;
    }

    public TreeNode addChild(char word,NodeTypeEnum type){

        TreeNode node = child.get(word);
        if( node== null){
            node = new TreeNode(word,type);
            child.put(word,node);
        }

        if(this.type.getValue()<type.getValue()){
            node.type = type;
        }

        return node;
    }

    public TreeNode addChild(char word,NodeTypeEnum type,String wordsString){
        TreeNode node = addChild(word,type);
        node.wordsString = wordsString;
        return node;
    }

    public Map<Character,TreeNode> getChild(){
        return this.child;
    }

    public String getWordsString(){
        return this.wordsString;
    }
}
