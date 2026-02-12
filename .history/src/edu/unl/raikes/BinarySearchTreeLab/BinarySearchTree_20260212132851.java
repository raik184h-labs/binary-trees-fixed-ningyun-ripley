package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Binary Search Tree class.
 */
public class BinarySearchTree {
    boolean verbose = true;
    private BinarySearchNode root = null;
    private int size = 0;

    /**
     * Insert a person.
     * 
     * @param data The person
     */
    public void insert(Person data) {
        boolean inserted = false;
        if (this.root == null) {
            this.root = new BinarySearchNode(data);
            inserted = true;
        } else {
            inserted = this.root.insert(data);
        }
        if (inserted) {
            this.size++;
        }
    }

    /**
     * Find a person with a given key.
     * 
     * @param  key The key of the person to find.
     * @return     The person with the given key, null if they don't exist
     */
    public Person search(int key) {
        if (this.root == null) {
            return null;
        }
        BinarySearchNode found = this.root.search(key);
        if (found != null) {
            return found.person;
        } else {
            return null;
        }

    }

    /**
     * Delete a person with a given key.
     * 
     * @param  key The key
     * @return     The person deleted, null if they don't exist
     */
    public Person delete(int key) {
        Person deleted = null;

        if (this.root == null) {
            return null;
        } else {
            if (this.root.person.key == key) {
                // add fake root in case the element to be removed is the root.
                // (simplifies pointer logic)
                BinarySearchNode auxRoot = new BinarySearchNode(null);
                auxRoot.setLeftChild(this.root);
                deleted = this.root.delete(key);
                // retrieve the root from the fake root (in case it changed)
                this.root = auxRoot.leftChild;
                if (this.root != null) {
                    this.root.parent = null;
                }
            } else {
                deleted = this.root.delete(key);
            }
            if (deleted != null) {
                this.size--;
            }
            return deleted;
        }
    }

    /**
     * To string method.
     */
    public String toString() {
        String toReturn = "Binary Search Tree of Size: " + this.size + "\n";
        if (this.root != null) {
            if (this.root.leftChild != null) {
                toReturn += this.root.leftChild.toString();
            }
            toReturn += this.root.toString();
            if (this.root.leftChild != null) {
                toReturn += this.root.leftChild.toString();
            }
        }
        return toReturn;
    }

}
