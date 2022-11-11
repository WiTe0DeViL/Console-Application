import javax.swing.*;
import java.awt.*;

public class Window {
    JFrame window;
    JTextArea textArea;
    JScrollPane scrollPane;
    JMenu menuFile, menuEdit, menuFormat, menuTheme;
    JMenuBar menuBar;
    JMenuItem fileNew, fileSave, fileSaveAs, fileExit;

    Window() {
        createWindow();
        createTextArea();
        createMenu();
        createFileMenu();
        window.setVisible(true);
    }

    public void createWindow() {
        window = new JFrame("Notepad");
        window.setSize(890, 500);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    private void createTextArea() {
        textArea = new JTextArea();
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        window.add(scrollPane);
    }

    private void createMenu() {
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);
        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);
        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);
        menuTheme = new JMenu("Theme");
        menuBar.add(menuTheme);
    }

    public void createFileMenu() {
        fileNew = new JMenuItem("New");
        menuFile.add(fileNew);
        fileSave = new JMenuItem("Save");
        menuFile.add(fileSave);
        fileSaveAs = new JMenuItem("Save as");
        menuFile.add(fileSaveAs);
        fileExit = new JMenuItem("Exit");
        menuFile.add(fileExit);
    }

    public void createEditMenu(){
    }

}
