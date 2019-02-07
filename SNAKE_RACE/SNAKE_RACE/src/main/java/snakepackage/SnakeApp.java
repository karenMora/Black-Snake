package snakepackage;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import enums.GridSize;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * @author jd-
 *
 */
public class SnakeApp {

    private static SnakeApp app;
    public static final int MAX_THREADS = 8;
    Snake[] snakes = new Snake[MAX_THREADS];
    private static final Cell[] spawn = {
        new Cell(1, (GridSize.GRID_HEIGHT / 2) / 2),
        new Cell(GridSize.GRID_WIDTH - 2,3 * (GridSize.GRID_HEIGHT / 2) / 2),
        new Cell(3 * (GridSize.GRID_WIDTH / 2) / 2, 1),
        new Cell((GridSize.GRID_WIDTH / 2) / 2, GridSize.GRID_HEIGHT - 2),
        new Cell(1, 3 * (GridSize.GRID_HEIGHT / 2) / 2),
        new Cell(GridSize.GRID_WIDTH - 2, (GridSize.GRID_HEIGHT / 2) / 2),
        new Cell((GridSize.GRID_WIDTH / 2) / 2, 1),
        new Cell(3 * (GridSize.GRID_WIDTH / 2) / 2,GridSize.GRID_HEIGHT - 2)};
    private JFrame frame;
    private static Board board;
    int nr_selected = 0;
    Thread[] thread = new Thread[MAX_THREADS];
    
    public boolean pausa=false;
    public Object llave;
    public Integer[] deadSnake=new Integer[MAX_THREADS];
    
    
    public SnakeApp() {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        frame = new JFrame("The Snake Race");
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.setSize(618, 640);
        frame.setSize(GridSize.GRID_WIDTH * GridSize.WIDTH_BOX + 17,
                GridSize.GRID_HEIGHT * GridSize.HEIGH_BOX + 40);
        frame.setLocation(dimension.width / 2 - frame.getWidth() / 2,
                dimension.height / 2 - frame.getHeight() / 2);
        board = new Board();
        
        llave= new Object();
        
        frame.add(board,BorderLayout.CENTER);
        
        JPanel actionsBPabel=new JPanel();
        actionsBPabel.setLayout(new FlowLayout());
        actionsBPabel.add(new JButton("Action "));
        JButton start= new JButton("Start");
        JButton pause= new JButton("Pause");
        JButton resume= new JButton("Resume");
        actionsBPabel.add(start);
        actionsBPabel.add(pause);
        actionsBPabel.add(resume);
        frame.add(actionsBPabel,BorderLayout.SOUTH);
        
        start.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                botonStart();
            }
        });
        
        pause.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    botonPause();
                } catch (InterruptedException ex) {
                    Logger.getLogger(SnakeApp.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
        
        resume.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                botonResume();
            }
        });
        
    }
    
    public void botonStart(){
        JOptionPane.showMessageDialog(null, "Start game");
        for (int i = 0; i != MAX_THREADS; i++) {
            thread[i].start();
        }
    }
    
    public void botonPause() throws InterruptedException{
        if(pausa==false){
            Integer[] temp=new Integer[2];
            for (int i = 0; i != MAX_THREADS; i++) {
                snakes[i].cond=true;
                System.out.println(thread[i].getState());
            }
            temp=longestSnake();
            JOptionPane.showMessageDialog(null,"PAUSE"+ "\n\nThe longest snake is: "+temp[1]+" de tañano:"+ temp[0]+"\nThe worst snake is: "+deadSnake[0]);
            pausa=true;
        }
    }
    
    public void botonResume(){
        if(pausa==true){
            JOptionPane.showMessageDialog(null,"Resume"); 
            for (int i = 0; i != MAX_THREADS; i++) {
                snakes[i].cond=false;
            }
            synchronized(llave){
                llave.notifyAll();
            }
            pausa=false;
        }
    }
    
    public static void main(String[] args) {
        app = new SnakeApp();
        app.init();
    }

    private void init() {
        for (int i = 0; i != MAX_THREADS; i++) {
            
            snakes[i] = new Snake(i + 1, spawn[i], i + 1, llave);
            snakes[i].addObserver(board);
            thread[i] = new Thread(snakes[i]);
            //thread[i].start();
        }

        frame.setVisible(true);

            
        while (true) {
            int x = 0;
            for (int i = 0; i != MAX_THREADS; i++) {
                if (snakes[i].isSnakeEnd() == true) {
                    deadSnake[x]=snakes[i].getIdt();
                    x++;
                }
            }
            if (x == MAX_THREADS) {
                break;
            }
        }
        System.out.println("Thread (snake) status:");
        for (int i = 0; i != MAX_THREADS; i++) {
            System.out.println("["+i+"] :"+thread[i].getState());
        }
    }

    public static SnakeApp getApp() {
        return app;
    }
    
    public Integer[] longestSnake(){
        int sol=0;
        int tots=0;
        Integer[] res=new Integer[2];
        
        for(int i=0;i<MAX_THREADS;i++){
            if((sol<=snakes[i].getBody().size()) && (thread[i].getState() != Thread.State.TERMINATED)){
                sol=snakes[i].getBody().size();
                tots=snakes[i].getIdt();
                res[0]=sol;
                res[1]=tots;
            }
        }
        return res;
    }
}
