package TreePack;

public class Prog {
    public static void main(String[] args) {
        Tree<Integer> mineTree = new Tree<>();
        mineTree.addValue(2);
        mineTree.addValue(4);
        mineTree.addValue(6);
        mineTree.addValue(1);
        System.out.println(mineTree.contains(4));
        System.out.println(mineTree.contains(6));
        System.out.println(mineTree.contains(1));
        System.out.println(mineTree.contains(2));
        System.out.println(mineTree.contains(3));
        mineTree.Print();
    }
}
