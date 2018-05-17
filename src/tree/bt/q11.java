package tree.bt;

/**
 * Created by Ravikanth on 5/11/2018.
 */
public class q11 {

    private void postOrfder(int[] inorder, int[] preorder) {
        StringBuilder sb = new StringBuilder();
        postorder(inorder, preorder, 0, inorder.length - 1, 0, preorder.length - 1, sb);

        System.out.println(sb.toString());
    }

    private void postorder(int[] I, int[] P, int il, int ir, int pl, int pr, StringBuilder sb) {
        if (isLegit(I, il, ir) && isLegit(P, pl, pr)) {
            int root = P[pl];
            int idx = find(I, il, ir, root);
            int L = idx - il;

            postorder(I, P, il, idx - 1, pl + 1, pl + L, sb);
            postorder(I, P, idx + 1, ir, pl + L + 1, pr, sb);

            sb.append(root).append(" ");
        }
    }


    private int find(int[] A, int l, int r, int root) {
        for (int i = l; i <= r; i++){
            if (A[i] == root) return i;
        }
        return -1;
    }

    private boolean isLegit(int[] A, int l, int r) {
        return l >= 0 && (l <= r);
    }

    public static void main(String[] args) {
        int in[] = {4, 2, 5, 1, 3, 6};
        int pre[] =  {1, 2, 4, 5, 3, 6};
        q11 test = new q11();
        test.postOrfder(in, pre);
    }
}
