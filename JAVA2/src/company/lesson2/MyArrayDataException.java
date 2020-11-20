package company.lesson2;

public class MyArrayDataException extends RuntimeException {
    private int i;
    private int j;

    public MyArrayDataException(int i, int j) {
        this.i = i;
        this.j = j;
    }

    @Override
    public String toString() {
        return "MyArrayDATAException: Incorrect array DATA. CELL[" + i + "][" + j + "]";
    }
}
