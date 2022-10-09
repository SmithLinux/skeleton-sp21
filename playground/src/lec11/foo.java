package lec11;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Foo implements Iterator<Foo> {

    public int size;
    public int item;
    public Foo rest;

    public Foo(int item) {
        size++;
        this.rest = null;
        this.item = item;
    }

    public void addLast(int item) throws Exception {
        if(item == 0) {
            throw new Exception("You can't add 0 to the Foo");
        }
        Foo point;
        while(this.rest != null) {
            point = this.rest;
        }
        point = new Foo(item);
        this.size++;
    }

    public int size() {
        return this.size;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public Foo next() {

        return null;
    }

    public static void main(String[] args) throws Exception {

        Foo foo = new Foo(1);
        foo.addLast(0);

        List list = new ArrayList<Integer>();
        list.add(0);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator listIterator = list.iterator();
        while(listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        List stringList = new ArrayList<String>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");
        stringList.add("e");
        for(Object o: stringList) {
            System.out.println((String)o);
        }
    }
}

