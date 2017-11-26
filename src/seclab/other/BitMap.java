package seclab.other;

import java.util.BitSet;

/**
 * User: Harlan1994
 * Date: 2017/8/9
 * Time: 10:13
 * Description: 一台主机，2G内存，40亿个不重复的没排过序的unsigned int的整数的文件，然后再给一个整数，
 * 如何快速判断这个整数是否在那40亿个数当中？
 *
 * solution: 用bitmap算法，因为40亿个不同的数字，文件大小超过40亿*4/(1024*1024*1024) = 14.9G
 * 直接加载进内存不实际。声明长度为1亿的byte，byte[一亿]，那么它就可以保存8亿个数，如果声明为char或者int型
 * 那么就可以保存4*8=32亿个数
 * 40亿个不同的数需要 4,000,000,000个bit位，那么就需要4,000,000,000 / 4 / 8 =
 */
public class BitMap {

    BitSet bitSet = new BitSet(2000000000);

}