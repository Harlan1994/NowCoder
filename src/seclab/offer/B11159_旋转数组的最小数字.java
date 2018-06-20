package seclab.offer;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/26
 * Time: 16:28
 * Description:
 */
public class B11159_旋转数组的最小数字 {

    public static void main(String[] args) {

    }

    /**
     * 最容易想到的最简单最笨的思路 Accepted
     *
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int[] array) {
        if (array == null) return 0;
        int length = array.length;
        if (length == 0) return 0;
        if (length == 1) return array[0];

        // 不能处理全部是从大到小的情况（貌似这也是一个旋转）
        for (int i = 0; i < length; i++) {
            if (array[i + 1] < array[i]) {
                return array[i + 1];
            }
        }
        // 如果找不到，也就是没发现后一个比前一个小的情况，那么肯定是因为没有旋转：1，2，3，4，5
        // 此时最小的是array[0]
        return array[0];
    }

    /**
     * 二分查找，二分查找的解空间是一颗二叉树
     * 这颗二叉树的特点是左孩子<根节点<右孩子
     * 所以如果发现不符合，那么右孩子肯定是这个要找的
     *
     * @param array
     * @param useless
     * @return
     */
    public int minNumberInRotateArray(int[] array, int useless) {
        int low = 0;

        if (array == null || array.length == 0) {
            return 0;
        }
        int high = array.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if (array[mid] > array[high]) {
                low = mid + 1;
            }else if(array[mid] == array[high]){

            }
        }
        return array[high];
    }
}
