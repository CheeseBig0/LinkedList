/*
Problem:  Write a program that keeps and manipulates a linked list of
	    String data. The data will be provided by the user one item at a time.
      The user should be able to do the following operations:
                     -add "String"
                                adds an item to your list (maintaining alphabetical order)
                     -remove "String"
                                if the item exists removes the first instance of it
                     -show
                                should display all items in the linked list
                     -clear
                               should clear the list
	Input:  commands listed above
	Output:  the results to the screen of each menu
	    choice, and error messages where appropriate.
*/
public class LinkedList{

  //instance variables go here (think about what you need to keep track of!)
  private int length = 0;
  private ListNode head;
  //constructors go here
  LinkedList() {
    head = null;
  }

  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been added and returned
  public ListNode addAValue(String line)
  {
    if(head == null) {
      head = new ListNode(line, null);
      length++;
      System.out.println("-set head-");
      return head;
    }
    
    //go through list until added next string is alphabetically after current
    ListNode spot = head;
    
    while(spot.getNext() != null) {
      //if the new value goes after current value
      if(spot.getValue().compareToIgnoreCase(line) < 0) {
        spot = spot.getNext();
      }
      else {
        //needs to insert without removing anything
        
        break;
      }
    }
    ListNode lastNode = new ListNode(line, null);
    spot.setNext(lastNode);
    length++;

    return lastNode;
  }
  
  //precondition: the list has been initialized
  //postcondition: the ListNode containing the appropriate value has been deleted and returned.
  //if the value is not in the list returns null
  public ListNode deleteAValue(String line)
  {
    return null;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String listValues = "";
    if(head == null) {
      return "empty";
    }
    
    ListNode spot = head;
    listValues += spot.getValue() + " ";
    while(spot.getNext() != null) {
      spot = spot.getNext();
      listValues += spot.getValue() + " ";
    }

    return ("List: " + listValues + " Size: " + length);
  }

  //precondition: the list has been initialized
  //postconditions: clears the list.
  public void clear()
  {
    head = null;
    length = 0;
    System.out.println("Cleared!");
  }
}
