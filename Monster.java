import java.util.Random;
import java.util.Scanner;

public class Monster {
    private final int x, y;
    private String image = "";

    Monster (int sizeBoard) {
        Random random = new Random();
        x = 1 + random.nextInt(sizeBoard);
        y = 1 + random.nextInt(sizeBoard);
    }
    Monster (int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }
    public int getY() {
        return y;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public boolean conflictPerson(int personX, int personY) {
        return personX == x && personY == y;
    }
    public boolean taskMonster(int difficultGame) {
        System.out.println("Решите задачу:");
        int a, b, trueAnswer, answer;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        switch (difficultGame) {
            case 1:
                a = random.nextInt(300);
                b = random.nextInt(300);
                trueAnswer = a + b;

                System.out.println("Реши пример: " + a + " + " + b + " = ?");
                answer = scanner.nextInt();

                if (trueAnswer == answer) {
                    System.out.println("Верно! Ты победил монстра");
                    return true;
                } else {
                    System.out.println("Ты проиграл эту битву!");
                    return false;
                }
            case 2:
                a = random.nextInt(400);
                b = random.nextInt(400);
                trueAnswer = a - b;

                System.out.println("Реши пример: " + a + " + " + b + " = ?");
                answer = scanner.nextInt();

                if (trueAnswer == answer) {
                    System.out.println("Верно! Ты победил монстра");
                    return true;
                } else {
                    System.out.println("Ты проиграл эту битву!");
                    return false;
                }
            case 3:
                a = random.nextInt(50);
                b = random.nextInt(50);
                trueAnswer = a * b + a / b;

                System.out.println("Реши пример: " + a + " + " + b + " = ?");
                answer = scanner.nextInt();

                if (trueAnswer == answer) {
                    System.out.println("Верно! Ты победил монстра");
                    return true;
                } else {
                    System.out.println("Ты проиграл эту битву!");
                    return false;
                }
            case 4:
                a = random.nextInt(30);
                b = random.nextInt(30);
                trueAnswer = a*a + b*b;

                System.out.println("Реши пример: " + a + " + " + b + " = ?");
                answer = scanner.nextInt();

                if (trueAnswer == answer) {
                    System.out.println("Верно! Ты победил монстра");
                    return true;
                } else {
                    System.out.println("Ты проиграл эту битву!");
                    return false;
                }
            case 5:
                a = random.nextInt(10);
                b = random.nextInt(10);
                trueAnswer = a*a*a + b*b*b;

                System.out.println("Реши пример: " + a + " + " + b + " = ?");
                answer = scanner.nextInt();

                if (trueAnswer == answer) {
                    System.out.println("Верно! Ты победил монстра");
                    return true;
                } else {
                    System.out.println("Ты проиграл эту битву!");
                    return false;
                }
        }
        return false;
    }
}