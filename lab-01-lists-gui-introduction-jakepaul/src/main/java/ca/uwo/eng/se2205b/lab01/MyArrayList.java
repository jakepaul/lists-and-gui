package ca.uwo.eng.se2205b.lab01;


import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

/**
 * Array List implementation
 */
public class MyArrayList<T> extends AbstractList<T> {
    private T[] array;
    private int capacity;
    private int size=0;
    
    public MyArrayList(){
        this.array = (T[])(new Object[2]);
        capacity=2;
    }
    
    @SuppressWarnings("unchecked")
    public MyArrayList(AbstractList<? extends T> base) {
        capacity = 2;
        array = (T[])(new Object[capacity]);
        for (T i : base) {
            add(i);
        }
    }
    
    
    @SuppressWarnings("unchecked")
    public MyArrayList(int initialCapacity) {
        capacity = initialCapacity;
        this.array = (T[])(new Object[initialCapacity]);
    }
    
    @Override
    public int size(){
        return size;
    }
    
    @Override
    public String toString(){
    
        StringBuilder stringOfValues= new StringBuilder();
    
        for (int x= 0; x < size; x++){
            if (array[x]!= null){
                if (x != (size-1)){
                    stringOfValues.append(array[x].toString()+ ", ");
                }
                else{
                    stringOfValues.append(array[x].toString());
                }
            }
        
        }
        return "["+(stringOfValues.toString()) +"]";
    
    }

    @Override
    public boolean equals(Object o){
       
        if (o == null)
            return false;
        // Check if the type of `o` is a List, if not, return false, they can't be equal
        if (!List.class.isAssignableFrom(o.getClass())){
            return false;
        }
        // Cast o to a List of Objects
        List<?> that = (List<?>)o;
    
        return Objects.equals(that, this);
    
    }
    
    /**
     * {@inheritDoc}
     *
     * @param i
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    @Override
    public T get(int i) {
        if(i<size && i>=0){
            return array[i];
        }
        else{
            throw new IndexOutOfBoundsException(i + "is invalid");
        }
    }
    
    public boolean isFull(){
        return (size == capacity);
    }
    
    private void increaseCapacity(){
        
        capacity = capacity *2;

        T[] diffarray = (T[])(new Object[capacity]);

        for (int i=0; i< array.length; i++){
            diffarray[i] = array[i];
        }

        array = diffarray;
    }
    @Override
    public boolean add(T e)
            throws IndexOutOfBoundsException {
        //in Exceptions return false, if no exceptions return true
        if (size == capacity){
            increaseCapacity();
        }
        array[size] = e;
        size++;
        
        return true;
    }
    /**
     * {@inheritDoc}
     *
     * <p>This implementation always throws an
     * {@code UnsupportedOperationException}.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    @Override
    public void add(int i, T e){
        if (i <= size && i >= 0) {
            if (size == capacity) {
                increaseCapacity();
            }
    
            for (int j = size - 1; j >= i; j--) {
                array[j + 1] = array[j];
            }
            array[i] = e;
            size++;
        }
        else{
            throw new IndexOutOfBoundsException(i + "is invalid");
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>This implementation always throws an
     * {@code UnsupportedOperationException}.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    @Override
    public T remove (int i) {
        
        if (i < size && i >=0) {
            T temp = array[i];
            
            for (int j = i; j < size - 1; j++) {
                array[j] = array[j + 1];
            }
            size--;
            array[size] = null;
            return temp;
        }
        
        else{
            throw new IndexOutOfBoundsException(i + "is invalid");
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>This implementation always throws an
     * {@code UnsupportedOperationException}.
     *
     * @throws UnsupportedOperationException {@inheritDoc}
     * @throws ClassCastException            {@inheritDoc}
     * @throws NullPointerException          {@inheritDoc}
     * @throws IllegalArgumentException      {@inheritDoc}
     * @throws IndexOutOfBoundsException     {@inheritDoc}
     */
    @Override
    public T set (int i, T e) {
        if(i >= 0 && i < size) {
    
            T temp = array[i];
            array[i] = e;
            return temp;
       
        }
         else {
            throw new IndexOutOfBoundsException(i + "is not valid");
        }
        
    }
    @Override
    public boolean isEmpty(){
        if (size ==0){
            return true;
        }
        return false;
    }
    
}