package company.lesson1;

public class Cat implements Participant {
    private int length;
    private int height;
    private boolean fullCourse = true;

    public Cat(int length, int height) {
        this.length = length;
        this.height = height;
    }



    @Override
    public void setFullCourse() {
        this.fullCourse = false;
    }

    @Override
    public boolean isFullCourse() {
        return fullCourse;
    }

    @Override
    public boolean run(int length) {
        if (length < this.length) {
            System.out.println("Cat Run " + length);
        } else {
            System.out.println("Cat NOT Run " + length);
        }
        return length < this.length;
    }

    @Override
    public boolean jump(int height) {
        if (height < this.height) {
            System.out.println("Cat Jump " + height);
        } else {
            System.out.println("Cat NOT Jump " + height);
        }
        return height < this.height;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "length=" + length +
                ", height=" + height +
                '}';
    }
}
