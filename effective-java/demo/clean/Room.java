package clean;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable {

    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {
        @Override
        public void run() {
            System.out.println("clean room");
        }
    }

    private final State state;
    private final Cleaner.Cleanable cleanable;

    public Room(){
        state = new State();
        cleanable =  cleaner.register(this,state);
    }
    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
