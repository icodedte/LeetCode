package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 22787 on 2018/5/26.
 */
public class TTT {
    public static void main(String[] args) {
        List<List<Integer>> rooms=new ArrayList<>();
        List<Integer> room0=new ArrayList<>();
        List<Integer> room1=new ArrayList<>();
        List<Integer> room2=new ArrayList<>();
        List<Integer> room3=new ArrayList<>();
        room0.add(1);
        room0.add(3);
        room1.add(3);
        room1.add(0);
        room1.add(1);
        room2.add(2);
        room3.add(0);
        rooms.add(room0);
        rooms.add(room1);
        rooms.add(room2);
        rooms.add(room3);
        TTT t=new TTT();
        boolean f=t.canVisitAllRooms(rooms);
        System.out.print(f);
    }
    int a[] =new int[1005];
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {

        if(rooms==null){
            return false;
        }
        int c=rooms.size();

        for(int i=0;i<c;i++){
            a[i]=0;
        }
        a[0]=1;
        help(rooms,0);
        boolean flag=true;
        for(int i=0;i<c;i++){
            if(a[i]==0){
                flag=false;
            }
        }
        return  flag;
    }
    public void help(List<List<Integer>> rooms,int room){
           List<Integer> c=rooms.get(room);

           for (int i=0;i<c.size();i++){
               if(a[c.get(i)]==0&&c.get(i)!=room){
                   a[c.get(i)]=1;
                   help(rooms,c.get(i));
               }
           }

    }
}
