package HW1;

public class Team {
    protected String name;
    protected MemberTeam[] members;


public Team(String name, MemberTeam... members){
    this.name=name;
    this.members = members;
}

public void printTeam() {
    int n = 1;
    System.out.println("Team name:" + name);

    for (int i = 0; i < members.length; i++) {
        System.out.println(n + " " + members[i]);
        n++;
    }
}
public void printTeamResults(){
        int n=1;
        System.out.println("Members who finished ! :");

        for (int i=0; i < members.length; i++){

            if (members[i].finished) {
            System.out.println(n + " " + members[i]);
            n++;
            }

        }
if (n==1) {
    System.out.println("Unfortunately no one survived !");
}
}

}
