
//////////////////// ALL ASSIGNMENTS INCLUDE THIS SECTION /////////////////////
//
// Title:           StorageUnitTests
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
 * This class checks the behavior of the methods in Class Box, LinkedBoxNode and
 * LinkedBoxList
 * 
 * @author Shihan.Cheng
 */
public class StorageUnitTests {

	/**
	 * Checks whether the behavior of equals method in Class Box is correct
	 * 
	 * @return true if test method detects a correct behavior of implemented
	 *         method and false otherwise
	 */
	public static boolean testBoxEquals() {
		// Create two new boxes with different color and weight
		Box box1 = new Box(39, 21);
		Box box2 = new Box(23, 14);
		// Check if the equals method returns false
		// If not, the method fails, test returns false
		if (box1.equals(box2) != false) {
			return false;
		}
		// Create tow more boxes with same color and weight
		Box box3 = new Box(30, 30);
		Box box4 = new Box(30, 30);
		// Check if the equals method returns true
		// If not, the method fails, test returns false
		if (box3.equals(box4) != true) {
			return false;
		}
		// Otherwise, return true
		return true;
	}

	/**
	 * Checks whether the behavior of compareTo method in Class Box is correctly
	 * implemented
	 * 
	 * @return true if test method detects a correct behavior of implemented
	 *         method and false otherwise
	 */
	public static boolean testBoxCompareTo() {
		// Create two new boxes with different color and weight
		Box box1 = new Box(39, 21);
		Box box2 = new Box(23, 14);
		// Create tow more boxes with same color and weight
		Box box3 = new Box(30, 30);
		Box box4 = new Box(30, 30);
		// Box1's weight is greater than box2's, the compareTo() should return 1
		if (box1.compareTo(box2) != 1) {
			// If the return value is not 1, method fails, return false
			System.out.println(
/////////////////////////////// 100 COLUMNS WIDE ///////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////
					"box1 is heavier than box2, expected return value should be 1, but it returns "
							+ box1.compareTo(box2));
			return false;
		}
		// Box2's weight is less than box1's, the compareTo() should return -1
		if (box2.compareTo(box1) != -1) {
			// If the return value is not -1, method fails, return false
			System.out.println(
					"box2 is lighter than box1, expected return value should be -1, but it returns "
							+ box2.compareTo(box1));
			return false;
		}
		// Box3 and box4 have same weight, the compareTO() should return 0
		if (box3.compareTo(box4) != 0) {
			// If the return value is not 0, method fails, return false
			System.out.println(
					"box3 is as heavey as box3, expected return value should be 0, but it returns "
							+ box3.compareTo(box4));
			return false;
		}
		// Otherwise, return true
		return true;
	}

	/**
	 * Checks whether the behavior of getNext() method in class LinkedBoxnode is
	 * correctly implemented
	 * 
	 * @return true if test method detects a correct behavior of implemented
	 *         method and false otherwise
	 */
	public static boolean testLinkedBoxNodeGetNext() {
		// Create three new boxes with different color and weight
		Box box1 = new Box(39, 21);
		Box box2 = new Box(23, 14);
		Box box3 = new Box(7, 17);
		// Use these three boxes as the parameters to create three LinkedBoxNode
		LinkedBoxNode boxNode2 = new LinkedBoxNode(box2);
		LinkedBoxNode boxNode1 = new LinkedBoxNode(box1, boxNode2); // boxNode1's
																	// next
																	// should be
																	// boxNode2
		LinkedBoxNode boxNode3 = new LinkedBoxNode(box3);
		boxNode2.setNext(boxNode3); // Then set boxNode2's next as boxNode3
		// boxNode1's next should be boxNode2
		if (!boxNode1.getNext().equals(boxNode2)) {
			System.out.println(
					"getnext() failed, boxNode1's next should be boxNode2.");
			return false;
		}
		// boxNode2's next should be boxNode3
		if (!boxNode2.getNext().equals(boxNode3)) {
			System.out.println(
					"getnext() failed, boxNode2's next should be boxNode3.");
			return false;
		}
		// Since boxNode3 is not followed by any BoxNode, its next should be
		// NULL
		if (boxNode3.getNext() != null) {
			System.out.println(
					"getnext() failed, boxNode3's next should be NULL.");
			return false;
		}
		// Otherwise, return true
		return true;
	}

	/**
	 * Checks whether the behavior of contains method in Class LinkedBoxList is
	 * correctly implemented
	 * 
	 * @return true if test method detects a correct behavior of implemented
	 *         method and false otherwise
	 */
	public static boolean testLinkedBoxListContains() {
		// Create a new LinkedBoxList
		LinkedBoxList list = new LinkedBoxList(30);
		// Create four new boxes with different color and weight
		Box box0 = new Box(39, 24);
		Box box1 = new Box(23, 20);
		Box box2 = new Box(7, 17);
		// Add them to list
		list.add(box0);
		list.add(box1);
		list.add(box2);
		// Check if the list contains all of them
		if (!list.contains(box0) || !list.contains(box1)
				|| !list.contains(box2)) {
			System.out.println("contains() fails.");
			return false;
		}
		return true;
	}

	/**
	 * Checks whether the behavior of add() method in Class LinkedBoxList is
	 * correctly implemented
	 * 
	 * @return true if test method detects a correct behavior of implemented
	 *         method and false otherwise
	 */
	public static boolean testLinkedBoxListAdd() {
		// Create a new LinkedBoxList
		LinkedBoxList list = new LinkedBoxList(30);
		// Create four new boxes with different color and weight
		Box box0 = new Box(39, 24);
		Box box1 = new Box(23, 20);
		Box box2 = new Box(7, 17);
		Box box3 = new Box(30, 10);
		Box box4 = new Box(11, 9);
		Box box5 = new Box(11, 9);
		Box box6 = new Box(10, 8);
		Box box7 = new Box(9, 7);
		Box box8 = new Box(16, 6);

		// Add them to list
		list.add(box8);
		list.add(box7);
		list.add(box6);
		list.add(box5);
		list.add(box4);
		list.add(box3);
		list.add(box2);
		list.add(box1);
		list.add(box0);

		System.out.println(list.toString());
		// Check if the index 0 is box0
		if (!list.get(0).equals(box0)) {
			System.out.println("Index 0 error, shoule be box0");
			return false;
		}
		// Check if the index 1 is box1
		if (!list.get(1).equals(box1)) {
			System.out.println("Index 1 error, shoule be box1");
			return false;
		}
		// Check if the index 2 is box2
		if (!list.get(2).equals(box2)) {
			System.out.println("Index 2 error, shoule be box2");
			return false;
		}
		// Check if the index 3 is box3
		if (!list.get(3).equals(box3)) {
			System.out.println("Index 3 error, shoule be box 3");
			return false;
		}
		// Check if the index 4 is box4
		if (!list.get(4).equals(box4)) {
			System.out.println("Index 4 error, shoule be box 4");
			return false;
		}
		if (list.size() != 9) {
			System.out.println("Size is " + list.size());
			return false;
		}
		// If no bug, return true
		return true;
	}

	/**
	 * Checks whether the behavior of remove() method in Class LinkedBoxList is
	 * correctly implemented
	 * 
	 * @return true if test method detects a correct behavior of implemented
	 *         method and false otherwise
	 */
	public static boolean testLinkedBoxListRemove() {
		// Create a new LinkedBoxList
		LinkedBoxList list = new LinkedBoxList(30);
		// Create four new boxes with different color and weight
		Box box0 = new Box(39, 24);
		Box box1 = new Box(23, 20);
		Box box2 = new Box(7, 17);
		Box box3 = new Box(30, 10);
		// Add them to list
		list.add(box0);
		list.add(box1);
		list.add(box2);
		list.add(box3);
		// Remove box2, the index 2 will be box3
		list.remove(2);
		if (!list.get(2).equals(box3)) {
			System.out.println("remove() fails, index 2 now should be box3.");
			return false;
		}
		// Remove box0, the index 0 will be box1
		list.remove(0);
		if (!list.get(0).equals(box1)) {
			System.out.println("remove() fails, index 0 now shold be box1.");
			return false;
		}
		// Remove box1 at index 0, then should return box1
		if (!list.remove(0).equals(box1)) {
			System.out.println(
					"remove() fails, box1 at index0 removed should return box1");
			return false;
		}
		// Remove the only element in the list
		list.remove(0);
		// Then list should be empty
		if (!list.isEmpty()) {
			System.out.println("remove() fails, list should be empty");
			return false;
		}
		// If no bug, return true
		return true;
	}

	/**
	 * Checks whether the behavior of clear() method in Class LinkedBoxList is
	 * correctly implemented
	 * 
	 * @return true if test method detects a correct behavior of implemented
	 *         method and false otherwise
	 */
	public static boolean testLindedBoxListClear() {
		// Create a new LinkedBoxList
		LinkedBoxList list = new LinkedBoxList(30);
		// Create four new boxes with different color and weight
		Box box0 = new Box(39, 24);
		Box box1 = new Box(23, 20);
		Box box2 = new Box(7, 17);
		Box box3 = new Box(30, 10);
		// Add them to list
		list.add(box0);
		list.add(box1);
		list.add(box2);
		list.add(box3);
		// Clear the list
		list.clear();
		// Then list should be empty
		if (!list.isEmpty()) {
			System.out.println(
					"clear() fails, the list should be empty. But the size is "
							+ list.size());
			System.out.println(list.contains(box0));
			System.out.println(list.contains(box1));
			System.out.println(list.contains(box2));
			System.out.println(list.contains(box3));
			return false;
		}
		// Otherwise, return true
		return true;
	}

	/**
	 * The main method is for calling all above test methods from Class Box,
	 * LinkedBoxNode and LinkedBoxList to test, and print the test results with
	 * the messages
	 * 
	 * @param arg Any type
	 */
	public static void main(String arg[]) {
		System.out.println("testBoxEquals(): " + testBoxEquals());
		System.out.println("testBoxCompareTo(): " + testBoxCompareTo());
		System.out.println(
				"testLinkedBoxNodeGetNext(): " + testLinkedBoxNodeGetNext());
		System.out.println(
				"testLinkedBoxListRemove(): " + testLinkedBoxListRemove());
		System.out.println("testLinkedBoxListAdd(): " + testLinkedBoxListAdd());
		System.out.println(
				"testLinkedBoxListContains(): " + testLinkedBoxListContains());
		System.out.println(
				"testLindedBoxListClear(): " + testLindedBoxListClear());

	}
}
