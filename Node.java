public class Node<E> {
    private E element;
    private Node<E> next;
    private Node<E> prev;

    public Node(E e, Node<E> n){
        this(e,n,null);
    }
    public Node(E e, Node<E> n, Node<E> n2){
        element = e;
        next = n;
        prev = n2;
    }

    public E getElement(){
        return element;
    }

    public Node<E> getNext(){
        return next;
    }
    public Node<E> getPrev(){
        return prev;
    }

    public void setNext(Node<E> n){
        next = n;
    }
    public void setPrev(Node<E> n){
        prev = n;
    }
}