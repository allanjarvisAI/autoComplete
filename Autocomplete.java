import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;

public class Autocomplete {
    private Term[] terms; // defensive copy

    // Initializes the data structure from the given array of terms.
    public Autocomplete(Term[] terms) {
        if (terms == null) {
            throw new IllegalArgumentException("Argument array of terms should"
                                                       + " not be null.");
        }
        for (Term term : terms) {
            if (term == null) {
                throw new IllegalArgumentException("Term entries should "
                                                           + "not be null.");
            }
        }
        this.terms = Arrays.copyOf(terms, terms.length);
        Arrays.sort(this.terms);
    }

    // Returns all terms that start with the given prefix,
    // in descending order of weight.
    public Term[] allMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix should not be null.");
        }

        int firstIndex =
                BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0),
                                                Term.byPrefixOrder(prefix.length()));
        int lastIndex =
                BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0),
                                               Term.byPrefixOrder(prefix.length()));

        if (firstIndex == -1) { // No matching terms found
            return new Term[0];
        }

        Term[] matches = Arrays.copyOfRange(terms, firstIndex, lastIndex + 1);
        Arrays.sort(matches, Term.byReverseWeightOrder());
        return matches;
    }

    // Returns the number of terms that start with the given prefix.
    public int numberOfMatches(String prefix) {
        if (prefix == null) {
            throw new IllegalArgumentException("Prefix should not be null.");
        }

        int firstIndex =
                BinarySearchDeluxe.firstIndexOf(terms, new Term(prefix, 0),
                                                Term.byPrefixOrder(prefix.length()));
        int lastIndex =
                BinarySearchDeluxe.lastIndexOf(terms, new Term(prefix, 0),
                                               Term.byPrefixOrder(prefix.length()));

        if (firstIndex == -1) {
            return 0; // No matching terms found
        }

        return lastIndex - firstIndex + 1;
    }

    // unit testing (required)
    public static void main(String[] args) {

        // read in the terms from a file
        String filename = args[0];
        In in = new In(filename);
        int n = in.readInt();
        Term[] terms = new Term[n];
        for (int i = 0; i < n; i++) {
            long weight = in.readLong();           // read the next weight
            in.readChar();                         // scan past the tab
            String query = in.readLine();          // read the next query
            terms[i] = new Term(query, weight);    // construct the term
        }

        // read in queries from standard input and print the top k matching terms
        int k = Integer.parseInt(args[1]);
        Autocomplete autocomplete = new Autocomplete(terms);
        while (StdIn.hasNextLine()) {
            String prefix = StdIn.readLine();
            Term[] results = autocomplete.allMatches(prefix);
            StdOut.printf("%d matches\n", autocomplete.numberOfMatches(prefix));
            for (int i = 0; i < Math.min(k, results.length); i++)
                StdOut.println(results[i]);
        }
    }
}
