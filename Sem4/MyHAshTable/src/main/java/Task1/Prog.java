package Task1;


public class Prog {
    public static void main(String[] args) {
        HashTable<Integer,Integer> table = new HashTable<>(10);
        table.PrintALL();
        table.SetValue(1,1);
        table.SetValue(2,2);
        table.SetValue(3,3);
        table.SetValue(4,4);
        table.SetValue(5,5);
        table.PrintALL();
    }
}
