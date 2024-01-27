package logic;  

/*
 * Node class
 * Used in tandem with the LinkedList class, used to store and access user save data
 */

public class Node

{

   private Object data;
   private Node next;
		
// default constructor
   public Node ()
   {
      this (null, null);
   }

	// constructor with parameters

   public Node (Object data, Node next)
   {
      this.data = data;
      this.next = next;
   }
   public Node (Object data)
   {
      this.data = data;
      this.next = null;
   }

// mutator methods
   public void setData (Object data)
   {
      this.data = data;
   }


   public void setNext (Node next)
   {
      this.next = next;
   }

// accessor methods
   public Object getData ()
   {
      return data;
   }


   public Node getNext ()
   {
      return next;
   }
}