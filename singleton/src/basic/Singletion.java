package basic;

import java.io.Serializable;

public class Singletion implements Serializable {
    // 属性都声明为transient
    private transient int num = 0;
    public static Singletion INSTANCE = new Singletion();

    private Singletion() {

    }

    public Object readResolve() {
        return INSTANCE;
    }

}
