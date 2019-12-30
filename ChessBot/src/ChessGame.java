import Pieces.Knight;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.awt.*;
import java.util.List;

public class ChessGame extends JFrame{
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
        jFrame.setPreferredSize(new Dimension(1200,1000));
        jFrame.setLocation(400,25);
        jFrame.setContentPane(new ChessGame().jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);

    }

    public void clearBoard(){
        
    }

}
