package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Binary Search Node class.
 */
class BinarySearchNode {
    protected BinarySearchNode parent;
    protected BinarySearchNode leftChild;
    protected BinarySearchNode rightChild;
    protected Person person;

    /**
     * Person constructor.
     * 
     * @param person Person
     */
    BinarySearchNode(Person person) {
        this.person = person;
    }

    /**
     * Insert a person.
     * 
     * @param  data The person
     * @return      false if the person was already in the tree
     */
    boolean insert(Person data) {
        if (data == this.person) {
            return false;
        } else if (Integer.compare(data.key, this.person.key) < 0) {
            if (this.leftChild == null) {
                this.setLeftChild(new BinarySearchNode(data));
                return true;
            } else {
                return this.leftChild.insert(data);
            }
        } else if (Integer.compare(data.key, this.person.key) > 0) {
            if (this.rightChild == null) {
                this.setRightChild(new BinarySearchNode(data));
                return true;
            } else {
                return this.rightChild.insert(data);
            }
        }
        return false;
    }

    /**
     * Search for a given key.
     * 
     * @param  key The key to search for
     * @return     The node with the key
     */
    BinarySearchNode search(int key) {
        if (this.leftChild != null && Integer.compare(key, this.person.key) < 0) {
            return this.leftChild.search(key);
        } else if (this.rightChild != null && Integer.compare(key, this.person.key) > 0) {
            return this.rightChild.search(key);
        } else if (this.person.key == key) {
            return this;
        } else {
            return null;
        }
    }

    /**
     * Delete the node with the given key.
     * 
     * @param  key The key to delete
     * @return     The person deleted, null if they don't exist
     */
    Person delete(int key) {
        BinarySearchNode node = this.search(key);
        if (node == null) {
            return null;
        }
        Person deleted = node.person;
        if (node.leftChild == null && node.rightChild == null) {
            if (node.parent.leftChild == node) {
                node.parent.setLeftChild(null);
            } else if (node.parent.rightChild == node) {
                node.parent.setRightChild(null);
            }
        } else if (node.leftChild != null && node.rightChild != null) {
            BinarySearchNode min = node.rightChild.getNodeWithMinValue();
            node.person = min.person;
            int minKey = min.person.key;
            min.delete(minKey);
        } else if (node.parent.leftChild == node) {
            BinarySearchNode newLeftChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setLeftChild(newLeftChild);
        } else if (node.parent.rightChild == node) {
            BinarySearchNode newRightChild = (node.leftChild != null) ? node.leftChild : node.rightChild;
            node.parent.setRightChild(newRightChild);
        }

        return deleted;
    }

    // TODO: ADD JAVADOC COMMENT
    BinarySearchNode getNodeWithMinValue() {
        if (leftChild == null)
            return this;
        else
            return leftChild.getNodeWithMinValue();
    }

    // TODO: ADD JAVADOC COMMENT
    void setLeftChild(BinarySearchNode child) {
        this.leftChild = child;
        if (child != null) {
            child.parent = this;
        }
    }

    // TODO: ADD JAVADOC COMMENT
    void setRightChild(BinarySearchNode child) {
        this.rightChild = child;
        if (child != null) {
            child.parent = this;
        }
    }

    // TODO: ADD JAVADOC COMMENT (WHAT KIND OF SEARCH SHOULD THIS BE???)
    public String toString() {
        String toReturn = "";

        // TODO: ADD COMMENT
        toReturn += "  " + this.person.toString() + "\n";

        return toReturn;
    }

}
