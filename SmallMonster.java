import java.util.Random;
import java.util.Scanner;

public class SmallMonster extends BigMonster{
    SmallMonster (int sizeBoard) {
        super(sizeBoard);
        setImage("\uD83D\uDEBE");
    }
    @Override
    public boolean taskMonster(int difficultGame) {
        if (difficultGame == 1) {
            return taskMonster();
        } else {
            System.out.println("Решите задачу:");

            Random random = new Random();
            int a = random.nextInt(50);
            int b = random.nextInt(40);
            int c = random.nextInt(50);
            int trueAnswer = a + c - b;

            System.out.println("Реши пример: " + a + " + " + c + " - " + b + " =?");
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
    }
    public boolean taskMonster() {
        return super.taskMonster(1);
    }
}