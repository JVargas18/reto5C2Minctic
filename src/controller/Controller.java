package controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Req1;
import model.Req2;
import model.Req3;
import services.Conector;

public class Controller {

    private ArrayList<Req1> req1s;
    private ArrayList<Req2> req2s;
    private ArrayList<Req3> req3s;
    private Conector conectorDB;

    public Conector getConectorDB() {
        return conectorDB;
    }

    public void setConectorDB(Conector conectorDB) {
        this.conectorDB = conectorDB;
    }

    public ArrayList<Req1> getReq1s() {
        return req1s;
    }

    public void setReq1s(ArrayList<Req1> req1s) {
        this.req1s = req1s;
    }

    public ArrayList<Req2> getReq2s() {
        return req2s;
    }

    public void setReq2s(ArrayList<Req2> req2s) {
        this.req2s = req2s;
    }

    public ArrayList<Req3> getReq3s() {
        return req3s;
    }

    public void setReq3s(ArrayList<Req3> req3s) {
        this.req3s = req3s;
    }

    public Controller(String url) {
        super();
        req1s = new ArrayList<>();
        req2s = new ArrayList<>();
        req3s = new ArrayList<>();
        conectorDB = new Conector(url);
    }

    public void req1() {
        req1s = new ArrayList<>();
        ResultSet rs = conectorDB.getReq1DB();
        try {
            while (rs.next()) {
                Req1 req1 = new Req1(rs.getInt("total")    ,rs.getInt("idProyecto"), 
                                     rs.getString("pagado"),rs.getString("proveedor"));
                req1.setTotal(rs.getInt("total"));
                req1.setIdProyecto(rs.getInt("idProyecto"));
                req1.setPagado(rs.getString("pagado"));
                req1.setProveedor(rs.getString("proveedor"));
                req1s.add(req1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void req2() {
        req2s = new ArrayList<>();
        ResultSet rs = conectorDB.getReq2DB();
        try {
            while (rs.next()) {
                Req2 req2 = new Req2(rs.getInt("estrato"),rs.getInt("financiable"), rs.getString("fechaInicio"),rs.getDouble("porcetaje"));
                
                req2.setEstrato(rs.getInt("estrato"));
                req2.setFinanciable(rs.getInt("financiable"));
                //req2.setFechaInicio(rs.getString("fechaInicio").substring(0, 10));
                req2.setFechaInicio(rs.getString("fechaInicio"));
                req2.setPorcetaje(rs.getDouble("porcetaje"));
                req2s.add(req2);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void req3() {
        req3s = new ArrayList<>();
        ResultSet rs = conectorDB.getReq3DB();
        try {
            while (rs.next()) {//int idProyecto, String pagado, String clasificacion
                Req3 req3 = new Req3(rs.getInt("idProyecto"),rs.getString("pagado"), rs.getString("clasificacion"));
                req3.setIdProyecto(rs.getInt("idProyecto"));
                req3.setPagado(rs.getString("pagado"));
                req3.setClasificacion(rs.getString("clasificacion"));
                req3s.add(req3);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void printReq1() {
        for (Req1 req1 : req1s) {
            System.out.println(req1);
        }
    }

    public String[] getDataReq1() {
        String[] dataReq1 = new String[req1s.size()];
        for (int i = 0; i < dataReq1.length; i++) {
            dataReq1[i] = req1s.get(i).toString();
        }
        return dataReq1;
    }
   
    public void printReq2() {
        for (Req2 req2 : req2s) {
            System.out.println(req2);
        }
    }

    public String[] getDataReq2() {
        String[] dataReq2 = new String[req2s.size()];
        for (int i = 0; i < dataReq2.length; i++) {
            dataReq2[i] = req2s.get(i).toString();
        }
        return dataReq2;
    }

    public void printReq3() {
        for (Req3 req3 : req3s) {
            System.out.println(req3);
        }
    }

    public String[] getDataReq3() {
        String[] dataReq3 = new String[req3s.size()];
        for (int i = 0; i < dataReq3.length; i++) {
            dataReq3[i] = req3s.get(i).toString();
        }
        return dataReq3;
    }
}
