package TreePack;

import org.w3c.dom.Node;

import java.text.Format;
import java.util.ArrayList;
import java.util.Formatter;

public class Tree<V extends Comparable<V>> {
    private Node root;

    private class Node {

        private V value;
        private Node left;
        private Node right;
        private Node parent;
        private boolean isBlack;
        private int Hight;

        private Node() {
            this.isBlack = false;
            this.Hight = 1;
        }

        private Node(V value) {
            this.isBlack = false;
            this.Hight = 1;
            this.value = value;
        }

        private void setToBlack() {
            this.isBlack = true;
        }

        private void setToRed() {
            this.isBlack = false;
        }
    }

    public void addValue(V value) {
        Node newNode = new Node(value);
        if (root == null) {
            newNode.setToBlack();
            root = newNode;
        } else {
            recursiveAdd(value, newNode, root);
        }
    }

    private boolean recursiveAdd(V value, Node insert, Node current) {
        if (current == null) {
            return true;
        } else if (value.compareTo(current.value) < 0) {
            if (recursiveAdd(value, insert, current.left)) {
                current.left = insert;
            }
        } else {
            if (recursiveAdd(value, insert, current.right)) {
                current.right = insert;
            }
        }
        current.Hight += 1;
        return false;
    }

    public boolean contains(V value) {
        Node node = root;
        while (node != null) {
            if (node.value.equals(value)) {
                return true;
            }
            if (node.value.compareTo(value) > 0) {
                node = node.left;
            } else {
                node = node.right;
            }
        }
        return false;
    }

    private ArrayList<Node> getALLItems() {
        ArrayList<Node> items = new ArrayList<>();
        items.add(root);
        int powderCount = 1;
        int nullItemCount = 0;
        int arrayCounter = 0;
        int itemsByLevel = 0;
        while (nullItemCount != Math.pow(2, powderCount)) {
            Node currentNode = items.get(arrayCounter);
            if (currentNode != null) {
                nullItemCount = 0;
                items.add(currentNode.left);
                items.add(currentNode.right);
            } else {
                items.add(null);
                items.add(null);
                nullItemCount++;
            }
            arrayCounter++;
            itemsByLevel++;
            if (itemsByLevel == Math.pow(2, powderCount)&&nullItemCount < Math.pow(2, powderCount)) {
                itemsByLevel = 0;
                nullItemCount = 0;
                powderCount++;
            }
        }
        for (int i = items.size()-1; i >(arrayCounter-nullItemCount) ; i--) {
            items.remove(i);
        }
        return items;
    }

    public void Print() {
        StringAlignUtils util = new StringAlignUtils(30, StringAlignUtils.Alignment.CENTER);
        ArrayList<Node> items = getALLItems();
        int powderCount = 0;
        int arrayCounter = 0;
        int itemsByLevel = 0;
        StringBuilder sb = new StringBuilder();
        while (arrayCounter < items.size()) {
            Node node = items.get(arrayCounter);
            if (node != null) sb.append(items.get(arrayCounter).value.toString());
            else sb.append("_");
            arrayCounter++;
            itemsByLevel++;
            if (itemsByLevel == Math.pow(2, powderCount)) {
                itemsByLevel = 0;
                powderCount++;
                String message = sb.toString();
                System.out.println(util.format(message));
                sb = new StringBuilder();
            } else sb.append(" ");
        }
    }
}