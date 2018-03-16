/**
 *  File: testHeaps.java
 *  Date: March 16, 2016
 *  Purpose: CSCI 2110, Lab 5 Solution
 *  
 *  Description: This program tests both minHeap and max heap class.
 */

import java.util.Random;

/**
 * @author Li Jingwei
 * This is the testHeaps class for testing the MinHeap and the max heap class.
 */
public class testHeaps {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Define random variable.
		Random random = new Random();
		
		// Define a max heap variable.
		Heap<Integer> maxHeap = new Heap<Integer>();
		
		// Add 30 random integers into a heap.
		for (int i = 0; i < 30; i++)
		{
			maxHeap.add(random.nextInt(100));
		}
		
		System.out.println("The level order:");
		// Print the level order.
		for (int i = 0; i < 30; i++)
		{
			if ( i == 0)
				System.out.print(maxHeap.first() + " ");
			else
				System.out.print(maxHeap.next() + " ");
		}
		
		System.out.println();
		System.out.println("The descending order:");
		// Print the descending order.
		for (int i = 0; i < 30; i++)
		{
			System.out.print(maxHeap.deleteMax() + " ");
		}
		
		/**
		 * Output:
		 * The level order:
		 * 95 82 92 77 68 79 89 75 59 57 66 48 75 78 87 22 35 10 37 24 37 33 52 24 18 25 15 10 56 50 
		 * The descending order:
		 * 95 92 89 87 82 79 78 77 75 75 68 66 59 57 56 52 50 48 37 37 35 33 25 24 24 22 18 15 10 10 
		 */
		
		// Define a min heap variable.
		MinHeap<Integer> minHeap = new MinHeap<Integer>();
				
		// Add 30 random integers into a minHeap.
		for (int i = 0; i < 30; i++)
		{
			minHeap.add(random.nextInt(100));
		}
				
		System.out.println();
		System.out.println("The level order:");
		// Print the level order.
		for (int i = 0; i < 30; i++)
		{
			if ( i == 0)
				System.out.print(minHeap.first() + " ");
			else
				System.out.print(minHeap.next() + " ");
		}
				
		System.out.println();
		System.out.println("The ascending order:");
		// Print the ascending order.
		for (int i = 0; i < 30; i++)
		{
			System.out.print(minHeap.deleteMin() + " ");
		}
		
		/**
		 * Output:
		 * The level order:
		 * 2 20 3 21 23 19 29 31 28 25 62 44 26 32 53 67 99 38 56 65 56 90 80 79 50 73 51 61 72 70 
		 * The ascending order:
		 * 2 3 19 20 21 23 25 26 28 29 31 32 38 44 50 51 53 56 56 61 62 65 67 70 72 73 79 80 90 99 
		 */
	}

}
