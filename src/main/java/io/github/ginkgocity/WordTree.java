package io.github.ginkgocity;

import java.util.ArrayList;
import java.util.List;

/**
 * WordTree
 *
 * @author hfh
 */
public class WordTree {

    private Node root = null;

    public WordTree(){
        this.root = new TreeNode();
    }
    public WordTree(Node node){
        this.root = node;
    }


    public void addWord(String word){
        String [] arr = {word};
        addWords(arr);
    }

    public void addWords(String [] words){
        NodeTypeEnum type;
        Node cnode;
        String str;
        for (int i = 0; i < words.length; i++) {
            str = words[i];
            cnode = this.root;
            for (int j = 0; j < str.length(); j++) {
                if(j==str.length()-1){
                    cnode = cnode.addChild(str.charAt(j),NodeTypeEnum.END,str);
                }else if(j==0){
                    cnode = cnode.addChild(str.charAt(j),NodeTypeEnum.START,str);
                }
                else{
                    cnode = cnode.addChild(str.charAt(j),NodeTypeEnum.MIDDLE);
                }
            }
        }
    }
    public void addWhiteWords(String [] words){
        NodeTypeEnum type;
        Node cnode;
        String str;
        for (int i = 0; i < words.length; i++) {
            str = words[i];
            cnode = this.root;
            for (int j = 0; j < str.length(); j++) {
                if(j==str.length()-1){
                    cnode = cnode.addChild(str.charAt(j),NodeTypeEnum.WHITE,"");
                }else if(j==0){
                    cnode = cnode.addChild(str.charAt(j),NodeTypeEnum.START,str);
                }
                else{
                    cnode = cnode.addChild(str.charAt(j),NodeTypeEnum.MIDDLE);
                }
            }
        }
    }

    public List<String> simpleMatch(String text){
        Node treeNode = this.root;
        List<String> list = new ArrayList<>();
        char word;
        for(int i=0;i<text.length();i++){
            word = text.charAt(i);
            treeNode = treeNode.get(word);
            if( treeNode == null){
                treeNode = this.root.get(word);
                if(treeNode!=null){
                    if(treeNode.getType() == NodeTypeEnum.END)
                        list.add(treeNode.getWordsString());
                }else{
                    treeNode = this.root;
                }
            }else if(treeNode.getType() == NodeTypeEnum.END){
                list.add(treeNode.getWordsString());
            }
        }
        return list;
    }

    public List<String> match(String text){
        Node treeNode = this.root;
        List<String> list = new ArrayList<>();
        char word;
        for(int i=0;i<text.length();i++){
            word = text.charAt(i);
            treeNode = treeNode.get(word);
            if( treeNode == null){
                treeNode = this.root.get(word);
                if(treeNode!=null){
                    if(treeNode.getType() == NodeTypeEnum.END)
                        list.add(treeNode.getWordsString());
                }else{
                    treeNode = this.root;
                    //i--;
                }
            }else if(treeNode.getType() == NodeTypeEnum.END){
                list.add(treeNode.getWordsString());
                if(!treeNode.existChild())i--;
            }
        }
        return list;
    }

    public boolean exist(String text){
        Node treeNode = this.root;
        char word;
        for(int i=0;i<text.length();i++){
            word = text.charAt(i);
            treeNode = treeNode.get(word);
            if( treeNode == null){
                treeNode = this.root.get(word);
                if(treeNode!=null){
                    if(treeNode.getType() == NodeTypeEnum.END)return true;
                }else
                    treeNode = this.root;
            }else if(treeNode.getType() == NodeTypeEnum.END){
                return true;
            }
        }
        return false;
    }
}
