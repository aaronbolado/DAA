#include <stdio.h>
#include <stdbool.h>

// Declare prototypes
bool binarySearch(int arr[], int l, int r, int key);

int main (void){
    // Initialize array to sort 
    int testArray[10] = {1, 8, 3, 4, 5, 6, 7, 2 ,9, 10};
    int testArray2[10] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int searchKey = 2;

    // Search in unsorted list
    printf("Element is %s", binarySearch(testArray, 0, sizeof(testArray)/sizeof(testArray[0]), searchKey)? "found" : "not found");
    
    // Search in sorted list
    printf("\nElement is %s", binarySearch(testArray2, 0, sizeof(testArray2)/sizeof(testArray2[0]), searchKey)? "found" : "not found");

    return 0;    
}

bool binarySearch(int arr[], int l, int r, int key) {
    while (l <= r) {        		
        int mid = l + (r - l) / 2;	// Calculate index for middle value

        if (arr[mid] == key) { // Key element found in current index
            return true;			    
        }

        if (arr[mid] < key) {
                l = mid + 1;   // Ignore left half
        } else {
                r = mid - 1;   // Ignore right half
        }
    }
    return false;
}