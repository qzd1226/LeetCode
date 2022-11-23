package UnionFind;

import org.junit.jupiter.api.Test;

public class UnionFIndTest {
    @Test
    public void UnionFIndTest01(){
        int n = 6;
        int[][] connections = {{0,1},{0,2},{0,3},{1,2},{1,3}};
        UnionFind uf = new UnionFind(n);
        if(connections.length < n - 1){
            System.out.println(-1);
        }else{
            uf.init();
            for(int i = 0; i < connections.length; i++){
                uf.merge(connections[i][0],connections[i][1]);
            }
            System.out.println(uf.scatter - 1);
        }


    }
}
