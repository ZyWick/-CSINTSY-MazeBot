public class Mazebot {
    private char maze[][];
    private int n;
    private int goalX;
    private int goalY;
    private int numVisited = 0;
    public boolean run = false;

    /*
     * '.' - blank - black
     * '#' - wall - red
     * 'O' - visited - yellow
     * 'X' - final path - green
     * 'S' - start - Blue
     * 'G' - goal - white
     */
    public Mazebot(char maze[][], int n, int goalX, int goalY){
        this.maze = maze;
        this.n = n;
        this.goalX = goalX;
        this.goalY = goalY;
    }

    //checks if the move is valid
    private boolean isValidMove(int row, int col){
        if (row < 0 || row >= n || col < 0 || col >= n)
            return false;
        if(maze[row][col] == '#' || maze[row][col] == 'O' || maze[row][col] == 'S')
            return false;
        return true;
    }

    //find the path in the maze
    public boolean findPath(int row, int col, MazeView view){
        if (row == goalX && col == goalY){
            return true;
        }
        if (maze[row][col] != 'S'){
            maze[row][col] = 'O';
            numVisited++;
            view.changeTile(row, col, 'O', numVisited);
            view.setNodesVisitedTxt(Integer.toString(numVisited));
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            //Auto generated catch block
            e.printStackTrace();
        }
        if(isValidMove(row,col+1)){
            if (findPath(row, col+1, view)){
                view.changeTile(row, col, 'X', numVisited);
                return true;
            }
        }
        if(isValidMove(row,col-1)){
            if (findPath(row, col-1, view)){
                view.changeTile(row, col, 'X', numVisited);
                return true;
            }
        }
        if(isValidMove(row+1,col)){
            if (findPath(row+1, col, view)){
                view.changeTile(row, col, 'X', numVisited);
                return true;
            }
        }
        if(isValidMove(row-1,col)){
            if (findPath(row-1, col, view)){
                view.changeTile(row, col, 'X', numVisited);
                return true;
            }
        }
        numVisited++;
        return false;
    }
}
