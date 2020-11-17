package company.lesson2;

public class Test {
    public static void main(String[] args) {

        String[][] myArray = new String[4][4];
//        String[][] myArray = new String[5][4];
//        String[][] myArray = new String[4][3];
        for (int i = 0; i < myArray.length; i++) {
            for (int j = 0; j < myArray[i].length; j++) {
                myArray[i][j] = String.valueOf(i + j);
            }
        }

//        myArray[2][2] = "Hello";

        try {
            System.out.println("Sum is " + checkArray(myArray));
        } catch (MyArraySizeException | MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    public static int checkArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) throw new MyArraySizeException();

        int sumResult = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sumResult += Integer.parseInt(array[i][j]);
                } catch (Exception e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }
        return sumResult;
    }
}
