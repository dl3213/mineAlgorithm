

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveCu {
    
    public static void main(String[] args) {
        int[] coun={1,1,1,2,2,3,3,3,4,4,5,5,7,7};
        System.out.println(Arrays.toString(removeCu(coun, 3)));
    }

    public static int[] removeCu(int[] arr,int a){
        ArrayList list = new ArrayList();
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != a) list.add(arr[i]);
        }
        int[] res = new int[list!=null?list.size():0];
        for (int i = 0; i < res.length; i++) {
            res[i] = Integer.parseInt(list.get(i).toString());
        }
        
        return res;
    }
}