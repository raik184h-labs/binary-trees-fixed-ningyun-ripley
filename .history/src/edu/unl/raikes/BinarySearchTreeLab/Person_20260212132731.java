package edu.unl.raikes.BinarySearchTreeLab;

/**
 * Person class.
 */
public class Person implements Comparable<Person> {
    int key;
    String name;

    /**
     * Person constructor.
     * 
     * @param nuid NUID
     * @param name name
     */
    Person(int nuid, String name) {
        this.key = nuid;
        this.name = name;
    }

    /**
     * To string method.
     */
    public String toString() {
        return "NUID: " + this.key + "  Name: " + this.name;
    }

    /**
     * Compare to method.
     */
    public int compareTo(Person other) {
        return Integer.compare(this.key, other.key);
    }
}
