package company.lesson1;

public class Test1 {
    public static void main(String[] args) {
        Participant[] participants = new Participant[4];
        participants[0] = new Cat(150, 15);
        participants[1] = new Human(250, 20);
        participants[2] = new Robot(350, 35);
        participants[3] = new Cat(450, 50);

        Courses[] courses = new Courses[4];
        courses[0] = new Wall(25);
        courses[1] = new Wall(35);
        courses[2] = new Treadmill(100);
        courses[3] = new Treadmill(200);

        Team team = new Team("SuperTeam", participants);
        Course c = new Course(courses);
        team.teamInfo();
        c.courseInfo();
        c.doIt(team);

        c.showResult(team);

        team.whoCompletedTheDistance();

    }
}
