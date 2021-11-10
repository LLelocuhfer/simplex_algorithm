package metodo_simplex;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class princiPal extends JFrame {
    /**Colores para la vetana **/ 
    Color gummental = new Color(10,46,54);
    Color esmeralda = new Color(20,204,96);
   Color verde_prim = new Color(39,251,107);
   Color verde_fuerte = new Color (3,109,25);
    Color verde_secundario = new Color (9,161,41);
    Color caja_c = new Color (234,242,239);
         public  JPanel panel;
        
         public princiPal(){
        setTitle("Metodo simplex");
        setBounds(0,0,1875,765);
       componentes();
       botones();
       cajatexto();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
     
     private void componentes(){
    panel= new JPanel();
    panel.setBackground(verde_prim);
    panel.setLayout(null);
    this.getContentPane().add(panel);
    
    JLabel titulo_1 = new JLabel("Solucion del metodo simplex",SwingConstants.CENTER); 
   titulo_1.setBounds(-1,-1,1500,25);
   titulo_1.setForeground(esmeralda);
   titulo_1.setOpaque(true);
   titulo_1.setBackground(gummental);
   titulo_1.setFont(new Font("arial",Font.BOLD,20));
     panel.add(titulo_1);
     
     JLabel etiqueta1 = new JLabel ("Ingresa el numero de variables:",SwingConstants.CENTER);
    etiqueta1.setForeground(gummental);
    etiqueta1.setBounds(30,40,200,25);
    etiqueta1.setFont(new Font("arial",Font.BOLD,12));
    panel.add(etiqueta1);
    
    }
     private void botones ()
     {
         JButton boton_1 = new JButton ();
         boton_1.setText("Iniciar");
         boton_1.setBounds(1250,40,100,40);
         boton_1.setBackground(gummental);
         boton_1.setForeground(esmeralda);
         boton_1.setEnabled(true);
         boton_1.setBorder(new LineBorder(gummental));
          boton_1.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
         panel.add(boton_1);
     }
     
     private void cajatexto(){
         JTextField caja = new JTextField();
         caja.setBounds(220,40,100,25);
         caja.setBackground(caja_c);
         
         panel.add(caja);
     }
     
}
