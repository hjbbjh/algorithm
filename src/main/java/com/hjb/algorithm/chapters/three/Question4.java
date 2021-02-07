package com.hjb.algorithm.chapters.three;

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
    public static Node revertTreeFromStr(String str) {
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

    public static void main(String[] args) {
        String str = "12!3!#!#!#!";
        Node head = revertTreeFromStr(str);
        System.out.println(serialByPre(head));

        String str1 = "1!2!4!#!#!5!#!#!3!6!#!#!7!#!#!";
        Node head1 = revertTreeFromStr(str1);
        System.out.println(serialByPre(head1));
    }
}
