package company.lesson2;

public class MyArraySizeException extends RuntimeException{
    @Override
    public String toString() {
        return "MyArraySizeException: Incorrect array size.";
    }
}
