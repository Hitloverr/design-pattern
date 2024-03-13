public class StrategyMain {
    public static void main(String[] args) {
        String a = "";
        new Context(StrategyFactory.getStrategy(a)).method();
    }
}
