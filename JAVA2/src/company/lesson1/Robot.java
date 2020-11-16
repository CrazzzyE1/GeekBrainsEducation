package company.lesson1;

public class Robot implements Participant {
    private int length;
    private int height;
    private boolean fullCourse = true;

    public Robot(int length, int height) {

        this.length = length;
        this.height = height;
    }

    @Override
    public boolean isFullCourse() {
        return fullCourse;
    }


    @Override
    public void setFullCourse() {
        this.fullCourse = false;
    }

    @Override
    public boolean run(int length) {
        if (length < this.length) {
            System.out.println("Robot Run " + length);
        } else {
            System.out.println("Robot NOT Run " + length);
        }
        return length < this.length;
    }

    @Override
    public boolean jump(int height) {
        if (height < this.height) {
            System.out.println("Robot Jump " + height);
        } else {
            System.out.println("Robot NOT Jump " + height);
        }
        return height < this.height;
    }

    @Override
    public String toString() {
        return "Robot{" +
                "length=" + length +
                ", height=" + height +
                '}';
    }
}
