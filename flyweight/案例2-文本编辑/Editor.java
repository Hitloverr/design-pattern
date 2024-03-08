import java.util.ArrayList;
import java.util.List;

public class Editor {

    private List<Text> notes = new ArrayList<>();
    public void appendChar(Character c , String textFont, Integer fontSize,String color) {
        notes.add(new Text(c,TextStyleFactory.getTextStyle(textFont, color, fontSize)));
    }
}
