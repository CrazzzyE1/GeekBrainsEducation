package company.lesson2;

public class MyArraySizeException extends Exception{
    @Override
    public String toString() {
        return "MyArraySizeException: Incorrect array size.";
    }
}
