import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Image backgroundImage = new ImageIcon("splh.png").getImage();
        JPanel backgroundPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
            }
        };
        backgroundPanel.setLayout(new BorderLayout());
        JLabel label = new JLabel("Professional Picasso");
        label.setBounds(25,10,300,70);
        label.setFont(new Font("Arial", Font.BOLD, 25));
        label.setForeground(Color.WHITE);
        JLabel label2 = new JLabel("Integrated Development Environment");
        label2.setBounds(25,35,250,70);
        label2.setFont(new Font("Arial", Font.PLAIN, 13));
        label2.setForeground(Color.WHITE);
        JWindow splash = new JWindow();
        splash.setContentPane(backgroundPanel);
        splash.setSize(600, 400);
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);
        splash.setLayout(null);
        backgroundPanel.add(label, BorderLayout.SOUTH);
        backgroundPanel.add(label2, BorderLayout.SOUTH);
        Timer timer = new Timer(5000, e -> {
            splash.dispose();
            showMainWindow();
        });
        timer.setRepeats(false);
        timer.start();
    }

    private static void showMainWindow() {
        JFrame mainFrame = new JFrame("Professional Picasso");
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(500, 400);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.add(new JLabel("Добро пожаловать!", SwingConstants.CENTER));
        mainFrame.setVisible(true);
    }
}
