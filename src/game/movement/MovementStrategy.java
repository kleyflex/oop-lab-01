package game.movement;
import game.Point;

public interface MovementStrategy {
    String title();

    void move(String heroName, Point from, Point to);
}
