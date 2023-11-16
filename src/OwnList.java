import java.util.*;

public class OwnList implements List<Toy>{

    private final int defaultCapacity = 15;

    private int size;
    private int capacity;
    private Toy[] items;


    public OwnList(int capacity) {
        if(capacity < 0){
            throw new IllegalArgumentException("Capacity cannot be negative");
        }
        this.capacity = capacity;
        this.size = 0;
        this.items = new Toy[capacity];
    }

    public OwnList(Toy[] providedItems) {
        if(providedItems == null){
            throw new IllegalArgumentException("Items cannot be null");
        }
        this.capacity = providedItems.length;
        this.size = providedItems.length;
        this.items = new Toy[capacity];
        System.arraycopy(providedItems, 0, items, 0, providedItems.length);
    }

    public OwnList() {
        this.capacity = defaultCapacity;
        this.size = 0;
        this.items = new Toy[defaultCapacity];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Toy item : items) {
            if(item.equals(o)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<Toy> iterator() {
        return new OwnListIterator(this);
    }

    @Override
    public Object[] toArray() {
        return Arrays.stream(items).toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        T[] array = (T[]) Arrays.stream(items).toArray();
        return array;
    }

    @Override
    public boolean add(Toy toy) {
        if(size >= capacity){
            resize();
        }

        try{
            items[size] = toy;
            size++;
        }catch (Exception e){
            return false;
        }

        return true;
    }

    private boolean addAt(int index, Toy item) {
        if (index < 0 || size < index){
            return false;
        }

        if(size >= capacity){
            resize();
        }

        if (size == index)
        {
            items[index] = item;
            return true;
        }

        try{
            System.arraycopy(items, index, items, index + 1, size - index);
            size++;
        }catch (Exception e){
            return false;
        }

        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = Arrays.asList(items).indexOf(o);

        return remove(index) != null;
    }


    @Override
    public boolean containsAll(Collection<?> c) {
        for(var item : c){
            if(!contains(item)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends Toy> c) {
        for (Toy item : c) {
            if(!add(item)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Toy> c) {
        for (Toy item : c) {
            if(!addAt(index++, item)){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
       if(c == null){
           return false;
       }

       for(Object item : c){
           remove(item);
       }

        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        if(c == null){
            return false;
        }

        int commonCount = 0;
        for (var item : c){
            if(contains(item)){
                commonCount++;
            }
        }

        Toy[] commonElements = new Toy[commonCount];

        int i = 0;
        for (Object element : c) {
            if (contains(element)) {
                commonElements[i++] = (Toy)element;
            }
        }

        System.arraycopy(commonElements, 0, items, 0, commonElements.length);
        size = commonCount;

        return true;
    }

    @Override
    public void clear() {
        items = new Toy[capacity];
        size = 0;
    }

    @Override
    public Toy get(int index) {
        return items[index];
    }

    @Override
    public Toy set(int index, Toy element) {
        return items[index] = element;
    }

    @Override
    public void add(int index, Toy element) {
        addAt(index, element);
    }

    @Override
    public Toy remove(int index) {
        if (index < 0 || index > size){
            throw new IndexOutOfBoundsException();
        }

        Toy item = get(index);

        size--;
        System.arraycopy(items, index+1, items, index, size - index);

        return item;
    }

    @Override
    public int indexOf(Object o) {
        for(int i = 0; i < size; i++){
            if(items[i].equals(o)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for(int i = size - 1; i >= 0; i--){
            if(items[i].equals(o)){
                return i;
            }
        }

        return -1;
    }

    @Override
    public ListIterator<Toy> listIterator() {
        return new OwnListIterator(this);
    }

    @Override
    public ListIterator<Toy> listIterator(int index) {
        return new OwnListIterator(this, index);
    }

    @Override
    public List<Toy> subList(int fromIndex, int toIndex) {
        OwnList sublist = new OwnList(toIndex - fromIndex);

        for(int i = fromIndex; i < toIndex; i++){
            sublist.add(items[i]);
        }

        return sublist;
    }

    public void sort(Comparator<? super Toy> c) {
        // Filter out null elements before sorting
        Object[] a = this.toArray();
        a = Arrays.stream(a).filter(Objects::nonNull).toArray();

        Arrays.sort(a, (Comparator<? super Object>) c);
        ListIterator<Toy> i = this.listIterator();
        for (Object e : a) {
            i.next();
            i.set((Toy) e);
        }
    }

    private void resize(){
        int newCapacity = capacity + capacity * 3 / 10;
        Toy[] tempArray = new Toy[newCapacity];
        System.arraycopy(items, 0, tempArray, 0, items.length);
        items = tempArray;
        capacity = newCapacity;
    }
}

class OwnListIterator implements ListIterator<Toy>{
    private List<Toy> list;
    private int cursor;

    public OwnListIterator(List<Toy> list) {
        this.list = list;
        this.cursor = 0;
    }

    public OwnListIterator(List<Toy> list, int currentIndex) {
        this.list = list;
        this.cursor = currentIndex;
    }

    @Override
    public boolean hasNext() {
        return cursor < list.size();
    }

    @Override
    public Toy next() {
        return list.get(cursor++);
    }

    @Override
    public boolean hasPrevious() {
        return cursor > 0;
    }

    @Override
    public Toy previous() {
        return list.get(cursor - 1);
    }

    @Override
    public int nextIndex() {
        return cursor + 1;
    }

    @Override
    public int previousIndex() {
        return cursor - 1;
    }

    @Override
    public void remove() {
        list.remove(cursor);
    }

    @Override
    public void set(Toy toy) {
        list.set(cursor, toy);
    }

    @Override
    public void add(Toy toy) {
        list.add(cursor, toy);
    }
}
