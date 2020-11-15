package company.lesson1;

public class Human implements Participant {
    private int length;
    private int height;
    private boolean fullCourse = true;

    public Human(int length, int height) {
        this.length = length;
        this.height = height;
    }

    @Override
    public boolean isFullCourse() {
        return fullCourse;
    }

    @Override
    public boolean run(int length) {
        if (length < this.length) {
            System.out.println("Human Run " + length);
        } else {
            System.out.println("Human NOT Run " + length);
        }
        return length < this.length;
    }

    @Override
    public void setFullCourse() {
        this.fullCourse = false;
    }

    @Override
    public boolean jump(int height) {
        if (height < this.height) {
            System.out.println("Human Jump " + height);
        } else {
            System.out.println("Human NOT Jump " + height);
        }
        return height < this.height;
    }

    @Override
    public String toString() {
        return "Human{" +
                "length=" + length +
                ", height=" + height +
                '}';
    }
}
