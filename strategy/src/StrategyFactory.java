import java.util.HashMap;
import java.util.Map;

// 策略的创建
public class StrategyFactory {
    private static Map<String,IStrategy> strategyMap = new HashMap<>();
    static {
        strategyMap.put("A",new StrategyA());
        strategyMap.put("B",new StrategyB());
    }

    public static IStrategy getStrategy(String type) {
        return strategyMap.get(type);
    }
}
