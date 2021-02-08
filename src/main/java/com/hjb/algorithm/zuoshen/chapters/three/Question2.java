package com.hjb.algorithm.zuoshen.chapters.three;

/**
 * ClassName: Question2
 * Description:
 * Created by haojingbin on 2021/2/5 16:00
 *
 * @author haojingbin
 */
public class Question2 {

    private static class Node {
        private Node left;
        private Node right;
        private int value;

        Node(int value) {
            this.value = value;
        }
    }

    public static void printEdge1(Node head) {
        if (null == head) {
            return;
        }
        int height = getHeight(head, 0);
        Node[][] nodeMap = new Node[height][2];
        setEdge(head, nodeMap, 0);
        //打印左边界
        for (Node[] nodes : nodeMap) {
            System.out.println(nodes[0].value);
        }
        printLeafNodeNotInMap(head, nodeMap, 0);
        //倒序打印又边界（逆时针）
        for (int i = nodeMap.length - 1; i > -1; i--) {
            if (nodeMap[i][0] != nodeMap[i][1]) {
                System.out.println(nodeMap[i][1].value);
            }
        }

    }

    /**
     * 打印既不是最左节点又不是最优节点的叶子节点
     * create by: haojingbin
     * create time: 21-02-05 16:17:11
     *
     * @return
     */
    public static void printLeafNodeNotInMap(Node head, Node[][] nodeMap, int level) {
        if (null == head) {
            return;
        }
        if (null == head.left && null == head.right && head != nodeMap[level][0] && head != nodeMap[level][1]) {
            System.out.println(head.value);
        }
        printLeafNodeNotInMap(head.left, nodeMap, level + 1);
        printLeafNodeNotInMap(head.right, nodeMap, level + 1);
    }

    /**
     * 获取包含最左和最右节点的矩阵
     * create by: haojingbin
     * create time: 21-02-05 16:17:37
     *
     * @return
     */
    public static void setEdge(Node head, Node[][] nodeMap, int level) {
        if (null == head) {
            return;
        }
        nodeMap[level][0] = null == nodeMap[level][0] ? head : nodeMap[level][0];
        nodeMap[level][1] = head;
        setEdge(head.left, nodeMap, level + 1);
        setEdge(head.right, nodeMap, level + 1);
    }

    /**
     * 递归求树的高度
     * create by: haojingbin
     * create time: 21-02-05 16:05:38
     *
     * @return
     */
    public static int getHeight(Node head, int level) {
        if (null == head) {
            return level;
        }
        return Math.max(getHeight(head.left, level + 1), getHeight(head.right, level + 1));
    }


    public static void printEdge2(Node head) {
        // TODO: 2021/2/7
        System.out.println("tmd,题目都没看懂！");
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node l2 = new Node(2);
        Node r2 = new Node(3);
        head.left = l2;
        head.right = r2;
        Node l31 = new Node(4);
        Node m32 = new Node(5);
        Node r33 = new Node(6);
        l2.right = l31;
        r2.left = m32;
        r2.right = r33;
        Node l41 = new Node(7);
        Node m42 = new Node(8);
        Node m43 = new Node(9);
        Node r44 = new Node(10);
        l31.left = l41;
        l31.right = m42;
        m32.left = m43;
        m32.right = r44;
        Node l51 = new Node(11);
        Node r52 = new Node(12);
        m42.right = l51;
        m43.left = r52;
        Node l61 = new Node(13);
        Node m62 = new Node(14);
        Node m63 = new Node(15);
        Node r64 = new Node(16);
        l51.left = l61;
        l51.right = m62;
        r52.left = m63;
        r52.right = r64;
        printEdge1(head);
    }
}
