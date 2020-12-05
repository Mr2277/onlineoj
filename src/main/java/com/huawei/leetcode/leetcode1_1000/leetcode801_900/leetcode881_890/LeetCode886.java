package com.huawei.leetcode.leetcode1_1000.leetcode801_900.leetcode881_890;


import java.util.*;

public class LeetCode886 {
    /*
    public static boolean possibleBipartition(int N, int[][] dislikes) {
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new HashSet<>());
        }
        for (int[] edge : dislikes) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] colors = new int[N + 1];

        for (int i = 1; i < N + 1; i++){
            if (colors[i] != 0) {
                continue;
            }
            Queue<Integer> queue=new LinkedList<>();
            colors[i] = 1;
            queue.add(i);
            while (!queue.isEmpty()) {
                int curr = queue.poll();
                int color = colors[curr];
                int nextColor = color == 1 ? 2 : 1;
                for(int neighbor : graph.get(curr)) {
                    if(colors[neighbor] == 0) {
                        colors[neighbor] = nextColor;
                        queue.add(neighbor);
                    } else if (colors[neighbor] != nextColor) {
                        return false;
                    }
                }
            }
        }
        return true;

    }
    */
    /*
    public static boolean possibleBipartition(int N, int[][] dislikes) {
       Map<Integer, Set<Integer>> dislikeMap = new HashMap<>();
       for (int[] dis : dislikes) {
           if (!dislikeMap.containsKey(dis[0])) {
               Set<Integer> set = new HashSet<>();
               set.add(dis[1]);
               dislikeMap.put(dis[0], set);
           } else {
               Set<Integer> set = dislikeMap.get(dis[0]);
               set.add(dis[1]);
               dislikeMap.put(dis[0], set);
           }
       }
       int[] colors = new int[N];
       Iterator iterator = dislikeMap.entrySet().iterator();
       while (iterator.hasNext()) {
           Map.Entry entry = (Map.Entry) iterator.next();
           Integer key = (Integer) entry.getKey();
           Set<Integer> set = (Set<Integer>) entry.getValue();
           List<Integer> list = new ArrayList<>(set);
           int target = 0;
           if (colors[key -1] != 0) {
               target = colors[key - 1];
           }
           for (Integer integer : list) {
               if (colors[integer - 1] != 0) {
                   int flag = colors[integer - 1] == 1 ? 2 : 1;
                   if (target != 0 && target != flag) {
                       result = false;
                   }
                   if (target == 0) {
                       target = flag;
                   }
               }
           }
           if (colors[key - 1] == 0) {
               target = target == 0 ? 1 : target;
               dfs(dislikeMap, colors, target, key);
           }
       }
       return result;
    }
    public static boolean result = true;
    public static void dfs (Map<Integer, Set<Integer>> dislikeMap, int[] colors, int target, int cur) {
        if (colors[cur - 1] == 0) {
            colors[cur - 1] = target;
        } else if (colors[cur - 1] != target) {
            result = false;
        }
        if (dislikeMap.containsKey(cur)) {
            Set<Integer> set = dislikeMap.get(cur);
            Iterator iterator = set.iterator();
            while (iterator.hasNext()) {
                int nextTarget = target == 1 ? 2 : 1;
                int next = (int) iterator.next();
                if (colors[next - 1] == 0) {
                    dfs(dislikeMap, colors, nextTarget, next);
                } else if (colors[next - 1] != nextTarget) {
                    result = false;
                }
            }
        }
    }
    */
    /*
    private static final int UNCOLOR = 0;
    private static final int WHITE = 1;
    private static final int BLACK = 2;
    List<List<Integer>> relation;

    public boolean possibleBipartition(int N, int[][] dislikes) {

        this.relation = new ArrayList<>();
        for(int i=0;i<N;++i) relation.add(new ArrayList<>());

        int[] people = new int[N];
        Arrays.fill(people, UNCOLOR);

        for(int[] dislike: dislikes) {
            relation.get(dislike[0]-1).add(dislike[1]-1);
            relation.get(dislike[1]-1).add(dislike[0]-1);
        }

        for(int i=0;i<N;++i) {
            if(!dfs(i, people)) return false;
        }

        return true;
    }

    public boolean dfs(int person, int[] people) {
        if(people[person] == UNCOLOR) {
            people[person] = WHITE;
        }

        int dislike = people[person] == WHITE ? BLACK : WHITE;

        for(int p: relation.get(person)) {
            if(people[p] == UNCOLOR) {
                people[p] = dislike;
                if(!dfs(p, people)) return false;
            } else if(people[p] != dislike) {
                return false;
            }
        }

        return true;
    }
     */
    /*
    public static boolean result = true;

    public static boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> dislikesMap = new HashMap<>();
        for (int[] dis : dislikes) {
            if (!dislikesMap.containsKey(dis[0])) {
                List<Integer> list = new ArrayList<>();
                list.add(dis[1]);
                dislikesMap.put(dis[0], list);
            } else {
                List<Integer> list = dislikesMap.get(dis[0]);
                list.add(dis[1]);
                dislikesMap.put(dis[0], list);
            }
        }
        int[] colors = new int[N];
        int target = 0;
        for (Integer key : dislikesMap.keySet()) {
            if (colors[key -1] != 0) {
                target = colors[key - 1];
            }
            for (Integer integer : dislikesMap.get(key)) {
                if (colors[integer - 1] != 0) {
                    int flag = colors[integer - 1] == 1 ? 2 : 1;
                    if (target != 0 && target != flag) {
                        result = false;
                    }
                    if (target == 0) {
                        target = flag;
                    }
                }
            }
            if (colors[key - 1] == 0) {
                dfs(dislikesMap, colors, target, key);
            }
        }
        return result;
    }

    public static void dfs(Map<Integer, List<Integer>> map, int[] colors, int target, int cur) {
        if (colors[cur - 1] == 0) {
            colors[cur - 1] = target;
        } else if (colors[cur - 1] != target) {
            result = false;
        }
        if (map.containsKey(cur)) {
            List<Integer> list = map.get(cur);
            int nextTarget = target == 1 ? 2 : 1;
            for (Integer integer : list) {
                if (colors[integer - 1] == 0) {
                    dfs(map, colors, nextTarget, integer);
                } else if (colors[integer - 1] != nextTarget) {
                    result = false;
                }
            }
        }
    }
    */
    public void dfs (Map<Integer, List<Integer>> dislikeMap, int[] colors, int target, int cur) {
        if (colors[cur - 1] == 0) {
            colors[cur - 1] = target;
        } else if (colors[cur - 1] != target) {
            result = false;
        }
        if (dislikeMap.containsKey(cur)) {
            List<Integer> list = dislikeMap.get(cur);
            for (Integer integer : list) {
                int nextTarget = target == 1 ? 2 : 1;
                int next = integer;
                if (colors[next - 1] == 0) {
                    dfs(dislikeMap, colors, nextTarget, next);
                } else if (colors[next - 1] != nextTarget) {
                    result = false;
                }
            }
        }
    }


    public boolean result = true;

    public boolean possibleBipartition(int N, int[][] dislikes) {
        Map<Integer, List<Integer>> dislikeMap = new HashMap<>();
        for (int[] dis : dislikes) {
            if (!dislikeMap.containsKey(dis[0])) {
                List<Integer> list = new ArrayList<>();
                list.add(dis[1]);
                dislikeMap.put(dis[0], list);
            } else {
                List<Integer> list = dislikeMap.get(dis[0]);
                list.add(dis[1]);
                dislikeMap.put(dis[0], list);
            }
        }
        int[] colors = new int[N];
        for (Integer key : dislikeMap.keySet()) {
            List<Integer> list = dislikeMap.get(key);
            int target = 0;
            if (colors[key -1] != 0) {
                target = colors[key - 1];
            }
            for (Integer integer : list) {
                if (colors[integer - 1] != 0) {
                    int flag = colors[integer - 1] == 1 ? 2 : 1;
                    if (target != 0 && target != flag) {
                        result = false;
                    }
                    if (target == 0) {
                        target = flag;
                    }
                }
            }
            if (colors[key - 1] == 0) {
                dfs(dislikeMap, colors, target, key);
            }
        }
        return result;
    }



    public static void main(String[] args) {
        //int[][] dislikes = new int[][] {{1,2},{2,3},{3,4},{4,5},{1,5}};
        int[][] dislikes = new int[][] {{1,2},{1,3},{2,3}};
        new LeetCode886().possibleBipartition(3, dislikes);
    }
}
