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
        backgroundPanel.setLayout(null);
        JLabel animatedLabel = new JLabel("");
        animatedLabel.setBounds(25, 10, 500, 70);
        animatedLabel.setFont(new Font("Arial", Font.BOLD, 25));
        animatedLabel.setForeground(Color.WHITE);
        JLabel subLabel = new JLabel("Integrated Development Environment");
        subLabel.setBounds(25, 50, 400, 40);
        subLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        subLabel.setForeground(Color.WHITE);
        backgroundPanel.add(animatedLabel);
        backgroundPanel.add(subLabel);
        JWindow splash = new JWindow();
        splash.setContentPane(backgroundPanel);
        splash.setSize(600, 400);
        splash.setLocationRelativeTo(null);
        splash.setVisible(true);
        String fullText = "Professional Picasso";
        Timer typingTimer = new Timer(150, null);
        typingTimer.addActionListener(e -> {
            String currentText = animatedLabel.getText();
            if (currentText.length() < fullText.length()) {
                animatedLabel.setText(fullText.substring(0, currentText.length() + 1));
            } else {
                typingTimer.stop();
            }
        });
        typingTimer.start();
        Timer closeTimer = new Timer(5000, e -> {
            splash.dispose();
            showMainWindow();
        });
        closeTimer.setRepeats(false);
        closeTimer.start();
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
