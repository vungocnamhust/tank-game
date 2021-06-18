package cn.qingyun.domain;

public class Message {

    public static int enemyTankNums = 2;
    public static int roleTankNums = 2;
    public static int hitTankNums = 0;

    public static void downEnemyTankNums() {
        enemyTankNums--;
    }

    public static void downRoleTankNums() {
        roleTankNums--;
    }

    public static void addHitTankNumus() {
        hitTankNums++;
    }

    public static int getEnemyTankNums() {
        return enemyTankNums;
    }

    public static void setEnemyTankNums(int enemyTankNums) {
        Message.enemyTankNums = enemyTankNums;
    }

    public static int getRoleTankNums() {
        return roleTankNums;
    }

    public static void setRoleTankNums(int roleTankNums) {
        Message.roleTankNums = roleTankNums;
    }

    public static int getHitTankNums() {
        return hitTankNums;
    }

    public static void setHitTankNums(int hitTankNums) {
        Message.hitTankNums = hitTankNums;
    }


}
