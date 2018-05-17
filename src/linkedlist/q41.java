package linkedlist;

/**
 * Created by Ravikanth on 4/27/2018.
 */
public class q41 {

    private void addTwoNumbers(Node n1, Node n2){
        if (n1 != null & n2 != null){
            int n1Length = length(n1);
            int n2Length = length(n2);

            Node l1 = n1Length >= n2Length ? n1 : n2;
            Node l2 = n1Length < n2Length ? n1 : n2;

            Node ans = new Node(0);

            int add = add(l1, l2, Math.max(n1Length, n2Length), Math.min(n1Length, n2Length), Math.max(n1Length, n2Length) - 1, Math.min(n1Length, n2Length) - 1, ans);

            Util.print(ans.next);
        }
    }


    private int add(Node n1, Node n2, int l1, int l2, int pos1, int pos2, Node prev){
        Node curr = new Node(0);
        int currTotal = 0;
        prev.next = curr;
        if (pos1 > pos2){
            curr.data = n1.data + add(n1.next, n2, l1, l2, pos1 - 1, pos2, curr);
        }else {

            if (pos1 == 0){
                currTotal = n1.data + n2.data;

            }else {
                currTotal = n1.data + n2.data + add(n1.next, n2.next, l1, l2, pos1 - 1, pos2 - 1, prev.next);
            }
            curr.data = currTotal % 10;
            return currTotal/10;
        }
        return 0;
    }

    public static void main(String[] args) {
        LinkedList list = LinkedList.create(new int[]{1, 2, 4, 5, 6, 1,  3});
        LinkedList list1 = LinkedList.create(new int[]{1, 2, 3});
        q41 test = new q41();
        test.addTwoNumbers(list.head, list1.head);
    }

    private int length(Node node){
        int l = 0;
        if (node == null) return 0;
        else {
            while (node != null){
                l++;
                node = node.next;
            }
        }
        return l;
    }
}
