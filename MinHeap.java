/**
 *  File: MinHeap.java
 *  Date: March 16, 2016
 *  Purpose: CSCI 2110, Lab 5 Solution
 *  
 *  Description: This program modifies heap class.
 */
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * @author Li Jingwei and Sesh Venugopal
 * This is the MinHeap class implementing the modification.
 * @param <T> Type of data stored in the heap, must implement method compareTo of
 * 				generic Comparable<T> interface, to compare priorities.
 */
public class MinHeap<T extends Comparable<T>> {

	/**
	 * Stores the heap items.
	 */
	ArrayList<T> items;
	
	/**
	 * Maintains iteration point. 
	 */
	int cursor;
	
	/**
	 * Initializes a new instance by setting up storage of given capacity.
	 * 
	 * @param cap Initial storage capacity.
	 */
	public MinHeap(int cap) {
		items = new ArrayList<T>(cap);
		cursor = -1;
	}
	
	/**
	 * Initializes a new instance by setting up storage of default initial capacity. 
	 */
	public MinHeap() {
		items = new ArrayList<T>();
		cursor = -1;
	}
	
	/**
	 * Sifts up the item at the given index.
	 * 
	 * @param index Index of item to be sifted up.
	 */
	void siftUp(int index) {
		T me = items.get(index);
		while (index > 0) {
			int pindex = (index-1) / 2;
			T myparent = items.get(pindex);
			if (me.compareTo(myparent) < 0) {
				items.set(index, myparent);
				index = pindex;
			}
			else break;
		}
		items.set(index, me);
	}
	
	/**
	 * Sifts down the item at the given item.
	 * 
	 * @param index Index of item to be sifted down.
	 */
	void siftDown(int index) {
		T me = items.get(index);
		int lindex = 2*index + 1;
		while (lindex < items.size()) {
			T minChild = items.get(lindex);
			int minIndex = lindex;
			
			int rindex = lindex + 1;
			if (rindex < items.size()) {
				T rightChild = items.get(rindex);
				if (rightChild.compareTo(minChild) < 0) {
					minChild = rightChild;
					minIndex = rindex;
				}
			}
			
			if (minChild.compareTo(me) < 0) {
				items.set(index, minChild);
				index = minIndex;
				lindex = 2*index + 1;
			}
			else break;
		}
		items.set(index, me);
	}
	
	/**
	 * Adds the given item to this heap.
	 * 
	 * @param item Item to be added.
	 */
	public void add(T item) {
		items.add(item);
		siftUp(items.size()-1);
	}
	
	/**
	 * Removes the minimum-priority (top) item of this heap.
	 * 
	 * @return Removed item.
	 * @throws NoSuchElementException If this heap is empty.
	 */
	public T deleteMin() {
		if (items.isEmpty()) {
			throw new NoSuchElementException();
		}
		
		T minItem = items.get(0);
		T lastItem = items.remove(items.size()-1);
		
		if (items.isEmpty()) {
			return minItem;
		}
		
		// move last item to vacant spot at top,and sift down 
		items.set(0, lastItem);
		siftDown(0);
		
		return minItem;
	}
	
	/**
	 * Empties this heap by removing all items. 
	 */
	public void clear() {
		items.clear();
	}
	
	/**
	 * Returns the number of items in this heap.
	 * 
	 * @return Number of items in this heap.
	 */
	public int size() {
		return items.size();
	}
	
	/**
	 * Tells whether this heap is empty or not.
	 * 
	 * @return True if this heap is empty, false otherwise.
	 */
	public boolean isEmpty() {
		return items.isEmpty();
	}
	
	/**
	 * Returns the first item in this heap, and sets the iteration cursor to the 
	 * first position. 
	 * 
	 * @return First item in this heap, null if list is empty.
	 */
	public T first() {
		if (items.size() == 0) return null;
		cursor = 0;
		return items.get(cursor);
	}
	
	/**
	 * Sets the cursor to the next position, and returns the item in this heap at
	 * that position. <br> To iterate over this heap, there
	 * must be a call to first( ), followed by successive calls to next( ). Iteration
	 * is in level-order sequence.
	 * 
	 * @return Next item in this heap. Null if heap is empty, or cursor is at the 
	 *         end of the heap at the time this method is called, i.e. end of heap was
	 *         reached. 
	 */
	public T next() {
		if (cursor < 0 || cursor == (items.size()-1)) {
			return null;
		}
		cursor++;
		return items.get(cursor);
	}
}
