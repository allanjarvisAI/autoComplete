import java.util.Comparator;

public class Term implements Comparable<Term> {
    private String query; // query
    private long weight; // weight

    // Initializes a term with the given query string and weight.
    public Term(String query, long weight) {
        if (query == null) throw new IllegalArgumentException("query should not "
                                                                      + "be null");
        if (weight < 0) throw new IllegalArgumentException("weight should not"
                                                                   + " be negative");
        this.query = query;
        this.weight = weight;
    }

    // Create ByReverseWeightOrder class
    private static class ByReverseWeightOrder implements Comparator<Term> {
        public int compare(Term term1, Term term2) {
            return Long.compare(term2.weight, term1.weight);
        }
    }

    // Compares the two terms in descending order by weight.
    public static Comparator<Term> byReverseWeightOrder() {
        return new ByReverseWeightOrder();
    }

    // Create ByPrefixOrder class
    private static class ByPrefixOrder implements Comparator<Term> {
        private int r; // first r characters of each query(cutoff).

        // Constructor for this class
        public ByPrefixOrder(int r) {
            if (r < 0) {
                throw new IllegalArgumentException("r should not be negative");
            }
            this.r = r;
        }

        //  Iterate through each character to make the comparison
        public int compare(Term term1, Term term2) {
            int minLength = Math.min(Math.min(term1.query.length(),
                                              term2.query.length()), r);
            for (int i = 0; i < minLength; i++) {
                if (term1.query.charAt(i) != term2.query.charAt(i)) {
                    return Character.compare(term1.query.charAt(i),
                                             term2.query.charAt(i));
                }
            }
            // If all characters up to the minimum length are the same,
            // then shorter string is considered to be less
            if (term1.query.length() < term2.query.length()
                    && term1.query.length() < r) {
                return -1;
            }
            else if (term2.query.length() < term1.query.length()
                    && term2.query.length() < r) {
                return 1;
            }
            // If the strings are considered equal
            return 0;
        }

    }

    // Compares the two terms in lexicographic order,
    // but using only the first r characters of each query.
    public static Comparator<Term> byPrefixOrder(int r) {
        return new ByPrefixOrder(r);
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(Term that) {
        return this.query.compareTo(that.query);
    }

    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString() {
        return weight + "\t" + query;
    }

    // Unit testing (required)
    public static void main(String[] args) {
        // Test Term constructor
        Term term1 = new Term("Toyota Camry", 10);
        Term term2 = new Term("Honda Accord", 5);
        Term term3 = new Term("Toyota Corolla", 15);
        Term term4 = new Term("Ford Mustang", 8);
        Term term5 = new Term("Honda Accord", 12);

        // Test toString method
        System.out.println(term1.toString());
        System.out.println(term2.toString());

        // Test compareTo method
        System.out.println(term1.compareTo(term2));
        System.out.println(term2.compareTo(term1));
        System.out.println(term2.compareTo(term5));

        // Test byReverseWeightOrder comparator
        Comparator<Term> reverseWeightComparator = Term.byReverseWeightOrder();
        System.out.println(reverseWeightComparator.compare(term1, term2));
        System.out.println(reverseWeightComparator.compare(term2, term5));

        // Test byPrefixOrder comparator
        Comparator<Term> prefixComparator = Term.byPrefixOrder(6);
        System.out.println(prefixComparator.compare(term1, term2));
        System.out.println(prefixComparator.compare(term3, term4));
    }

}
