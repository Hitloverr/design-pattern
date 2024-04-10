package clean;

import java.math.BigInteger;

public class CreateObject {
    private CreateObject() {

    }

    public static CreateObject ofValue(Object object) {
        return new CreateObject();
    }
}

class Bj extends BigInteger {

    public Bj(byte[] val, int off, int len) {
        super(val, off, len);
    }
}