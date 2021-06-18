package cn.qingyun.domain;

public class Shot implements Runnable {

    int x, y;
    int direct;
//    Distance of a bullet moving
    int spend = 5;
//    The tank be to shot which is alive or not?
    boolean isLive = true;

    public Shot(int x, int y, int direct) {
        this.x = x;
        this.y = y;
        this.direct = direct;
    }


    @Override
    public void run() {
        while (true) {
            try {
//                Speed of bullet
                Thread.sleep(50);
                switch (this.direct) {
                    case 0:
                        y -= spend;
                        break;
                    case 1:
                        y += spend;
                        break;
                    case 2:
                        x -= spend;
                        break;
                    case 3:
                        x += spend;
                        break;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
// Set limit position of bullet
            if (this.x < -2 || this.x > 800 || this.y < -2 || this.y > 400) {
                this.isLive = false;
                break;
            }
        }

    }


    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
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


}
