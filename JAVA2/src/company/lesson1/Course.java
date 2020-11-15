package company.lesson1;

public class Course {

    private Courses[] courses;
    public Course(Courses[] courses) {
        this.courses = courses;
    }

    public void doIt(Team team) {
        System.out.println("TEAM DO IT");
        Participant[] pr;
        pr = team.getParticipants();
        for (int i = 0; i < pr.length; i++) {
            for (int j = 0; j < courses.length; j++) {
                if (!courses[j].doIt(pr[i])) {
                    pr[i].setFullCourse();
                    break;
                }
            }
            System.out.println();
        }
    }

    public void showResult(Team team) {
        Participant[] pr;
        pr = team.getParticipants();
        System.out.println("Result of Course:");
        for (int i = 0; i < pr.length; i++) {
            if (pr[i].isFullCourse()) System.out.println(pr[i]);
        }
        System.out.println();
    }

    public void courseInfo() {
        for (int i = 0; i < courses.length; i++) {
            System.out.println(courses[i]);
        }
        System.out.println();
    }
}


