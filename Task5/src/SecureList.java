import java.util.*;

public class SecureList<E> extends AbstractList<E> implements
        Cloneable, java.io.Serializable {

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 16;

    /**
     * The array buffer into which the elements of the SecureList are stored.
     * The capacity of the SecureList is the length of this array buffer. Any
     * empty SecureList with elementData will be expanded to DEFAULT_CAPACITY
     * when the first element is added.
     */
    private Object[] elementData;

    /**
     * The size of the SecureList (the number of elements it contains).
     */
    private int size;

    /**
     * Constructs an empty list with the specified initial capacity.
     *
     * @param  capacity  the initial capacity of the list
     * @throws IllegalArgumentException if the specified initial capacity
     *         is negative
     */
    public SecureList(int capacity) {
        if(capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: "+
                    capacity);
        }
        this.elementData = new Object[capacity];
        this.size = 0;
    }

    /**
     * Constructs an empty list with an initial capacity of sixteen.
     */
    public SecureList() {
        this.elementData = new Object[DEFAULT_CAPACITY];
        this.size = 0;
    }

    /**
     * Constructs a list containing the elements of the specified
     * collection, in the order they are returned by the collection's
     * iterator.
     *
     * @param collection the collection whose elements are to be placed into this list
     * @throws NullPointerException if the specified collection is null
     */
    public SecureList(Collection<? extends E> collection) {
        elementData = collection.toArray();
        if((size = elementData.length) != 0) {
            if (elementData.getClass() != Object[].class)    {
                elementData = Arrays.copyOf(elementData, size, Object[].class);
            } else {
                this.elementData = new Object[]{};
            }
        }
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param e element to be appended to this list
     * @return <tt>true</tt> if element appended
     */
    @Override
    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity){
        if(minCapacity == elementData.length) {
            expandElementData();
        }
    }

    private void expandElementData() {
        Object[] temp = elementData;
        elementData = new Object[grow()];
        System.arraycopy(temp, 0, elementData, 0, temp.length);
    }

    private int grow() {
        int capacity = elementData.length;
        return capacity << 1;
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if index more than array size.
     */
    @Override
    public E get(int index) {
        if(index > -1 && index >= size) {
            throw new IndexOutOfBoundsException(String.valueOf(index));
        }
        return (E) elementData[index];
    }

    /**
     * A \ B
     * Returns difference between two lists. Used Set to determine
     * the same elements, it returns false, if such element already
     * exists in set. This work for faster then:
     * <pre>
     *     firstList.removeAll(secondList)
     * </pre>
     *
     * @param list is list of elements.
     * @return list of elements that isn't  contained in the param list.
     */
    public List<E> difference(List<? extends E> list) {
        Set<E> set = new HashSet<>(list);
        List<E> theList = new ArrayList<>();
        for (E e : this) {
            if(set.add(e)) {
                theList.add(e);
            }
        }
        return theList;
    }

    @Override
    public int indexOf(Object o) {
        return super.indexOf(o);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        super.sort(c);
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int cursor = 0;
            @Override
            public boolean hasNext() {
                return cursor < size;
            }

            @Override
            public E next() {
                if(!hasNext()) {
                    throw new IndexOutOfBoundsException(String.valueOf(cursor));
                }
                return (E) elementData[cursor++];
            }
        };
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            SecureList<?> theClone = (SecureList<?>) super.clone();
            theClone.elementData = Arrays.copyOf(elementData, size);
            return theClone;
        } catch (CloneNotSupportedException e) {
            throw new InternalError(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o != null && o instanceof List) {
            List<?> theList = (List<?>) o;
            if(theList.size() != this.size) return false;
            Iterator<?> iterator1 = theList.iterator();
            Iterator<E> iterator2 = this.iterator();
            while (iterator1.hasNext() && iterator2.hasNext()) {
                if (! iterator1.next().equals(iterator2.next())) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * This collection doesn't support delete operations.
     */
    @SuppressWarnings("uncheked")
    public E remove(int index) {
        throw new UnsupportedOperationException("You cannot delete any element in this collection");
    }

}
