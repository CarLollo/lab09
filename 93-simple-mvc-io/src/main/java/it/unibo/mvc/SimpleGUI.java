package it.unibo.mvc;

import java.awt.BorderLayout;
import java.awt.LayoutManager;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import java.awt.Dimension;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String TITLE = "A very simple GUI application";
    private final JFrame frame = new JFrame(TITLE);
    private static final int PROPORTION = 2;
    private final FileController controller = new Controller();
    
    public SimpleGUI() {
        this.buildView();
        this.display();
    }

    private void buildView()  {
        final JPanel panel = new JPanel();
        final JPanel elementPanel = new JPanel();
        panel.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        final JTextArea textArea = new JTextArea();
        
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




        
        final JButton button = new JButton("Save");

        elementPanel.setLayout(new BoxLayout(elementPanel, BoxLayout.Y_AXIS));
        elementPanel.add(textArea);
        elementPanel.add(button);
        panel.add(elementPanel, BorderLayout.CENTER);
        frame.setContentPane(panel);
        button.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String s = textArea.getText();
                try {
                    SimpleGUI.this.controller.writeLine(s);
                } catch(IOException ex) {
                    System.out.println("Problema!");
                }
            }
            
        });
    }

    public static void main(String[] args) {
        new SimpleGUI();
    }

    private void display() {
        /*
         * Make the frame one fifth the resolution of the screen. This very method is
         * enough for a single screen setup. In case of multiple monitors, the
         * primary is selected. In order to deal coherently with multimonitor
         * setups, other facilities exist (see the Java documentation about this
         * issue). It is MUCH better than manually specify the size of a window
         * in pixel: it takes into account the current resolution.
         */
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        /*
         * Instead of appearing at (0,0), upper left corner of the screen, this
         * flag makes the OS window manager take care of the default positioning
         * on screen. Results may vary, but it is generally the best choice.
         */
        frame.setLocationByPlatform(true);
        //01.01
        frame.pack();
        /*
         * OK, ready to push the frame onscreen
         */
        frame.setVisible(true);
    }

}
