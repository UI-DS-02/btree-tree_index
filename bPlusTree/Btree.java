package bPlusTree;

import bPlusTree.Node;

class BPlusTree<K extends Comparable<K>, T> {

    public Node<K, T> root;
    public static final int D = 2;

    public T search(K key) {
        // Return if empty tree or key
        if(key == null || root == null) {
            return null;
        }
        // Look for leaf node that key is pointing to
        LeafNode<K,T> leaf = (LeafNode<K,T>)treeSearch(root, key);

        // Look for value in the leaf
        for(int i=0; i<leaf.keys.size(); i++) {
            if(key.compareTo(leaf.keys.get(i)) == 0) {
                return leaf.values.get(i);
            }
        }

        return null;
    }
    private Node<K,T> treeSearch(Node<K,T> node, K key) {
        if(node.isLeafNode) {
            return node;
        }
        // The node is index node
        else {
            IndexNode<K,T> index = (IndexNode<K,T>)node;

            // K < K1, return treeSearch(P0, K)
            if(key.compareTo(index.keys.get(0)) < 0) {
                return treeSearch((Node<K,T>)index.children.get(0), key);
            }
            // K >= Km, return treeSearch(Pm, K), m = #entries
            else if(key.compareTo(index.keys.get(node.keys.size()-1)) >= 0) {
                return treeSearch((Node<K,T>)index.children.get(index.children.size()-1), key);
            }
            // Find i such that Ki <= K < K(i+1), return treeSearch(Pi,K)
            else {
                // Linear searching
                for(int i=0; i<index.keys.size()-1; i++) {
                    if(key.compareTo(index.keys.get(i)) >= 0 && key.compareTo(index.keys.get(i+1)) < 0) {
                        return treeSearch((Node<K,T>)index.children.get(i+1), key);
                    }
                }
            }
            return null;
        }
    }
}
