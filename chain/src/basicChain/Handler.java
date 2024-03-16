package basicChain;

import javax.swing.text.AbstractDocument;
import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.Segment;
import javax.swing.undo.UndoableEdit;
import java.util.ArrayList;
import java.util.List;

public interface Handler {
    boolean handle(AbstractDocument.Content content);
}

class AHandler implements Handler {


    @Override
    public boolean handle(AbstractDocument.Content content) {
        System.out.println('A');
        return false;
    }
}

class BHandler implements Handler {

    @Override
    public boolean handle(AbstractDocument.Content content) {
        return true;
    }
}

class HandlerChain{
    private List<Handler> handlerList = new ArrayList<>();

    public void addHandler(Handler handler){
        handlerList.add(handler);
    }

    public void handle(AbstractDocument.Content content) {
        for (Handler handler : handlerList) {
            boolean handled = handler.handle(content);
            if (handled) {
                break;
            }
        }
    }

}

class Main{
    public static void main(String[] args) {
        HandlerChain handlerChain = new HandlerChain();
        handlerChain.addHandler(new AHandler());
        handlerChain.addHandler(new BHandler());
        handlerChain.handle(new AbstractDocument.Content() {
            @Override
            public Position createPosition(int offset) throws BadLocationException {
                return null;
            }

            @Override
            public int length() {
                return 0;
            }

            @Override
            public UndoableEdit insertString(int where, String str) throws BadLocationException {
                return null;
            }

            @Override
            public UndoableEdit remove(int where, int nitems) throws BadLocationException {
                return null;
            }

            @Override
            public String getString(int where, int len) throws BadLocationException {
                return null;
            }

            @Override
            public void getChars(int where, int len, Segment txt) throws BadLocationException {

            }
        });
    }
}