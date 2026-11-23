import java.util.Iterator;

public class SimpleLinkedList<E> implements SimpleList<E>{
    private Node<E> HEAD;
    private int length = 0;

    //constructor
    public SimpleLinkedList() {
        HEAD = null;
    }

    @Override
    public void add(E e) {
        //add element to end of list
        //How do we do this?
        //create a new element (Node)
        Node<E> node = new Node<>();
        node.e = e;
        //traverse the list to the end
        Node<E> tail = findTail();
        //append to end by having the final node with null ref point to new node
        tail.next = node;
        length++;
    }

    @Override//01234
    public void add(int index, E e) {
        //add element to specified position, splicing it into place
        //create new node
        Node<E> newNode = new Node<>();
        newNode.e = e;
        //traverse to index
        Node<E> cursor = traverse(index);
        //point the new node to the cursor's reference
        newNode.next = cursor.next;
        //point the indexed node to our new node
        cursor.next = newNode;
        length++;
    }

    public void replace(int index, E e) {

    }

    @Override
    public void clear() {
        //empty array
        HEAD = null;
        length = 0;
    }

    @Override
    public void remove(int index) {
        //remove an element from a specified position, splicing it out
    }

    @Override
    public E get(int index) {
        //traverse the list to retrieve a value at position specified
        return null;
    }

    @Override
    public int contains(E e) {
        //traverse the list looking for the specified element, if it is found return the index, otherwise return -1
        return 0;
    }

    @Override
    public int length() {
        return 0;
    }

    private Node<E> traverse(int index) {
        Node<E> cursor = HEAD;
        for(int i = 0; i < index; i++) {
            cursor = cursor.next;
        }

        return cursor;
    }

    private Node<E> findTail() {
        Node<E> cursor = HEAD;
        if(HEAD == null) {
            return HEAD;
        }
        while(cursor.next != null) {
            cursor = cursor.next;
            if(cursor.next == null) {
                return cursor;
            }
        }
        return cursor;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            Node<E> currentNode = HEAD;

            @Override
            public boolean hasNext() {
                //is there a reference from this node to the next, or is the reference null?
                if(currentNode != null) {
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                E e = currentNode.e;
                currentNode = currentNode.next;
                return e;
            }
        };
    }


    private class Node<E> {
        E e;
        Node<E> next;
    }
}
