package io.github.liuguo;

import java.util.ArrayList;
import java.util.List;

/**
 * 词树
 *
 * @author hfh
 */
public class WordTree {

    private TreeNode root = null;

    public TreeNode root(){
        if(root == null){
            root = new TreeNode('0',NodeTypeEnum.ROOT);
        }
        return root;
    }

    /**
     * 添加需要匹配的单词
     */
    public void addWords(String words){
        String [] arr = {words};
        addWords(arr);
    }

    /**
     * 添加需要匹配的单词数组
     */
    public void addWords(String [] words){
        NodeTypeEnum type;
        TreeNode cnode;
        String str;
        for (int i = 0; i < words.length; i++) {
            str = words[i];
            cnode = root();
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

    /**
     * 从一个字符文本中，找到命中匹配到的词集
     *
     * @return 匹配到的词集
     */
    public List<String> match(String text){
        TreeNode treeNode = root();
        List<String> list = new ArrayList<>();
        char word;
        for(int i=0;i<text.length();i++){
            word = text.charAt(i);
            treeNode = treeNode.get(word);
            if( treeNode == null){
                treeNode = root().get(word);
                if(treeNode!=null){
                    if(treeNode.getType() == NodeTypeEnum.END)
                        list.add(treeNode.getWordsString());
                }else
                    treeNode = root();
            }else if(treeNode.getType() == NodeTypeEnum.END){
                list.add(treeNode.getWordsString());
            }
        }
        return list;
    }


    /**
     * 从一个字符文本中，判断是否存在有命中匹配的词语
     *
     * @return 命中结果
     */
    public boolean exist(String text){
        TreeNode treeNode = root();
        char word;
        for(int i=0;i<text.length();i++){
            word = text.charAt(i);
            treeNode = treeNode.get(word);
            if( treeNode == null){
                treeNode = root().get(word);
                if(treeNode!=null){
                    if(treeNode.getType() == NodeTypeEnum.END)return true;
                }else
                    treeNode = root();
            }else if(treeNode.getType() == NodeTypeEnum.END){
                return true;
            }
        }
        return false;
    }
}
