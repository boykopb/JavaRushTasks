package com.javarush.task.task20.task2028;

import java.io.Serializable;
import java.util.*;

/* 
Построй дерево(1)
*/
public class CustomTree extends AbstractList<String> implements Cloneable, Serializable {
    Entry<String> root;
    ArrayList<Entry<String>> tree;
    Stack<Entry<String>> removeStack = new Stack<>();

    public CustomTree() {
        this.root = new Entry<>("0");
        root.parent = null;
        this.tree = new ArrayList<>();
        tree.add(root);
        root.availableToAddLeftChildren = true;
        root.availableToAddRightChildren = true;

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
        if (!(o instanceof String))
            throw new UnsupportedOperationException();

        Entry<String> nodeRemove = null;
        String nodeRemoveName = (String) o;
        for (Entry<String> entry : tree) {
            if (entry.elementName.equals(nodeRemoveName)) {
                nodeRemove = entry;
                break;
            }
        }

        if (nodeRemove == null)
            return false;

        if (nodeRemove.leftChild != null) {
         //   System.out.println("<======= LEFT BRANCH DEEPER " + o);
            remove(nodeRemove.leftChild.elementName);
        }
        if (nodeRemove.rightChild != null) {
         //   System.out.println("=======>  RIGHT BRANCH DEEPER " + o);
            remove(nodeRemove.rightChild.elementName);

        }

        if (nodeRemove.parent.leftChild == nodeRemove) {
        //    System.out.println("LEFT CHILD IS NULL FOR " + nodeRemove.parent.elementName);
            nodeRemove.parent.availableToAddLeftChildren = true;
            nodeRemove.parent.leftChild = null;
        } else {
            nodeRemove.parent.rightChild = null;
            nodeRemove.parent.availableToAddRightChildren = true;
        //    System.out.println("RIGHT CHILD IS NULL FOR " + nodeRemove.parent.elementName);

        }
       // System.out.println("REMOVED " + nodeRemove.elementName);
        tree.remove(nodeRemove);

        return true;


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
