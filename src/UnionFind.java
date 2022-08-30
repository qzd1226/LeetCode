import java.util.Arrays;

public class UnionFind {
    int[] parent;
    int[] rank;
    int n;
    int scatter;
    public UnionFind(int n){
        this.n = n;
        this.scatter = n;
    }
    public void init(){
        this.parent = new int[n];
        this.rank = new int[n];
        for(int i = 0; i < n; i++){
            this.parent[i] = i;
        }
        Arrays.fill(this.rank,1);
    }
    public int find(int x){
        if(parent[x] == x){
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }
    public void merge(int x, int y){
        int px = find(x);
        int py = find(y);
        if(px == py){
            return;
        }else{
            scatter --;
            if(rank[parent[px]] > rank[parent[py]]){
                rank[parent[px]] = rank[parent[px]] + rank[parent[py]];
                parent[py] = parent[px];
                return;
            }else{
                rank[parent[py]] = rank[parent[py]] + rank[parent[px]];
                parent[px] = parent[py];
                return;
            }
        }
    }
}
