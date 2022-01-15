package HW1;


public class MemberTeam {
    protected String name;
    protected int power;
    protected boolean finished = false;

public MemberTeam(String name, int power){
this.name = name;
this.power = power;

}

    @ Override
    public String toString() {
        return name+" "+power+" "+ finished;
    }

    public int getPower() {
        return power;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public boolean isFinished() {
        return finished;
    }
}
