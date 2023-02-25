import java.util.ArrayList;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;

public class MazePanel extends JPanel{
    private char[][] map;
    private ArrayList<JLabel> labels;
    private int n;

    public MazePanel(char[][] map, int panelSize, int n){
        this.map = map;
        this.n = n;
        this.setLayout(new GridLayout(n, n));
        this.setOpaque(true);
        labels = new ArrayList<JLabel>();
        int index = 0;
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                labels.add(new JLabel());
                labels.get(index).setOpaque(true);
                changeColor(i, j, index);
                this.add(labels.get(index));
                index++;
            }
        }
    }

    //sets the tile status then calls changeColor() and changeNum()
    public void changeTile(int row, int col, char status, int num){
        this.map[row][col] = status;
        int index = row*n + col;
        changeColor(row, col, index);
        if (num != -1)
            changeNum(index, num);
        //repaint();
    }

    //changes the tile color based on its status
    private void changeColor(int i, int j, int index){
        if (map[i][j] == '.'){ //could be a switch statement but i already coded it all lmao
            labels.get(index).setBackground(Color.BLACK);
        }
        else if (map[i][j] == '#'){
            labels.get(index).setBackground(Color.RED);
        }
        else if (map[i][j] == 'O'){
            labels.get(index).setBackground(Color.yellow);
        }
        else if(map[i][j] == 'X'){
            labels.get(index).setBackground(Color.green);
        }
        else if (map[i][j] == 'S'){
            labels.get(index).setBackground(Color.BLUE);
        }
        else if (map[i][j] == 'G'){
            labels.get(index).setBackground(Color.WHITE);
        }
    }

    //sets the jlabel text to x where x = xth node visited (idk how to word this)
    private void changeNum(int index, int num){
        if (labels.get(index).getText() == "")
            labels.get(index).setText(Integer.toString(num));
    }
}
