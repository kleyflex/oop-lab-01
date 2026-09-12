package game.movement;
import game.Point;

public class Flying implements MovementStrategy {
    @Override 
    public String title() {
        return "Летит";
    }

    @Override 
    public void move(String heroName, Point from, Point to) {
        System.out.println(heroName + " летит из точки " + from + " в точку " + to);
    }
}
