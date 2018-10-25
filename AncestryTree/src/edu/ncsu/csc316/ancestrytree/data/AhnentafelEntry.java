package edu.ncsu.csc316.ancestrytree.data;

/**
 * This class stores entries from the ahnentafel list given by the user.
 * @author John Ruisi
 *
 */
public class AhnentafelEntry {

	//The anhen number
	private int num;
	//The first name
	private String first;
	//The last name
	private String last;
	//The persons father
	private AhnentafelEntry father;
	//The persons mother
	private AhnentafelEntry mother;
	
	/**
	 * Creates an AhnentafelEntry object
	 * @param a the ahnen number
	 * @param b the first name
	 * @param c the last name
	 */
	public AhnentafelEntry(int a, String b, String c) {
		this.num = a;
		this.first = b;
		this.last = c;
		this.father = null;
		this.mother = null;
	}
	
	/**
	 * Gets the entries father
	 * @return father the father
	 */
	public AhnentafelEntry getFather() {
		return father;
	}
	
	/**
	 * Sets the entries father
	 * @param a the father
	 */
	public void setFather(AhnentafelEntry a) {
		this.father = a;
	}
	
	/**
	 * Gets the entries mother
	 * @return mother the mother
	 */
	public AhnentafelEntry getMother() {
		return mother;
	}
	
	/**
	 * Sets the mother
	 * @param a the mother
	 */
	public void setMother(AhnentafelEntry a) {
		this.mother = a;
	}
	
	/**
	 * Gets the number
	 * @return num the number
	 */
	public int getNum() {
		return num;
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
	 * Gets the to string
	 */
	@Override
	public String toString() {
		return last + ", " + first;
	}
}
