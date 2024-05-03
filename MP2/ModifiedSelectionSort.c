#include <stdio.h>
#include <stdbool.h>

// Declare prototypes
void modifiedSelectionSort(int arr[], int n);
void selectionSort(int arr[], int n);

int main (void){
    // Initialize array to sort 
    // int testArray[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    // int testArray2[10] = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
    int testArray[10] = {6, 2, 13, 62, 5, 2, 10, 8, 11, 41};
    int testArray2[10] = {6, 2, 13, 62, 5, 2, 10, 8, 11, 41};
    int arrSize = sizeof(testArray) / sizeof(testArray[0]);

    // Call standard selection sort
    selectionSort(testArray, arrSize);

    // Call modified selection sort 
    modifiedSelectionSort(testArray2, arrSize);
 
    return 0;    
}

void modifiedSelectionSort(int arr[], int n) {
    int i, j;       // Index for traversing from left     
    int a, b;       // Index for traversing from right 
    int cmpCount = 0;  // Tracks number of comparisons
    bool flag;      // Tracks if a swap occurs in the iteration

    // Traverse the array at both ends
    for (i = 0, a = n-1; i < n && a >= 0; i++, a--) {       
        int leftIndex = i, rightIndex = a;      // Index for the sorted portion of the array     
        flag = false;                           // Set/Reset flag  

        for (j = i+1, b = a-1; j <= a && b >= i; j++, b--) { // Traverses the array for values to compare 
            if (arr[j] < arr[leftIndex]) {      // If current element is less in value          
                leftIndex = j;                  
                flag = true;                    // A swap occurs
            }
            if (arr[b] > arr[rightIndex]){      // If current element is higher in value
                rightIndex = b;                 
                flag = true;                    // A swap occurs
            }
            cmpCount++;
        }

        if (leftIndex == a && rightIndex == i) { // When both elements should be swapped with each other
            int tempLeft = arr[i];    
            arr[i] = arr[leftIndex];  
            arr[leftIndex] = tempLeft;
            continue; 

        } else { // Swaps both element to its correct position
            int tempLeft = arr[i];   
            int tempRight = arr[a];   
                        
            arr[i] = arr[leftIndex];          
            arr[a] = arr[rightIndex]; 

            arr[leftIndex] = tempLeft;
            arr[rightIndex] = tempRight;
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

void selectionSort(int arr[], int n) {
    int i, j;                         
    int cmpCount = 0;  // Tracks number of comparisons

    for (i = 0; i < n-1; i++) {             
        int sortedIndex = i;                
    
        for (j = i+1; j < n; j++) {         
            if (arr[j] < arr[sortedIndex])  
                sortedIndex = j;     
            cmpCount++;          
        }
    
        int temp = arr[i];                  
        arr[i] = arr[sortedIndex];          
        arr[sortedIndex] = temp;            
    }

    // Display output
    printf("\nNumber of Comparisons: %d", cmpCount);
    printf("\nStandard Sorted Array: ");
    for (int i = 0; i < n; i++) {
        printf("%d ", arr[i]);
    }
    printf("\n");
}