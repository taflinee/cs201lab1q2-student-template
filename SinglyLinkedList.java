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
        size++;
    }

    public void addLast(E e){
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()){
            head = newest;
        } else {
            tail.setNext(newest);
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
        if(head == tail){
            head = null;
            tail = null;
            size--;
            return last;
        }
        Node<E> n = head;
        Node<E> prev = null;
        while (n.getNext() != null){
            prev = n;
            n = n.getNext();
        }
        if (prev != null){
            prev.setNext(null);
        }
        tail = prev;
        size--;
        return last;
    }

    public void reverse(){    
        Node<E> prev = null;   
        Node<E> curr = head;
        tail = head;
        while (curr != null){
            Node<E> next = curr.getNext();
            curr.setNext(prev);
            prev = curr;
            curr = next;
        }
        head = prev;
    }
}