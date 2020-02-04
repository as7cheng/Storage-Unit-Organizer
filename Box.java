
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           Box
// Files:           None.
// Course:          Comp Sci 300, LEC-005, Spring 2019
//
// Author:          Shihan Cheng
// Email:           scheng93@wisc.edu
// Lecturer's Name: Mouna Kacem
//
//////////////////// PAIR PROGRAMMERS COMPLETE THIS SECTION ///////////////////
//
// Partner Name:    NA
// Partner Email:   NA
// Partner Lecturer's Name: NA
// 
// VERIFY THE FOLLOWING BY PLACING AN X NEXT TO EACH TRUE STATEMENT:
//   ___ Write-up states that pair programming is allowed for this assignment.
//   ___ We have both read and understand the course Pair Programming Policy.
//   ___ We have registered our team prior to the team registration deadline.
//
///////////////////////////// CREDIT OUTSIDE HELP /////////////////////////////
//
// Students who get help from sources other than their partner must fully 
// acknowledge and credit those sources of help here.  Instructors and TAs do 
// not need to be credited here, but tutors, friends, relatives, room mates, 
// strangers, and others do.  If you received no outside help from either type
//  of source, then please explicitly indicate NONE.
//
// Persons:         (identify each person and describe their help in detail)
// Online Sources:  (identify each URL and describe their assistance in detail)
//
/////////////////////////////// 80 COLUMNS WIDE ///////////////////////////////

import java.util.Random;

/**
 * This class models a box to be stored in a Storage Unit using our
 * StorageUnitOrganizer application.
 * 
 * @author Shihan.Cheng
 */
public class Box implements Comparable<Box> {
	// generator of random numbers for initializing this box's weight
	private static Random randGen = new Random();
	
	private int color; // color of this box
	private int weight; // weight of this box in lbs between
						// 1 inclusive and 31 exclusive

	/**
	 * Creates a new Box and initializes its instance fields color and weight to
	 * random values
	 */
	public Box() {
		// Constructor's initialization
		this.color = randGen.nextInt(); // Random color
		this.weight = randGen.nextInt(30) + 1; // Weight range is [1,30]

	}

	/**
	 * Creates a new Box and initializes its instance fields color and weight to
	 * the specified values. Throws IllegalArgumentException if the provided
	 * weight value is out of the range of [1..30]
	 * 
	 * @param color  Box object's color
	 * @param weight Box object's weight
	 */
	public Box(int color, int weight) {
		// Assign color to box object
		this.color = color;
		// If parameter weight is out of range [1,30]
		if (weight < 1 || weight > 30) {
			// Throw exception
			throw new IllegalArgumentException();
		} else { // If weight is within range, assign it to this weight
			this.weight = weight;
		}

	}

	/**
	 * Check if this box's color and weight equal object's when object is box
	 * 
	 * @return true If if the specified other object is a Box and this box and
	 *         other have the same color and same weight. Otherwise, it returns
	 *         false.
	 */
	@Override
	public boolean equals(Object other) {
		// Check if the object is Box
		if (other instanceof Box) {
			// If it is Box, get its color and weight
			int otherColor = ((Box) other).getColor();
			int otherWeight = ((Box) other).getWeight();
			// If their color and weight are totally same, return true
			if (this.color == otherColor && this.weight == otherWeight) {
				return true;
			}
		}
		// Otherwise, return false
		return false;
	}

	/**
	 * Compare this box's weight with the specific box
	 * 
	 * @return A negative integer, a positive integer, or zero as this box is
	 *         lighter than, heavier than, or has the same weight as the
	 *         specified otherBox.
	 */
	@Override
	public int compareTo(Box otherBox) {
		// Declare an integer as the return value
		int comparisonVal;
		// Compare their weight
		comparisonVal = ((Integer) this.weight).compareTo(otherBox.getWeight());
		// Return the value
		return comparisonVal;
	}

	/**
	 * Getter for the instance field color of this box
	 * 
	 * @return The color of this box
	 */
	public int getColor() {
		return this.color;
	}

	/**
	 * Getter for the instance field weight of this box
	 * 
	 * @return The weight of this box
	 */
	public int getWeight() {
		return this.weight;
	}

}
