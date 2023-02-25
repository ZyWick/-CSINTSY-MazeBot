import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Driver {

    /*
     * 0 - empty space
     * 1 - wall
     * 2 - explored
     * 3 - path
     * 4 - start
     * 5 - end
     */
    public static void main(String[] args) {
        try (Scanner txtFileReader = new Scanner(new File("maze.txt")).useLocale(Locale.ENGLISH)) {
            txtFileReader.useDelimiter("\\n");
            int n = txtFileReader.nextInt();
            char c;
            int map[][] = new int[n][n];
            int startX = 0, startY = 0, goalX = n, goalY = n;
            String line;
            for (int i = 0; i < n; i++){
                line = txtFileReader.next();
                //System.out.println(line);
                for (int j = 0; j < n; j++){
                    c = line.charAt(j);

                    if (c == '.')
                        map[i][j] = 0;
                    else if (c == '#')
                        map[i][j] = 1;
                    else if (c == 'S'){
                        map[i][j] = 4;
                        startX = i;
                        startY = j;
                    }
                    else if (c == 'G'){
                        map[i][j] = 5;
                        goalX = i;
                        goalY = j;
                    }
                    System.out.print(map[i][j]);
                }
                System.out.println();
            }

            Mazebot mazeBot = new Mazebot(map, n, goalX, goalY, startX, startY);
    

        } catch (FileNotFoundException e) {
            
        }
    }
}
