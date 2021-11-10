package metodo_simplex;
import java.awt.Color;
import javax.swing.JFrame;//paqueteria para poder crear las ventanas 
import javax.swing.JPanel;//para poder crear un panel
//import java.awt.Color;//para poder dar color a el panel
import java.awt.Font;//PODER DARLE FORMATO A EL TEXTO 
import javax.swing.JLabel;//libreria para poder generar las etiquetass
import javax.swing.SwingConstants;//para poder centrar las etiquetas 
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
public class princiPal extends JFrame {
    /**Colores para la vetana **/ 
    Color gummental = new Color(10,46,54);
    Color esmeralda = new Color(20,204,96);
   Color verde_prim = new Color(39,251,107);
         
    public princiPal(){
        setTitle("Metodo simplex");
        setBounds(350,100,800,500);
       componentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
     
     private void componentes(){
    JPanel panel= new JPanel();
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
}