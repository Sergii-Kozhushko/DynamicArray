package de.telran.dynamicarray;

public interface IDynamic {
    void addToEnd(String data);
    void addAt(int index, String data);
    void removeFirst(String data);
    void removeAt(int index);
    void doubleCapacity();
    void trimToSize();
    void set(int index, String data);
    String get(int index);
    String[] clear();
    boolean contains(String data);
    boolean isEmpty();

    //методы XXX
    long removeAllFromLast();
    long removeAllFromFirst();
    long removeAllFromMid();
    long fillFromFirst(int count);
    long fillFromLast(int count);
    long fillFromMid(int count);

}
