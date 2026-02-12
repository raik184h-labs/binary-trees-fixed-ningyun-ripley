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
     * @param NUID NUID
     * @param name name
     */
    Person(int NUID, String name) {
        this.key = NUID;
        this.name = name;
    }

    // TODO: ADD JAVADOC COMMENT
    public String toString() {
        return "NUID: " + this.key + "  Name: " + this.name;
    }

    // TODO: ADD JAVADOC COMMENT
    public int compareTo(Person other) {
        return Integer.compare(this.key, other.key);
    }
}
