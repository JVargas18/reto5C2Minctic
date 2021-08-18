package views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import controller.Controller;

import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Interfaz  extends JFrame{

    private PanelOpciones panelOpciones;  
    private PanelText panelText;
    private PanelReqs panelReqs; 

    private Controller controller;

    public Interfaz() {
        super();
        setSize(600, 450);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Requerimientos");
        setLayout(new BorderLayout());

        controller = new Controller("jdbc:mysql://localhost:3306/proyectos");

        panelOpciones = new PanelOpciones(this);
        panelReqs = new PanelReqs(this);
        panelText = new PanelText(this);
        JPanel panelCentral = new JPanel();
        panelCentral.setLayout(new GridLayout(1, 4));
        panelCentral.add(panelReqs);

        add(panelText, BorderLayout.NORTH);
        add(panelOpciones, BorderLayout.SOUTH);
        add(panelCentral, BorderLayout.CENTER);
    
        JScrollPane scroll = new JScrollPane(panelCentral);
        add(scroll, BorderLayout.CENTER);

        updateReqs1List();
    }
    
    public void updateReqs1List() {
        controller.req1();
        panelReqs.updateReqs1(controller.getDataReq1());
        panelText.updateTextReqs1();
    }

    public void updateReqs2List() {
        controller.req2();
        panelReqs.updateReqs2(controller.getDataReq2());
        panelText.updateTextReqs2();
    }

    public void updateReqs3List() {
        controller.req3();
        panelReqs.updateReqs3(controller.getDataReq3());
        panelText.updateTextReqs3();
    }
    public static void main(String[] args) {
        Interfaz vistaPrincipal = new Interfaz();
        vistaPrincipal.setVisible(true);
    }
}
