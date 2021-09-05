package HomeWorkTwo;

public class Array
{
    public static void main(String[] args) throws MyArraySizeException {
        String[][] arrays = {{"1", "2", "0", "1"}, {"0", "1", "1", "0"}};
        arraySize(arrays);

    }

    public static void arraySize(String array[][]) throws MyArraySizeException
    {
        int sum = 0;
        if (array.length != 4 && array[0].length != 4)
        {
            throw new MyArraySizeException("Введенный массив не 4х4");
        }
        for(int rows = 0; rows < array.length; rows++)
        {
            for(int columns = 0; columns < array[rows].length; columns++)
            {
                try
                {
                    sum = Integer.parseInt(array[rows][columns].trim());
                    sum++;
                }
                catch (NumberFormatException e)
                {
                    System.out.println(e.getMessage() + array[rows][columns]);
                }
            }
        }
        System.out.println(sum);
    }
}
