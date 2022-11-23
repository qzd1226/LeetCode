package UnionFind;

public class LC323 {
    static int components;
    public static void main(String[] args) {
        components = 0;
        int count = 3;
        int[][] edgs = {{0, 1}, {1, 2}};
        countComponents(count,edgs);
        System.out.println("ans:" + components);

    }
    public static int countComponents(int n, int[][] edges) {
        if(n <= 1){
            return n;
        }
        components = n;
        int[] degree = new int[n];
        int[] parents = new int[n];
        for(int i = 0; i < degree.length; i++){
            degree[i] = 1;
        }
        for(int i = 0; i < parents.length; i++){
            parents[i] = i;
        }
        for(int i = 0; i < edges.length; i++){
            int x = edges[i][0];
            int y = edges[i][1];
            merge(degree,parents,x,y);
        }
        return components;
    }
    public static int getParents(int[] parents, int child){
        System.out.println("child:" + child);
        System.out.println("child parents:" + parents[child]);
        if(parents[child] == child){
            return child;
        }
        parents[child] = getParents(parents, parents[child]);
        return parents[child];
    }
    public static void merge(int[] degree, int[] parents, int x, int y){
        int px = getParents(parents, x);
        int py = getParents(parents, y);
        if(px == py){
            return;
        }else{
            components --;
            if(degree[px] >= degree[py]){
                degree[parents[px]] = degree[parents[px]] + degree[parents[py]];
                parents[py] = parents[px];
                return;
            }else{
                degree[parents[py]] = degree[parents[py]] + degree[parents[px]];
                parents[px] = parents[py];
            }
        }
    }
}
