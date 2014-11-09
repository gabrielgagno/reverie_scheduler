package reverie.view;

import reverie.scheduler.AppState;

import javax.swing.*;

/**
 * Created by Dell on 11/7/2014.
 */
public class ReverieMainFrame extends JFrame {
    ReverieMainPanel mainPanel;
    JMenuBar menuBar;
    JMenu fileMenu;
    JMenu viewMenu;
    JMenu helpMenu;
    JMenuItem settingsItem;
    JMenuItem exitItem;

    public ReverieMainFrame(){
        //initializing the menu and menu items
        menuBar = new JMenuBar();
        fileMenu = new JMenu("File");
        viewMenu = new JMenu("View");
        helpMenu = new JMenu("Help");

        settingsItem = new JMenuItem("Settings");
        exitItem = new JMenuItem("Exit");

        menuBar.add(fileMenu);
        menuBar.add(viewMenu);
        menuBar.add(helpMenu);
        fileMenu.add(settingsItem);
        fileMenu.add(exitItem);
        this.add(menuBar);

        //initializing the panel
        mainPanel = new ReverieMainPanel();

        //initializing the frame
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setTitle("Reverie Scheduler 1.0");
        this.setSize(900, 500);
        this.setVisible(true);
    }
}
