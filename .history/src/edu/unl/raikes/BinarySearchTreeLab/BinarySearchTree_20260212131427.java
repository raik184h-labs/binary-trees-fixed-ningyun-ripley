package edu.unl.raikes.BinarySearchTreeLab;

//TODO: ADD JAVADOC COMMENT
public class BinarySearchTree {
    boolean verbose = true;
    private BinarySearchNode root = null;
    private int size = 0;

    // TODO: ADD JAVADOC COMMENT
    public void insert(Person data) {
        boolean inserted = false;
        // TODO: ADD COMMENT
        if (this.root == null) {
            this.root = new BinarySearchNode(data);
            inserted = true;
        } // TODO: ADD COMMENT
        else {
            inserted = this.root.insert(data);
        } // TODO: ADD COMMENT
        if (inserted) {
            this.size++;
        }
    }

    // TODO: ADD JAVADOC COMMENT
    public Person search(int key) {
        // TODO: ADD COMMENT
        if (this.root == null) {
            return null;
        }
        // TODO: ADD COMMENT
        BinarySearchNode found = this.root.search(key);
        // TODO: ADD COMMENT
        if (found != null) {
            return found.person;
        } else {
            return null;
        }

    }

    // TODO: ADD JAVADOC COMMENT
    public Person delete(int key) {
        Person deleted = null;

        // TODO: ADD COMMENT
        if (this.root == null) {
            return null;
        } // TODO: ADD COMMENT
        else {
            // TODO: ADD COMMENT
            if (this.root.person.key == key) {
                // add fake root in case the element to be removed is the root.
                // (simplifies pointer logic)
                BinarySearchNode auxRoot = new BinarySearchNode(null);
                auxRoot.setLeftChild(this.root);
                // TODO: ADD COMMENT
                deleted = this.root.delete(key);
                // retrieve the root from the fake root (in case it changed)
                this.root = auxRoot.leftChild;
                // TODO: ADD COMMENT
                if (this.root != null)
                    this.root.parent = null;
            } // TODO: ADD COMMENT
            else {
                deleted = this.root.delete(key);
            } // TODO: ADD COMMENT
            if (deleted != null) {
                this.size--;
            }
            return deleted;
        }
    }

    // TODO: ADD JAVADOC COMMENT
    public String toString() {
        String toReturn = "Binary Search Tree of Size: " + this.size + "\n";
        // TODO: ADD COMMENT
        if (this.root != null) {
            toReturn += this.root.toString();
        }
        return toReturn;
    }

}
