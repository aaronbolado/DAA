#include <stdio.h>
#include <stdbool.h>

// Declare prototypes
void bubbleSort(int arr[], int n);
void modifiedBubbleSort(int arr[], int n);

int main (void) {
    // Initialize array to sort 
    // int testArray[10] = {6, 2, 13, 62, 5, 2, 10, 8, 11, 41};
    // int testArray2[10] = {6, 2, 13, 62, 5, 2, 10, 8, 11, 41};
    int testArray[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int testArray2[10] = {10, 9, 2, 7, 5, 6, 4, 3, 8, 1};
    int arrSize = sizeof(testArray) / sizeof(testArray[0]);

    // Call standard bubble sort
    bubbleSort(testArray, arrSize);

    // Call modified bubble sort
    modifiedBubbleSort(testArray2, arrSize);

    return 0;    
}

void modifiedBubbleSort(int arr[], int n) {
    int i, j;       // Index for traversing from left
    int cmpCount = 0;  // Tracks number of comparisons
    bool flag;      // Tracks if a swap occurs in the iteration

    // Traverse the array at both ends
    for (i = 0; i < n-1; i++) {             
        flag = false;                   // Set/Reset flag

        for (j = 0; j < n-i-1; j++) {   // Traverses the array for values to compare    
            if (arr[j] > arr[j+1]) {    // If current element is larger in value
                int temp = arr[j];          
                arr[j] = arr[j+1];          
                arr[j+1] = temp;   
                flag = true;            // Swap occurs
            }        
                cmpCount++; 
        }
        
        // Breaks loop if there were no swaps in previous iteration
        if (flag != true) { 
            printf("\nNo swaps occured. Array is already sorted");
            break;  
        }            
    }

    // Display output
    printf("\nNumber of Comparisons: %d", cmpCount);
    printf("\nModified Sorted Array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}

void bubbleSort(int arr[], int n) {
    int i, j;                               
    int cmpCount = 0;  // Tracks number of comparisons

    for (i = 0; i < n-1; i++) {             
        for (j = 0; j < n-i-1; j++) {       
            if (arr[j] > arr[j+1]) {
                int temp = arr[j];          
                arr[j] = arr[j+1];          
                arr[j+1] = temp;            
            }        
            cmpCount++;
        }
    }

    // Display output
    printf("\nNumber of Comparisons: %d", cmpCount);
    printf("\nStandard Sorted Array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}