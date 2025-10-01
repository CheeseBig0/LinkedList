/*
Luca Ostuni Lima 9/30/2025

This manages a linked list that can be modified by these methods:
add: puts in a value into the list and sorts it alphabetically, returns the value sorted
remove: deletes the first found specified value, returns the deleted value
clear: empties out the list
show: displays each node in the list and the length (also counted length for testing)

part2 stuff
reverse: reverses the whole list
nReverse: will only reverse the list up until the specified number

*/
public class LinkedList{

  //instance variables go here (think about what you need to keep track of!)
  private int length = 0;
  private ListNode head;
  //constructors go here
  LinkedList() {
    head = null;
  }

  //reverses list
  public ListNode reverse() {
    ListNode beforeSpot = null;
    ListNode spot = head;
    ListNode afterSpot = head.getNext();

    while(spot != null) {
      afterSpot = spot.getNext();

      spot.setNext(beforeSpot);
      beforeSpot = spot;
      spot = afterSpot;

      head = beforeSpot;
    }

    System.out.println("reversed!");
    return(null);
  }

  public ListNode nReverse(int n) {
    ListNode spot = head;
    int count = 1;
    
    while(count < n) {
      spot = spot.getNext();
      count++;
    }

    ListNode head2 = spot.getNext();
    spot.setNext(null); 

    //reverse code from earlier
    ListNode beforeSpot = null;
    ListNode current = head;
    ListNode afterSpot = head.getNext();

    while(current != null) {
      afterSpot = current.getNext();
      current.setNext(beforeSpot);
      beforeSpot = current;
      current = afterSpot;

      head = beforeSpot;
    }


    head = beforeSpot;
    spot = head;
    while(spot.getNext() != null) {
      spot = spot.getNext();
    }

    //combine 2 parts into one finally
    spot.setNext(head2);

    System.out.println("reversed only the first " + n);
    return null;
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

    //insert at the start of list
    if((head.getValue().compareToIgnoreCase(line) > 0)) {
        ListNode newHead = new ListNode(line, null);
        newHead.setNext(head);
        head = newHead;
        length++;
        return (newHead);
    }

    //go through list until added next string is alphabetically after current
    ListNode spot = head;
    
    while(spot.getNext() != null) {

      //if the new value goes after current value
      if(spot.getNext().getValue().compareToIgnoreCase(line) <= 0) {
        spot = spot.getNext();
      }
      else
      {
        //goes before, inserts
        ListNode insertedNode = new ListNode(line, null);
        insertedNode.setNext(spot.getNext());
        spot.setNext(insertedNode);
        length++;
        return insertedNode;
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
    ListNode spot = head;
    ListNode beforeSpot = null;

    if(head != null && head.getValue().equals(line) ) {
      ListNode oldhead = head;
      head = head.getNext();
      return oldhead;
    }

    while ((spot != null) && !(spot.getValue().equals(line))) {
      beforeSpot = spot;
      spot = spot.getNext();
    }

    //its not in the list
    if(spot == null) {
      System.out.println("Not in list");
      return (null);
    }

    //the previous node will set its next node to the one after the current one, so it removes the current one
    beforeSpot.setNext(spot.getNext());

    return spot;
  }

  //precondition: the list has been initialized
  //postconditions: returns a string containing all values appended together with spaces between.
  public String showValues()
  {
    String listValues = "";
    if(head == null) {
      return "empty";
    }
    int tempcount = 1;
    ListNode spot = head;
    listValues += spot.getValue() + " ";
    while(spot.getNext() != null) {
      tempcount += 1;
      spot = spot.getNext();
      listValues += spot.getValue() + " ";
    }

    return ("List: " + listValues + "  -Counted: " +tempcount+"- " + " --Length: " + length + "--");
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
