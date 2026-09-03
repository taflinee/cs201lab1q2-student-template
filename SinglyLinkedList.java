public class SinglyLinkedList<E> {
    
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public SinglyLinkedList(){

    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public E first(){
        if (isEmpty()){
            return null;
        } 
        return head.getElement();
    }

    public E last(){
        if (isEmpty()){
            return null;
        }
        return tail.getElement();
    }

    public void addFirst(E e){
        head = new Node<>(e, head);

        if (isEmpty()){
            tail = head;
        }
        else{
            head.getNext().setPrev(head);
        }
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
            newest.setPrev(tail);
        }
        tail = newest;
        size++;
    }

    public E removeFirst(){
        if (isEmpty()){
            return null;
        }

        E answer = head.getElement();
        head = head.getNext();
        
        size--;

        if (isEmpty()){
            tail = null;
        }
        else{
            head.setPrev(null);
        }
        return answer;
    }

    // Write your codes below
    public String toString(){
        StringBuilder s = new StringBuilder();
        Node<E> curr = head;
        while (curr != null){
            s.append(curr.getElement());
            curr = curr.getNext();
        }
        return s.toString();
    }

    public E removeLast(){
        if (isEmpty()){
            return null;
        }
        E last = tail.getElement();
        if (tail == head){
            head = null;
            tail = null;
        }
        else{
            tail = tail.getPrev();
            tail.setNext(null);
        }
        size--;
        return last;
    }

    public void reverse(){    
        Node<E> temp = tail;   
        tail = head;
        head = temp;
        while (temp != null){
            Node<E> nextNode = temp.getNext();
            temp.setNext(temp.getPrev());
            temp.setPrev(nextNode);
            temp = temp.getNext();
        }
    }
}