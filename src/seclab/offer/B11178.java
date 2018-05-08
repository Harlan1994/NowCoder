package seclab.offer;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/4/17
 * Time: 13:56
 * Description:
 */
public class B11178 {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    public static void main(String[] args) {
        B11178 b = new B11178();

    }

    // 建立一个HashMap，键为被复制的节点，值为复制好的节点，一一对应，按next遍历，直到null
    public RandomListNode Clone(RandomListNode pHead) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode beCloned = pHead; // 被复制的节点
        RandomListNode q = new RandomListNode(-1); // 头节点

        while (beCloned != null) {
            // 新建复制的节点
            RandomListNode clone = new RandomListNode(beCloned.label);
            map.put(beCloned, clone);
            beCloned = beCloned.next;

            // 建立next关系
            q.next = clone;
            q = clone;
        }

        // 遍历map，建立random关系,同时需要键和值
        Set<Map.Entry<RandomListNode, RandomListNode>> entries = map.entrySet();
        Iterator<Map.Entry<RandomListNode, RandomListNode>> iterator = entries.iterator();
        while(iterator.hasNext()){
            Map.Entry<RandomListNode, RandomListNode> next = iterator.next();
            next.getValue().random = map.get(next.getKey().random);
        }

        return map.get(pHead);
    }
}
