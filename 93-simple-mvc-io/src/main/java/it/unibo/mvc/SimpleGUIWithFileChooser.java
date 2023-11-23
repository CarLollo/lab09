package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private static final String TITLE = "My second Java graphical interface";
    private final JFrame frame = new JFrame(TITLE);
    private static final int PROPORTION = 2;
    private final FileController controller = new Controller();
    
    public SimpleGUIWithFileChooser() {
        this.buildView();
        this.display();
    }

    private void buildView()  {
        final JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea textArea = new JTextArea();
        
        final JButton button = new JButton("Save");

        button.addActionListener(new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                String s = textArea.getText();
                try {
                    SimpleGUIWithFileChooser.this.controller.writeLine(s);
                } catch(IOException ex) {
                    System.out.println("Problema!" + ex);
                }
            }           
        });

        final JPanel panelElement = new JPanel();
        panelElement.setLayout(new BorderLayout());

        final JTextField textField = new JTextField();
        textField.setEditable(false);
        
        final JButton browserButton = new JButton("Browse...");

        final JFileChooser fileChooser = new JFileChooser();

        browserButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // Qui abbiamo cliccato il bottone
                final int chooseResult = fileChooser.showSaveDialog(panel);
                if(chooseResult == JFileChooser.APPROVE_OPTION) {
                    SimpleGUIWithFileChooser.this.controller.setFile(fileChooser.getSelectedFile());
                    textField.setText(SimpleGUIWithFileChooser.this.controller.getPathFile());
                } else if( chooseResult == JFileChooser.CANCEL_OPTION) {

                } else {
                    JOptionPane.showMessageDialog(panel, "Errore"); 
                }
            }
            
        });        
        
        panel.add(panelElement, BorderLayout.NORTH);
        panelElement.add(textField, BorderLayout.CENTER);
        panelElement.add(browserButton, BorderLayout.AFTER_LINE_ENDS);
        
        panel.add(textArea, BorderLayout.CENTER);
        panel.add(button, BorderLayout.SOUTH);
        frame.setContentPane(panel);
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
        new SimpleGUIWithFileChooser();
    }

}
