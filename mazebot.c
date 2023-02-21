#include <stdio.h>
#include <stdbool.h>

#define SIZE 3

// Define the maze
int maze[SIZE][SIZE] = {
    {0, 1, 0},
    {0, 1, 0},
    {0, 0, 0}
};

// Function to check if a move is valid
bool isValidMove(int row, int col) {
    if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) {
        // out of bounds
        return false;
    }
    if (maze[row][col] == 1) {
        // wall or already visited
        return false;
    }
    return true;
}

// Recursive function to find a path in the maze
bool findPath(int row, int col, int goalRow, int goalCol) {
    if (row == goalRow && col == goalCol) {
        // we reached the goal
        return true;
    }
    maze[row][col] = 1; // mark as visited
    printf("(%d, %d)\n", row, col); // print coordinates
    if (isValidMove(row, col+1)) {
        // try right
        if (findPath(row, col+1, goalRow, goalCol)) {
            return true;
        }
    }
    if (isValidMove(row+1, col)) {
        // try down
        if (findPath(row+1, col, goalRow, goalCol)) {
            return true;
        }
    }
    if (isValidMove(row, col-1)) {
        // try left
        if (findPath(row, col-1, goalRow, goalCol)) {
            return true;
        }
    }
    if (isValidMove(row-1, col)) {
        // try up
        if (findPath(row-1, col, goalRow, goalCol)) {
            return true;
        }
    }
    return false; // no path found
}

int main() {
    int startX, startY, goalX, goalY;
    printf("Enter starting coordinates (x y): ");
    scanf("%d %d", &startX, &startY);
    printf("Enter goal coordinates (x y): ");
    scanf("%d %d", &goalX, &goalY);
    
    if (findPath(startX, startY, goalX, goalY)) {
        // path found
        printf("Path found!\n");
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (maze[i][j] == 1) {
                    printf("X ");
                } else {
                    printf("_ ");
                }
            }
            printf("\n");
        }
    } else {
        // path not found
        printf("Path not found.\n");
    }
    return 0;
}