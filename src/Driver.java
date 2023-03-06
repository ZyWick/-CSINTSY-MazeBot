package src;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Locale;
import java.util.Scanner;

public class Driver {

    /*
     * . - empty space
     * #- wall
     * O- explored
     * X- path
     * S- start
     * G- end
     */

    public static void main(String[] args) {
        try (Scanner txtFileReader = new Scanner(new File("maze.txt")).useLocale(Locale.ENGLISH)) {
            txtFileReader.useDelimiter("\\n");
            int n = txtFileReader.nextInt();
            char map[][] = new char[n][n];
            int startX = 0, startY = 0, goalX = n, goalY = n;
            String line;
            for (int i = 0; i < n; i++){
                line = txtFileReader.next();
            
                for (int j = 0; j < n; j++){
                    map[i][j]=line.charAt(j);
                 
                    if (map[i][j] == 'S'){
                        startX = i;
                        startY = j;
                    }
                    else if (map[i][j] == 'G'){
                        goalX = i;
                        goalY = j;
                    }
                }
                System.out.println();
            }

            Mazebot bot = new Mazebot(map, n, goalX, goalY);
            MazeView view = new MazeView(n, map);
            Thread thread = new Thread();
            view.setStartButtonActionListener(new ActionListener(){

               @Override
                public void actionPerformed(ActionEvent e) {
                   bot.run = true;
                }

            });
            boolean start = false;
            while(start == false){
                if (bot.run == true){
                    
                    if (bot.findPath(startX, startY, view))
                        view.setGoalFound();
                    else
                        view.setGoalNotFoundTxt();
                    start = true;
                }
                thread.interrupt(); //I have no idea if this is good practice or not
                                    //probably not
            }

        } catch (FileNotFoundException e) {
            System.out.println("File not found. Please place maze.txt in the folder where the code is being run from");
        }
    }
}
