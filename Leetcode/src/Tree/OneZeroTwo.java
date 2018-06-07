package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by 22787 on 2018/5/21.
 */
public class OneZeroTwo {
    public static void main(String[] args) {
        TreeNode q=new TreeNode(1);
        TreeNode w=new TreeNode(2);
        TreeNode e=new TreeNode(3);
        TreeNode r=new TreeNode(4);
        TreeNode t=new TreeNode(5);
        TreeNode y=new TreeNode(6);
        q.left=w;

        OneZeroTwo o=new OneZeroTwo();
        List<List<Integer>> ls=o.pathSum(q,1);
                  for (int i=0;i<ls.size();i++){
                      for (int k=0;k<ls.get(i).size();k++){
                          System.out.print(ls.get(i).get(k));
                      }
                  }
    }
      public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;

      TreeNode(int x) { val = x; }
  }public class TreeLinkNode {
     int val;
     TreeLinkNode left, right, next;
     TreeLinkNode(int x) { val = x; }
  }
    public void connect(TreeLinkNode root) {


        while (root!=null){
            TreeLinkNode var= root;
            while (var!=null){
                var.left.next=var.right;
                var.right=var.next.left;
                var=var.next;
            }root=root.left;
        }

    }

    List<List<Integer>> result =new ArrayList<List<Integer>>() ;
    public List<List<Integer>> pathSum(TreeNode root, int sum) {

           if(root==null){
            return result;
        }

           if(root.right==null&&root.left==null){
               if(root.val==sum){
                   List<Integer> ls=new ArrayList<>();
                   ls.add(root.val);
                   result.add(ls);
               }
               return result;
           }
           else {
               List<TreeNode>helplist =new ArrayList<>();
               helplist.add(root);
               help(helplist,sum-root.val,root);
               return  result;
           }

    }
    public void help(List<TreeNode> helplist,int num,TreeNode root){
        if(root.left==null&&root.right==null&&num==0){
            List<Integer> ls=new ArrayList<>();
            for(int i=0;i<helplist.size();i++){
                ls.add(helplist.get(i).val);
            }
            result.add(ls);
        }

        else {
            if(root.right!=null){
                List<TreeNode> Rlist =new ArrayList<>();
                Rlist.addAll(helplist);
                Rlist.add(root.right);

                help(Rlist,num-root.right.val,root.right);
            }
            if(root.left!=null){
                List<TreeNode> LList=new ArrayList<>();
                LList.addAll(helplist);
                LList.add(root.left);
                help(LList,num-root.left.val,root.left);
            }
        }
    }
}
