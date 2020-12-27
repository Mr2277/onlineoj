package com.huawei.leetcode.leetcode1_1000.leetcode701_800.leetcode781_790;

import java.util.*;

public class LeetCode787 {
    static class Location {
       int airport;
       int transfer;
       int costs;
       Location(int airport, int transfer, int costs) {
           this.airport = airport;
           this.transfer = transfer;
           this.costs = costs;
       }
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K)
    {
        int[][] g = new int[n][n];//记录的是目的地
        for(int[] f : flights)
        {
            g[f[0]][f[1]] = f[2];
        }

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b)->a[0] - b[0]);
        //集合的参数是一个comparator的lambda表达式，默认升序
        heap.offer(new int[]{0, src, K + 1});//想集合添加一个记录费用、起点和中转站+1的数组
        //K + 1是还可以走过站点的个数

        while(!heap.isEmpty())//数组为空直接返回-1
        {
            int[] cur = heap.poll();//得到集合当中添加的数组
            int price = cur[0], place = cur[1], remainStops = cur[2];

            if(place == dst)//起点等于v中点
                return price;//返回0费用0

            if(remainStops > 0)//中转次数》0（至少执行一次，因为remain====k+1）
            {
                for(int i = 0; i < n; i++)//小于城市数量
                {
                    if(g[place][i] > 0)//表示起点----终点的中转路线是否存在
                    {
                        heap.offer(new int[]{price + g[place][i], i, remainStops - 1});
                        //如果存在 计算路费、起点的值、中转站-1
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {


        /*
        int[][] edges = new int[][] {
                {4, 1, 1},
                {1, 2, 3},
                {0, 3, 2},
                {0, 4, 10},
                {3, 1, 1},
                {1, 4, 3}
        };
        new LeetCode787().findCheapestPrice(5, edges, 2, 1, 1);
        */
        //4 [[0,1,1],[0,2,5],[1,2,1],[2,3,1]] 0 3 1
        int[][] edges = new int[][] {
                {0, 1, 1},
                {0, 2, 5},
                {1, 2, 1},
                {2, 3, 1}
        };
        new LeetCode787().findCheapestPrice(4, edges, 0, 3, 1);
    }
}
