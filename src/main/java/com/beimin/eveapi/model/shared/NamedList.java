package com.beimin.eveapi.model.shared;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class NamedList<E> {
    private final List<E> list = new ArrayList<E>();
    private String name;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public void add(final E value) {
        list.add(value);
    }

    public Iterator<E> iterator() {
        return list.iterator();
    }

    public int size() {
        return list.size();
    }

    public E get(final int index) {
        return list.get(index);
    }

    public List<E> getList() {
        return list;
    }
}
