package com.hfh;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class TreeNode {
    private char word;
    private NodeTypeEnum type;
    private TreeNode parent;
    private Map<Character,TreeNode> child = null;
    private String wordsString = null;
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

    public String getWordsString(){
        return this.wordsString;
    }
}
