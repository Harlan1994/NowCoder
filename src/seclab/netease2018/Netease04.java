package seclab.netease2018;

import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: harlan
 * Date: 2018/8/11
 * Time: 12:56
 * Description:
 */
public class Netease04 {

    public static void main(String[] args) {
        Netease04 netease04 = new Netease04();
        netease04.test();

    }

    public void test() {
        Scanner scanner = new Scanner(System.in);
        int time, uptime;
        int[] xingqu, qingxing;

        time = scanner.nextInt();
        uptime = scanner.nextInt();

        xingqu = new int[time];
        qingxing = new int[time];

        int[] sumOfStep = new int[time * 2];

        for (int i = 0; i < time; i++) {
            xingqu[i] = scanner.nextInt();
            sumOfStep[i + 1] = xingqu[i] + sumOfStep[i];
        }

        long now = 0;
        for (int i = 0; i < time; i++) {
            qingxing[i] = scanner.nextInt();
            if (qingxing[i] == 1) {
                now += xingqu[i];
            }
        }
        int[] up = new int[time];
        for (int i = 0; i <= time - uptime; i++) {
            up[i] = sumOfStep[uptime + i] - sumOfStep[i];
            for (int j = 0; j < uptime; j++) {
                if(qingxing[i + j] == 1) {
                    up[i] = up[i] - xingqu[i + j];
                }
            }
        }
        int maxResult = 0;
        for(int i = 0; i < up.length; i++){
            if(maxResult < up[i]){
                maxResult = up[i];
            }
        }
        System.out.println(maxResult + now);
    }
}

/*
#include <iostream>
#include <algorithm>
using namespace std;

int main() {

    int time,uptime;
    long long sum[100006];
    long long now=0;
    long long up[100006];
    int qingxing[100006];
    int xingqu[100006];
    cin>>time>>uptime;
    sum[0] = 0;

    //读入每个兴趣点的兴趣值，存入的时候用sum把兴趣点所有都求和
    for(int i = 0; i < time; i++){
        cin>>xingqu[i];
        sum[i+1]=xingqu[i]+sum[i];

    }

    //读入清醒的时间，把当前的清醒时间所带来的兴趣值总和
    for(int i = 0; i < time; i++){
        cin>>qingxing[i];
        if(qingxing[i]==1){
            now=now+xingqu[i];
        }
    }

    //枚举每个点所带来的收益
    for(int i = 0; i <= time-uptime; i++){
        up[i] = sum[uptime+i]-sum[i];
        for(int j = 0; j < uptime; j++){
            if(qingxing[i+j]==1){
                up[i]=up[i]-xingqu[i+j];
            }
        }
    }
//    排序收益
    sort(up,up+time-uptime+1);

    //得到最大收益
    cout<<up[time-uptime]+now;

    return 0;


}

 */
