package com.hjb.algorithm.zuoshen.chapters.three;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ClassName: Question4
 * Description:
 * Created by haojingbin on 2021/2/7 14:12
 *
 * @author haojingbin
 */
public class Question4 {

    private static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 前序遍历法序列化二叉树
     * create by: haojingbin
     * create time: 21-02-07 14:39:55
     *
     * @return
     */
    public static String serialByPre(Node head) {
        if (null == head) {
            return "#!";
        }
        String result = head.value + "!";
        result += serialByPre(head.left);
        result += serialByPre(head.right);
        return result;
    }

    /**
     * 前序遍历法反序列化二叉树
     * create by: haojingbin
     * create time: 21-02-07 14:40:21
     *
     * @return
     */
    public static Node revertTreeFromStrByPre(String str) {
        if (null == str) {
            return null;
        }
        String[] splits = str.split("!");
        Queue<String> queue = new LinkedList<String>();
        for (String split : splits) {
            queue.offer(split);
        }
        return reBuildPreOrder(queue);
    }

    public static Node reBuildPreOrder(Queue<String> queue) {
        String headStr = queue.poll();
        if ("#".equals(headStr)) {
            return null;
        }
        Node head = new Node(Integer.parseInt(headStr));
        head.left = reBuildPreOrder(queue);
        head.right = reBuildPreOrder(queue);
        return head;
    }

    /**
     * 层级遍历法序列化二叉树
     * create by: haojingbin
     * create time: 21-02-08 11:15:21
     *
     * @return
     */
    public static String serialByLevel(Node head) {
        if (null == head) {
            return "#!";
        }
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        StringBuilder result = new StringBuilder(head.value + "!");
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            if (null != cur.left) {
                result.append(cur.left.value).append("!");
                queue.offer(cur.left);
            } else {
                result.append("#!");
            }
            if (null != cur.right) {
                result.append(cur.right.value).append("!");
                queue.offer(cur.right);
            } else {
                result.append("#!");
            }
        }
        return result.toString();
    }

    /**
     * 层级遍历法反序列化二叉树
     * create by: haojingbin
     * create time: 21-02-08 11:15:35
     *
     * @return
     */
    public static Node revertTreeFromStrByLevel(String str) {
        String[] values = str.split("!");
        int index = 0;

        Node head = getNodeFromStr(values[index++]);
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(head);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            cur.left = getNodeFromStr(values[index++]);
            cur.right = getNodeFromStr(values[index++]);
            if (null != cur.left) {
                queue.offer(cur.left);
            }
            if (null != cur.right) {
                queue.offer(cur.right);
            }
        }
        return head;
    }

    public static Node getNodeFromStr(String str) {
        if ("#".equals(str)) {
            return null;
        }
        return new Node(Integer.parseInt(str));
    }


    public static void main(String[] args) {
        String str = "12!3!#!#!#!";
        Node head = revertTreeFromStrByPre(str);
        System.out.println(serialByPre(head));

        String str1 = "1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!";
        Node head1 = revertTreeFromStrByPre(str1);
        System.out.println(serialByPre(head1));


        String str2 = "12!3!#!#!#!";
        Node head2 = revertTreeFromStrByLevel(str2);
        System.out.println(serialByLevel(head2));

        String str3 = "1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!";
        Node head3 = revertTreeFromStrByLevel(str3);
        System.out.println(serialByLevel(head3));
    }
}
