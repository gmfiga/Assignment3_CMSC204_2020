
import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T>{

    Node firstNode;
    Node lastNode = null;
    int size; //the number of entries

    public BasicDoubleLinkedList() {
    }


    /**
     * Notice you must not traverse the list to compute the size.
     * This method just returns the value of the instance variable you use to keep track of size.
     *
     * @return the size of the linked list
     */
    public int getSize(){
        return size;
    }


    /**
     * Adds an element to the end of the list. Do not use iterators to implement this method.
     *
     * @param data - the data for the Node within the linked list
     * @return reference to the current object
     */
    public BasicDoubleLinkedList<T> addToEnd(T data){

    }

    /**
     * Adds element to the front of the list. Do not use iterators to implement this method.
     *
     * @param data - the data for the Node within the linked list
     * @return reference to the current object
     */
    public BasicDoubleLinkedList<T> addToFront(T data){

    }

    /**
     * Returns but does not remove the first element from the list.
     * If there are no elements the method returns null. Do not implement this method using iterators.
     *
     * @return the data element or null
     */
    public T getFirst(){

    }

    /**
     * Returns but does not remove the last element from the list.
     * If there are no elements the method returns null. Do not implement this method using iterators.
     *
     * @return the data element or null
     */
    public T getLast(){

    }

    /**
     *This method must be implemented using an inner class that implements ListIterator and
     * defines the methods of hasNext(), next(), hasPrevious() and previous().
     * Remember that we should be able to call the hasNext() method as many times as we
     * want without changing what is considered the next element.
     *
     * @return
     * @throws UnsupportedOperationException- Your next() method should throw NoSuchElementException
     * if there are no more elements (at the end of the list and calling next()
     * or at the beginning of the list and calling previous()).
     * @throws NoSuchElementException - You don't need to implement the ListIterator's remove(),
     * add(), nextIndex() and previousIndex() and set() methods, throw UnsupportedOperationException if called.
     */
    @Override
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
        return new IteratorForLinkedList();
    }


    /**
     *Removes the first instance of the targetData from the list.
     * Notice that you must remove the elements by performing a single traversal over the list.
     * You may not use any of the other retrieval methods associated with the
     * class in order to complete the removal process. You must use the provided
     * comparator (do not use equals) to find those elements that match the target.
     * Do not implement this method using iterators.
     *
     * @param targetData - the data element to be removed
     * @param comparator - the comparator to determine equality of data elements
     * @return data element or null
     */
    public BasicDoubleLinkedList<T> remove(T targetData,
                                           java.util.Comparator<T> comparator){

    }

    /**
     * Removes and returns the first element from the list.
     *
     * If there are no elements the method returns null. Do not implement this method using iterators.
     * @return data element or null
     */
    public T retrieveFirstElement(){

    }


    /**
     * Removes and returns the last element from the list. If there are no elements the method returns null.
     * Do not implement implement this method using iterators.
     *
     * @return data element or null
     */
    public T retrieveLastElement(){

    }

    /**
     * Returns an arraylist of the items in the list from head of list to tail of list
     *
     * @return an arraylist of the items in the list
     */
    public java.util.ArrayList<T> toArrayList(){

    }


    /**
     * Node inner class
     */
    private class Node{

        private T data;
        private Node next;
        private Node previous;

        public Node(T data) {
            this(data, null, null);
        }

        public Node(T data, Node nextNode, Node previousNode) {
            this.data = data;
            this.next = nextNode;
            this.previous = previousNode;
        }

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }


    private class IteratorForLinkedList implements ListIterator<T> {

        private Node nextNode;
        private Node previousNode;

        public IteratorForLinkedList() {
            this.nextNode = firstNode;
            this.previousNode = lastNode;
        }

        @Override
        public boolean hasNext() {
            return nextNode!= null;
        }

        @Override
        public T next() {
            T result;
            if (hasNext()){
                result = nextNode.getData();
                nextNode = nextNode.getNext();
            }
            else
                throw new NoSuchElementException();

            return result;
        }

        @Override
        public boolean hasPrevious() {
            return false;
        }

        @Override
        public T previous() {
            return null;
        }

        @Override
        public int nextIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public int previousIndex() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        @Override
        public void set(T t) {
            throw new UnsupportedOperationException();
        }

        @Override
        public void add(T t) {
            throw new UnsupportedOperationException();
        }
    }

}
