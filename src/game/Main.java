package game;

import java.util.List;
import java.util.Scanner;

import game.movement.Flying;
import game.movement.HorseRiding;
import game.movement.MovementStrategy;
import game.movement.Walking;


public class Main {
    // Неизменяемый лист точек
    private static final List<Point> MAP = List.of(
        new Point("Дом"),
        new Point("Лес")
    );

    // Неизменяемый лист обьектов передвижений
    private static final List<MovementStrategy> STRATEGIES = List.of(
        new Walking(),
        new Flying(),
        new HorseRiding()
    );

    // Вход программы
    public static void main(String[] args) {
        Hero hero = new Hero("Void", MAP.get(0), new Walking());
        Scanner scanner = new Scanner(System.in);

        System.out.println("Игра запущена");
        while(true) {
            System.out.println(hero.getName() + " сейчас в точке " + hero.getPosition() + " , способом - " + hero.getMovement().title());

            Integer pointIndex = ask(scanner, "В какую точку двигаемся?", MAP.stream().map(Point::getName).toList());
            if (pointIndex == null) {
                break;
            }
            hero.move(MAP.get(pointIndex));

            Integer strategyIndex = ask(scanner, "Выберите способ перемещения", STRATEGIES.stream().map(MovementStrategy::title).toList());
            if (strategyIndex == null) {
                break;
            }
            hero.setMovement(STRATEGIES.get(strategyIndex));
        }

        System.out.println("Игра окончена");
        scanner.close();
    }

    private static Integer ask(Scanner scanner, String question, List<String> options) {
        while (true) {
            System.out.println(question);
            for(int i = 0; i < options.size(); i++) {
                System.out.println("  " + (i + 1) + ") " + options.get(i));
            }
            System.out.print("> ");

            String input = scanner.nextLine().trim();
            try {
                int choice = Integer.parseInt(input);
                if (choice == 0) {
                    return null;
                }
                if (choice >= 1 && choice <= options.size()) {
                    return choice - 1;
                }
            } catch (NumberFormatException ignored) {

            }
            System.out.println("Введите число от 0 до " + options.size());
        }
    }
}
