import java.util.Objects;

public class TextStyle {
    private String textFont;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TextStyle textStyle = (TextStyle) o;
        return Objects.equals(textFont, textStyle.textFont) && Objects.equals(textSize, textStyle.textSize) && Objects.equals(color, textStyle.color);
    }

    private Integer textSize;

    private String color;

    public TextStyle(String textFont,Integer textSize,String color) {
        this.textFont = textFont;
        this.textSize = textSize;
        this.color = color;
    }

}
