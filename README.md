**一、简述**

1. matchwords项目，是一个性能极佳的敏感词过滤器。

2. 支持简单匹配，全量匹配，白名单等等模式。简单匹配性能最好，但是不能完全匹配，其中区别API中有体现。白名单主要处理词汇中包含黑名单的词。

3. 用其他同类型项目测试性能，使用相同的文本和敏感词，处理一万次。可以看到，本项目性能上的优势。
   <img src="C:\Users\liuguo18301806757\Pictures\Feedback\12e1715a061679a1b52da86e530abc5.png"  />
   ![](C:\Users\liuguo18301806757\Pictures\Feedback\4552903979c5bc758955a93b2361f0c.png)
   ![](C:\Users\liuguo18301806757\Pictures\Feedback\c1343bf41c83c272e21bfdd85492381.png)
   
**二、API预览**

1. 添加敏感词

```java
String [] arr = {"小狗","狗毛","大侠"}
WordTree tree = new WordTree();
tree.addWords(arr);
//线程安全的节点树
WordTree tree = new WordTree(new SyncTreeNode());
```

2. 简单匹配敏感词。

```java
String text = "小狗毛";
List<String> list = tree.simpleMatch(text);
输出: [小狗]
```

3. 全量匹配

```java
String text = "小狗毛";
List<String> list = tree.match(text);
输出: [小狗, 狗毛]
```

4. 添加白名单。白名单中的词，不会被检测。比如，白名单"小狗狗" 包含 黑名单的"狗狗"，当文本中出现"小狗狗"这个词时候，不会被匹配出来。**注意先加黑名单，在添加白名单。**

```java
String [] arr = {"小狗","狗狗","大侠"}
WordTree tree = new WordTree();
tree.addWords(arr);
String [] arr = {"小狗狗"}
tree.addWhiteWords(arr2);
```

5. 是否包含敏感词

```java
tree.exist(text);
```

