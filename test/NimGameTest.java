import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class NimGameTest {
    
    @Test
    void testCalculateNimSum() {
        assertEquals(0, NimGame.calculateNimSum(new int[]{0, 0, 0}));
        assertEquals(2, NimGame.calculateNimSum(new int[]{3, 4, 5}));
        assertEquals(1, NimGame.calculateNimSum(new int[]{1, 2, 2}));
    }
    
    @Test
    void testIsWinningPosition() {
        assertTrue(NimGame.isWinningPosition(new int[]{3, 4, 5}));  // 3^4^5=2 ≠0
        assertFalse(NimGame.isWinningPosition(new int[]{1, 2, 3})); // 1^2^3=0
        assertTrue(NimGame.isWinningPosition(new int[]{5}));        // 5 ≠0
        assertFalse(NimGame.isWinningPosition(new int[]{0}));       // 0 =0
    }
    
    @Test
    void testFindWinningMove() {
        // Для (3,4,5) должен найти ход: 3→1
        int[] move = NimGame.findWinningMove(new int[]{3, 4, 5});
        assertNotNull(move);
        assertEquals(0, move[0]); // Индекс кучки 3
        assertEquals(1, move[1]); // Новый размер 1
        
        // Для проигрышной позиции хода нет
        assertNull(NimGame.findWinningMove(new int[]{1, 2, 3}));
    }
    
    @Test
    void testMakeMove() {
        int[] piles = {3, 4, 5};
        int[] newPiles = NimGame.makeMove(piles, 0, 1);
        assertArrayEquals(new int[]{1, 4, 5}, newPiles);
        
        // Проверка исключений
        assertThrows(IllegalArgumentException.class, 
            () -> NimGame.makeMove(piles, 5, 1)); // Неверный индекс
        assertThrows(IllegalArgumentException.class, 
            () -> NimGame.makeMove(piles, 0, 5)); // Новый размер больше текущего
    }
}
