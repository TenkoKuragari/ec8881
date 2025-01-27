package sort;

import tripods.Tripod;

import java.util.ArrayList;

/**
 * Perform an "out of place" quick sort on an array list of Tripod's by
 * ascending tripod sum.
 * <pre>
 * quick_sort (not in place):
 * best=O(nlogn)
 * worst=O(n^2)
 * </pre>
 *
 * @author RIT CS
 * @author YOUR NAME HERE
 */
public class QuickSort {
    /**
     * Partition the array for values less than the pivot.
     *
     * @param data  the full array of data
     * @param pivot the pivot
     * @return data less than the pivot
     */
    public static ArrayList<Tripod> partitionLess(ArrayList<Tripod> data, Tripod pivot) {
        ArrayList<Tripod> less = new ArrayList<>();
        for (Tripod n : data) {
            if (n.sum() < pivot.sum()) {
                less.add(n);
            }
        }
        return less;
    }

    /**
     * Partition the array for values equal to the pivot.
     *
     * @param data  the full array of data
     * @param pivot the pivot
     * @return data equal to the pivot
     */
    public static ArrayList<Tripod> partitionEqual(ArrayList<Tripod> data, Tripod pivot) {
        ArrayList<Tripod> equal = new ArrayList<>();
        for (Tripod n : data) {
            if (n.sum() == pivot.sum()) {
                equal.add(n);
            }
        }
        return equal;
    }

    /**
     * Partition the array for values greater than the pivot.
     *
     * @param data  the full array of data
     * @param pivot the pivot
     * @return data greater than  the pivot
     */
    public static ArrayList<Tripod> partitionGreater(ArrayList<Tripod> data, Tripod pivot) {
        ArrayList<Tripod> greater= new ArrayList<>();
        for (Tripod n : data) {
            if (n.sum() > pivot.sum()) {
                greater.add(n);
            }
        }
        return greater;
    }

    /**
     * Performs a quick sort and returns a newly sorted array.
     *
     * @param data the data to be sorted
     * @return a sorted array
     */
    public static ArrayList<Tripod> quickSort(ArrayList<Tripod> data) {
        ArrayList<Tripod> everything = new ArrayList<>();
        if (data.size() == 0) {
            return new ArrayList<>();
        }
        everything.addAll(quickSort(partitionLess(data, data.get(0))));
        everything.addAll(partitionEqual(data, data.get(0)));
        everything.addAll(quickSort(partitionGreater(data, data.get(0))));
        return everything;
    }
}
