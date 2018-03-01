// SearchArray.java
//    linearSearch (sorted and unsorted array) and 
//    binarySearch (sorted array only)

public class SearchArray {
   // Linear search to find a key in the list 
   public static int linearSearch(int[] list, int key) {
      for (int i = 0; i < list.length; i++) {
         if (key == list[i])
            return i;
      } // end for
      return -1;
   } // end linearSearch
  
  // Binary search (sorted array only) to find the key in the list
   public static int binarySearch(int[] list, int key) {
      int low = 0;
      int high = list.length - 1;
      while (low <= high) {
         int mid = (low + high) / 2;
         if (key < list[mid])
            high = mid - 1;
         else if (key == list[mid])
            return mid;
         else
            low = mid + 1;
      } // end while
      return -low - 1; // low > high
   } // end binarySearch
} // end Search
