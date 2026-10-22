import java.util.Random;
import java.util.Scanner;

public class BigMonster extends Monster {
    BigMonster (int sizeBoard) {
        super(sizeBoard);
        setImage("\uD83D\uDC79");
    }
    @Override
    public boolean taskMonster(int difficultGame) {
        if (difficultGame == 1) {
            return taskMonster();
        }

        System.out.println("Решите задачу:");

        Random random = new Random();
        int a = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
        int b = random.nextInt(50 * (difficultGame - 1), 50 * difficultGame);
        int c = random.nextInt(10 * (difficultGame - 1), 10 * difficultGame);
        int trueAnswer = a * c - b;

        System.out.println("Реши пример: " + a + "*" + c + "-" + b + " =?");
        Scanner scanner = new Scanner(System.in);
        int answer = scanner.nextInt();

        if (answer == trueAnswer) {
            System.out.println("Верно! Ты победил монстра!");
            return true;
        } else {
            System.out.println("Ты проиграл эту битву!");
            return false;

        }

    }
    public boolean taskMonster() {
        return super.taskMonster(1);
    }
}