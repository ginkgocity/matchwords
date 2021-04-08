package io.github.liuguo;

public enum NodeTypeEnum {
    ROOT((short)0,"根节点"),
    START((short)1,"当前节点是某个字符的起点"),
    MIDDLE((short)2,"当前节点是某个字符的中间点"),
    END((short)3,"当前节点是某个字符的终点");

    private short value;
    NodeTypeEnum(short value,String desc){
        this.value = value;
    }

    public short getValue(){
        return this.value;
    }
}
