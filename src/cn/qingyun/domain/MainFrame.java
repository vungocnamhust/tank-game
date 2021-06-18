package cn.qingyun.domain;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import client.Client;
import jdk.nashorn.internal.codegen.*;

public class MainFrame extends JFrame implements ActionListener {

    private JMenuItem menuItem;
    private StartPanel startPanel = new StartPanel();
    Client client;
    public int[] clientIds;
    public int obstaclesX[] = {217, 262, 521, 225, 184, 519, 396, 158, 398, 468, 409, 689, 178, 499, 692, 235, 313, 358, 317, 468, 648, 443, 639, 528, 252, 499, 269, 554, 465, 380, 267, 653, 393, 201, 682, 583, 667, 304, 476, 569, 523, 263, 269, 332, 617, 225, 223, 690, 169, 198};
    public int obstaclesY[] = {296, 274, 240, 100, 178, 216, 133, 290, 175, 283, 155, 164, 174, 136, 269, 295, 151, 163, 259, 105, 105, 237, 283, 293, 275, 208, 193, 125, 176, 202, 290, 297, 251, 256, 227, 272, 216, 129, 170, 119, 270, 204, 140, 128, 285, 287, 283, 227, 202, 251};
    public ArrayList<Obstacle> obstacles = new ArrayList<Obstacle>();

    public MainFrame() {
        initFrame();
        addPanel();
        this.client = new Client("127.0.0.1", 4321);
        this.client.startPanel = startPanel;
        this.client.mainFrame = this;
        System.out.println("start panel: " + startPanel);
        this.client.sendMessage("NEW_PLAYER");
    }

    private void addPanel() {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        menu.setMnemonic('G');
        menuItem = new JMenuItem("New game(N)");
        JMenuItem exitGame = new JMenuItem("Exit(E)");
        exitGame.setMnemonic('E');

        menuItem.addActionListener(this);
        menuItem.setActionCommand("newGame");
        exitGame.addActionListener(this);
        exitGame.setActionCommand("exitGame");

        menu.add(menuItem);
        menu.add(exitGame);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
        this.add(startPanel);
    }

    private void initFrame() {
        this.setTitle("Tank game");
        this.setSize(800, 550);
        this.setLocation(200, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public  void enterGame() {
        this.generateObstacle();
        MainPanel mainPanel = new MainPanel(client, clientIds, this.obstacles);
        this.client.mainPanel = mainPanel;

        mainPanel.repaint();
        Thread thread = new Thread(mainPanel);
        thread.start();

        this.remove(startPanel);
        this.add(mainPanel);
        this.addKeyListener(mainPanel);
        this.setVisible(true);
    }

    public void generateObstacle() {
        for (int i = 0; i < 15; i++) {
            Obstacle obstacle = new Obstacle(obstaclesX[i], obstaclesY[i], i);
            this.obstacles.add(obstacle);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("newGame")) {
            enterGame();
//            EnemyTank[] enemyTanks = {};
//            MainPanel mainPanel = new MainPanel(client, enemyTanks);
//
//            this.client.mainPanel = mainPanel;
//
//
//            mainPanel.repaint();
//            Thread thread = new Thread(mainPanel);
//            thread.start();
//
//            this.remove(startPanel);
//            this.add(mainPanel);
//            this.addKeyListener(mainPanel);
////	    	  Voice voice = new Voice("F:\\��Ϸ����\\voice.wav");
////	    	  voice.start();
//            this.setVisible(true);

        } else if (e.getActionCommand().equals("exitGame")) {
            System.exit(0);
        }
    }


}
