package bPlusTree;

import javax.print.attribute.standard.MediaSizeName;
import java.util.ArrayList;

 class Node<K extends Comparable<K>, T> {
    protected boolean isLeafNode;
    protected ArrayList<K> keys;

    public boolean isOverflowed() {
        return keys.size() > 2 * BPlusTree.D;
    }

    public boolean isUnderflowed() {
        return keys.size() < BPlusTree.D;
    }

}