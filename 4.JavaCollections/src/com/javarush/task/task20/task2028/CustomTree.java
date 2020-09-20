package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    ArrayList<Entry<String>> tree;

    public CustomTree() {
        this.root = new Entry<>("0");
        root.parent = null;
        this.tree = new ArrayList<>();
        tree.add(root);

    }


    @Override
    public String get(int index) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int size() {
        return tree.size() - 1;
    }


    public String set(int index, String element) {
        throw new UnsupportedOperationException();

    }

    public void add(int index, String element) {
        throw new UnsupportedOperationException();

    }

    public String remove(int index) {
        throw new UnsupportedOperationException();

    }

    public List<String> subList(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();

    }

    protected void removeRange(int fromIndex, int toIndex) {
        throw new UnsupportedOperationException();

    }

    public boolean addAll(int index, Collection<? extends String> c) {
        throw new UnsupportedOperationException();

    }


    @Override
    public boolean add(String s) {
        Entry<String> newEntry = new Entry<>(s);

        for (int i = 0; i < tree.size(); i++) {
            Entry<String> currentNode = tree.get(i);
            if (currentNode.isAvailableToAddChildren()) {
                if (currentNode.availableToAddLeftChildren) {
                    currentNode.leftChild = newEntry;
                    currentNode.availableToAddLeftChildren = false;
                    tree.add(newEntry);
                    newEntry.parent = currentNode;
                    break;
                }
                if (currentNode.availableToAddRightChildren) {
                    currentNode.rightChild = newEntry;
                    currentNode.availableToAddRightChildren = false;
                    tree.add(newEntry);
                    newEntry.parent = currentNode;
                    break;
                }

            }
        }
        return true;
    }

    public String getParent(String s) {

        String parentName = null;
        for (Entry<String> currentNode : tree) {
            if (currentNode == null) {
                return null;
            }

            if (currentNode.elementName.equals(s)) {
                parentName = currentNode.parent.elementName;
                break;
            }
        }
        return parentName;
    }


    public boolean remove(Object o) {
        boolean isNodeRemoved = false;
      /*  if (!(o instanceof String)) {
            throw new UnsupportedOperationException();
        }*/


        for (int i = 0; i < tree.size(); i++) {
            Entry<String> currentNode = tree.get(i);
            if (currentNode.elementName.equals(o)) {
                if (currentNode.leftChild != null) {
                    remove(currentNode.leftChild);
                }
                if (currentNode.rightChild != null) {
                    remove(currentNode.rightChild);
                }

                if (currentNode.rightChild == null && currentNode.leftChild == null) {
                    tree.remove(currentNode);
                    isNodeRemoved = true;
                    break;
                }
            }

        }

        return isNodeRemoved;
    }


    static class Entry<T> implements Serializable {
        String elementName;
        boolean availableToAddLeftChildren;
        boolean availableToAddRightChildren;
        Entry<T> parent;
        Entry<T> leftChild;
        Entry<T> rightChild;


        public Entry(String elementName) {
            this.elementName = elementName;
            this.availableToAddLeftChildren = true;
            this.availableToAddRightChildren = true;
        }

        public boolean isAvailableToAddChildren() {
            return availableToAddLeftChildren | availableToAddRightChildren;
        }
    }


}
