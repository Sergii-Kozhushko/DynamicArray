import lombok.Getter;
import lombok.Setter;

/**
 * MyLinkedList.java
 *
 * @author Sergii Kozhushko, sergiikozhushko@gmail.com
 * Date of creation: 29-Apr-2023 15:51
 */

@Getter
@Setter
public class MyLinkedList implements Linked {
    private Node first;
    private Node last;
    private int size;

    public MyLinkedList() {

    }

    private Node getNodeAt(int index) {
        Node positionNode;
        if (index < size / 2) {
            positionNode = first;
            for (int i = 0; i < index; i++) {
                positionNode = positionNode.getNextNode();
            }
        } else {
            positionNode = last;
            for (int i = size - 1; i >= 0; i--) {
                positionNode = positionNode.getPreviousNode();
            }
        }
        return positionNode;
    }

    public void print() {
        if (first == null) {
            System.out.println("[] size: 0");
            return;
        }
        Node currentNode = first;
        System.out.print("[");
        while (true) {
            System.out.print(currentNode.getData());
            if (currentNode.getNextNode() == null) {
                System.out.print("] size: " + size);
                return;
            } else {
                System.out.print(", ");
            }
            currentNode = currentNode.getNextNode();
        }

    }

    // добавляет элемент в конец списка
    @Override
    public void add(int data) {
        size++;
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            last = first;
            return;
        }
        newNode.setPreviousNode(last);
        last.setNextNode(newNode);
        last = newNode;
    }

    @Override
    public void addAt(int index, int data) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node newNode = new Node(data);
        Node positionNode = getNodeAt(index); // нода, перед которой будем добавлять

        if (positionNode != null) {
            newNode.setPreviousNode(positionNode.getPreviousNode());
            if (positionNode.getPreviousNode() != null) {
                positionNode.getPreviousNode().setNextNode(newNode);
            } else {
                first = newNode;
            }
            positionNode.setPreviousNode(newNode);
            newNode.setNextNode(positionNode);
        }
        // добавляем в конец?
        else {
            last.setNextNode(newNode);
            newNode.setPreviousNode(last);
            last = newNode;
        }
        size++;
    }

    //удаляет первое вхождение элемента в список
    @Override
    public void remove(int data) {
        Node currentNode = first;
        while (currentNode != null) {
            if (currentNode.getData() == data) {
                size--;
                if (currentNode == first) {
                    currentNode.getNextNode().setPreviousNode(null);
                    first = currentNode.getNextNode();
                    return;
                }
                if (currentNode == last) {
                    currentNode.getPreviousNode().setNextNode(null);
                    last = currentNode.getPreviousNode();
                    return;
                }
                currentNode.getNextNode().setPreviousNode(currentNode.getPreviousNode());
                currentNode.getPreviousNode().setNextNode(currentNode.getNextNode());
                return;
            }
            currentNode = currentNode.getNextNode();
        }
    }

    @Override
    public void removeAt(int index) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        if (size > 0) {
            size--;
        } else {
            return;
        }
        Node positionNode = getNodeAt(index);

        if (positionNode == first) {
            positionNode.getNextNode().setPreviousNode(null);
            first = positionNode.getNextNode();
            return;
        }
        if (positionNode == last) {
            positionNode.getPreviousNode().setNextNode(null);
            last = positionNode.getPreviousNode();
            return;
        }
        positionNode.getPreviousNode().setNextNode(positionNode.getNextNode());
        positionNode.getNextNode().setPreviousNode(positionNode.getPreviousNode());
    }

    @Override
    public void set(int index, int data) {
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        Node positionNode = getNodeAt(index);
        positionNode.setData(data);
    }

    @Override
    public int get(int index) {
        if (index >= size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return getNodeAt(index).getData();
    }

    // удаляет все элементы, оставляет пустой список
    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public boolean contains(int data) {
        if (size == 0) {
            return false;
        }
        Node currentNode = first;
        while (true) {
            if (currentNode.getData() == data) {
                return true;
            }
            if (currentNode == last) {
                return false;
            }
            currentNode = currentNode.getNextNode();
        }

    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }
}
