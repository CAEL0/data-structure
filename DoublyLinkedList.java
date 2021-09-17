public class DoublyLinkedList<E> {
    // Node Class
    private static class Node<E> {
        private E element;
        private Node<E> next;
        private Node<E> prev;
        public Node(E e, Node<E> n, Node<E> p) {
            element = e;
            next = n;
			prev = p;
		}
		public E getElement() { return element; }
		public Node<E> getNext() { return next; }
		public void setNext(Node<E> n) { next = n; }
		public Node<E> getPrev() { return prev; }
		public void setPrev(Node<E> p) { prev = p; }
	}
	// Variables
	private Node<E> head = null;
	private Node<E> tail = null;
	private int size = 0;
	public DoublyLinkedList() { }
	public int size() { return size; }
	// Methods
	public boolean isEmpty() { return size == 0; }
	public E first() {
		if (isEmpty()) return null;
		return head.getElement();
	}
	public E last() {
		if (isEmpty()) return null;
		return tail.getElement();
	}
	public void appendLeft(E e) {
		Node<E> node = new Node<E>(e, head, null);
		if (isEmpty()) tail = node;
		else head.setPrev(node);
		head = node;
		size++;
	}
	public void append(E e) {
		Node<E> node = new Node<E>(e, null, tail);
		if (isEmpty()) head = node;
		else tail.setNext(node);
		tail = node;
		size++;
	}
	public void popLeft() {
		if (!isEmpty()) {
			head = head.getNext();
			head.setPrev(null);
			size--;
		}
	}
	public void pop() {
		if (!isEmpty()) {
			tail = tail.getPrev();
			tail.setNext(null);
			size--;
		}
	}
	public void insertAfter(Node<E> n, E e) {
		Node<E> tar = head;
		while (tar != null) {
			if (tar == n) {
				Node<E> node = new Node<E>(e, tar.getNext(), tar);
				tar.setNext(node);
				if (node.getNext() == null) tail = node;
				else node.getNext().setPrev(node);
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
					if (tar.getNext() == null) tail = tar;
					else tar.getNext().setPrev(tar);
					size--;
				}
				break;
			}
			tar = tar.getNext();
		}
	}
}
