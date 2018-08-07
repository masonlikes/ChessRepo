package chess;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;
import chess.Main;
import chess.Main.BothKings;
import pieces.King;
import pieces.Piece;
import pieces.Rook;

import org.junit.Test;

public class MainTest {
	Main m = new Main();

	@Test
	public void testSetupChess960() {
		King wk;
		King bk;
		
		m.setupBoard();
		
		BothKings both = m.setupChess960();
		
		wk = both.WK;
		bk = both.BK;
		
		assertEquals(wk.getx(),m.flipInt(bk.getx()));
	}

	@Test
	public void testFlipInt() {
		int expectednum = 7;
		int realnum = m.flipInt(0);
		assertEquals(realnum, expectednum);
	}
	
	@Test
	public void testFlipIntFail() {
		int expectednum = 7;
		int realnum = m.flipInt(1);
		assertNotEquals(realnum, expectednum);
	}

	@Test
	public void testChangechance() {
		m.setupBoard();
		int beforeChance = m.getChance();
		m.changechance();
		int afterChance = m.getChance();
		assertNotEquals(beforeChance, afterChance);
	}

	@Test
	public void testCheckmate() {
		Cell board[][] = new Cell[8][8];
		for(int i = 0; i < 8; i++) {
			for(int j = 0; j < 8; j++) {
				board[i][j] = new Cell(j, j, null);
			}
		}
		King k = new King("BK", "Black_King.png", 1, 0, 0);
		Rook r1 = new Rook("WR01", "White_Rook.png", 0);
		Rook r2 = new Rook("WR02", "White_Rook.png", 0);
		
		Piece p = k;
		
		board[0][0] = new Cell(0, 0, p);
		p = r1;
		board[3][0] = new Cell(0, 3, p);
		p = r2;
		board[3][1] = new Cell(1, 3, p);
		
		m.setBoardState(board);
		
		boolean checkmate = m.checkmate(1);
		System.out.println(checkmate);
	}

}
