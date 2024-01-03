import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class FrontEnd extends JFrame {

    private final CustomPanel customPanel;
    private TetraPiece piece;

    public FrontEnd(TetraPiece piece) {
        this.piece = piece;
        setTitle("Tetris");
        setSize(216, 439);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        customPanel = new CustomPanel();
        add(customPanel, BorderLayout.CENTER);

        setFocusable(true);

        addKeyListener(new ArrowKeyListener());

        Timer timer = new Timer(500, new TimerListener());
        timer.start();
        if (BackEnd.map[4][1] || BackEnd.map[4][0]) {
            timer.stop();
            remove(customPanel);
        }
    }

    private class ArrowKeyListener implements KeyListener {

        @Override
        public void keyTyped(KeyEvent e) {
        }

        @Override
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();

            switch (keyCode) {
                case KeyEvent.VK_DOWN -> {
                    customPanel.moveDown();
                    repaint();
                }
                case KeyEvent.VK_LEFT -> {
                    customPanel.moveLeft();
                    repaint();
                }
                case KeyEvent.VK_RIGHT -> {
                    customPanel.moveRight();
                    repaint();
                }
                case KeyEvent.VK_Q -> {
                    customPanel.rotateCounter();
                    repaint();
                }
                case KeyEvent.VK_E -> {
                    customPanel.rotateClock();
                    repaint();
                }
            }
        }

        @Override
        public void keyReleased(KeyEvent e) {
        }
    }

    private class TimerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            customPanel.moveDown();
            repaint();
        }
    }

    private class CustomPanel extends JPanel {
        private Color currentColor;

        public CustomPanel() {
            switch (piece.Type) {
                case I -> currentColor = Color.RED;
                case J -> currentColor = Color.BLUE;
                case T -> currentColor = Color.CYAN;
                case L -> currentColor = Color.GREEN;
                case S -> currentColor = Color.getHSBColor(0.1f, 1.0f, 1.0f);
                case O -> currentColor = Color.MAGENTA;
                case Z -> currentColor = Color.YELLOW;
                case Y -> currentColor = Color.getHSBColor(0.8f,1.0f,1.0f);
            }
        }

        public void moveDown() {
            piece = BackEnd.NewPiece(piece);
            BackEnd.DeleteLine();
            piece.yPos++;
        }

        public void moveLeft() {
            if (piece.xPos > 0) piece.xPos--;
        }

        public void moveRight() {
            if (BackEnd.MoveRight(piece)) piece.xPos++;
        }

        public void rotateClock(){
            while (BackEnd.Rotate(piece)){
                piece.xPos--;
            }
            piece.Rotation++;
        }

        public void rotateCounter(){
            while (BackEnd.Rotate(piece)){
                piece.xPos--;
            }
            piece.Rotation--;
        }

        public Color getCurrentColor() {
            switch (piece.Type) {
                case I -> currentColor = Color.RED;
                case J -> currentColor = Color.BLUE;
                case T -> currentColor = Color.CYAN;
                case L -> currentColor = Color.GREEN;
                case S -> currentColor = Color.getHSBColor(0.1f, 1.0f, 1.0f);
                case O -> currentColor = Color.MAGENTA;
                case Z -> currentColor = Color.YELLOW;
                case Y -> currentColor = Color.getHSBColor(0.8f,1.0f,1.0f);
            }
            return currentColor;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.setColor(getCurrentColor());
            switch (piece.Type) {
                case I -> {
                    if (piece.Rotation % 2 == 0) {
                        g.fillRect(piece.xPos * 20, piece.yPos * 20, 20, 80);
                    } else {
                        g.fillRect(piece.xPos * 20, piece.yPos * 20, 80, 20);
                    }
                }
                case J -> {
                    switch (piece.Rotation % 4) {
                        case 0 -> {
                            g.fillRect((piece.xPos + 1) * 20, piece.yPos * 20, 20, 60);
                            g.fillRect(piece.xPos * 20, (piece.yPos + 2) * 20, 20, 20);
                        }
                        case 1, -3 -> {
                            g.fillRect(piece.xPos * 20, piece.yPos * 20, 60, 20);
                            g.fillRect((piece.xPos + 2) * 20, (piece.yPos + 1) * 20, 20, 20);
                        }
                        case 2, -2 -> {
                            g.fillRect(piece.xPos * 20, piece.yPos * 20, 20, 60);
                            g.fillRect((piece.xPos + 1) * 20, piece.yPos * 20, 20, 20);
                        }
                        case 3, -1 -> {
                            g.fillRect(piece.xPos * 20, piece.yPos * 20, 20, 20);
                            g.fillRect(piece.xPos * 20, (piece.yPos + 1) * 20, 60, 20);
                        }
                    }
                }
                case T -> {
                    switch (piece.Rotation % 4){
                        case 0 -> {
                            g.fillRect(piece.xPos * 20, piece.yPos * 20, 60, 20);
                            g.fillRect((piece.xPos + 1) * 20, (piece.yPos + 1) * 20, 20, 20);
                        }
                        case 1, -3 -> {
                            g.fillRect(piece.xPos * 20, piece.yPos * 20, 20, 60);
                            g.fillRect((piece.xPos + 1) * 20, (piece.yPos + 1) * 20, 20, 20);
                        }
                        case 2, -2 -> {
                            g.fillRect((piece.xPos + 1) * 20, piece.yPos * 20, 20, 20);
                            g.fillRect(piece.xPos * 20, (piece.yPos + 1) * 20, 60, 20);
                        }
                        case 3, -1 -> {
                            g.fillRect(piece.xPos * 20, (piece.yPos + 1) * 20, 20, 20);
                            g.fillRect((piece.xPos + 1) * 20, piece.yPos * 20, 20, 60);
                        }
                    }
                }
                case L -> {
                    switch (piece.Rotation % 4) {
                        case 2, -2 -> {
                            g.fillRect((piece.xPos + 1) * 20, piece.yPos * 20, 20, 60);
                            g.fillRect(piece.xPos * 20, piece.yPos * 20, 20, 20);
                        }
                        case 3, -1 -> {
                            g.fillRect(piece.xPos * 20, piece.yPos * 20, 60, 20);
                            g.fillRect(piece.xPos * 20, (piece.yPos + 1) * 20, 20, 20);
                        }
                        case 0 -> {
                            g.fillRect(piece.xPos * 20, piece.yPos * 20, 20, 60);
                            g.fillRect((piece.xPos + 1) * 20, (piece.yPos + 2) * 20, 20, 20);
                        }
                        case 1, -3 -> {
                            g.fillRect((piece.xPos + 2) * 20, piece.yPos * 20, 20, 20);
                            g.fillRect(piece.xPos * 20, (piece.yPos + 1) * 20, 60, 20);
                        }
                    }
                }
                case S -> {
                    if (piece.Rotation % 2 == 0){
                        g.fillRect((piece.xPos + 1) * 20, piece.yPos * 20, 40, 20);
                        g.fillRect(piece.xPos * 20, (piece.yPos + 1) * 20, 40, 20);
                    }else{
                        g.fillRect(piece.xPos * 20, piece.yPos * 20, 20, 40);
                        g.fillRect((piece.xPos + 1) * 20, (piece.yPos + 1) * 20, 20, 40);
                    }
                }
                case O -> g.fillRect(piece.xPos * 20, piece.yPos * 20, 40, 40);
                case Z -> {
                    if (piece.Rotation % 2 == 0){
                        g.fillRect(piece.xPos * 20, piece.yPos * 20, 40, 20);
                        g.fillRect((piece.xPos + 1) * 20, (piece.yPos + 1) * 20, 40, 20);
                    }else{
                        g.fillRect((piece.xPos + 1) * 20, piece.yPos * 20, 20, 40);
                        g.fillRect(piece.xPos * 20, (piece.yPos + 1) * 20, 20, 40);
                    }
                }
                case Y -> {
                    switch (piece.Rotation % 4){
                        case 0 -> {
                            g.fillRect(piece.xPos * 20,piece.yPos * 20, 20, 20);
                            g.fillRect((piece.xPos + 1) * 20,(piece.yPos + 1) * 20, 20, 40);
                            g.fillRect((piece.xPos + 2) * 20,piece.yPos * 20, 20, 20);
                        }
                        case 1,-3 -> {
                            g.fillRect(piece.xPos * 20,piece.yPos * 20, 20, 20);
                            g.fillRect(piece.xPos * 20,(piece.yPos + 2) * 20, 20, 20);
                            g.fillRect((piece.xPos + 1) * 20,(piece.yPos + 1) * 20, 40, 20);
                        }
                        case 2,-2 -> {
                            g.fillRect(piece.xPos * 20,(piece.yPos + 2) * 20, 20, 20);
                            g.fillRect((piece.xPos + 1) * 20,piece.yPos * 20, 20, 40);
                            g.fillRect((piece.xPos + 2) * 20,(piece.yPos + 2) * 20, 20, 20);
                        }
                        case 3,-1 -> {
                            g.fillRect((piece.xPos + 2) * 20,piece.yPos * 20, 20, 20);
                            g.fillRect((piece.xPos + 2) * 20,(piece.yPos + 2) * 20, 20, 20);
                            g.fillRect(piece.xPos * 20,(piece.yPos + 1) * 20, 40, 20);
                        }
                    }
                }
            }
            g.setColor(Color.GRAY);
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 20; j++) {
                    if (BackEnd.map[i][j]) g.fillRect(i * 20, j * 20, 20, 20);
                }
            }
        }
    }
}