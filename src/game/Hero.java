package game;
import game.movement.MovementStrategy;

public class Hero {
    private final String name;

    private Point position;

    private MovementStrategy movement;

    public Hero(String name, Point start, MovementStrategy movement) {
        this.name = name;
        this.position = start;

        setMovement(movement);
    }

    public void setMovement(MovementStrategy movement) {
        if(movement == null) {
            throw new IllegalArgumentException("Способ перемещения не задан");
        }

        this.movement = movement;
    }

    public MovementStrategy getMovement() {
        return movement;
    }

    public void move(Point destination) {
        movement.move(name, position, destination);
        this.position = destination;
    }

    public String getName() {
        return name;
    }

    public Point getPosition() {
        return position;
    }
}
