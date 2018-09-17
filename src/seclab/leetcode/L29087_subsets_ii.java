package seclab.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/6/20
 * Time: 10:33
 * Description:
 * Given a collection of integers that might contain duplicates, S, return all possible subsets.
 * Note:
 * Elements in a subset must be in non-descending order.
 * The solution set must not contain duplicate subsets.
 * <p>
 * Solution:
 * 其实整个结果集就是一棵多叉树，树中的任意路径都是结果集的一个元素，只不过由于有重复的元素，可能不同的路径也会有相同的元素集合
 * 我们只需要在遍历之前把整个集合排序，遍历整棵树的时候只要前面的元素和我的一样，就不继续递归遍历这个分支，否则将当前路径添加进去，然后继续递归
 * 在回溯的时候，为了避免重复添加，需要把回溯的路径上的元素删除，也就是每次回溯删除结果集中最后一个即可
 */
public class L29087_subsets_ii {

    public static void main(String[] args) {
        L29087_subsets_ii subsets_ii = new L29087_subsets_ii();
        subsets_ii.subsetsWithDup(new int[]{1, 2, 2});
    }

    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        subsetsWithDupCore(num, 0, new ArrayList<>(), result);
        return result;
    }

    public void subsetsWithDupCore(int[] num, int current, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        // 首先将本次递归的路径添加进来（刚开始的时候就是根元素，空集）
        result.add(new ArrayList<>(path));

        // 然后递归遍历所有分支
        for (int i = current; i < num.length; i++) {
            // 如果当前所有的分支（各个分支的元素已排序）中，存在重复的，那么后面的分支产生的结果集肯定是重复的
            if (i > current && num[i] == num[i - 1]) { // i > current是为了避免i == current的时候造成的溢出，而且也没有必要比较 num[0] 和 num[-1]，不存在
                continue;
            }
            // 否则将当前分支根节点加入路径, 然后继续递归
            path.add(num[i]);
            subsetsWithDupCore(num, i + 1, path, result);
            // 回溯的时候记得删除路径中保存的节点
            path.remove(path.size() - 1);
        }
    }
}
