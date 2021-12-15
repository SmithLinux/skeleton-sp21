package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque implements Comparator<MaxArrayDeque>{

    //creates a MaxArrayDeque with the given Comparator
    public MaxArrayDeque(Comparator<T> c) {

    }

    //returns the maximum element in the deque as governed by the previously given Comparator.
    //If the MaxArrayDeque is empty, simply return null.
    public T max() {
        return null;
    }

    //returns the maximum element in the deque as governed by the parameter Comparator c.
    //If the MaxArrayDeque is empty, simply return null.
    public T max(Comparator<T> c) {
        return null;
    }

    @Override
    public int compare(MaxArrayDeque o1, MaxArrayDeque o2) {
        return 0;
    }
}
