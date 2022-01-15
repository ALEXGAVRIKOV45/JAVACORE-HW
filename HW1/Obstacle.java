package HW1;
import java.util.Random;

public class Obstacle {
    protected String name;
    protected int difficulty;


    public Obstacle(String name) {
        Random random;
        random = new Random();
        this.name = name;
        this.difficulty = random.nextInt(15);
    }




        @Override
        public String toString () {
        return name + " " + difficulty;
    }


    public int getDifficulty() {
        return difficulty;
    }
}
