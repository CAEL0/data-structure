package queue;
import linked_list.SinglyLinkedList;

/** Realization of a FIFO queue as an adaptation of a SinglyLinkedList. */
public class LinkedQueue<E> implements IQueue<E> {
    private SinglyLinkedList<E> list = new SinglyLinkedList<>();    // an empty list
    
    // constructor
    public LinkedQueue() { }         // new queue relies on the initially empty list
    
    // methods
    public int size() { return list.size(); }
    public boolean isEmpty() { return list.isEmpty(); }
    public void enqueue(E element) { list.addLast(element); }
    public E first() { return list.first(); }
    public E dequeue() { return list.removeFirst(); }
}
