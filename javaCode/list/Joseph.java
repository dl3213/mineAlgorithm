package list;

public class Joseph<T> {
    
    public static void main(String[] args) {
        
        Node<Integer> first = null;
        Node<Integer> pre = null;

        for (int i = 1; i <= 41; i++) {
            if(i == 1){
                first = new Node<Integer>(i, null);
                pre = first;
                continue;
            }
            Node newNode = new Node<>(i, null);
            pre.next = newNode;
            pre = newNode;
            if(i==41){
                pre.next = first;
            }
        }
        
        int count = 0;
        Node<Integer> n = first;
        Node<Integer> b4 = null;
        while (n!=n.next) {
            count ++;
            if(count == 3){
                b4.next = n.next;
                System.out.print(" " + n.item);
                count = 0;
                n = n.next;
            }else{
                b4 = n;
                n = n.next;
            }
        }
        System.out.println(" " + n.item);
    }

    private static class Node<T>{
        public T item;
        public Node next;
        public Node (T item, Node next){
            this.item = item;
            this.next = next;
        }
    }
}
