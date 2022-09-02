package iterator;

//---------------- nested ArrayIterator class ----------------
/**
 * A (nonstatic) inner class. Note well that each instance contains an implicit
 * reference to the containing list, allowing it to access the list's members.
 */

private class ArrayIterator<E> implements Iterator<E> {
    private int j = 0;                              // index of the next element to report
    private boolean removable = false;              // can remove be called at this time?
    
    /**
     * Tests whether iterator has a next object.
     * @return true if there are further objects, false otherwise
     */
    public boolean hasNext() { return j < size; }   // size is field of outer instance
    
    /**
     * Returns the next object in the iterator.
     * 
     * @return next object
     * @throws NoSuchElementException if there are no further elements
     */
    public E next() throws NoSuchElementException {
        if (j == size) throw new NoSuchElementException("No next element");
        removable = true;
        return data[j++];
    }
    
    /** Removes the element returned by most recent call to next.
     * @throws IllegalStateException if next has not yet been called
     * @throws IllegalStateException if remove was already called since recent next
     */
    public void remove() throws IllegalStateException {
        if (!removable) throw new IllegalStateException("nothing to remove");
        ArrayList.this.remove(j - 1);               // that was the last one returned
        j--;                                        // next element has shifted one cell to the left
        removable = false;                          // do not allow remove again until next is called
    }
} //------------ end of nested ArrayIterator class ------------

/** Returns an iterator of the elements stored in the list. */
public Iterator<E> iterator() {
    return new ArrayIterator();                    // create a new instance of the inner class
}