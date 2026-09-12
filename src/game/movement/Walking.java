package game.movement;
import game.Point;

public class Walking implements MovementStrategy {
    @Override 
    public String title() {
        return "Пешком";
    }

    @Override 
    public void move(String heroName, Point from, Point to) {
        System.out.println(heroName + " идёт пешком из точки " + from + " в точку " + to);
    }
}
