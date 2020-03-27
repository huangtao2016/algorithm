
package com.baidu.algorithm.basic_class_03;

/**
 * 已知一个二叉树增加了父节点，给定任意一节点，求其后继节点。
 * 后继节点：中序序列中节点的下一个节点称之为后继节点。
 */
public class Code_03_SuccessorNode {

    public static class Node {
        public int value;
        public Node left;
        public Node right;
        public Node parent;

        public Node(int value) {
            this.value = value;
        }
    }

    /**
     * 找某一节点的后继节点，有几个边界条件
     * 1）如果该节点有右子树，就是代码中第一个if
     * 2）如果该节点没用右子树，则其后继节点肯定在某一层的父节点
     * 所以，只需找到有没有右子树就可以覆盖所有情况。
     *
     * @param node
     * @return
     */
    public static Node getSuccessorNode(Node node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        } else {
            Node parent = node.parent;
            while (parent != null && parent.left != node) {
                node = parent;
                parent = node.parent;
            }
            return parent;
        }
    }

    public static Node getLeftMost(Node node) {
        if (node.left == null) {
            return node;
        } else {
            return getLeftMost(node.left);
        }
    }
}
