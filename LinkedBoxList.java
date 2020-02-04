//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           LinkedBoxList
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
 * This class models a dynamic list to store box objects sorted in a descendant
 * order with respect to their weights
 * 
 * @author Shihan.Cheng
 */
public class LinkedBoxList {

	private LinkedBoxNode head; // head of this LinkedBoxList (refers to the
								// element stored at index 0 within this list)
	private int size; // number of boxes already stored in this list
	private int capacity; // capacity of this LinkedBoxList
							// maximum number of box elements that this
							// LinkedBoxList can store

	/**
	 * Creates an empty LinkedBoxList with a given initial capacity
	 * 
	 * @param capacity capacity of this LinkedBoxList
	 */
	public LinkedBoxList(int capacity) {
		this.head = null; // Head is null due to list is empty
		this.capacity = capacity;// capacity of this LinkedBoxList
									// maximum number of box elements that this
									// LinkedBoxList can store
		this.size = 0; // number of boxes already stored in this list
	}

	/**
	 * Getter for the size of this list
	 * 
	 * @return the size of this list
	 */
	public int size() {
		return this.size;
	}

	/**
	 * Getter for the capacity of this list
	 * 
	 * @return the capacity of this list
	 */
	public int getCapacity() {
		return this.capacity;
	}

	/**
	 * Expands the capacity of this LinkedBoxList with the specified number a of
	 * additional elements
	 * 
	 * @param a The amount of capacity to expand
	 */
	public void expandCapacity(int a) {
		this.capacity += a;
	}

	/**
	 * Checks whether this LinkedBoxList is empty
	 * 
	 * @return true if this LinkedBoxList is empty, false otherwise
	 */
	public boolean isEmpty() {
		// When current size is 0, list is empty
		if (this.size == 0 && this.head == null) {
			return true;
		}
		// If size is not 0, return false
		return false;
	}

	/**
	 * Checks whether this LinkedBoxList is full
	 * 
	 * @return true if this list is full, false otherwise
	 */
	public boolean isFull() {
		// When current size is equal or greater than capacity
		// this list is full
		if (size >= capacity) {
			return true;
		}
		// If this list is not full, return false
		return false;
	}

	/**
	 * Adds a new box into this sorted list
	 * 
	 * @param newBox the box needed to add
	 * @throws IllegalArgumentException if newBox is null
	 * @throws IllegalStateExceptionif  this list is full
	 */
	public void add(Box newBox)
			throws IllegalArgumentException, IllegalStateException {
		// When newBox is null or this list is full
		// Throw exceptions
		if (newBox == null) {
			throw new IllegalArgumentException();
		}
		if (isFull()) {
			throw new IllegalStateException();
		}

		// Declare three LinkedBoxNodes to store data for tracking this list
		LinkedBoxNode checkBefore = this.head; // Assign head to checkBefore
		LinkedBoxNode checkAfter;
		LinkedBoxNode cur;
		int count = this.size; // For storing this size

		// Start with checking head of this list
		// If this list is empty, add newBox to the head
		if (isEmpty()) {
			this.head = new LinkedBoxNode(newBox);
			this.size += 1;
		} else if (this.head.getBox().compareTo(newBox) <= 0) {
			// When this list is not empty, compare head with newBox
			// If head's weight is lighter than or equal to newBox
			// Add newBox to head and set original head to newBox's next
			// This size increases by 1
			this.head = new LinkedBoxNode(newBox);
			this.head.setNext(checkBefore);
			this.size += 1;
		} else { // When head is heavier than newBox
			// If the size increases by 1, loop ends
			while (this.size != count + 1) {
				// Check its next
				// Assign checkBefore's next to checkAfter
				checkAfter = checkBefore.getNext();
				// When its next does not exist
				// Set newBox to its next
				// This size increases by 1
				if (checkAfter == null) {
					checkBefore.setNext(new LinkedBoxNode(newBox));
					this.size += 1;
				} else if (checkAfter.getBox().compareTo(newBox) <= 0) {
					// If its next is lighter or equals to newBox
					// Insert newBox into this list
					// Set newBox to its next
					// Set the original next to newBox's next
					// This size increases by 1
					cur = new LinkedBoxNode(newBox);
					cur.setNext(checkAfter);
					checkBefore.setNext(cur);
					this.size += 1;
				} else { // If its next is heavier than newBox
					// Move to its next's next
					checkBefore = checkAfter.getNext();
					// If its next's next is null
					// Insert newBox to the end of this list
					// This size increases by 1
					if (checkBefore == null) {
						checkAfter.setNext(new LinkedBoxNode(newBox));
						this.size += 1;
					}
					// If it's not null, begin the loop again
				}

			}
		}

	}

	/**
	 * Checks if this list contains a box that matches with (equals) a specific
	 * box object
	 * 
	 * @param findBox The specific box object to find
	 * @return true if this list contains findBox, false otherwise
	 */
	public boolean contains(Box findBox) {
		// Declare a LinkedBoxNode assigned with this head
		LinkedBoxNode check = this.head;
		// Start tracking
		while (check != null) {
			// If the checked one's box data equals findBox
			// Then this list contains findBox
			if (check.getBox().equals(findBox)) {
				return true;
			}
			// If the checked one does not equal findBox
			// Check next one
			check = check.getNext();
		}
		// If no element matches findBox, return false
		return false;
	}

	/**
	 * Find a specific box stored in this list by provided index
	 * 
	 * @param index The index of the specific box
	 * @return A box stored in this list given its index
	 * @throws IndexOutOfBoundsException if index is out of the range 0..size-1
	 */
	public Box get(int index) throws IndexOutOfBoundsException {
		// If index is out of the range, throw new exception
		if (index < 0 || index >= this.size) {
			throw new IndexOutOfBoundsException();
		}
		// Start checking with this head
		LinkedBoxNode check = this.head;
		Box box = check.getBox();
		// Until i in loop reaches index - 1
		for (int i = 0; i < index; i++) {
			check = check.getNext(); 
			box = check.getBox();
		}
		// Then return the box with specific index
		return box;
	}

	/**
	 * Removes a box stored at index from this LinkedBoxList
	 * 
	 * @param index Index of the LinkedBoxNode needs to be removed
	 * @return the box data of the LinkedBoxNode needs to be removed
	 * @throws IndexOutOfBoundsException if index is out of bounds. index should
	 *                                   be in the range of [0.. size()-1]
	 */
	public Box remove(int index) throws IndexOutOfBoundsException {
		// Declare a LinkedBoxNode and its box data
		LinkedBoxNode check = this.head;
		Box box = this.head.getBox();
		// If index is out of bounds, throw new exception
		if (index < 0 || index > this.size - 1) {
			throw new IndexOutOfBoundsException();
		}
		// If the index of the LinkedBoxNode is 0
		if (index == 0) {
			// If this list only contains one element
			// Just set head to null
			// Then the list is empty
			// This list's size is 0
			// Return head's box data
			if (this.size == 1) {
				this.head = null;
				this.size -= 1;
				return box;
			}
			// If this list's size is greater than 1
			// Set head to the original head's next
			// Size decreases by 1
			// Return head's box data
			this.head = this.head.getNext();
			this.size -= 1;
			return check.getBox();
		} else { // If index != 0, create a loop for reaching the target index
			for (int i = 0; i < index; i++) {
				// When i = index - 1, the check's next is the element we want
				// to remove form this list
				// Then set check's next as the box's next
				// This size decreases by 1
				if (i == index - 1) {
					box = check.getBox();
					check.setNext(check.getNext().getNext());
					this.size -= 1;
				}
				// If the loop has not reached the index, check moves to its
				// next
				check = check.getNext();
			}
		}
		// Return the box data of the LinkedBoxNode at the provided index
		return box;
	}

	/**
	 * Removes all the boxes from this list
	 */
	public void clear() {
		// Run the loop for checking every index of this list
		// Due to the list is sorted from heavy to light, every remove() will
		// resort the list if we choose from index 0 to start
		// So we start remove from the tail of the list
		for (int i = size - 1; i > -1; i--) {
			remove(i);
		}
	}

	/**
	 * String representation of the state and content of this LinkedBoxList
	 * 
	 * @return a String representation for this LinkedBoxList
	 */
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(); // creates a StringBuilder
													// object
		String newLine = System.getProperty("line.separator");
		result.append(
				"------------------------------------------------" + newLine);
		if (!isEmpty()) {
			LinkedBoxNode runner = head;
			int index = 0;
			// traverse the list and add a String representation for each box
			while (runner != null) {
				result.insert(0, "Box at index " + index + ": "
						+ runner.getBox().getWeight() + " lbs" + newLine);
				runner = runner.getNext();
				index++;
			}
			result.insert(0, "Box List Content:" + newLine);
		}
		result.insert(0, "List size: " + size + " box(es)." + newLine);
		result.insert(0, "Box List is empty: " + isEmpty() + newLine);
		result.insert(0,
				"------------------------------------------------" + newLine);
		return result.toString();
	}
}
