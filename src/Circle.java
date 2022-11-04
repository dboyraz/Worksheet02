import java.awt.*;
import java.util.Random;

public class Circle implements Runnable {


    private int x, y, r, xDelta, yDelta, move;
    private int fXpos, fYpos, sXpos, sYpos, fxDelta, fyDelta, sxDelta, syDelta;
    private final int size;
    private Color clr;
    private Random rd;

    private Direction d;

    public enum Direction {
        horizontal, vertical, diagonal, xDiagonal
    }


    public Circle(Direction dr) {

        this.d = dr;
        Random rd = new Random();
        xDelta = 10;
        yDelta = 10;
        x = rd.nextInt(700);
        y = rd.nextInt(700);
        r = rd.nextInt(300) + 50;
        clr = new Color(rd.nextInt(255), rd.nextInt(255), rd.nextInt(255));

        size = 60;

        fXpos = 100;
        fYpos = 100;
        sXpos = 200;
        sYpos = 100;

        fxDelta = 5;
        fyDelta = 5;
        sxDelta = 5;
        syDelta = 5;

    }


    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }

    public int getxDelta() {
        return xDelta;
    }

    public void setxDelta(int xDelta) {
        this.xDelta = xDelta;
    }

    public int getyDelta() {
        return yDelta;
    }

    public void setyDelta(int yDelta) {
        this.yDelta = yDelta;
    }

    public Color getClr() {
        return clr;
    }

    public void setClr(Color clr) {
        this.clr = clr;
    }

    public Random getRd() {
        return rd;
    }

    public int getSize() {
        return size;
    }

    public void moveHorizontal() {
        x += xDelta;

    }

    public void moveVertical() {
        y += yDelta;
    }

    public void moveDiagonal() {
        x += xDelta;
        y += yDelta;
    }

    private void moveDiagonalFirst() {

        fXpos += fxDelta;
        fYpos += fyDelta;

        if (fXpos > 200) {
            fXpos = 200;

            fxDelta *= -1;
            fyDelta *= -1;
        } else if (fXpos < 100) {
            fXpos = 100;
            fYpos = 100;
            fxDelta *= -1;
            fyDelta *= -1;
        }


    }

    private void moveDiagonalSecond() {


        sXpos -= sxDelta;
        sYpos += syDelta;

        if (sXpos < 100) {
            sXpos = 100;
            sxDelta *= -1;
            syDelta *= -1;
        } else if (sXpos > 200) {
            sXpos = 200;
            sYpos = 100;
            sxDelta *= -1;
            syDelta *= -1;
        }


    }

    public int getfXpos() {
        return fXpos;
    }

    public int getfYpos() {
        return fYpos;
    }

    public int getsXpos() {
        return sXpos;
    }

    public int getsYpos() {
        return sYpos;
    }

    public int getFxDelta() {
        return fxDelta;
    }

    public int getFyDelta() {
        return fyDelta;
    }

    public int getSxDelta() {
        return sxDelta;
    }

    public int getSyDelta() {
        return syDelta;
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub


        try {
            while (true) {

                Thread.sleep(100);


                switch (d) {
                    case horizontal:
                        moveHorizontal();
                        break;
                    case vertical:
                        moveVertical();
                        break;
                    case diagonal:
                        moveDiagonal();
                        break;
                    case xDiagonal:
                        moveDiagonalFirst();
                        moveDiagonalSecond();
                        break;
                }


            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }
}
