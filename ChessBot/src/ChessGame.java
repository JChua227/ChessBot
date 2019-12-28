import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.*;
import java.util.List;

public class ChessGame {
    private JPanel jPanel;
    private JButton newGameButton;

    public ChessGame(){
        newGameButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                clearBoard();
            }
        });
    }

    public static void main(String []args){
        JFrame jFrame = new JFrame("Chess Game: Made by Jared Chua");
        jFrame.setPreferredSize(new Dimension(2200,1500));
        jFrame.setLocation(600,200);
        jFrame.setResizable(false);
        jFrame.setContentPane(new ChessGame().jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

    }

    public void clearBoard(){

    }
}
