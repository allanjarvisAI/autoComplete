Programming Assignment 3: Autocomplete


/* *****************************************************************************
 *  Describe how your firstIndexOf() method in BinarySearchDeluxe.java
 *  finds the first index of a key that is equal to the search key.
 **************************************************************************** */

 It initializes two pointers(lo and hi) to define the search range. Initially,
 lo is set to 0 and hi is set to the last index of the array. The method enters
 a loop where it continues to search for the key until lo becomes greater than
 hi. In each iteration of the loop, the method calculates the midpoint
 index(mid) of the current search range using the formula (lo + hi >>> 1). It
 then compares the search key with the key at the midpoint index using the
 provided comparator. If the search key is less than the key at a[mid], it
 updates hi to mid - 1, narrowing the search range to the lower half. If the
 search key is greater than the key at a[mid], it updates lo to mid + 1,
 narrowing the search range to the upper half. When the search key is equal to
 the key at a[mid], instead of immediately returning mid, the method updates hi
 to mid - 1. This step ensures that the method continues to search for the
 first occurrence of the key in the lower half of the search range in case
 there are duplicates. The method continues this process until the search range
 becomes invalid, at which point it returns the index of the first occurrence
 of the key (stored in the variable called “result”). If no occurrence of the
 key is found, the method returns -1.



/* *****************************************************************************
 *  Identify which sorting algorithm (if any) that your program uses in the
 *  Autocomplete constructor and instance methods. Choose from the following
 *  options:
 *
 *    none, selection sort, insertion sort, mergesort, quicksort, heapsort
 *
 *  If you are using an optimized implementation, such as Arrays.sort(),
 *  select the principal algorithm.
 **************************************************************************** */

Autocomplete() : mergesort.

allMatches() : mergesort.

numberOfMatches() : mergesort.

/* *****************************************************************************
 *  How many compares (in the worst case) does each of the operations in the
 *  Autocomplete data type make, as a function of both the number of terms n
 *  and the number of matching terms m? Use Big Theta notation to simplify
 *  your answers.
 *
 *  Recall that with Big Theta notation, you should discard both the
 *  leading coefficients and lower-order terms, e.g., Theta(m^2 + m log n).
 **************************************************************************** */

Autocomplete():     Theta(n log n)

allMatches():       Theta(log n + m log m)

numberOfMatches():  Theta(log n)




/* *****************************************************************************
 *  Known bugs / limitations.
 **************************************************************************** */

N/A


/* *****************************************************************************
 *  Describe any serious problems you encountered.
 **************************************************************************** */

Trying to switch from Substring function to CharAt in the implementation of
ByPrefixOrder. But we eventually figured it out after goingbto lab TA.



/* *****************************************************************************
 *  List any other comments here. Feel free to provide any feedback
 *  on how much you learned from doing the assignment, and whether
 *  you enjoyed doing it.
 **************************************************************************** */

Another great assignment that really engaged us throughout, mergesorts are
awesome!!
