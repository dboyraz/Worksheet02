import javax.swing.*;

public class Main {


    public static void main(String[] args) {


        JFrame myWindow = new JFrame();
        Animation myAnimation = new Animation();
        myWindow.setSize(myAnimation.getSize());
        myWindow.setTitle("Worksheet 02 - X Circles with Threading");
        myWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myWindow.add(myAnimation);
        myWindow.setVisible(true);
    }


}