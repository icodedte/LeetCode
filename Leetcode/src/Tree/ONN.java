package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 22787 on 2018/5/26.
 */
public class ONN {
    public static void main(String[] args) {
        TreeNode q=new TreeNode(1);
        TreeNode w=new TreeNode(2);
        TreeNode e=new TreeNode(3);
        TreeNode r=new TreeNode(4);
        TreeNode t=new TreeNode(5);
        TreeNode y=new TreeNode(6);
        q.left=w;
        q.right=e;
        e.right=r;
        r.left=t;
        e.right=y;
        ONN o=new ONN();
        o.rightSideView(q);
        for (int i=0;i<o.list.size();i++){
            System.out.print(o.list.get(i));
        }

    }
    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    List<Integer> list=new ArrayList<>();

    public List<Integer> rightSideView(TreeNode root) {
        if(root==null){
            return list;
        }
        List<TreeNode> Tree=new ArrayList<>();
        Tree.add(root);
        help(Tree);
        return  list;
    }

    public void help(List<TreeNode> treeNodes){

        int sz=treeNodes.size();
        int val=treeNodes.get(sz-1).val;
        list.add(val);
        List<TreeNode> nes=new LinkedList<>();
        for(int i=0;i<sz;i++){
            if(treeNodes.get(i).left!=null){
                nes.add(treeNodes.get(i).left);
            }
            if(treeNodes.get(i).right!=null){
                nes.add(treeNodes.get(i).right);
            }
        }
        if(nes.size()!=0){
            help(nes);
        }

    }

}
