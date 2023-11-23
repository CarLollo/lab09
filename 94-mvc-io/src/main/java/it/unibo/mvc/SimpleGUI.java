package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.util.List;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "My first Java graphical interface";
    private final JFrame frame = new JFrame(TITLE);
    private static final int PROPORTION = 2;
    private final Controller controller = new SimpleController();

    public SimpleGUI() {
        this.buildView();
        this.display();
    }

    private void buildView()  {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextField textField = new JTextField();

        final JTextArea textArea = new JTextArea();

        final JPanel panelSouth = new JPanel();
        panelSouth.setLayout(new BoxLayout(panelSouth, BoxLayout.LINE_AXIS));
        
        final JButton buttonPrint = new JButton("Print");

        final JButton buttonHistory = new JButton("Show history");

        panel.add(textField, BorderLayout.NORTH);
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(panelSouth, BorderLayout.SOUTH);
        panelSouth.add(buttonPrint);
        panelSouth.add(buttonHistory);
        frame.setContentPane(panel);
        
        buttonPrint.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String s = textField.getText();
                try {
                    SimpleGUI.this.controller.setNext(s);
                    SimpleGUI.this.controller.printString();
                } catch(Exception ex) {
                    System.out.println("Problema!" + ex);
                }
            }
            
        });

        buttonHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    final List<String> list = SimpleGUI.this.controller.getHistory();
                    for (String s : list) {
                        textArea.append(s + "\n");
                    }
                    textArea.append("\n");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(panel, "Errore enlla stampa della history!");
                }
            }
            
        });
    }

    
    private void display() {
        
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        
        frame.setLocationByPlatform(true);
        
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new SimpleGUI();
    }
}
