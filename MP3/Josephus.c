#include <stdio.h>
#include <stdbool.h>

// Declare prototypes
void josephus(int n, int q);

int main(void) {
    // Declare variables
    int numPeople, numInterval;

    // Prompt user
    printf("Enter number of people in circle: ");
    scanf("%d", &numPeople);
    printf("Enter number of intervals: ");
    scanf("%d", &numInterval);
    printf("\n");

    josephus(numPeople, numInterval);

    return 0;
}

void josephus(int n, int q) {
    int circle[n]; 
    int ans = 0; 

    for (int i = 0; i < n; i++) {
        circle[i] = i + 1;
    }

    for (int i = 0; i < n - 1; i++) {
        while (circle[ans] == 0) { // Skip empty indices
            ans = (ans + 1) % n;
        }
        printf("Person to be eliminated: %d\n", circle[ans]);

        circle[ans] = 0; // Mark as eliminated
        ans = (ans + q) % n; // Get new index

        printf("Current position after elimination: %d\n", circle[ans]);
    }

    printf("\nLast person alive: %d\n", circle[ans]);
}