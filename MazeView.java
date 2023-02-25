import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MazeView {
    private JFrame frame;
    private MazePanel panel;
    private JButton startButton;
    private JLabel nodesVisited;
    private int mazeSize;
    private int frameSize = 900;

    public MazeView(int n, char[][] maze){
        mazeSize = n;
        frame = new JFrame("MazeBot");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(new Dimension(frameSize, frameSize));
        frame.setLayout(new BorderLayout());
        frame.setLocationRelativeTo(null); 
        panel = new MazePanel(maze, frameSize, mazeSize);
        startButton = new JButton("Run");
        startButton.setSize(50, 35);
        nodesVisited = new JLabel("0 nodes visited");
        nodesVisited.setSize(50, 20);
        frame.add(startButton,BorderLayout.SOUTH);
        frame.add(nodesVisited,BorderLayout.NORTH);
        frame.add(panel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    public void changeTile(int row, int col, char status, int num){
        panel.changeTile(row, col, status, num);
    }

    public void setStartButtonActionListener(ActionListener actionListener){
        this.startButton.addActionListener(actionListener);
    }

    public void setNodesVisitedTxt(String txt){
        nodesVisited.setText(txt + " nodes visited");
    }
}
