package ca.bcit.comp2522.labs.lab06;

import java.util.List;

public interface PayLoadList<E, P> extends List<E> {
    void setPayload(int index, P val);
}

// no compiler warnings

/*
 * public void setPayload(int index, P val) {
 *  this.list.add(index, val);
 * }
 */