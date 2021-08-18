package views;

import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.GridLayout;

public class PanelReqs extends JPanel {
    
    private JList<String> listaReqs;
        
    public PanelReqs(Interfaz inter) {
        super();
        
        setLayout(new GridLayout());
        //setBorder(new TitledBorder("Requerimiento_1"));
        listaReqs = new JList<>();        
        add(listaReqs);        
        
    }

    public void updateReqs1(String[] listaReqs1) {
        setBorder(new TitledBorder("Requerimiento_1:"));
        listaReqs.setListData(listaReqs1);
    }

    public void updateReqs2(String[] listaReqs2) {
        setBorder(new TitledBorder("Requerimiento_2"));
        listaReqs.setListData(listaReqs2);
    }

    public void updateReqs3(String[] listaReqs3) {
        setBorder(new TitledBorder("Requerimiento_3"));
        listaReqs.setListData(listaReqs3);
    }
}
