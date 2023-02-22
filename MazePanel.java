import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;

public class MazePanel extends JPanel{
    private ArrayList<BufferedImage> imgList = new ArrayList<>();
    private int[][] map;
    private int scale;
    private ArrayList<JLabel> labels;
    private int n;

    public MazePanel(int[][] map, int panelSize, int n){
        this.map = map;
        this.n = n;
        this.scale = (int) Math.floor(panelSize / n);
        System.out.println(scale + "ABCDE");
        this.setLayout(new GridLayout(n, n));
        this.setOpaque(true);
        labels = new ArrayList<JLabel>();
        System.out.println(n + "ADASDAASDA");
        int index = 0;
        for (int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                labels.add(new JLabel());
                labels.get(index).setOpaque(true);
                changeColor(i, j, index);
                labels.get(index).setText(Integer.toString(index));
                this.add(labels.get(index));
                index++;
            }
        }
        System.out.println(labels.size());
    }

   /* @Override
    public void paint(Graphics g){
        Graphics2D g2d = (Graphics2D) g;

        super.paint(g2d);

        for(int i = 0; i < n; i++){
            for (int j = 0; j < n; j++){
                g2d.drawRect(i*scale, j*scale, scale, scale);
                switch(map[i][j]){
                    case 0: g2d.setColor(Color.BLACK);
                            g2d.fillRect(i*scale, j*scale, scale, scale);
                            break;
                    case 1: g2d.setColor(Color.red);
                            g2d.fillRect(i*scale, j*scale, scale, scale);
                            break;
                    case 2: g2d.setColor(Color.yellow);
                            g2d.fillRect(i*scale, j*scale, scale, scale);
                            break;
                    case 3: g2d.setColor(Color.green);
                            g2d.fillRect(i*scale, j*scale, scale, scale);
                            break;
                    case 4: g2d.setColor(Color.blue);
                            g2d.fillRect(i*scale, j*scale, scale, scale);
                            break;
                    case 5: g2d.setColor(Color.white);
                            g2d.fillRect(i*scale, j*scale, scale, scale);
                            break;
                    default: g2d.setColor(Color.MAGENTA);
                            g2d.fillRect(i*scale, j*scale, scale, scale);
                        
                }         
            }
        }
        g2d.dispose();
    }*/

    public void changeTile(int row, int col, int status, int num){
        this.map[row][col] = status;
        int index = row*n + col;
        changeColor(row, col, index);
        if (num != -1)
            changeNum(index, num);
        //repaint();
    }

    private void changeColor(int i, int j, int index){
        if (map[i][j] == 0){ //could be a switch statement but i already coded it all lmao
            labels.get(index).setBackground(Color.BLACK);
        }
        else if (map[i][j] == 1){
            labels.get(index).setBackground(Color.RED);
        }
        else if (map[i][j]==2){
            labels.get(index).setBackground(Color.yellow);
        }
        else if(map[i][j] == 3){
            labels.get(index).setBackground(Color.green);
        }
        else if (map[i][j] == 4){
            labels.get(index).setBackground(Color.BLUE);
        }
        else if (map[i][j] == 5){
            labels.get(index).setBackground(Color.WHITE);
        }
        //repaint();
    }

    private void changeNum(int index, int num){
        //labels.get(index).setText(Integer.toString(num));
    }
    /*public void initImages() throws IOException{
        imgList.add(ImageIO.read(new File("")));
        imgList.add(ImageIO.read(new File("")));
        imgList.add(ImageIO.read(new File("")));
        imgList.add(ImageIO.read(new File("")));
        imgList.add(ImageIO.read(new File("")));
        imgList.add(ImageIO.read(new File("")));
    }*/
}
