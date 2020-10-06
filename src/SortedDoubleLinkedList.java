public class SortedDoubleLinkedList<T> extends BasicDoubleLinkedList<T> {

    /**
     * Creates an empty list that is associated with the specified comparator.
     *
     * @param comparator2 - Comparator to compare data elements
     */
    SortedDoubleLinkedList(java.util.Comparator<T> comparator2) {

    }


    /**
     * Inserts the specified element at the correct position in the sorted list.
     * Notice we can insert the same element several times.
     * Your implementation must traverse the list only once in order to perform the insertion.
     * Do not implement this method using iterators.
     * Notice that you don't need to call any of the super class methods in order to implement this method.
     *
     * @param data - the data to be added to the list
     * @return a reference to the current object
     */
    public SortedDoubleLinkedList<T> add(T data) {

    }


    /**
     * This operation is invalid for a sorted list.
     * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
     *
     * @param data - the data for the Node within the linked list
     * @return reference to the current object
     * @throws UnsupportedOperationException - if method is called
     */
    @Override
    public BasicDoubleLinkedList<T> addToEnd(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }


    /**
     * This operation is invalid for a sorted list.
     * An UnsupportedOperationException will be generated using the message "Invalid operation for sorted list."
     *
     * @param data - the data for the Node within the linked list
     * @return reference to the current object
     * @throws UnsupportedOperationException
     */
    @Override
    public BasicDoubleLinkedList<T> addToFront(T data) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }


    /**
     * Implements the iterator by calling the super class iterator method.
     * @return an iterator positioned at the head of the list
     */
    @Override
    public java.util.ListIterator<T> iterator(){

    }

    /**
     * Implements the remove operation by calling the super class remove method.
     *
     * @param data - the data element to be removed
     * @param comparator - the comparator to determine equality of data elements
     * @return data element or null
     */
    public SortedDoubleLinkedList<T> remove(T data,
                                            java.util.Comparator<T> comparator){

    }

}
