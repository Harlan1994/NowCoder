package seclab.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/5/12
 * Time: 16:26
 * Description: 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * Solution: 为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
 * 1、两个堆中的数据数目差不能超过1，这样的话，当数据量为偶数，两个堆数量一样，中位数就是大顶堆和小顶堆的堆顶元素平均值
 * 如果是奇数，因为插入的时候默认先插入大顶堆，所以中位数就是大顶堆堆顶。
 * 2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
 * <p>
 * 一个大顶堆最大的数在堆顶，一个小顶堆最小的数在堆顶，如果小顶堆的数全部比大顶堆的大，那么小顶堆堆顶和大顶堆堆顶是在整个数据链的中间的。
 * <p>
 * 如何保证大小顶堆数目不超过1并且小顶堆的值大于大顶堆？要想不超过1，只需要一边插入一次即可。要想小顶堆大于大顶堆，则需要在偶数个的时候，
 * 判断是否可以插入大顶堆，不管是否可以插入，都要往小顶堆插入当前大顶堆最大的值，并在大顶堆删除该值
 * 奇数个的时候反回来就可以。这样往返，其实每次都是往小顶堆或者大顶堆插入一个值，只不过每次都保证了大顶堆的值小于小顶堆
 */
public class B11216 {

    public static void main(String[] args) {

    }

    private static int count = 0;
    private static PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private static PriorityQueue<Integer> maxHeap = new PriorityQueue<>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2.compareTo(o1);
        }
    });

    public static void Insert(Integer num) {
        count++;
        if ((count & 1) == 0) { // 数的个数为偶数的时候
            if (!maxHeap.isEmpty() && num < maxHeap.peek()) { // 如果num小于maxHeap的最大值，那么应该插入maxHeap中，并且为了平衡，每次插入一个要将其中一个移到minHeap中
                maxHeap.offer(num); // 插入一个元素
                num = maxHeap.poll(); // 取出队首并删除（最大的那个）
            }
            minHeap.offer(num); // 把它插入小顶堆
        } else {
            if (!minHeap.isEmpty() && num > minHeap.peek()) {
                minHeap.offer(num);
                num = minHeap.poll();
            }
            maxHeap.offer(num);
        }
    }

    public static Double GetMedian() {
        if (count == 0)
            throw new RuntimeException("no available number!");
        double result;
        //总数为奇数时，大顶堆堆顶就是中位数
        if ((count & 1) == 1)
            result = maxHeap.peek();
        else
            result = (minHeap.peek() + maxHeap.peek()) / 2.0;
        return result;
    }
}
