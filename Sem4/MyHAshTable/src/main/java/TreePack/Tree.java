package TreePack;

public class Tree<V extends Comparable<V>> {
    private Node root;

    private class Node {
        private V value;
        private Node left;
        private Node right;
        private boolean isBlack;

    }
    public void addValue(V value)
    {
        Node newNode = new Node();
        newNode.value = value;
        newNode.isBlack = false;
        if (root == null){
            newNode.isBlack = true;
            root = newNode;
        }
        else{
            Node parent = LastParent(value,root);
            if(value.compareTo(parent.value)<0)
                parent.left = newNode;
            else{
                parent.right = newNode;
            }
        }
    }
    private Node LastParent(V value, Node parent){
        if (parent.left == null && parent.right == null) {
            return parent;
        }
        else {
            Node nextParent;
            if (value.compareTo(parent.value)<0)
                nextParent = parent.left;
            else nextParent = parent.right;
            return LastParent(value, nextParent);
        }
    }
    public boolean contains(V value){
        Node node = root;
        while (node != null){
            if (node.value.equals(value)){
                return true;
            }
            if (node.value.compareTo(value) > 0) {
                node = node.left;
            }else {
                node = node.right;
            }
        }
        return false;
    }

}