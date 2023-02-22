import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.JFrame;

public class MazeView {
    private JFrame frame;
    private MazePanel panel;
    private int mazeSize;
    private int frameSize = 1500;
  

    public MazeView(int n, int[][] maze){
        mazeSize = n;
        frame = new JFrame("MazeBot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(frameSize, frameSize));
        frame.setResizable(true);
        frame.setLocationRelativeTo(null); 
        panel = new MazePanel(maze, frameSize, mazeSize);
        frame.add(panel);
        System.out.println("AAAAAAAAAAAAAAAAAA");
        frame.setVisible(true);
    }

    public void changeTile(int row, int col, int status, int num){
        panel.changeTile(row, col, status, num);
 
    }
}
