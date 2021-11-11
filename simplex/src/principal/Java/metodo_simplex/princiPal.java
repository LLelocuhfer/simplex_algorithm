package metodo_simplex;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

public class princiPal<J> extends JFrame {
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
        boton_eliminar();
        cajatexto();
        cajatexto2();
        cajatexto3();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
     
  
  
       

        
    private void componentes(){
    panel= new JPanel();
    panel.setBackground(verde_prim);
    panel.setLayout(null);
    this.getContentPane().add(panel);
    //header
    JLabel titulo_1 = new JLabel("| Solucion del metodo simplex |",SwingConstants.CENTER); 
    titulo_1.setBounds(-1,-1,1400,35);
    titulo_1.setForeground(esmeralda);
    titulo_1.setOpaque(true);
    titulo_1.setBackground(gummental);
    titulo_1.setFont(new Font("arial",Font.BOLD,20));
    panel.add(titulo_1);
    //footer
    JLabel titulo_2 = new JLabel("| Desarrollado por: | Fernando Patoni De La Rosa | Jesus Antonio Mendez Garcia | Sebastian Giovanni Grajales Mendez",SwingConstants.CENTER);
    titulo_2.setBounds(-1,670,1400,35);
    titulo_2.setForeground(esmeralda);
    titulo_2.setOpaque(true);
    titulo_2.setBackground(gummental);
    titulo_2.setFont(new Font("arial",Font.BOLD,20));
    panel.add(titulo_2);

    //datos de entrada 
    String[] datos = {"Maximizar","Minimizar"};
    //etiqueta de la caja de texto
    JLabel etiqueta_c = new JLabel("Ingrese el tipo de problema:    ",SwingConstants.LEFT);
    etiqueta_c.setForeground(gummental);
    etiqueta_c.setBounds(30,40,200,25);
    etiqueta_c.setFont(new Font("arial",Font.BOLD,12));
    panel.add(etiqueta_c);
    //Elegir el tipo de problema
    JComboBox<String> caja_1 = new JComboBox<String>(datos);
    caja_1.setBounds(220,40,150,25);
    caja_1.setBackground(caja_c); 
    caja_1.setForeground(verde_secundario);
    caja_1.setFont(new Font("arial",Font.BOLD,15));
    panel.add(caja_1);

    JLabel etiqueta1 = new JLabel ("Ingresa el numero de variables:    ",SwingConstants.LEFT);
    etiqueta1.setForeground(gummental);
    etiqueta1.setBounds(30,80,200,25);
    etiqueta1.setFont(new Font("arial",Font.BOLD,12));
    panel.add(etiqueta1);

    JLabel etiqueta2 = new JLabel ("Ingresa la funcion objetivo   ",SwingConstants.LEFT);
    etiqueta2.setForeground(gummental);
    etiqueta2.setBounds(30,120,200,25);
    etiqueta2.setFont(new Font("arial",Font.BOLD,12));
    panel.add(etiqueta2);

    JLabel etiqueta3 = new JLabel ("Ingresa las restricciones   ",SwingConstants.LEFT);
    etiqueta3.setForeground(gummental);
    etiqueta3.setBounds(30,160,200,25);
    etiqueta3.setFont(new Font("arial",Font.BOLD,12));
    panel.add(etiqueta3);

    }
    private void botones (){
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
     private void boton_eliminar (){
        JButton boton_2 = new JButton ();
        boton_2.setText("Eliminar");
        boton_2.setBounds(30,200,100,40);
        boton_2.setBackground(gummental);
        boton_2.setForeground(esmeralda);
        boton_2.setEnabled(true);
        boton_2.setBorder(new LineBorder(gummental));
        boton_2.setFont(new Font("Franklin Gothic Heavy",Font.BOLD,20));
        panel.add(boton_2);
     }
     private void cajatexto(){
         JTextField caja = new JTextField();
         caja.setBounds(220,80,150,25);
         caja.setBackground(caja_c);    
         panel.add(caja);
     }
     private void cajatexto2(){
         JTextField caja2 = new JTextField();
         caja2.setBounds(220,120,150,25);
         caja2.setBackground(caja_c);    
         panel.add(caja2);
     }

     private void cajatexto3(){
         JTextField caja3 = new JTextField();
         caja3.setBounds(220,160,150,25);
         caja3.setBackground(caja_c);    
         panel.add(caja3);
     }

}
