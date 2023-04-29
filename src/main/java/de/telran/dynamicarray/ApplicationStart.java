/**
 * ApplicationStart.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 26-Apr-2023 16:11
 */

package de.telran.dynamicarray;

public class ApplicationStart {
    public static void main(String[] args) {
        DynamicArray dynamicArray = new DynamicArray();
        // Вызов методов:
        dynamicArray.addToEnd("A");
        dynamicArray.addToEnd("B");
        dynamicArray.addToEnd("C");
        dynamicArray.removeFirst("C");
        System.out.println(dynamicArray);
        dynamicArray.addToEnd("3");
        dynamicArray.addAt(10, "10");
        dynamicArray.addAt(6, "6");
        System.out.println(dynamicArray);
        dynamicArray.removeFirst("3");
        dynamicArray.removeAt(1);
        dynamicArray.trimToSize();
        dynamicArray.set(10,"a");
        System.out.println("Remove all from middle time=" +dynamicArray.removeAllFromMid());
        dynamicArray.fillFromFirst(20);
        System.out.println(dynamicArray);
        System.out.println("Fill from first time=" + dynamicArray.fillFromFirst(100)/10_000);
        System.out.println(dynamicArray);
        System.out.println("Fill from middle time=" + dynamicArray.fillFromMid(100)/10_000);
        System.out.println(dynamicArray);
        System.out.println("Fill from last time=" + dynamicArray.fillFromLast(100)/10_000);
        System.out.println(dynamicArray);
    }
}
