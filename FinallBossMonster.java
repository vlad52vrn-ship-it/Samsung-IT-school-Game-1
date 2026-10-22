import java.util.Scanner;
import java.util.Random;
import java.util.concurrent.*;

public class FinallBossMonster {
    private final int x;
    private final int y;
    private int health = 3;

    private final String[] qteCommands = {"УВЕРНИСЬ", "БЛОК", "АТАКА", "УДАР", "ЩИТ", "ПАРИРУЙ"};

    public FinallBossMonster (int castleX, int castleY) {
        this.x = castleX;
        this.y = castleY;
    }
    public int getX() { return x; }
    public int getY() { return y; }
    public boolean startBossFight(int difficultGame, Person person) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("\n=== 🔴 ФИНАЛЬНЫЙ БОСС: ВЕЛИКИЙ МАГ КРИСТАЛЛА ===");
        System.out.println("Босс замахивается для сокрушительных ударов!");
        System.out.println("Правила: Быстро вводите появляющиеся слова и нажимайте Enter, пока не вышло время!");

        // Время на ввод в секундах зависит от сложности:
        // Сложность 1 = 4.0 сек, Сложность 5 = 1.6 сек.
        double timeLimitSeconds = Math.max(5 , 7 - (difficultGame * 0.6));

        while (health > 0 && person.getLive() > 0) {
            System.out.println("\n--- Жизни босса: " + health + " | Ваши жизни: " + person.getLive() + " ---");
            System.out.printf("Приготовьтесь... Время на реакцию: %.1f сек.\n", timeLimitSeconds);

            // Небольшая пауза перед атакой для создания напряжения
            try { Thread.sleep(1500); } catch (InterruptedException ignored) {}

            // Выбираем случайное слово
            String targetWord = qteCommands[random.nextInt(qteCommands.length)];

            System.out.println("\n🔥 БОСС АТАКУЕТ! СКОРЕЕ ПИШИ:");
            System.out.println("👉 >>> " + targetWord + " <<< 👈");
            System.out.print("Ввод: ");

            // Запускаем асинхронное чтение ввода с тайм-аутом
            String playerInput = getInputWithTimeout(timeLimitSeconds);

            if (playerInput == null) {
                System.out.println("\n⏱️ ВРЕМЯ ВЫШЛО! Вы не успели среагировать!");
                System.out.println("⚡ Босс наносит вам сокрушительный удар! (-1 жизнь)");
                person.downLive();
            } else if (playerInput.trim().equalsIgnoreCase(targetWord)) {
                System.out.println("\n✨ ИДЕАЛЬНО! Вы вовремя среагировали и провели контратаку!");
                health--;
            } else {
                System.out.println("\n❌ ОШИБКА! Вы запаниковали и ввели: \"" + playerInput + "\"");
                System.out.println("⚡ Босс пробивает вашу защиту! (-1 жизнь)");
                person.downLive();
            }
        }

        return health <= 0;
    }

    /**
     * Метод для неблокирующего чтения консоли с ограничением по времени
     */
    private String getInputWithTimeout(double seconds) {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        // Обертка для чтения строки из консоли
        Callable<String> readTask = () -> {
            Scanner in = new Scanner(System.in);
            if (in.hasNextLine()) {
                return in.nextLine();
            }
            return "";
        };

        Future<String> future = executor.submit(readTask);
        try {
            // Переводим секунды в миллисекунды для точного замера
            long milliseconds = (long) (seconds * 1000);
            return future.get(milliseconds, TimeUnit.MILLISECONDS);
        } catch (TimeoutException e) {
            // Время вышло, отменяем задачу чтения
            future.cancel(true);
            return null;
        } catch (Exception e) {
            return null;
        } finally {
            executor.shutdownNow(); // Обязательно закрываем поток
        }
    }
}
