package seclab.other;

import java.util.List;

/**
 * User: Harlan1994
 * Date: 2017/8/16
 * Time: 11:11
 * Description:
 */
public class UnionFindSet {

    private int union_find_set[];
    private int level[];
    private int capacity;

    public UnionFindSet(int capacity) {
        if (capacity < 1) throw new IllegalArgumentException("count cannot be less than 1");
        this.capacity = capacity;
        union_find_set = new int[capacity];
        level = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            union_find_set[i] = i; // 初始化为每个节点的父节点为自身，即每个节点单独为一棵树
            level[i] = 1; // 每棵树的高度初始化为1
        }
    }

    /**
     * 返回element所在集合的根节点
     *
     * @param element
     * @return
     */
    private int getRoot(int element) {
        int target = element;
        while (target != union_find_set[target]) {
            target = union_find_set[target];
        }
        return target;
    }

    /**
     * 将两个元素所在集合合并成一个集合
     * 通常需要判断两个集合是否已经在同一个集合
     * 只需要判断其根节点是否相同，相同则在同一集合
     *
     * @param elementA
     * @param elementB
     */
    private void union(int elementA, int elementB) {
        int rootA = getRoot(elementA);
        int rootB = getRoot(elementB);
        if (rootA == rootB) {
            return;
        }

        // 给定元素的根节点所代表的树越高，说明它离并查集的根节点越近
        // 如果将树高度低的那棵连接到高的那棵，则可以压缩路径，优化并查集
        if (level[rootA] > level[rootB]) {
            union_find_set[rootB] = rootA;
        } else {
            if(level[rootA] == level[rootB]){
                level[rootB]++;
            }
            union_find_set[rootA] = rootB;
        }
    }

    /**
     * 清除这个并查集
     */
    private void clear() {
        union_find_set = null;
        level = null;
    }
}