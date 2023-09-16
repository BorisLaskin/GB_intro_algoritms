package Task1;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class HashTable<Key, Value> {

    private static final int INITSIZE = 16;
    private ArrayList<Basket> baskets;

    private class Entity {
        private Key key;
        private Value value;
    }

    private class Node {
        private Node next;
        private Entity value;
    }

    private class Basket {
        private Node head;

        private void AddValue(Value value, Key key) {

            if (this.head.value == null) {
                this.head.value = new Entity();
                this.head.value.value = value;
                this.head.value.key = key;
            } else {
                Node newNode = new Node();
                newNode.value.value = value;
                newNode.value.key = key;
                head.next = newNode;
            }
        }

        private Value GetValue(Key key) {
            Node currentNode = head;
            do {
                if (currentNode.value.key == key) {
                    return currentNode.value.value;
                }
                currentNode = currentNode.next;
            } while (currentNode != null);

            return null;
        }

        private void DelValue(Key key) {
            if (GetValue(key) != null) {
                Node currentNode = head;
                boolean found = false;
                while (!found) {
                    if (currentNode.value.key == key) {
                        currentNode.next = currentNode.next.next;
                        found = true;
                    } else {
                        currentNode = currentNode.next;
                    }
                }
            }
        }
    }

    public HashTable() {
        this(INITSIZE);
    }

    public HashTable(int size) {
        baskets = new ArrayList<Basket>(size);
    }

    private int GetBasketIndex(Key key) {
        return key.hashCode() % baskets.size();
    }

    public Value GetValue(Key key) {
        int currentBasketIndex = GetBasketIndex(key);
        Basket currentBasket = baskets.get(currentBasketIndex);
        if (currentBasket != null) {
            return currentBasket.GetValue(key);
        }
        return null;
    }

    public void SetValue(Key key, Value value) {
        int currentBasketIndex = GetBasketIndex(key);
        if (GetValue(key) == null) {
            baskets.get(currentBasketIndex).AddValue(value, key);
        }
    }

    public void DelValue(Key key) {
        int currentBasketIndex = GetBasketIndex(key);
        baskets.get(currentBasketIndex).DelValue(key);
    }

    public void PrintALL() {
        StringBuilder sb = new StringBuilder();
        for (Basket currentBasket : baskets) {
            if (currentBasket != null) {
                Node currentNode = currentBasket.head;
                while (currentNode != null) {
                    sb.append(currentNode.value.key).append(" : ").append(currentNode.value.value).append("\t");
                    currentNode = currentNode.next;
                }
            }
        }
        System.out.println(sb.toString());
    }
}
