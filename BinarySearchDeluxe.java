import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {

    // Returns the index of the first key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int firstIndexOf(Key[] a, Key key,
                                         Comparator<Key> comparator) {
        if ((a == null || key == null) || comparator == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }
        int lo = 0;
        int hi = a.length - 1;
        int result = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int compare = comparator.compare(key, a[mid]);
            if (compare < 0) hi = mid - 1;
            else if (compare > 0) lo = mid + 1;
            else {
                hi = mid - 1;
                result = mid;
            }
        }
        return result;
    }

    // Returns the index of the last key in the sorted array a[]
    // that is equal to the search key, or -1 if no such key.
    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        if ((a == null || key == null) || comparator == null) {
            throw new IllegalArgumentException("Argument should not be null");
        }
        int lo = 0;
        int hi = a.length - 1;
        int result = -1;
        while (lo <= hi) {
            int mid = (lo + hi) >>> 1;
            int compare = comparator.compare(key, a[mid]);
            if (compare < 0) hi = mid - 1;
            else if (compare > 0) lo = mid + 1;
            else {
                lo = mid + 1;
                result = mid;
            }
        }
        return result;
    }

    // unit testing (required)
    public static void main(String[] args) {
        String[] carModels = {
                "Toyota Camry", "Honda Accord", "Toyota Corolla",
                "Ford Mustang", "Honda Civic", "Toyota Corolla"
        };
        Arrays.sort(carModels);

        // Test firstIndexOf method
        String key;
        key = "Toyota Corolla";
        int firstIndex = firstIndexOf(carModels, key, String::compareTo);
        if (firstIndex != -1) {
            StdOut.println("First occurrence of '" + key + "' is at index: "
                                   + firstIndex);
        }
        else {
            StdOut.println("'" + key + "' not found.");
        }

        // Test lastIndexOf method
        key = "Toyota Corolla";
        int lastIndex = lastIndexOf(carModels, key, String::compareTo);
        if (lastIndex != -1) {
            StdOut.println("Last occurrence of '" + key + "' is at index: "
                                   + lastIndex);
        }
        else {
            StdOut.println("'" + key + "' not found.");
        }
    }

}
