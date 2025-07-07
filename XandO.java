package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class XandO {
    ArrayList<Integer> playerOne = new ArrayList<>();
    ArrayList<Integer> playerTwo = new ArrayList<>();

    JFrame xAndO = new JFrame("Tic-Tac-Toe Game");
    JPanel myPanel = new JPanel(new GridLayout(3, 3));
    int flag = 0;

    String playerOneName = "Player 1";
    String playerTwoName = "Player 2";

    JButton btn1 = new JButton();
    JButton btn2 = new JButton();
    JButton btn3 = new JButton();
    JButton btn4 = new JButton();
    JButton btn5 = new JButton();
    JButton btn6 = new JButton();
    JButton btn7 = new JButton();
    JButton btn8 = new JButton();
    JButton btn9 = new JButton();

    public static void main(String[] args) {
        XandO xandO = new XandO();
        xandO.drawGrid();
    }
    void showWelcomeDialog() {
        JDialog welcomeDialog = new JDialog(xAndO, "Tech tribe's Tic Tac Toe", true);
        welcomeDialog.setLayout(new BorderLayout());

        Color backgroundColor = Color.GREEN;
        Color textColor = Color.WHITE;
        Color inputBackground = Color.WHITE;
        Color inputBorder = new Color(150, 150, 150);

        welcomeDialog.getContentPane().setBackground(backgroundColor);

        JLabel title = new JLabel("Welcome to Tic-Tac-Toe!", JLabel.CENTER);
        title.setFont(new Font("Bradley Hand ITC", Font.BOLD, 35));
        title.setForeground(textColor);
        title.setBorder(BorderFactory.createEmptyBorder(30, 0, 10, 0));
        title.setOpaque(true);
        title.setBackground(backgroundColor);

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        formPanel.setBackground(backgroundColor);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 5, 8, 5);
        gbc.anchor = GridBagConstraints.WEST;

        JLabel p1Label = new JLabel("Enter Player 1 name:");
        p1Label.setFont(new Font("ALGERIAN", Font.BOLD, 13));
        p1Label.setForeground(Color.RED);
        JTextField player1Field = new JTextField(15);
        player1Field.setFont(new Font("ALGERIAN", Font.PLAIN, 14));
        player1Field.setBackground(inputBackground);
        player1Field.setForeground(Color.BLACK);
        player1Field.setBorder(BorderFactory.createLineBorder(inputBorder));

        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(p1Label, gbc);
        gbc.gridx = 1;
        formPanel.add(player1Field, gbc);

        JLabel p2Label = new JLabel("Enter Player 2 name:");
        p2Label.setFont(new Font("ALGERIAN", Font.BOLD, 13));
        p2Label.setForeground(Color.BLUE);
        JTextField player2Field = new JTextField(15);
        player2Field.setFont(new Font("ALGERIAN", Font.PLAIN, 14));
        player2Field.setBackground(inputBackground);
        player2Field.setForeground(Color.BLACK);
        player2Field.setBorder(BorderFactory.createLineBorder(inputBorder));

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(p2Label, gbc);
        gbc.gridx = 1;
        formPanel.add(player2Field, gbc);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(backgroundColor);

        JButton startBtn = new JButton("Start") {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                setContentAreaFilled(false);
                setOpaque(false);
            }

            @Override
            protected void paintBorder(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setColor(getForeground());
                g2.setStroke(new BasicStroke(1.5f));
                g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
                g2.dispose();
            }
        };

        startBtn.setPreferredSize(new Dimension(90, 38));
        startBtn.setFont(new Font("Bradley Hand ITC", Font.BOLD, 15));
        startBtn.setForeground(textColor);
        startBtn.setBackground(textColor);
        startBtn.setFocusPainted(false);
        startBtn.setContentAreaFilled(false);
        startBtn.setBorderPainted(false);

        buttonPanel.add(startBtn);

        startBtn.addActionListener(e -> {
            String name1 = player1Field.getText().trim();
            String name2 = player2Field.getText().trim();
            if (!name1.isEmpty()) playerOneName = name1;
            if (!name2.isEmpty()) playerTwoName = name2;
            welcomeDialog.dispose();
        });

        welcomeDialog.add(title, BorderLayout.NORTH);
        welcomeDialog.add(formPanel, BorderLayout.CENTER);
        welcomeDialog.add(buttonPanel, BorderLayout.SOUTH);
        welcomeDialog.setSize(400, 400);
        welcomeDialog.setLocationRelativeTo(null);
        welcomeDialog.setVisible(true);
    }

     void drawGrid() {
        showWelcomeDialog();
    
        myPanel.removeAll();
        myPanel.setBackground(Color.BLACK);
        xAndO.getContentPane().setBackground(Color.BLACK);

        myPanel.add(btn1); myPanel.add(btn2); myPanel.add(btn3);
        myPanel.add(btn4); myPanel.add(btn5); myPanel.add(btn6);
        myPanel.add(btn7); myPanel.add(btn8); myPanel.add(btn9);

        addAction(btn1, 1); addAction(btn2, 2); addAction(btn3, 3);
        addAction(btn4, 4); addAction(btn5, 5); addAction(btn6, 6);
        addAction(btn7, 7); addAction(btn8, 8); addAction(btn9, 9);

        JButton[] buttons = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9};
        for (JButton btn : buttons) {
            btn.setFont(new Font("Bodoni MT Black", Font.PLAIN, 40));
            btn.setBackground(Color.WHITE);
            btn.setForeground(Color.RED);
            btn.setFocusPainted(false);
            btn.setBorder(BorderFactory.createLineBorder(Color.GREEN, 1));
        }
         
          void addAction(JButton button, int position) {
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (flag == 0) {
                    playerOne.add(position);
                    button.setText("X");
                    button.setBackground(Color.RED);
                    flag = 1;
                } else {
                    playerTwo.add(position);
                    button.setText("O");
                    button.setBackground(Color.BLUE);
                    flag = 0;
                }
                button.setEnabled(false);
                checkWin();
            }
        });
    }


}
