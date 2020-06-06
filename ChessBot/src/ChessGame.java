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
                createNewGame();
            }
        });
    }

    public static void main(String []args){
        JFrame jFrame = new JFrame("Chess Game: Made by Jared Chua");
        jFrame.setPreferredSize(new Dimension(600,500));
        jFrame.setLocation(400,25);
        jFrame.setContentPane(new ChessGame().jPanel);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();
        jFrame.setVisible(true);



    }

    public void createNewGame(){
        JFrame jframe = new JFrame("Chess");
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(jframe.DISPOSE_ON_CLOSE);
        jframe.setSize(300,400);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8,8,1,1));

        panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        for(int x=0; x<8; x++){
            for(int y=0; y<8; y++){
                JButton jbutton = new JButton(x + "," + y);
                if((x+y)%2==0) {
                    jbutton.setBackground(Color.GRAY);
                }
                else{
                    jbutton.setBackground(Color.WHITE);
                }


                /*jbutton*/
                panel.add(jbutton);
            }
        }

        jframe.add(panel);
    }


    public void doAnotherAction(){
        System.out.println("ok world");
    }

}
