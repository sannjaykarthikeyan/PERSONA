package logic;

import java.awt.*;

/*
 * ArrayQueue class
 * Used in tandem with the LinkedList class, used to store and access user save data
 */


   public class ArrayQueue implements Queue
   {
      Object q [];
      int capacity;
      int beginPos;
      int endPos;
   
      public ArrayQueue (int capacity)
      {
      
         this.capacity = capacity;
         q = new Object [capacity];
         beginPos = -1;
         endPos = -1;
      }
   
   
      public boolean isEmpty ()
      {
         if (beginPos == -1)
            return true;
         else
            return false;
      }
   
   
      public Object remove ()
      {
         Object temp;
         if (isEmpty ())
            return null;
         else
         {
            temp = q [beginPos];
            if (beginPos == endPos) // Only ONE Node 
            {
               beginPos = -1; // after removal, reset beginPos
               endPos = -1;
            }
            else
               beginPos = (beginPos + 1) % capacity;
            return temp;
         
         }
      }
   
   
      public boolean add (Object item)
      {
         System.out.println ("beginPos = " + beginPos + ";endPos = " + endPos);
         if (isFull ())
            return false;
         else
         {
            if (isEmpty ()) {
               beginPos++;
            }
            endPos = (endPos + 1) % capacity;
            q [endPos] = item;
            return true;
         }
      }
   
   
      public boolean isFull ()
      
      {
         if (((endPos + 1) % capacity) == beginPos)
            return true;
         else
            return false;
      }
   }


