package HW1;

import HW1.Course;
import HW1.MemberTeam;
import HW1.Obstacle;
import HW1.Team;

/**
 *  Java Core. Homework #1
 *
 *  @ author Alex Gavrikov
 *  @ version 15/01/2022
 *
 */

class HWGAL1 {
public static void main(String[]args) {

    //Создаем препятствия
    Obstacle ob1 = new Obstacle("Log");
    Obstacle ob2 = new Obstacle("Stairs");
    Obstacle ob3 = new Obstacle("Moat");
    // Создаем массив препятствий
    Obstacle[] obstacles = {ob1,ob2,ob3};
    // Создаем полосу препятствий
    Course course = new Course("Road of the brave",obstacles);

    //Приглашаем участников
    MemberTeam men1 = new MemberTeam("Vova", 5);
    MemberTeam men2 = new MemberTeam("Alex", 10);
    MemberTeam men3 = new MemberTeam("Serg", 8);
    MemberTeam men4 = new MemberTeam("Ivan", 6);
    // Создаем массив спортсменов
    MemberTeam[] Members = {men1,men2,men3,men4};
    // Создаем команду
    Team team = new Team("Veterok", Members);

    //Посмотрим полосу препятсвий и команду
    course.printCourse();
    team.printTeam();
    //Просим команду пройти полосу
    course.passTheCourse(team);
    //Печатаем результаты
    team.printTeamResults();


}
}

