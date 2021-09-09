package homeWorkThree;

import java.util.Arrays;

public class SwapPlaces
{
    private int[] arr;

    public SwapPlaces(int[] arr) {
        this.arr = arr;
    }

    @Override
    public String toString(){
        return "SwapPlaces{" +
                "array=" + Arrays.toString(arr) +
                '}';
    }

    public static void swapPlaces(int[] arr)
    {
        int buffer = arr[0];
        arr[0] = arr[arr.length - 1];
        arr[1] = buffer;
    }

    public static void main(String[] args)
    {
        int[] arr = {1, 2};
        System.out.println(Arrays.toString(arr));
        swapPlaces(arr);
        System.out.println(Arrays.toString(arr));
    }


}
