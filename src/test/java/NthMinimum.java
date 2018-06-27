
import java.util.ArrayList;
import java.util.Collections;

public class NthMinimum {

    public static void main(String[] args) {

        int FindNThSmallest = 6;

        ArrayList<Integer> randomList = new ArrayList<Integer>();
        ArrayList<Integer> SortedList = new ArrayList<Integer>();
        randomList = generateRandomNumbers(2000, 500);
        System.out.println("Random values:");
        for (int i = 0; i < randomList.size(); i++) {
            System.out.println(randomList.get(i));
        }
        SortedList = sortingArrayList(randomList);
        System.out.println(FindNThSmallest + "th smallest number = " + SortedList.get(FindNThSmallest - 1));
    }

    /**
     * To generate random numbers
     *
     * @param maxValue
     * @param totalNumbers
     * @return
     */
    public static ArrayList<Integer> generateRandomNumbers(int maxValue, int totalNumbers) {
        ArrayList<Integer> originaLlist = new ArrayList<Integer>();
        ArrayList<Integer> randomList = new ArrayList<Integer>();
        if (totalNumbers <= maxValue) {
            for (int i = 0; i < maxValue; i++) {
                originaLlist.add(new Integer(i));
            }
            Collections.shuffle(originaLlist);
            for (int i = 0; i < totalNumbers; i++) {
                randomList.add(originaLlist.get(i));
            }
        } else {
            System.out.println("Generated TotalNumbers should not be greater than MaxValue");
        }
        return randomList;
    }


    /**
     * To sort list of values
     *
     * @param listValues
     * @return
     */
    public static ArrayList<Integer> sortingArrayList(ArrayList<Integer> listValues) {

        for (int i = 0; i < listValues.size() - 1; i++) {
            int index = i;
            for (int j = i + 1; j < listValues.size(); j++)
                if (listValues.get(j) < listValues.get(index))
                    index = j;

            int smallerNumber = listValues.get(index);
            listValues.set(index, listValues.get(i));
            listValues.set(i, smallerNumber);
        }
        return listValues;
    }
}
