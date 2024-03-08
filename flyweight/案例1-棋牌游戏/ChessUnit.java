public class ChessUnit {

    private String text;

    private Color color;

    public ChessUnit(String text,Color color) {
        this.text = text;
        this.color = color;
    }


    public static enum Color{
        RED,BLACK
    }
}
