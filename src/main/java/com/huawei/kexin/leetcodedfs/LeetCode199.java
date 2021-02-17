package com.huawei.kexin.leetcodedfs;

import com.huawei.kexin.util.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode199 {

    public List<Integer> list = new ArrayList<>();

    public Set<Integer> set = new HashSet<>();

    public List<Integer> rightSideView(TreeNode root) {
        dfs(root, 0);
        return list;
    }

    public List<Integer> dfs(TreeNode root, int deepth) {
        if (root == null) {
            return list;
        }
        if (!set.contains(deepth)) {
            set.add(deepth);
            list.add(root.val);
        }
        dfs(root.right, deepth + 1);
        dfs(root.left, deepth + 1);
        return list;
    }

    public static void main(String[] args) {
        //String str = "1(2(#,5),3(#,4))";
        String str = "1(2(4,#),3)";
        TreeNode root = TreeNode.create(str);
        List<Integer> res = new LeetCode199().rightSideView(root);
        System.out.println(res.size());
        System.out.println(res.size());
    }
}
