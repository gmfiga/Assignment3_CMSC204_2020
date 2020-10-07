
import java.util.ArrayList;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class BasicDoubleLinkedList<T> implements Iterable<T> {

    protected Node firstNode;
    protected Node lastNode;
    int size; //the number of entries
    int counterNext = 0;
    int counterLast = 0;

    public BasicDoubleLinkedList() {

        firstNode = null;
        lastNode = null;
        size = 0;
    }


    /**
     * Notice you must not traverse the list to compute the size.
     * This method just returns the value of the instance variable you use to keep track of size.
     *
     * @return the size of the linked list
     */
    public int getSize() {
        return size;
    }


    /**
     * Adds an element to the end of the list. Do not use iterators to implement this method.
     *
     * @param data - the data for the Node within the linked list
     * @return reference to the current object
     */
    public BasicDoubleLinkedList<T> addToEnd(T data) {
        Node newNode = new Node(data, firstNode, lastNode);
        if (size == 0) {
            firstNode = lastNode = newNode;
        } else
            lastNode.setNextNode(newNode);

        lastNode = newNode;
        firstNode.setPreviousNode(lastNode);
        size++;
        return this;
    }

    /**
     * Adds element to the front of the list. Do not use iterators to implement this method.
     *
     * @param data - the data for the Node within the linked list
     * @return reference to the current object
     */
    public BasicDoubleLinkedList<T> addToFront(T data) {
        Node newNode = new Node(data, firstNode, lastNode);
        if (size == 0) {
            firstNode = lastNode = newNode;
        } else
            firstNode.setPreviousNode(newNode);

        firstNode = newNode;
        lastNode.setNextNode(firstNode);
        size++;
        return this;
    }

    /**
     * Returns but does not remove the first element from the list.
     * If there are no elements the method returns null. Do not implement this method using iterators.
     *
     * @return the data element or null
     */
    public T getFirst() {

        return firstNode.getData();
    }

    /**
     * Returns but does not remove the last element from the list.
     * If there are no elements the method returns null. Do not implement this method using iterators.
     *
     * @return the data element or null
     */
    public T getLast() {

        return lastNode.getData();
    }

    /**
     * This method must be implemented using an inner class that implements ListIterator and
     * defines the methods of hasNext(), next(), hasPrevious() and previous().
     * Remember that we should be able to call the hasNext() method as many times as we
     * want without changing what is considered the next element.
     *
     * @return
     * @throws UnsupportedOperationException- Your next() method should throw NoSuchElementException
     *                                        if there are no more elements (at the end of the list and calling next()
     *                                        or at the beginning of the list and calling previous()).
     * @throws NoSuchElementException         - You don't need to implement the ListIterator's remove(),
     *                                        add(), nextIndex() and previousIndex() and set() methods, throw UnsupportedOperationException if called.
     */
    @Override
    public ListIterator<T> iterator() throws UnsupportedOperationException, NoSuchElementException {
        return new IteratorForLinkedList();
    }


    /**
     * Removes the first instance of the targetData from the list.
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
                                           java.util.Comparator<T> comparator) {
        Node targetNode = firstNode;

        while (comparator.compare(targetNode.getData(), targetData) != 0) {
            targetNode = targetNode.getNextNode();
        }

        Node beforeTarget = targetNode.getPreviousNode();
        Node afterTarget = targetNode.getNextNode();

        if (targetNode == firstNode) {
            firstNode = afterTarget;
        } else if (targetNode == lastNode) {
            lastNode = beforeTarget;
        }

        beforeTarget.setNextNode(afterTarget);
        afterTarget.setPreviousNode(beforeTarget);

        size--;
        return this;
    }

    /**
     * Removes and returns the first element from the list.
     * <p>
     * If there are no elements the method returns null. Do not implement this method using iterators.
     *
     * @return data element or null
     */
    public T retrieveFirstElement() {
        T dataToReturn = firstNode.getData();
        Node secondNode = firstNode.getNextNode();
        secondNode.setPreviousNode(lastNode);
        firstNode = secondNode;
        size--;

        return dataToReturn;
    }


    /**
     * Removes and returns the last element from the list. If there are no elements the method returns null.
     * Do not implement implement this method using iterators.
     *
     * @return data element or null
     */
    public T retrieveLastElement() {
        T dataToReturn = lastNode.getData();
        Node secondToLastNode = lastNode.getPreviousNode();
        secondToLastNode.setNextNode(firstNode);
        lastNode = secondToLastNode;
        size--;
        return dataToReturn;
    }

    /**
     * Returns an arraylist of the items in the list from head of list to tail of list
     *
     * @return an arraylist of the items in the list
     */
    public java.util.ArrayList<T> toArrayList() {
        ArrayList<T> arrayList = new ArrayList<>();
        Node dummyNode = firstNode;

        for (int i = 0; i <= size; i++) {
            arrayList.add(dummyNode.getData());
            dummyNode = dummyNode.getNextNode();
        }

        return arrayList;
    }


    /**
     * Node inner class
     */
    private class Node {

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

        public Node getNextNode() {
            return next;
        }

        public void setNextNode(Node next) {
            this.next = next;
        }

        public Node getPreviousNode() {
            return previous;
        }

        public void setPreviousNode(Node previous) {
            this.previous = previous;
        }
    }


    private class IteratorForLinkedList implements ListIterator<T> {

        private Node nextNode;
        private Node previousNode;

        public IteratorForLinkedList() {
            this.nextNode = firstNode;
            this.previousNode = null;
        }

        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        @Override
        public T next() {
            T result;

            if (nextNode == firstNode && counterNext == 0) {
                counterNext++;
            } else if (nextNode == firstNode && counterNext > 0) {
                throw new NoSuchElementException();
            }

            if (hasNext()) {
                result = nextNode.getData();
                previousNode = nextNode;
                nextNode = nextNode.getNextNode();
            } else
                throw new NoSuchElementException();

            return result;
        }

        @Override
        public boolean hasPrevious() {
            return previousNode != null;
        }

        @Override
        public T previous() {
            T result;

            if (previousNode == lastNode && counterLast == 0) {
                counterLast++;
            } else if (previousNode == lastNode && counterLast > 0) {
                throw new NoSuchElementException();
            }

            if (hasPrevious()) {
                result = previousNode.getData();
                nextNode = previousNode;
                previousNode = previousNode.getPreviousNode();
            } else
                throw new NoSuchElementException();

            return result;
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
