import java.util.HashMap;
import java.util.Map;

// 解决了创建一盘棋盘游戏就要新建所有的ChessUnit的问题，通过共享对象解决了空间问题
public class ChessGame {
    private Map<Integer,ChessPiece> chessPieces = new HashMap<>();
    public ChessGame() {
        init();
    }

    private void init() {
        chessPieces.put(1,new ChessPiece(ChessUnitFactory.getChessUnit(1),0,0));
        chessPieces.put(2,new ChessPiece(ChessUnitFactory.getChessUnit(2),0,0));
        chessPieces.put(3,new ChessPiece(ChessUnitFactory.getChessUnit(3),0,0));
    }

    public void move(Integer id, Integer positionX,Integer positionY) {
        chessPieces.get(id).moveTo(positionX,positionY);
    }
}
