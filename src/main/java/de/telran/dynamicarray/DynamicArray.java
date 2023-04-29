/**
 * DynamicArray.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 26-Apr-2023 16:19
 */

package de.telran.dynamicarray;

import java.util.Random;
import java.util.stream.Collectors;

public class DynamicArray implements IDynamic {
    private String[] array;
    private int size = 0;//сколько ячеек массива сейчас занято, видно снаружи
    private int capacity;//реальная длинна массива

    public DynamicArray() {
        capacity = 10;
        array = new String[capacity];
    }

    public DynamicArray(int initialCapacity) {
        capacity = initialCapacity;
        array = new String[initialCapacity];
    }

    @Override
    public void addToEnd(String data) {
        if (size == capacity) {
            doubleCapacity();
        }
        array[size] = data;
        size++;
    }

    @Override
    public void addAt(int index, String data) {
        if (index < size) {
            // сдвигаем элементы вправо
            for (int i = size - 1; i >= index; i--) {
                array[i + 1] = array[i];
            }
            array[index] = data;
            size++;
        } else if (index < capacity) {
            size = index;
            array[index] = data;
            size++;
        } else {
            // если мы решили вставить элемент за пределы capacity, то увеличиваем капасити
            String[] arrayTemp = array;
            array = new String[(int) (index * 1.5)];
            System.arraycopy(arrayTemp, 0, array, 0, arrayTemp.length);
            array[index] = data;
            size = index + 1;
            capacity = (int) (index * 1.5);
        }
    }

    // удаляет первое вхождение элемента, элементы справа сдвигаются влево
    @Override
    public void removeFirst(String data) {
        for (int i = 0; i < size; i++) {
            if (array[i] != null && array[i].equals(data)) {
                removeAt(i);
            }
        }

    }

    // удаляет элемент по индексу, все что справа сдвигается на 1
    @Override
    public void removeAt(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
        }
        size--;
    }

    @Override
    public void doubleCapacity() {
        String[] arrayTemp = array;
        array = new String[capacity * 2];
        System.arraycopy(arrayTemp, 0, array, 0, arrayTemp.length);
        capacity = capacity * 2;
    }

    // устанавливает capacity=size
    @Override
    public void trimToSize() {
        String[] arrayTemp = array;
        array = new String[size];
        System.arraycopy(arrayTemp, 0, array, 0, array.length);
        capacity = size;
    }

    // перезаписывает содержимое элемента по индексу
    @Override
    public void set(int index, String data) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        } else {
            array[index] = data;
        }
    }

    @Override
    public String get(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return array[index];
    }

    @Override
    public String[] clear() {
        size = 10;
        capacity = 15;
        array = new String[15];
        return array;
    }

    @Override
    public boolean contains(String data) {
        for (int i = 0; i < size; i++) {
            if (array[i].equals(data)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        for (int i = 0; i < size; i++) {
            if (array[i] != null) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        String result = (size > 0) ? "[" : "";
        for (int i = 0; i < size; i++) {
            result += array[i] != null ? array[i] : "null";
            result += (i != size - 1) ? ", " : "]";
        }
        result += " size : " + size + ", capacity : " + capacity;
        return result;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getSize() {
        return size;
    }

    @Override
    public long removeAllFromLast() {
        long startTime = System.nanoTime();
        array = new String[0];
        size = 0;
        return System.nanoTime() - startTime;
    }

    @Override
    public long removeAllFromFirst() {
        long startTime = System.nanoTime();
        int startLength = size;
        for (int i = 0; i < startLength; i++) {
            removeAt(0);
        }
        return System.nanoTime() - startTime;
    }

    @Override
    public long removeAllFromMid() {
        long startTime = System.nanoTime();
        while (size > 0) {
            removeAt(size / 2);
        }
        return System.nanoTime() - startTime;
    }

    private String randomString() {
        String symbols = "abcdefghijklmnopqrstuvwxyz";
        int size1 = 1 + new Random().nextInt(9);
        String random = new Random().ints(size1, 0, symbols.length())
                .mapToObj(symbols::charAt)
                .map(Object::toString)
                .collect(Collectors.joining());
        return random;
    }

    @Override
    public long fillFromFirst(int newSize) {
        long startTime = System.nanoTime();
        array = new String[newSize];
        size = 0;
        capacity = newSize;
        for (int i = 0; i < newSize; i++) {
            addAt(0, randomString());
        }
        return System.nanoTime() - startTime;
    }

    @Override
    public long fillFromLast(int newSize) {
        long startTime = System.nanoTime();
        array = new String[newSize];
        size = newSize;
        capacity = newSize;
        for (int i = newSize - 1; i >= 0; i--) {
            set(i, randomString());
        }
        return System.nanoTime() - startTime;
    }

    @Override
    public long fillFromMid(int newSize) {
        long startTime = System.nanoTime();
        array = new String[newSize];
        size = 0;
        capacity = newSize;
        for (int i = 0; i < newSize; i++){
            addAt(size / 2, randomString());
        }
        return System.nanoTime() - startTime;
    }
}
