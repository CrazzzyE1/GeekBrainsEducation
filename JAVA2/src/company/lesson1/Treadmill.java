package company.lesson1;

public class Treadmill implements Courses {
    private int length;

    public Treadmill(int length) {
        this.length = length;
    }

    @Override
    public boolean doIt(Participant participant) {
        return participant.run(length);
    }

    @Override
    public String toString() {
        return "Treadmill{" +
                "length=" + length +
                '}';
    }
}
