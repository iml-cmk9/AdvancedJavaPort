import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class MyProgram extends JPanel implements KeyListener {

    private final int NUM_STREETS = 4;
    private final int NUM_AVES = 4;
    private final int WORLD_WIDTH = 400;
    private final int WORLD_HEIGHT = 400;
    private final int STREET_HEIGHT = WORLD_HEIGHT / NUM_STREETS;
    private final int AVE_WIDTH = WORLD_WIDTH / NUM_AVES;

    private int karelX = 0;
    private int karelY = WORLD_HEIGHT - STREET_HEIGHT;

    //2d array fix. I'm tuff asl
    private boolean[][] balls = new boolean[NUM_AVES][NUM_STREETS];

    private boolean ballVisible = false;
    private Random random = new Random();

    public MyProgram() {
        setPreferredSize(new Dimension(WORLD_WIDTH, WORLD_HEIGHT));
        setFocusable(true);
        addKeyListener(this);

        spawnBall();

        Timer timer = new Timer(1000, e -> {
            ballVisible = !ballVisible;
            if (ballVisible) spawnBall();
            repaint();
        });
        timer.start();
    }

    private void spawnBall() {
        int x = random.nextInt(NUM_AVES);
        int y = random.nextInt(NUM_STREETS);

        balls[x][y] = true;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw grid
        g.setColor(Color.BLACK);
        for (int i = 0; i <= NUM_AVES; i++) {
            g.drawLine(i * AVE_WIDTH, 0, i * AVE_WIDTH, WORLD_HEIGHT);
        }
        for (int j = 0; j <= NUM_STREETS; j++) {
            g.drawLine(0, j * STREET_HEIGHT, WORLD_WIDTH, j * STREET_HEIGHT);
        }

        // Draw balls from 2D array
        if (ballVisible) {
            g.setColor(Color.RED);
            for (int i = 0; i < NUM_AVES; i++) {
                for (int j = 0; j < NUM_STREETS; j++) {
                    if (balls[i][j]) {
                        g.fillOval(i * AVE_WIDTH + 20, j * STREET_HEIGHT + 20, 20, 20);
                    }
                }
            }
        }

        // Draw Karel
        g.setColor(Color.BLUE);
        g.fillRect(karelX + 10, karelY + 10, 40, 40);
    }

    private void moveKarel(int dx, int dy) {
        int nextX = karelX + dx;
        int nextY = karelY + dy;

        if (nextX >= 0 && nextX < WORLD_WIDTH && nextY >= 0 && nextY < WORLD_HEIGHT) {
            karelX = nextX;
            karelY = nextY;

            
            int gridX = karelX / AVE_WIDTH;
            int gridY = karelY / STREET_HEIGHT;

            if (balls[gridX][gridY]) {
                balls[gridX][gridY] = false;
            }
        }
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        char key = e.getKeyChar();

        if (key == 'w') moveKarel(0, -STREET_HEIGHT);
        if (key == 's') moveKarel(0, STREET_HEIGHT);
        if (key == 'a') moveKarel(-AVE_WIDTH, 0);
        if (key == 'd') moveKarel(AVE_WIDTH, 0);
    }

    public void keyTyped(KeyEvent e) {}
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        JFrame frame = new JFrame("Game");
        MyProgram game = new MyProgram();
        frame.add(game);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
