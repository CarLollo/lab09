package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Dimension;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "My first Java graphical interface";
    private final JFrame frame = new JFrame(TITLE);
    private static final int PROPORTION = 2;
    private final FileController controller = new Controller();
    
    public SimpleGUI() {
        this.buildView();
        this.display();
    }

    private void buildView()  {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea textArea = new JTextArea();
        
        final JButton button = new JButton("Save");

        panel.add(textArea, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        frame.setContentPane(panel);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String s = textArea.getText();
                try {
                    SimpleGUI.this.controller.writeLine(s);
                } catch(IOException ex) {
                    System.out.println("Problema!" + ex);
                }
            }
            
        });

        //TOD0: delete
        /*final JFileChooser fileChooser = new JFileChooser();
        final JButton browserButton = new JButton(); 
        browserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Qui abbiamo cliccato il bottone
                final int chooseResult = fileChooser.showSaveDialog(elementPanel);
                if(chooseResult == JFileChooser.APPROVE_OPTION) {
                    SimpleGUI.this.controller.setFile(fileChooser.getSelectedFile());
                    textArea.setText(SimpleGUI.this.controller.getPath());
                } else if( chooseResult == JFileChooser.CANCEL_OPTION) {
                    JOptionPane.showMessageDialog(elementPanel, "Errore"); // verify
                }

            }
        });*/




        
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
