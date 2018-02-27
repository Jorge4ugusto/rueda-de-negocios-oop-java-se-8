/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package clases;
import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;

import javax.swing.JFrame;

/**
 *
 * @author Jorge Augusto
 */
public class Pantalla extends JFrame {

    private static final long serialVersionUID = 1L;
    private Dimension dimension;

    public Pantalla(Dimension dimension) {
        this.dimension = dimension;
        initcomponents();
    }

    private void initcomponents() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        changeSize();
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setTitle("Ejemplo de Pantalla tamaño automatico");
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {

            public void eventDispatched(AWTEvent event) {

                Dimension newScreenSize = Toolkit.getDefaultToolkit().getScreenSize();
                if (newScreenSize.width != dimension.width || newScreenSize.height != dimension.height)
                {                           
                    changeSize();
                }
            }
        }, AWTEvent.PAINT_EVENT_MASK);
    }

    private void changeSize(){
        System.out.println("Nueva tañamo de pantalla ancho : "+dimension.width+" el alto : "+dimension.height);
        setSize(dimension);
    }

}
