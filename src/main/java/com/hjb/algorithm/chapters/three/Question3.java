package com.hjb.algorithm.chapters.three;

/**
 * ClassName: Question3
 * Description:
 * Created by haojingbin on 2021/2/7 10:37
 *
 * @author haojingbin
 */
public class Question3 {
    private static class Node {
        private Node left;
        private Node right;
        private int value;

        public Node(int value) {
            this.value = value;
        }
    }

    public static void printTree(Node head) {
        printInOrder(head, 0, "H", 17);
    }

    /**
     * 右、中、左顺序遍历打印
     * create by: haojingbin
     * create time: 21-02-07 11:01:52
     *
     * @return
     */
    public static void printInOrder(Node head, int height, String label, int length) {
        if (null == head) {
            return;
        }
        printInOrder(head.right, height + 1, "v", length);
        String val = label + head.value + label;
        int lenL = (length - val.length()) / 2;
        int lenR = length - val.length() - lenL;
        val = getSpace(lenL) + val + getSpace(lenR);
        System.out.println();
        System.out.println(getSpace(height * length) + val);
        System.out.println();
        printInOrder(head.left, height + 1, "^", length);
    }

    public static String getSpace(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        Node l21 = new Node(2);
        Node r22 = new Node(3);
        head.left = l21;
        head.right = r22;
        Node l31 = new Node(4);
        Node m32 = new Node(5);
        Node r33 = new Node(6);
        l21.left = l31;
        r22.left = m32;
        r22.right = r33;
        Node l41 = new Node(7);
        l31.right = l41;
        printTree(head);
    }
}
