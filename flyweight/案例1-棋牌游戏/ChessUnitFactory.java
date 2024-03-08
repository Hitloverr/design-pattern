import java.util.HashMap;
import java.util.Map;

public class ChessUnitFactory {
    private static final Map<Integer,ChessUnit> pieces = new HashMap<>();
    
    static {
        pieces.put(1,new ChessUnit("车", ChessUnit.Color.RED));
        pieces.put(2,new ChessUnit("车", ChessUnit.Color.BLACK));
    }

    public static ChessUnit getChessUnit(Integer id) {
        return pieces.get(id);
    }
}
