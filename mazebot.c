#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int n;

// Function to check if a move is valid
bool isValidMove(int row, int col, char maze[][n]) {
    if (row < 0 || row >= n || col < 0 || col >= n) {
        // out of bounds
        return false;
    }
    if (maze[row][col] == '#' || maze[row][col] == 'O' || maze[row][col] == 'S') {
        // wall or already visited
        return false;
    }
    return true;
}

// Recursive function to find a path in the maze
bool findPath(int row, int col, int goalRow, int goalCol, char maze[][n]) {
    if (row == goalRow && col == goalCol) {
        // we reached the goal
        printf("(%d, %d)\n", row, col);
        return true;
    }
    if (maze[row][col] != 'S'){
        maze[row][col] = 'O'; // mark as visited
    }
    printf("(%d, %d)\n", row, col); // print coordinates
    if (isValidMove(row, col+1, maze)) {
        // try right
        if (findPath(row, col+1, goalRow, goalCol, maze)) {
            return true;
        }
        printf("(%d, %d)\n", row, col);
    }
    if (isValidMove(row+1, col, maze)) {
        // try down
        if (findPath(row+1, col, goalRow, goalCol, maze)) {
            return true;
        }
        printf("(%d, %d)\n", row, col);
    }
    if (isValidMove(row, col-1, maze)) {
        // try left
        if (findPath(row, col-1, goalRow, goalCol, maze)) {
            return true;
        }
        printf("(%d, %d)\n", row, col);
    }
    if (isValidMove(row-1, col, maze)) {
        // try up
        if (findPath(row-1, col, goalRow, goalCol, maze)) {
            return true;
        }
        printf("(%d, %d)\n", row, col);
    }
    return false; // no path found
}

int main() {
    int i, j;
    int startX, startY, goalX, goalY;

    // Read in the maze from a file
    FILE *fp = fopen("maze.txt", "r");
    fscanf(fp, "%d", &n);
    char maze [n][n];
    for (int i = 0; i < n; i++) {
        fscanf(fp, "%s", maze[i]);
    }
    fclose(fp);
    for (int i = 0; i < n; i++) { //Displaying the maze
        for (int j = 0; j < n; j++) {
            printf("%c", maze[i][j]);
            if (maze[i][j] == 'G'){
                goalX = i;
                goalY = j;
            }
            if (maze[i][j] == 'S'){
                startX = i;
                startY = j;
            }
        }
        printf("\n");
    }
    
    if (findPath(startX, startY, goalX, goalY, maze)) {
        // path found
        printf("Path found!\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                printf("%c", maze[i][j]);
            }
            printf("\n");
        }
    } else {
        // path not found
        printf("Path not found.\n");
    }
    return 0;
}