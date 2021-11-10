package metodo_simplex;

import java.awt.*;
import javax.swing.*;

public class princiPal extends JFrame {
    /**Colores para la vetana **/ 
    Color gummental = new Color(10,46,54);
    Color esmeralda = new Color(20,204,96);
   Color verde_prim = new Color(39,251,107);
         public  JPanel panel;
        
         public princiPal(){
        setTitle("Metodo simplex");
        setBounds(0,0,1875,765);
       componentes();
       botones();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
     
     private void componentes(){
    panel= new JPanel();
    panel.setBackground(verde_prim);
    panel.setLayout(null);
    this.getContentPane().add(panel);
    
    JLabel titulo_1 = new JLabel("Solucion del metodo simplex",SwingConstants.CENTER); 
   titulo_1.setBounds(-1,-1,1400,30);
   titulo_1.setForeground(esmeralda);
   titulo_1.setOpaque(true);
   titulo_1.setBackground(gummental);
   titulo_1.setFont(new Font("arial",Font.BOLD,20));
     panel.add(titulo_1);
    
    }
     private void botones ()
     {
         JButton boton_1 = new JButton ("Iniciar");
         boton_1.setBounds(100,100,100,23);
         panel.add(boton_1);
     }
     
}
