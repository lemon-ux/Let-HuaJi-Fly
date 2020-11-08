package com.zxl;


import java.util.Random;

/**
 * Description:
 * ��ɫ�࣬��Ϊ����ࡢ������ĸ���
 *
 * @encode UTF-8
 */
public class Role 
{
    protected double x, y, dx, dy;
    protected int radius;
    // ��ɫ�İ뾶�������ѽ�ɫ����ΪԲ�Σ�������ײ��⣩����ɫ�����꣬ǰ���ľ���
    private int id;
    protected GUI gui;
    public int type; // ��ɫ�����ͣ���дö�������鷳
    // 1��������2��������3��������ˣ�4�����ɴ��ǣ�5����ըҩ��6����ҩˮ��7�����ӵ�
    public static String[] imgPath = {" ", "./res/huaji.png", "./res/rocket.png",
            "./res/missile.png", "./res/bigStar.png", "./res/boom.png", "./res/life.png"};
    public int angle = 0; //ͼƬת��ĽǶ�(���ǻ���)

    public Role(double X, double Y, int R, int id, int type, GUI gui, double dx, double dy) {
        x = X;
        y = Y;
        radius = R;
        Random random = new Random();
        this.dx = random.nextBoolean() ? dx : -dx;
        this.dy = random.nextBoolean() ? dy : -dy;
        this.gui = gui;
        this.type = type;
        this.id = id;
        draw();
    }

    public Role(double X, double Y, int R, int id, int type, GUI gui) {
        x = X;
        y = Y;
        radius = R;
        this.type = type;
        this.gui = gui;
        this.id = id;
    }

    public Role(){
    }

    public void draw() {
        gui.updateRole(this);
    }

    public void move() {
        x += dx;
        y += dy;
        if (x + radius > gui.graphWidth || x - radius < 0) {
            calMoveDirection();
        }
        if (y + radius > gui.graphHeight || y - radius < GUI.PROGRESSWIDTH) {
            calMoveDirection();
        }
        draw();
    }

    protected void calMoveDirection() {
        dx = -dx;
        dy = -dy;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getR() {
        return radius;
    }

    public int getD() {
        return radius << 1;
    }

    public int getID() {
        return id;
    }
}