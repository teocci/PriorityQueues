/******************************************************************************
 *  Compilation:  javac OrderedArrayMaxPQ.java
 *  Execution:    java OrderedArrayMaxPQ
 *  Dependencies: StdOut.java
 *
 *  Priority queue implementation with an ordered array.
 *
 *  Limitations
 *  -----------
 *   - no array resizing
 *   - does not check for overflow or underflow.
 *
 *
 ******************************************************************************/

import edu.princeton.cs.algs4.StdOut;

/**
 *  The {@code OrderedArrayMaxPQ} class provides another approach to move larger entries one position to the right,
 *  thus keeping the entries in the array in order (as in insertion sort).
 *  Thus the largest item is always at the end, and the code for remove the maximum in the priority queue
 *  is the same as for pop in the stack.
 *  <p>
 *  For additional documentation, see <a href="http://algs4.cs.princeton.edu/24pq">Section 2.4</a>
 *  of <i>Algorithms, 4th Edition</i> by Robert Sedgewick and Kevin Wayne.
 *
 *  @author Jorge Frisancho
 */
public class OrderedArrayMaxPQ<Key extends Comparable<Key>> {
    private Key[] pq;          // elements
    private int n;             // number of elements

    // set inititial size of heap to hold size elements
    public OrderedArrayMaxPQ(int capacity) {
        pq = (Key[]) (new Comparable[capacity]);
        n = 0;
    }


    public boolean isEmpty() { return n == 0;  }
    public int size()        { return n;       }
    public Key delMax()      { return pq[--n]; }

    public void insert(Key key) {
        int i = n-1;
        while (i >= 0 && less(key, pq[i])) {
            pq[i+1] = pq[i];
            i--;
        }
        pq[i+1] = key;
        n++;
    }



    /***************************************************************************
     * Helper functions.
     ***************************************************************************/
    private boolean less(Key v, Key w) {
        return v.compareTo(w) < 0;
    }

    /***************************************************************************
     * Test routine.
     ***************************************************************************/
    public static void main(String[] args) {
        OrderedArrayMaxPQ<String> pq = new OrderedArrayMaxPQ<String>(10);
        pq.insert("this");
        pq.insert("is");
        pq.insert("a");
        pq.insert("test");
        while (!pq.isEmpty())
            StdOut.println(pq.delMax());
    }
}