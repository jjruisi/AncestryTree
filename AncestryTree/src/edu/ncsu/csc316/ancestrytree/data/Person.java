package edu.ncsu.csc316.ancestrytree.data;

/**
 * Creates person entries for traversal files
 * @author John Ruisi
 *
 */
public class Person {

	//First name
	private String first;
	//Last name
	private String last;
	//Gender
	private String sex;
	
	/**
	 * Constructor for the person
	 * @param a the first name
	 * @param b the last name
	 * @param c the persons sex
	 */
	public Person(String a, String b, String c) {
		this.first = a;
		this.last = b;
		this.sex = c;
	}
	
	/**
	 * Gets the first name
	 * @return first the first name
	 */
	public String getFirst() {
		return first;
	}
	
	/**
	 * Gets the last name
	 * @return last the last name
	 */
	public String getLast() {
		return last;
	}
	
	/**
	 * Gets the sex
	 * @return sex the sex
	 */
	public String getSex() {
		return sex;
	}
	
	/**
	 * Gets the to string
	 */
	@Override
	public String toString() {
		return last + ", " + first;
	}

	/**
	 * Equals method to see if two persons are equal
	 */
	@Override
	public boolean equals(Object obj) {

		Person other = (Person) obj;
		if (first.equals(other.first) && last.equals(other.last)) {
			return true;
		}
		return false;
	}
}
