import de.telran.dynamicarray.DynamicArray;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


/**
 * DynamicArrayTest.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 26-Apr-2023 21:11
 */

public class DynamicArrayTest {
   private DynamicArray dynamicArray;

   @BeforeEach
   public void setUp(){
      dynamicArray = new DynamicArray();
   }
   @Test
   public void addToEnd1(){
      dynamicArray.addToEnd("A");
      //assertTrue
      assertEquals( 1, dynamicArray.getSize(), "Тест добавления 1-го элемента, проверка размера");
      assertEquals( "A", dynamicArray.get(0), "Тест добавления 1-го элемента, проверка элемента'");
   }
   @Test
   public void addToEnd5(){
      dynamicArray.addToEnd("A");
      dynamicArray.addToEnd("A");
      dynamicArray.addToEnd("A");
      dynamicArray.addToEnd("A");
      dynamicArray.addToEnd("A");
      assertEquals( 5, dynamicArray.getSize(), "Тест добавления 5-ти элементов, проверка размера");
   }
   @Test
   public void addAtTest(){
      dynamicArray.addAt(0,"aaa");
      assertEquals("aaa", dynamicArray.get(0), "Тест метода addAt");
      assertEquals(1, dynamicArray.getSize(), "Тест метода addAt");
      dynamicArray.addAt(100,"bb");
      assertEquals("bb", dynamicArray.get(100), "Тест метода addAt");
      assertEquals(150, dynamicArray.getCapacity(), "Тест метода addAt");
   }

   @Test
   public void removeFirstTest(){
      dynamicArray.addToEnd("A");
      dynamicArray.addToEnd("B");
      dynamicArray.addToEnd("C");
      dynamicArray.removeFirst("C");
      assertEquals(2, dynamicArray.getSize(), "Тест метода removeFirst");
      assertFalse(dynamicArray.contains("C"), "Тест метода removeFirst");
   }

   @Test
   public void removeAtTest(){
      dynamicArray.addToEnd("A");
      dynamicArray.addToEnd("B");
      dynamicArray.addToEnd("C");
      dynamicArray.removeAt(1);
      assertEquals(2, dynamicArray.getSize(), "Тест метода removeFirst");
      assertEquals("C", dynamicArray.get(1), "Тест метода removeFirst");
   }
   @Test
   public void doubleCapacityTest(){
      int c = dynamicArray.getCapacity();
      dynamicArray.doubleCapacity();
      assertEquals(c*2, dynamicArray.getCapacity(), "Тест doubleCapacity");
   }
   @Test
   public void trimToSizeTest(){
      dynamicArray.trimToSize();
      assertTrue(dynamicArray.getSize()== dynamicArray.getCapacity(), "Тест trimToSize");
   }

   @Test
   public void setTest(){
      dynamicArray.addToEnd("A");
      dynamicArray.set(0,"B");
      assertEquals("B", dynamicArray.get(0), "Тесто метода set");
   }

   @Test
   public void clearTest(){
      dynamicArray.addToEnd("A");
      dynamicArray.addToEnd("B");
      dynamicArray.clear();
      assertEquals(null, dynamicArray.get(0), "Тесто метода clear");
   }

   @Test
   public void containsTest(){
      dynamicArray.addToEnd("A");
      dynamicArray.addToEnd("B");
      assertTrue(dynamicArray.contains("A"), "Тест contains");
   }

   @Test
   public void isEmpty(){
      assertTrue(dynamicArray.isEmpty(), "Тест isEmpty, " + dynamicArray.toString());
   }
   @Test
   void fillFromFirst(){
      dynamicArray.fillFromFirst(100);
      assertEquals(100, dynamicArray.getSize(), "Тест fillFromFirst");
   }

   @Test
   void fillFromLast(){
      dynamicArray.fillFromLast(100);
      assertEquals(100, dynamicArray.getSize(), "Тест fillFromLast");
   }

   @Test
   void fillFromMid(){
      dynamicArray.fillFromMid(100);
      assertEquals(100, dynamicArray.getSize(), "Тест fillFromMid");
   }

}
