import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Animation extends JPanel implements ActionListener, Runnable {

    private Circle firstCircle, secondCircle, thirdCircle, firstXCircle, secondXCircle;
    private Thread t0, t1, t2, t3, t4, t5;
    private JMenuBar menuBar;
    private JMenu menuAnimate;
    private JMenuItem itemStart, itemExit;
    private String lblVertical, lblHorizontal, lblDiagonal;


    public Animation() {

        setLayout(new BorderLayout());

        lblVertical = "Vertical";
        lblHorizontal = "Horizontal";
        lblDiagonal = "Diagonal";


        t0 = new Thread(this);

        menuBar = new JMenuBar();
        menuAnimate = new JMenu("Animate");
        menuBar.add(menuAnimate);

        add(menuBar, BorderLayout.NORTH);

        itemStart = new JMenuItem("Start");

        itemExit = new JMenuItem("Exit");

        menuAnimate.add(itemStart);

        menuAnimate.add(itemExit);

        itemStart.addActionListener(this);

        itemExit.addActionListener(this);



        firstCircle = new Circle(Circle.Direction.vertical);
        secondCircle = new Circle(Circle.Direction.horizontal);
        thirdCircle = new Circle(Circle.Direction.diagonal);
        firstXCircle = new Circle(Circle.Direction.xDiagonal);
        secondXCircle = new Circle(Circle.Direction.xDiagonal);

        t1 = new Thread(firstCircle);
        t1.start();
        t2 = new Thread(secondCircle);
        t2.start();
        t3 = new Thread(thirdCircle);
        t3.start();
        t4 = new Thread(firstXCircle);
        t4.start();
        t5 = new Thread(secondXCircle);
        t5.start();


        setSize(500, 500);
        setVisible(true);
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);


        g.setColor(firstCircle.getClr());
        g.fillOval(firstCircle.getX(), firstCircle.getY(), firstCircle.getR(), firstCircle.getR());

        g.setColor(secondCircle.getClr());
        g.fillOval(secondCircle.getX(), secondCircle.getY(), secondCircle.getR(), secondCircle.getR());

        g.setColor(thirdCircle.getClr());
        g.fillOval(thirdCircle.getX(), thirdCircle.getY(), thirdCircle.getR(), thirdCircle.getR());

        g.setColor(firstXCircle.getClr());
        g.fillOval(firstXCircle.getfXpos(), firstXCircle.getfYpos(), firstCircle.getSize(), firstCircle.getSize());

        g.setColor(secondXCircle.getClr());
        g.fillOval(secondXCircle.getsXpos(), secondXCircle.getsYpos(), secondCircle.getSize(), secondCircle.getSize());


    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (t0 == null) {
            t0 = new Thread(this);

        }

        if (e.getSource() == itemStart && !t0.isAlive()) {
            t0.start();
        } else if (e.getSource() == itemExit) {
            System.exit(0);
        }

    }


    @Override
    public void run() {

        while (true) {


            repaint();

        }


    }
}
