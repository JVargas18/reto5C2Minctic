package views;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelOpciones extends JPanel implements ActionListener {

    public final static String BTN_REQ1 = "Requerimiento 1";
    public final static String BTN_REQ2 = "Requerimiento 2";
    public final static String BTN_REQ3 = "Requerimiento 3";

    // crear relaciones o atributos
    private JButton btnReq1;
    private JButton btnReq2;
    private JButton btnReq3;    
    
    private Interfaz interfaz;
    
    public PanelOpciones(Interfaz inter) {
        super();
        setLayout(new GridLayout(1, 4));
        setBorder(new TitledBorder("Opciones"));

        interfaz = inter;

        //inicializar las relaciones o atributos
        btnReq1 = new JButton(BTN_REQ1);
        btnReq2 = new JButton(BTN_REQ2);
        btnReq3 = new JButton(BTN_REQ3);
        //modificar las propiedades (opcional)
        btnReq1.setActionCommand(BTN_REQ1);
        btnReq2.setActionCommand(BTN_REQ2);
        btnReq3.setActionCommand(BTN_REQ3);

        btnReq1.addActionListener(this);
        btnReq2.addActionListener(this);
        btnReq3.addActionListener(this);
        //agregar las relaciones o atributos
        add(btnReq1);
        add(btnReq2);
        add(btnReq3);
        btnMouseChangeColor(btnReq1,btnReq2,btnReq3);
    }

    private void btnMouseChangeColor(JButton btn1, JButton btn2, JButton btn3){
        btn1.setBackground(Color.LIGHT_GRAY);
        btn2.setBackground(Color.WHITE);
        btn3.setBackground(Color.WHITE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals(BTN_REQ1)) {
            btnMouseChangeColor(btnReq1,btnReq2,btnReq3);
            interfaz.updateReqs1List();            
        }else if(e.getActionCommand().equals(BTN_REQ2)){
            btnMouseChangeColor(btnReq2,btnReq1,btnReq3);
            interfaz.updateReqs2List();
        }else if(e.getActionCommand().equals(BTN_REQ3)){
            btnMouseChangeColor(btnReq3,btnReq1,btnReq2);
            interfaz.updateReqs3List();
        }
    }

}
