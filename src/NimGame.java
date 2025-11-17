import java.util.Arrays;
import java.util.Scanner;

public class NimGame {
    
    // Проверяет, является ли позиция выигрышной для игрока
    public static boolean isWinningPosition(int[] piles) {
        int nimSum = calculateNimSum(piles);
        return nimSum != 0;
    }
    
    // Вычисляет XOR-сумму всех размеров кучек
    public static int calculateNimSum(int[] piles) {
        int result = 0;
        for (int pile : piles) {
            result ^= pile;
        }
        return result;
    }
    
    // Находит выигрышный ход для текущей позиции
    public static int[] findWinningMove(int[] piles) {
        int nimSum = calculateNimSum(piles);
        if (nimSum == 0) {
            return null;
        }
        for (int i = 0; i < piles.length; i++) {
            int targetSize = piles[i] ^ nimSum;
            if (targetSize < piles[i]) {
                return new int[]{i, targetSize};
            }
        }
        return null;
    }
    
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Читаем входные данные
        String input = scanner.nextLine();
        
        // Разбиваем строку на числа
        String[] parts = input.split(" ");
        int[] piles = new int[parts.length];
        
        for (int i = 0; i < parts.length; i++) {
            piles[i] = Integer.parseInt(parts[i]);
        }
        
        // Вычисляем результаты
        int nimSum = calculateNimSum(piles);
        boolean isWinning = isWinningPosition(piles);
        int[] move = findWinningMove(piles);
        
        // Выводим результаты в формате для тестовой системы
        System.out.println(nimSum);
        System.out.println(isWinning);
        if (move != null) {
            System.out.println(move[0] + " " + move[1]);
        } else {
            System.out.println("no move");
        }
        
        scanner.close();
    }
}
