public class SinglyLinkedList<E> {
    // Node Class
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    // Variables
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;
    
    // Constructor
    public SinglyLinkedList() {
    }

    // Methods
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return tail.getElement();
    }

    public void appendLeft(E e) {
        Node<E> node = new Node<E>(e, head);
        if (isEmpty()) {
            tail = node;
        }
        head = node;
        size++;
    }

    public void append(E e) {
        Node<E> node = new Node<E>(e, null);
        if (isEmpty()) {
            head = node;
        }
        else {
            Node<E> tar = head;
            while (tar.getNext() != null) {
                tar = tar.getNext();
            }
            tar.setNext(node);
        }
        tail = node;
        size++;
    }

    public void popLeft() {
        if (!isEmpty()) {
            head = head.getNext();
            size--;
        }
    }

    public void pop() {
        if (!isEmpty()) {
            Node<E> tar = head;
            while (tar.getNext().getNext() != null) {
                tar = tar.getNext();
            }
            tar.setNext(null);
            tail = tar;
            size--;
        }
    }

    public void insertAfter(Node<E> n, E e) {
        Node<E> tar = head;
        while (tar != null) {
            if (tar == n) {
                Node<E> node = new Node<E>(e, tar.getNext());
                tar.setNext(node);
                if (node.getNext() == null) {
                    tail = node;
                }
                size++;
                break;
            }
            tar = tar.getNext();
        }
    }

    public void deleteAfter(Node<E> n) {
        Node<E> tar = head;
        while (tar != null) {
            if (tar == n) {
                if (tar.getNext() != null) {
                    tar.setNext(tar.getNext().getNext());
                    if (tar.getNext() == null) {
                        tail = tar;
                    }
                    size--;
                }
                break;
            }
            tar = tar.getNext();
        }
    }
}
