package company.lesson1;

public class Team {
    private String name;
    Participant[] participants;

    public Participant[] getParticipants() {
        return participants;
    }

    public Team(String name, Participant[] participants) {
        this.name = name;
        this.participants = participants;
    }

    public void teamInfo() {
        System.out.println("Team: " + name);
        for (int i = 0; i < participants.length; i++) {
            System.out.println(participants[i]);
        }
        System.out.println();
    }

    public void whoCompletedTheDistance() {
        System.out.println("Who completed the distance:");
        for (int i = 0; i < participants.length; i++) {
            if(participants[i].isFullCourse())
            System.out.println(participants[i]);
        }
        System.out.println();
    }
}
