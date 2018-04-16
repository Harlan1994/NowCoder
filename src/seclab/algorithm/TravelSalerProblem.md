# 算法分析与实例

## 一、旅行售货员问题
### 1. 问题描述
某售货员要到若干城市去推销商品，已知各城市之间的路程（旅费），他要选定一条从驻地出发，经过每个城市一遍，最后回到驻地的路线，使总的路程（总旅费）最小。

### 2. 问题分析
旅行售货员问题的解空间是一颗排列树，需要递归遍历整棵树，寻找最佳路线。假设售货员选从某一个点出发，设为*1*号点，那么他的最后一个点必定是也是*1*号点，形成一条回路。假设中间某两个节点之间没有路径，那么这条路肯定行不通。从*1*号点开始寻找下一个可行节点，这些节点都是排列树中节点*1*的子节点，这样的话，我们就可以得到问题的排列树解空间。我们只需要遍历这个解空间，寻求最佳路线即可。
![图示](https://github.com/Harlan1994/NowCoder/blob/master/src/seclab/algorithm/travelsalerproblem)
### 3. 算法思路
当我们递归到第*n*个节点的时候，就是当前递归回溯的时候。这时候应该判断节点*n*和节点*n-1*以及节点*n*和节点*1*是否有路径，如果两条边都存在，那么就找到了一条可行的回路，此时再判断这条回路是否最佳。只需要和已经找到的回路的费用进行对比即可。如果对比下是当前最佳路线，则需要更新最佳路线费用值。

### 4. 剪枝优化
当发现当前路径还没形成回路时已经超过了当前最有路线的费用值，那么需要减去这条路线。

### 5. 关键代码
1). 初始化相关数据
```
int[][] matrix = new int[N][N] // N个节点的邻接矩阵，代表售货员需要去的各个点形成的路径图。
int[] bestx = new int[N] // 当前最优解
int cost = 0 // 当前费用
int bestc = 0 // 当前最优值
int INF = Integer.MAX_VALUE // 邻接矩阵中的值，表示节点之间没有路径
```
2). 回溯法求最优解
```
if(i == N) { // 如果递归到了最后一个节点
    if(matrix[N][N-1] != INF && matrix[N][1] != INF){ // 如果n节点和n-1节点以及n和1节点有路径
        if(bestc == 0 || cost + matrix[N-1][N] + matrix[N][1] < bestc){ // 如果当前bestc是0（还没有最优解），或者n节点和n-1节点以及n和1节点的路径费用加上当前的cost费用小于最优解
            bestc = cost + matrix[N-1][N] + matrix[N][1] // 更新当前最优解
            
            // 更新当前解
            for(int i = 1; i <= N; i++)bestx[i] = x[i]
        }
    }
}else{// 否则继续遍历子树
    ...
}
```
