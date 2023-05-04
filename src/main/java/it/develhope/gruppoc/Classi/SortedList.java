package it.develhope.gruppoc.Classi;

import java.util.*;

public class SortedList<T> extends AbstractList<T> implements Collection<T> {

    private List<T> contenitore;
    private Comparator<T> comparator;

    public SortedList(Comparator<T> comparator) {
        contenitore = new ArrayList<>();
        this.comparator = comparator;
    }
    @Override
    public int size() {
        return contenitore.size();
    }

    @Override
    public boolean isEmpty() {
        return contenitore.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return contenitore.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return contenitore.iterator();
    }

    @Override
    public T[] toArray() {
        return (T[]) contenitore.toArray();
    }

    @Override
    public boolean add(Object o) {
        boolean ritornoAdd = contenitore.add((T) o);
        contenitore.sort(comparator);
        return ritornoAdd;
    }

    @Override
    public boolean remove(Object o) {
        boolean ritornoAdd = contenitore.remove((T) o);
        contenitore.sort(comparator);
        return ritornoAdd;
    }

    @Override
    public boolean addAll(Collection c) {
        boolean ritorno = contenitore.addAll((Collection<? extends T>) c);
        contenitore.sort(comparator);
        return ritorno;
    }

    @Override
    public T get(int index) {
        return contenitore.get(index);
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public T[] toArray(Object[] a) {
        return (T[]) new Object[0];
    }
}
