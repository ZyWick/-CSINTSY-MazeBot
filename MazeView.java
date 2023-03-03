import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class MazeView {
    private JFrame frame;
    private MazePanel panel;
    private JPanel panel2;
    private JButton startButton;
    private JLabel nodesVisited;
    private JLabel status;
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
        panel2 = new JPanel(new GridLayout(1,3, -1, -1));
        panel2.setBorder(BorderFactory.createEmptyBorder(10, 2, 10, 2));
        startButton = new JButton("Run");
        startButton.setBorder(BorderFactory.createLineBorder(Color.black));
        startButton.setFocusPainted(false);
        startButton.setPreferredSize(new Dimension(45,45));
        nodesVisited = new JLabel("0 states visited", SwingConstants.CENTER);
        nodesVisited.setPreferredSize(new Dimension(45,45));
        nodesVisited.setBorder(BorderFactory.createLineBorder(Color.black));
        status = new JLabel("", SwingConstants.CENTER);
        status.setBorder(BorderFactory.createLineBorder(Color.black));
        status.setPreferredSize(new Dimension(45,45));
        panel2.add(startButton);
        panel2.add(status);
        panel2.add(nodesVisited);
        frame.add(panel2,BorderLayout.NORTH);
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
        nodesVisited.setText(txt + " states visited");
    }

    public void setGoalNotFoundTxt(){
        status.setText("Goal not found...");
    }

    public void setGoalFound(){
        status.setText("Goal found!");
    }
}
