import java.util.HashMap;
import java.util.Map;

public class TextStyleFactory {

    private static Map<String,TextStyle> textStyleMap = new HashMap<>();

    public static TextStyle getTextStyle(String textFont,String color,Integer fontSize) {
        String hashKey = String.join("-",textFont,color,fontSize +"");
        if (!textStyleMap.containsKey(hashKey)) {
            textStyleMap.put(hashKey,new TextStyle(textFont,fontSize,color));
        }
        return textStyleMap.get(hashKey);
    }
}
