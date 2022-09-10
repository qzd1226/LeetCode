import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.*;
public class listTest {
    @Test
    public void listTest01(){
        List<Integer> t = new LinkedList<>();
        for(int i = 0; i < 10; i++){
            t.add(i);
        }
        int size = t.size();
        for(int i = 0; i < t.size(); i++){
            int cur = (int)t.get(i);
            if(cur  == 3){
                t.remove(i);
            }
        }
        System.out.println("size:" + t.size());
        for(int i = 0; i < t.size(); i++){
            System.out.println(t.get(i));
        }

    }

}
