package views;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.GridLayout;

public class PanelText extends JPanel{

    public final static String LBL_REQ1 = "<html><body> <br> Proyectos que no hayan sido pagados, cuyo total (suma)en la cantidad de compra supere los 50, <br> agrupe esta consulta por el id del proyecto. <br>  <br> </body></html>";

    public final static String LBL_REQ2 = "<html><body> <br> Proyectos iniciados en los últimos años ordenados desde el más antiguo al más reciente cuyos <br> estratos sean mayores o iguales a 5, los cuales no sean financiables, pero el porcentaje <br> de cuota inicial sea mayor al 30%. <br>  <br> </body></html>";
      
    public final static String LBL_REQ3 = "<html><body> <br> Proyectos de apartamentos o aparta-estudios no pagados, o pagados parcialmente que dentro de <br> sus compras tengan material de construcción importado y que no se entreguen acabados. <br>  <br> </body></html>";

    private Interfaz interfaz;
    
    private JLabel lblSaldo;

    public PanelText(Interfaz inter) {
        super();
        setLayout(new GridLayout(1, 4));
        setBorder(new TitledBorder("Descripción del requerimiento"));
        setBackground(Color.WHITE);
        interfaz = inter;
        lblSaldo = new JLabel(LBL_REQ1);
        add(lblSaldo);
    }

    public void updateTextReqs1() {        
        lblSaldo.setText(LBL_REQ1);
    }    

    public void updateTextReqs2() {        
        lblSaldo.setText(LBL_REQ2);
    } 

    public void updateTextReqs3() {        
        lblSaldo.setText(LBL_REQ3);
    } 

}

