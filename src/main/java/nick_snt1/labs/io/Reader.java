package nick_snt1.labs.io;

public abstract class Reader {
    public abstract Integer    readSize()   throws Exception;
    public abstract Double[][] readMatrix() throws Exception;
}
