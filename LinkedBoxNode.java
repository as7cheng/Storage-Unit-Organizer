//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           LinkedBoxNode
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

/**
 * This class models a linked node in our application
 * 
 * @author Shihan.Cheng
 */
public class LinkedBoxNode {

	private Box box; // box that represents the data for this Linked node
	private LinkedBoxNode next; // reference to the next Linked Box Node

	/**
	 * Constructor, creates a new LinkedBoxNode object with a given box and
	 * without referring to any next LinkedBoxNode
	 * 
	 * @param box
	 */
	public LinkedBoxNode(Box box) {
		this.box = box;
		this.next = null;
	} 

	/**
	 * Constructor, creates a new LinkedBoxNode object and sets its instance
	 * fields box and next to the specified ones
	 * 
	 * @param box
	 * @param next
	 */
	public LinkedBoxNode(Box box, LinkedBoxNode next) {
		this.box = box;
		this.next = next;
	}

	// getters and setters methods
	/**
	 * Getter for instance of LinkedBoxNode
	 * 
	 * @return this next
	 */
	public LinkedBoxNode getNext() {
		return this.next;
	}
	
	/**
	 * Setter for setting next
	 * @param next The next which is set to this next
	 */
	public void setNext(LinkedBoxNode next) {
		this.next = next;
	}
	
	/**
	 * Getter for instance of LinkedBoxNode
	 * 
	 * @return this box
	 */
	public Box getBox() {
		return this.box;
	}
	
	/**
	 * Setter for setting box
	 * @param next The box which is set to this box
	 */
	public void setBox(Box box) {
		this.box = box;
	}

}
