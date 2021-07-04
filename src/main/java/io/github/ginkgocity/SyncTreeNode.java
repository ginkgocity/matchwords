package io.github.ginkgocity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SyncTreeNode implements Node{
    private char word;
    private NodeTypeEnum type;
    private Map<Character,SyncTreeNode> child = null;
    private String wordsString = null;
    SyncTreeNode(char word,NodeTypeEnum type){
        this.word = word;
        this.type = type;
        this.child = new ConcurrentHashMap<Character,SyncTreeNode>();;
    }

    SyncTreeNode(){
        this.word = '0';
        this.type = NodeTypeEnum.ROOT;
        this.child = new ConcurrentHashMap<Character,SyncTreeNode>();;
    }

    public NodeTypeEnum getType(){
        return this.type;
    }


    public Node get(char word){
        return child.get(word);
    }

    public boolean exist(char word){
        return child.get(word) != null;
    }

    public boolean existChild(){
        return this.child==null || this.child.size()>0;
    }

    public SyncTreeNode addChild(char word,NodeTypeEnum type){

        SyncTreeNode node = child.get(word);
        if( node== null){
            node = new SyncTreeNode(word,type);
            child.put(word,node);
        }

        if(this.type.getValue()<type.getValue()){
            node.type = type;
        }

        return node;
    }

    public Node addChild(char word,NodeTypeEnum type,String wordsString){
        SyncTreeNode node = addChild(word,type);
        node.wordsString = wordsString;
        return node;
    }

    public String getWordsString(){
        return this.wordsString;
    }
}
