package ca.uwo.eng.se2205b.lab01;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * Doubly linked list implementation
 */
public class MyLinkedList<T> extends AbstractList<T> {
    
    Node head= null;
    Node tail = null;
    
    
    private int size = 0;
    
    private Node dll;
            
    public class Node {
        T value;
        Node next;
        Node prev;
        
        public Node getPrevious() {
            return prev;
        }
    
        public Node getNext() {
            return next;
        }
    
        public T getValue() {
            return value;
        }
        
        public void setNext(Node next) {
            this.next = next;
        }
    
        public void setPrev(Node prev) {
            this.prev = prev;
        }
        
        public void setValue(T val) {
            this.value = val;
        }
    
        public Node(T val, Node nx, Node pv){
            this.value = val;
            this.next = nx;
            this.prev = pv;
        }
        
    }
    
    public MyLinkedList(AbstractList<? extends T> base) {
        
        //create new Node
        head = new Node(null, null, null);
        tail = new Node (null, null, null);
        
        //set the values in the list to be copied over to the DLL
        // ....need to use a .addHead() or somethign using a for loop
        for (T i : base){
            add(i);
        }
    }
    
    @Override
    public T get(int i) {
        if(i>= 0 && i <size) {
            return this.getNode(i).getValue();
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    @Override
    public T set(int i, T val){
        if(i>= 0 && i <size) {
           
           T temp = this.get(i);
            this.getNode(i).setValue(val);
            
            return temp;
        }
        else{
            throw new IndexOutOfBoundsException();
        }
    }
    
    private Node getNode(int i){
        int count =0;
    
        Node curr;
        for(curr = head.getNext(); count <= i && curr != null; curr = curr.getNext()) {
            if (count == i) {
                return curr;
            }
            count++;
        }
        return null;
    }
    
    @Override
    public int size(){
        return size;
    }
    
    @Override
    public boolean isEmpty() {
    
       /*if ( head == null || tail == null){
           return true;
       }
        
       if(head.getNext() == tail || tail.getPrevious() == head){
           return true;
       }
       
       return false;*/
       if (size <= 0) {
           return true;
       }
       else {
           return false;
       }
       
    }
    
    @Override
   public String toString() {
        
       StringBuilder sb = new StringBuilder();
       sb.append("[");
    
       Node current = head.getNext();
 
       while (current != null) {
           sb.append((current.getValue() == null) ? "" : current.getValue().toString());
           if (current.getNext() != tail && current.getNext() != null) {
               sb.append(", ");
           }
           current = current.getNext();
       }
    
       sb.append("]");
       return sb.toString();
       
    }
    
    @Override
    public boolean equals(Object o){
    
        if (o == null){
            return false;
        }
        // Check if the type of `o` is a List, if not, return false, they can't be equal
        if (!List.class.isAssignableFrom(o.getClass())) return false;
        
        // Cast o to a List of Objects
        List<?> that = (List<?>)o;
    
        return Objects.equals(that, this);
        /*MyLinkedList list = (MyLinkedList)o;
    
        if (this.size() != list.size()){
            return false;
        }
    
        Node cur1 = this.head.getNext();
        Node cur2 = list.head.getNext();
        
        for (int i = 0; i <size; i++){
            if (!Objects.equals(cur1.getValue(), cur2.getValue())){
                cur1= cur1.getNext();
                cur2= cur2.getNext();
            }
        }
    
        return true;*/
    }
    
    @Override
    public boolean add(T val){
        
        if (head.getNext() == null) {  // means list is empty, so add first element
            if (tail.getPrevious() != null) {
                throw new AssertionError();  // if head points to null then tail should too
            }
        }
        
        Node addn = new Node(val, tail, (tail.getPrevious() == null ? head : tail.getPrevious()));
        (tail.getPrevious() == null ? head : tail.getPrevious()).setNext(addn);
        tail.setPrev(addn);
        size++;
        
        return true;
    }
    
    
    public void add(int i, T val){
        //System.out.println("Adding " + val.toString() + " at index " + i);
//        if (val == null){
//            throw new NullPointerException();
//        }
//
        if ( 0 <= i && i <= this.size()) {
//            if (head.getNext() == null) {  // means list is empty, so add first element
//                if (tail.getPrevious() != null) {
//                    throw new AssertionError(); // if head points to null then tail should too
//                }
//
//
//            }
    
            //(toReplace == null ? null : toReplace.getPrevious())
            
            Node toReplace = getNode(i);
            
            if (toReplace != null) {
                Node addi = new Node(val, toReplace, toReplace.getPrevious());
                toReplace.getPrevious().setNext(addi);
                toReplace.setPrev(addi);
                size++;
            }
            else {
                Node addi = new Node(val, tail, head);
                head.setNext(addi);
                tail.setPrev(addi);
                size++;
            }
        }
        else {
            throw new IndexOutOfBoundsException(i +" is invalid. Size: " + this.size() );
        }
        
    }
    
    
    public void addFirst (T val){
        if (head.getNext() == null) {  // means list is empty, so add first element
            if (tail.getPrevious() != null) {
                throw new AssertionError(); // if head points to null then tail should too
    
            }
        }
        
        Node addf = new Node(val,(head.getNext()==null ? tail : head.getNext()),head );
        head.setNext(addf);
        addf.getNext().setPrev(addf);
        size++;
            
            
    }
    
    public void addTail (T val) {
        add(val);
        
    }
    
    @Override
    public T remove(int i) {
    
        if(i<size && i>=0) {
            T retVal = null;
            if (!this.isEmpty()) {
        
                Node temp = getNode(i);
                retVal = temp.getValue();
        
                temp.getPrevious().setNext(temp.getNext());
                temp.getNext().setPrev(temp.getPrevious());
        
                temp.setNext(null);
                temp.setPrev(null);
                size--;
            }
            return retVal;
        }
        else{
            throw new IndexOutOfBoundsException(i + " is invalid");
        }
    }
    
    public void removeFirst() {
       remove(0);
    }
    
    public void removeLast() {
       remove(size-1);
    }
    
    @Override
    public void clear(){
        while (!this.isEmpty()) {
            this.remove(0);
        }
    }
    
    
    
    
}
