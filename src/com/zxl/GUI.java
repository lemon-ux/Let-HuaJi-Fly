package com.zxl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.Random;

/**
 * Description:
 * GUI����Ϸ������棬������ڴ�����
 *
 * @encode UTF-8
 */
public class GUI 
{
    public final int graphWidth;
    public final int graphHeight;
    public final int STARTX = 150; // ��ʼͼ�������
    public final int STARTY = 500;
    public final int EXITX = 300; // ����ͼ�������
    public final int EXITY = 500;
    public final int HUAJIX = 200; // ����������
    public final int HUAJIY = 200;
    public static final int PROGRESSWIDTH = 40;
    public static final int BOTTOM = 70;

    public int mouseX;
    public int mouseY;
    public Role[] roles = new Role[Game.EnemyNr + 3];
    public PaintPanel conn = new PaintPanel(roles, "paintPanel");// ��Ϸ�еĽ���
    public  JFrame jf; // ��ʼ����
    public JButton start;
    public JButton exit;
    public JLabel huaJi;
    public JLabel currentScoreLabel;
    public JLabel maxScoreLabel;
    public JLabel gameLevelLabel;
    public JLabel letHuaJiFly;
    public ProgressUI jProBar; // ����ֵ
    Random rand = new Random();
    public int movex = rand.nextInt(50) + 20;
    public int movey = rand.nextInt(50) + 20;

    public static Color initColor;

    public GUI() 
    {
        jf = new JFrame("Let HuaJi Fly!"); // ��������
        Toolkit kit = Toolkit.getDefaultToolkit(); // ����Ӧ��Ļ��С
        graphWidth = kit.getScreenSize().width;
        graphHeight = kit.getScreenSize().height - BOTTOM;

        jf.setBounds(graphWidth / 2 - 300, graphHeight / 2 - 400, 600, 800); // �趨λ��

        jf.setLayout(null); // ��ղ��ֹ�����
        jf.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        conn.setLayout(null);
        start = new JButton();
        start.setBounds(STARTX, STARTY, 200, 70);
        exit = new JButton();
        exit.setBounds(EXITX, EXITY, 200, 70);

        start.setIcon(new ImageIcon("./res/start.png"));
        start.setMargin(new Insets(0, 0, 0, 0));//���߿�����������ҿռ�����Ϊ0
        start.setIconTextGap(0);//����ǩ����ʾ���ı���ͼ��֮��ļ��������Ϊ0
        start.setBorderPainted(false);//����ӡ�߿�
        start.setBorder(null);//��ȥ�߿�
        start.setFocusPainted(false);//��ȥ����Ŀ�
        start.setContentAreaFilled(false);//��ȥĬ�ϵı������


        exit.setIcon(new ImageIcon("./res/exit.png"));
        exit.setMargin(new Insets(0, 0, 0, 0));//���߿�����������ҿռ�����Ϊ0
        exit.setIconTextGap(0);//����ǩ����ʾ���ı���ͼ��֮��ļ��������Ϊ0
        exit.setBorderPainted(false);//����ӡ�߿�
        exit.setBorder(null);//��ȥ�߿�
        exit.setFocusPainted(false);//��ȥ����Ŀ�
        exit.setContentAreaFilled(false);//��ȥĬ�ϵı������

        Font font1 = MyUtils.getSelfDefinedFont("./res/hkww.ttc", 18);
        Font font2 = MyUtils.getSelfDefinedFont("./res/font.ttf", 60);

        currentScoreLabel = new JLabel();
        currentScoreLabel.setVisible(false);
        currentScoreLabel.setFont(font1);
        currentScoreLabel.setBounds(10, 40, 200, 20);

        maxScoreLabel = new JLabel();
        maxScoreLabel.setVisible(false);
        maxScoreLabel.setFont(font1);
        maxScoreLabel.setBounds(10, 60, 200, 20);

        gameLevelLabel = new JLabel();
        gameLevelLabel.setVisible(false);
        gameLevelLabel.setFont(font1);
        gameLevelLabel.setBounds(10, 80, 200, 20);

        letHuaJiFly = new JLabel("�û�����");
        letHuaJiFly.setVisible(true);
        letHuaJiFly.setFont(font2);
        letHuaJiFly.setBounds(200, 120, 500, 100);
        letHuaJiFly.setForeground(Color.decode("#8A2BE2"));

        huaJi = new JLabel();
        huaJi.setBounds(HUAJIX, HUAJIY, 300, 300);
        huaJi.setIcon(new ImageIcon("./res/normal2.png"));
        huaJi.setIconTextGap(0);//����ǩ����ʾ���ı���ͼ��֮��ļ��������Ϊ0
        huaJi.setBorder(null);//��ȥ�߿�

        conn.add(start);
        conn.add(exit);
        conn.add(huaJi);
        conn.add(currentScoreLabel);
        conn.add(maxScoreLabel);
        conn.add(gameLevelLabel);
        conn.add(letHuaJiFly);

        jProBar = new ProgressUI();
        jProBar.getjProgressBar().setSize(graphWidth, PROGRESSWIDTH);
        jProBar.getjProgressBar().setLocation(0, 0);
        jProBar.getjProgressBar().setVisible(false);
        conn.add(jProBar.getjProgressBar());

        jf.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            	mouseX = e.getX() ;
                mouseY = e.getY() ;
            }
        });
                
        /*jf.addKeyListener(new KeyListener() {

    		@Override
    		public void keyTyped(KeyEvent e1) {
    			// TODO Auto-generated method stub	
    		}

    		@Override
    		public void keyPressed(KeyEvent e1) {
    			if (e1.getKeyCode() == KeyEvent.VK_SHIFT) { 
    				
    		try {
    			Robot myrobot;
    			myrobot = new Robot();
        	    myrobot.mouseMove(mouseX + movex, mouseY + movex);
    		} catch (AWTException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
    		}
    		}
    		
    		@Override
    		public void keyReleased(KeyEvent e1) {
    			// TODO Auto-generated method stub
    		}	
        });	*/
        
        jf.setContentPane(conn);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /*
     * �������н�ɫ
     */
    public void printAllEnemies() {
        jf.getContentPane().repaint();
    }

    /*
     * ��ͼ�л����µĽ�ɫ
     */
    public void updateRole(Role c) {
        if (c != null) {
            if (c.getID() == Game.EnemyNr) {
                roles[c.getID()] = c;
                jf.getContentPane().repaint();
            } else {
                roles[c.getID()] = c;
            }
        }
    }

    /*
    * ��Ϸ��������ս���Ľ�ɫ
    */
    public void clearRole(){
        for(int i = 0; i < roles.length; i++){
            roles[i] = null;
        }
        jf.getContentPane().repaint();
    }
}