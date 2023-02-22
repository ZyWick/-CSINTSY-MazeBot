import java.util.concurrent.TimeUnit;
public class Mazebot {
    private int maze[][];
    private int n;
    private int goalX;
    private int goalY;
    private MazeView view;
    private int numVisited = 0;

    /*
     * 0 - blank - black
     * 1 - wall - red
     * 2 - visited - yellow
     * 3 - final path - green
     * 4 - start - Blue
     * 5 - goal - white
     */
    public Mazebot(int maze[][], int n, int goalX, int goalY, int startX, int startY){
        this.maze = maze;
        this.n = n;
        this.goalX = goalX;
        this.goalY = goalY;
        view = new MazeView(n, maze);

        findPath(startX, startY);
    }

    private boolean isValidMove(int row, int col){
        if (row < 0 || row >= n || col < 0 || col >= n)
            return false;
        if(maze[row][col] == 1 || maze[row][col] == 2 || maze[row][col] == 4)
            return false;
        return true;
    }

    private boolean findPath(int row, int col){
        if (row == goalX && col == goalY){
            view.changeTile(row, col, 3, numVisited);
            return true;
        }
        if (maze[row][col] != 4){
            maze[row][col] = 2;
            numVisited++;
            view.changeTile(row, col, 2, numVisited);
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } 
        if(isValidMove(row,col+1)){
            if (findPath(row, col+1)){
                numVisited++;
                view.changeTile(row, col, 3, numVisited);
                return true;
            }
        }
        if(isValidMove(row,col-1)){
            if (findPath(row, col-1)){
                numVisited++;
                view.changeTile(row, col, 3, numVisited);
                return true;
            }
        }
        if(isValidMove(row+1,col)){
            if (findPath(row+1, col)){
                numVisited++;
                view.changeTile(row, col, 3, numVisited);
                return true;
            }
        }
        if(isValidMove(row-1,col)){
            if (findPath(row-1, col)){
                numVisited++;
                view.changeTile(row, col, 3, numVisited);
                return true;
            }
        }
        
        return false;
    }
}
