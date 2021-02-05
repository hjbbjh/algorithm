package com.hjb.algorithm.chapters.three;

import java.awt.print.Pageable;
import java.util.Stack;

/**
 * ClassName: Question1
 * Description:
 * Created by haojingbin on 2021/1/27 14:49
 *
 * @author haojingbin
 */
public class Question1 {

    private static class Node {
        private Node left;
        private Node right;
        private int value;

        Node(int value) {
            this.value = value;
        }
    }

    private static void preOrderReadDiGui(Node head) {
        if (null == head) {
            return;
        }
        System.out.println(head.value);
        preOrderReadDiGui(head.left);
        preOrderReadDiGui(head.right);
    }

    private static void preOrderReadNotDiGui(Node head) {
        if (null != head) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            while (!stack.isEmpty()) {
                Node cur = stack.pop();
                System.out.println(cur.value);
                if (null != cur.right) {
                    stack.add(cur.right);
                }
                if (null != cur.left) {
                    stack.add(cur.left);
                }
            }
        }
    }

    private static void middleOrderReadDiGui(Node head) {
        if (null == head) {
            return;
        }
        middleOrderReadDiGui(head.left);
        System.out.println(head.value);
        middleOrderReadDiGui(head.right);
    }

    private static void middleOrderReadNotDiGui(Node head) {
        if (null != head) {
            Stack<Node> stack = new Stack<Node>();
            Node cur = head;
            while (!stack.isEmpty() || null != cur) {
                if (null != cur) {
                    stack.add(cur);
                    cur = cur.left;
                } else {
                    cur = stack.pop();
                    System.out.println(cur.value);
                    cur = cur.right;
                }
            }
        }
    }

    private static void afterOrderReadDiGui(Node head) {
        if (null == head) {
            return;
        }
        afterOrderReadDiGui(head.left);
        afterOrderReadDiGui(head.right);
        System.out.println(head.value);
    }

    private static void afterOrderReadNotDiGui1(Node head) {
        if (null != head) {
            Stack<Node> stack1 = new Stack<Node>();
            Stack<Node> stack2 = new Stack<Node>();
            stack1.add(head);
            while (!stack1.isEmpty()) {
                Node top = stack1.pop();
                if (null != top.left) {
                    stack1.add(top.left);
                }
                if (null != top.right) {
                    stack1.add(top.right);
                }
                stack2.add(top);
            }
            while (!stack2.isEmpty()) {
                System.out.println(stack2.pop().value);
            }
        }
    }

    private static void afterOrderReadNotDiGui2(Node head) {
        if (null != head) {
            Stack<Node> stack = new Stack<Node>();
            stack.add(head);
            Node h = head;
            Node c = null;
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (null != c.left && c.left != h && c.right != h) {
                    stack.add(c.left);
                } else if (null != c.right && c.right != h) {
                    stack.add(c.right);
                } else {
                    System.out.println(stack.pop().value);
                    h = c;
                }
            }
        }
    }


    public static void main(String[] args) {
        Node head = new Node(1);
        Node left = new Node(2);
        Node right = new Node(3);
        head.left = left;
        head.right = right;
        left.left = new Node(4);
        left.right = new Node(5);
        right.left = new Node(6);
        right.right = new Node(7);

        System.out.println("digui ----------------- pre");
        preOrderReadDiGui(head);
        System.out.println("not digui ----------------- pre");
        preOrderReadNotDiGui(head);
        System.out.println("digui ----------------- middle");
        middleOrderReadDiGui(head);
        System.out.println("not digui ----------------- middle");
        middleOrderReadNotDiGui(head);
        System.out.println("digui ----------------- after");
        afterOrderReadDiGui(head);
        System.out.println("not digui 1 ----------------- after");
        afterOrderReadNotDiGui1(head);
        System.out.println("not digui 2 ----------------- after");
        afterOrderReadNotDiGui2(head);

    }


}
