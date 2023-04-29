import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Node.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 29-Apr-2023 15:53
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Node {
   private int data;
   private Node nextNode;
   private Node previousNode;

   public Node(int data) {
      this.data = data;
   }
}
