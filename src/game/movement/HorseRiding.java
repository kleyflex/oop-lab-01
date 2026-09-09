package game.movement;
import game.Point;

public class HorseRiding implements MovementStrategy{
    @Override 
    public String title(){
        return "Езда на лошади";
    }

    @Override 
    public void move(String heroName, Point from, Point to) {
        System.out.println(heroName + "скачет на лошади из точки " + from + " в точку " + to);
    }
}
