package logic;

import java.awt.Image;

/*
 * Queue class
 * Used in tandem with the LinkedList class, used to store and access user save data
 */


public interface Queue
{

   public boolean isEmpty();


   public Object remove();


   public boolean add(Object item);


   public boolean isFull();


}


