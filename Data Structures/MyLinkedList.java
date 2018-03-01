// CMPS390
// MyLinkedList.java

class MyLinkedList { 

	private Node firstNode;    // index = 0
	private int length;

	public MyLinkedList()	{
		firstNode = null;
		length = 0;
	} // end default constructor

	/** Task: Adds a new entry to the end of the list.
	 * @param newEntry the object to be added as a new entry
	 * @return true if the addition is successful, or false if not */
	public boolean add(Object newEntry)	{
		Node newNode = new Node(newEntry);
		if (isEmpty())
			firstNode = newNode;
		else	{
			Node lastNode = getNode(length-1);
			lastNode.next = newNode;
		}
		length++;
		return true;
	} // end add

	/** Task: Adds a new entry at a specified index 
	 * @param newEntry the object to be added at the specified index
 	 * @return true if successful, or false if not */
	public boolean add(int index, Object newEntry)	{
		boolean isSuccessful = true;
		if ((index >= 0) && (index <= length)) {
			Node newNode = new Node(newEntry);
			if (isEmpty() || (index == 0)) {
				newNode.next = firstNode;
				firstNode = newNode;
			}
			else	{
				Node nodeBefore = getNode(index - 1);
				Node nodeAfter = nodeBefore.next;
				newNode.next = nodeAfter;
				nodeBefore.next = newNode;
			}
			length++;
		}
		else
			isSuccessful = false;
		return isSuccessful;
	} // end add

	/** Task: Determines whether the list contains a given entry.
	 * @param anEntry the object that is the desired entry
	 * @return true if the list contains anEntry, or false if not */
	public boolean contains(Object anEntry) {
		boolean found = false;
		Node currentNode = firstNode;

		while (!found && (currentNode != null)) {
			if (anEntry.equals(currentNode.data))
				found = true;
			else
				currentNode = currentNode.next;
		} // end while
		return found;
	} // end contains

   /** Task: Gets an entry in the list.
    * @param the desired index
    * @return the desired entry, or 
    * 	null if either the list is empty or index is invalid */
	public Object getEntry(int index)	{
		Object result = null; // result to return
		if (!isEmpty() && (index >= 0) && (index < length))
			result = getNode(index).data;
		return result;
	} // end getEntry

	/** Task: Gets index of an entry in the list.
	 * @param the desired entry
	 * @return index of the first occurrence of the specified entry
    *    in this list, or -1 if this list does not contain the entry */
	public int getIndex(Object anEntry)	{
      int index = 0;                          
 		if(isEmpty() || (contains(anEntry)==false)){
         return -1;
      }else{
         Node currentNode = firstNode;
         while(currentNode.data != anEntry){
            index++;
            currentNode = currentNode.next;
         }
         return index;
      }
	} // end getIndex

	/** Task: Removes the entry at a given index from the list.
	 * @param the desired index to be removed
	 * @return the entry at index, or null if the removal
	 *          is not successful */
	public Object remove(int index) {
		Object result = null; // return value
		if (!isEmpty() && (index >= 0) && (index < length)) {
			if (index == 0) {
				result = firstNode.data;
				firstNode = firstNode.next;
			}
			else	{
				Node nodeBefore = getNode(index-1);
				Node nodeToRemove = nodeBefore.next;
				Node nodeAfter = nodeToRemove.next;
				nodeBefore.next = nodeAfter;  // disconnect node to be removed
				result = nodeToRemove.data;   // save entry to be removed
			} // end if
			length--;
		} // end if
		return result;
	} // end remove

   /** Task: Removes an entry from the list.
    * @param the desired entry to be removed
    * @return the first occurrence of the specified entry in 
    * 	this list, or null if the removal is not successful */
	public Object remove(Object anEntry) {            
		Object result = null;
 		Node nodetoRemove = firstNode;
      if(!isEmpty() && (contains(anEntry)==true)){
         while(nodetoRemove.data != anEntry){
            nodetoRemove = nodetoRemove.next;   //finds the node to be removed
         }
         int index = getIndex(nodetoRemove.data); 
         //System.out.println("index = " + index);
         if(index==0){     //getIndex(nodetoRemove.data)
            result = firstNode.data;
            firstNode = firstNode.next;
         }else{
            Node nodeBefore = getNode(index-1);
            nodetoRemove = nodeBefore.next;   
            Node nodeAfter = nodetoRemove.next;
            nodeBefore.next = nodeAfter;
            result = nodetoRemove.data;
         }
         length--;
      }//end if   
      return result;  
	} // end remove

   /** Task: Replaces the entry at a given index in the list.
    * @param newEntry the object that will replace the entry 
    * 	at the desired index
    * @return true if the replacement occurs, or
    *   false if either the list is empty or index is invalid */
	public boolean replace(int index, Object newEntry)	{  
      boolean isSuccessful = false;
      if(!isEmpty() && (index >= 0) && (index < length)){
         Node nodetoReplace = getNode(index);
         nodetoReplace.data = newEntry;
         isSuccessful = true;
      }
      return isSuccessful;							
	} // end replace

   /** Task: Determines whether two lists are equal.
    * @param other object that contains the other linked list 
    * @return true if two lists have the same length and all 
    * entries are equal, or false if not */
	public boolean equals(Object other)	{
		MyLinkedList aList = (MyLinkedList)other;
		boolean isEqual = false; // result of comparison of lists
      if(this.length != aList.length){
         return isEqual = false;
      }else{
         //now I need to compare Nodes' data in both lists
         for(int i = 0; i < length; i++){
            if(this.getNode(i).data != aList.getNode(i).data){
               isEqual = false;
               return isEqual;
            }else{
               isEqual = true;
            }
         }//end for-loop
      }
		return isEqual;
	}  // end equals

	public int getLength() {
		return length;
	}
   
	public boolean isEmpty() {
		return length == 0;
	}
   
   // @return an string with all entries in the list
	public String toString() {
		Node currentNode = firstNode;
      String s = new String();
		while (currentNode != null) {
			s += currentNode.data + " ";
			currentNode = currentNode.next;
	   }
 		return s;
	}

	private Node getNode(int index)	{
		Node currentNode = firstNode;      
		// traverse the list to locate the desired node
		for (int counter = 0; counter < index; counter++)
			currentNode = currentNode.next;
		return currentNode;
	} // end getNode


	private class Node	{
		private Object data; // data portion
		private Node next; // link to next node
      
		private Node(Object dataPortion)	{
			data = dataPortion;
			next = null;
		} // end constructor

		private Node(Object dataPortion, Node nextNode) {
			data = dataPortion;
			next = nextNode;
		} // end constructor

		private void setData(Object dataPortion)	{
			data = dataPortion;
		} // end setData

		private Object getData() {
			return data;
		} // end getData

		private void setNextNode(Node nextNode) {
			next = nextNode;
		} // end setNextNode

		private Node getNextNode()	{
			return next;
		} // end getNextNode
	} // end Node
   
} // end MyLinkedList
