package list;

import java.util.Iterator;

public class LinkedList<E> implements List<E> {
    private int size = 0;
    private Node<E> firstElement = null;
    private Node<E> lastElement = null;

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void add(E value) {
        if (size == 0) {
            firstElement = new Node<E>(value);
            lastElement = firstElement;
        } else {
            lastElement.next = new Node<>(value);
            lastElement = lastElement.next;
        }
        this.size++;

    }

    @Override
    public void remove(int index) {
        int indexElement = 0;
        for (Node<E> element = firstElement; element != null; element = element.next) {
            if (this.isTheFirstNodeAndOnlyNodeInTheList(index, indexElement)) {
                firstElement = null;
                this.size--;
            } else if (this.isTheFirstNodeAndHasAnotherNodesIntoTheList(index, indexElement)) {
                firstElement = firstElement.next;
                this.size--;
            } else if (this.isOneBeforeTheMiddleNode(index, indexElement)) {
                element.next = element.next.next;
                this.size--;
            } else if (this.isOneBeforeTheLastNode(index, indexElement)) {
                element.next = null;
                this.size--;
            }
            indexElement++;
        }
    }

    private boolean isOneBeforeTheLastNode(int index, int indexElement) {
        return index > 0 && (index < size - 1) && indexElement == (index - 1);
    }

    private boolean isOneBeforeTheMiddleNode(int index, int indexElement) {
        return index > 0 && (index < size - 2) && indexElement == (index - 1);
    }


    private boolean isTheFirstNodeAndHasAnotherNodesIntoTheList(int index, int indexElement) {
        return indexElement == index && size > 1 && index == 0;
    }

    private boolean isTheFirstNodeAndOnlyNodeInTheList(int index, int indexElement) {
        return indexElement == index && size == 1 && index == 0;
    }

    @Override
    public E get(int index) {
        int indexElement = 0;
        for (Node<E> element = firstElement; element != null; element = element.next) {
            if (indexElement == index) {
                return element.value;
            }
        }
        return null;
    }


    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator<E>(firstElement);
    }

    @Override
    public void clear() {
        this.firstElement = null;
    }


    private static class LinkedListIterator<E> implements Iterator<E> {
        private Node<E> list;

        public LinkedListIterator(Node<E> list) {
            this.list = list;
        }


        @Override
        public boolean hasNext() {
            return list != null;
        }

        @Override
        public E next() {
            Node<E> temp = list;
            list = list.next;
            return temp.value;
        }
    }
}
