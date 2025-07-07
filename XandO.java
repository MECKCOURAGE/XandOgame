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
void drawGrid() {

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
}
