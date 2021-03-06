package com.baidu.algorithm.basic_class_03;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 并查集：isSameSet() 和 union()
 */
public class Code_04_UnionFind {

    public static class Node {

    }

    public static class UnionFindSet {
        public Map<Node, Node> fatherMap; // key: child, value: father
        public Map<Node, Integer> sizeMap; // 某个节点所在的集合有多少个节点

        public UnionFindSet(List<Node> nodes) {
            fatherMap = new HashMap<>();
            sizeMap = new HashMap<>();
            makeSets(nodes);
        }

        private void makeSets(List<Node> nodes) {
            for (Node node : nodes) {
                fatherMap.put(node, node);
                sizeMap.put(node, 1);
            }
        }

        public Node findHead(Node node) {
            Node father  = fatherMap.get(node);
            if (father != node) {
                father = findHead(father);
            }
            fatherMap.put(node, father);
            return father;
        }

        public boolean isSameSet(Node a, Node b) {
            return findHead(a) == findHead(b);
        }

        public void union(Node a, Node b) {
            if (a == null || b == null) {
                return;
            }
            Node aHead = findHead(a);
            Node bHead = findHead(b);
            if (aHead != bHead) {
                int aSetSize= sizeMap.get(aHead);
                int bSetSize = sizeMap.get(bHead);
                if (aSetSize <= bSetSize) {
                    fatherMap.put(aHead, bHead);
                    sizeMap.put(bHead, aSetSize + bSetSize);
                } else {
                    fatherMap.put(bHead, aHead);
                    sizeMap.put(aHead, aSetSize + bSetSize);
                }
            }
        }
    }
}
