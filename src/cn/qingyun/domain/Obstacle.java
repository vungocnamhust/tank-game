package cn.qingyun.domain;

public class Obstacle extends RoleTank {
    int x;
    int y;
    int id;
    public int Color = 0;

    public Obstacle(int x, int y, int id) {
        super(x, y);
        this.x = x;
        this.y = y;
        this.id = id;
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
