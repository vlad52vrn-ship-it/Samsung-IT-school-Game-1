import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;


public class Monster {
    private final int x, y;
    private String image = "\uD83E\uDDDF";

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

    public boolean makeDecision(int answer, int trueAnswer, long maxAnswerTime, long currentAnswerTime){
        if (currentAnswerTime > maxAnswerTime) {
            System.out.println("Время вышло! Ты потратил много времени: " + currentAnswerTime/1000 + " сек. Ты проиграл эту битву!");
            return false;
        }

        if (trueAnswer == answer) {
            System.out.println("Верно! Ты потратил на ответ всего: " + currentAnswerTime/1000 + " сек. Ты победил монстра!");
            return true;
        } else {
            System.out.println("Ответ неверный. Ты проиграл эту битву!");
            return false;
        }
    }

    public boolean taskMonster(int difficultGame) {
        System.out.println("Решите задачу:");
        int a, b, c, trueAnswer, answer;
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        long startTime, endTime, diffTime;
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

                System.out.println("Реши пример: " + a + " - " + b + " = ?");
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

                System.out.println("Реши пример: " + a + " * " + b + " + " + a + " / " + b + " = ?");
                System.out.println("У ТЕБЯ НА ОТВЕТ 20 СЕКУНД !!!");
                startTime = System.currentTimeMillis();
                answer = scanner.nextInt();

                return makeDecision(answer, trueAnswer, 20999, System.currentTimeMillis() - startTime);

            case 4:
                a = random.nextInt(30);
                b = random.nextInt(30);
                trueAnswer = a*a + b*b;

                System.out.println("Реши пример: " + a + "^2" + " + " + b + "^2" + " = ?");
                System.out.println("У ТЕБЯ НА ОТВЕТ 20 СЕКУНД !!!");
                startTime = System.currentTimeMillis();
                answer = scanner.nextInt();

                return makeDecision(answer, trueAnswer, 20999, System.currentTimeMillis() - startTime);

            case 5:
                a = random.nextInt(100);
                b = random.nextInt(100);
                c = random.nextInt(100);
                if (a + b > c && a + c > b && b + c > a) {
                    trueAnswer = 1;
                } else {
                    trueAnswer = 0;
                }

                System.out.println("Существует ли треугольник со сторонами: " + a + " " + b + " " + c +" - ?, введите 1 если да, 0 если нет");
                System.out.println("У ТЕБЯ НА ОТВЕТ 20 СЕКУНД !!!");

                startTime = System.currentTimeMillis();
                answer = scanner.nextInt();

                return makeDecision(answer, trueAnswer, 20999, System.currentTimeMillis() - startTime);
        }
        return false;
    }
}