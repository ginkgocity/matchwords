package io.github.ginkgocity;

public enum NodeTypeEnum {
    ROOT((short)0),
    START((short)1),
    MIDDLE((short)2),
    END((short)3),
    WHITE((short)4);

    private short value;
    NodeTypeEnum(short value){
        this.value = value;
    }

    public short getValue(){
        return this.value;
    }
}
