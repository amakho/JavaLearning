package GUI;
 import javax.swing.*;
 import java.awt.event.*;

public class TryActionEvent implements ActionListener{
    JButton button;

    public static void main(String[] args) {
        TryActionEvent gui = new TryActionEvent();
        gui.go();

    }
    public void go(){
        JFrame frame = new JFrame();
        button = new JButton("click me");

        button.addActionListener(this);

        frame.getContentPane().add(button);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300,300);
        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent event){
        button.setText("i've been clicked");
    }
}

