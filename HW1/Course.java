package HW1;

public class Course {
    protected String name;
    protected Obstacle[] obstacles;

    public Course(String name, Obstacle... obstacles) {
        this.name = name;
        this.obstacles = obstacles;
    }

    public void printCourse() {
        int n = 1;
        System.out.println("Course name:" + name);

        for (int i = 0; i < obstacles.length; i++) {
            System.out.println(n + " " + obstacles[i]);
            n++;
        }
    }

    public void passTheCourse(Team team) {
        int succes = 0;
        for (int i=0; i < team.members.length; i++){
            succes = 0;
         for (int y=0; y < obstacles.length; y++) {
             if (team.members[i].getPower() > obstacles[y].difficulty){
                 succes++;
             }
            else{
                 team.members[i].setFinished(false);
                continue;
             }


         }
            if (succes == obstacles.length) {team.members[i].setFinished(true);}

        }


    }
}