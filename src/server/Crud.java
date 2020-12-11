/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author kasmira
 */
public class Crud extends UnicastRemoteObject implements RMImethod {

    public Crud() throws RemoteException {
        koneksi();
    }
    public boolean databaru = true;
    Statement stat;
    ResultSet rs;
    private Connection connection;

    private void koneksi() {
        String DB = "jdbc:mysql://localhost/siangkatan";
        String user = "root";
        String pass = "";
        try {
            DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            connection = (Connection) DriverManager.getConnection(DB, user, pass);
            if (connection != null) {
                System.out.println("Koneksi db Berhasil");
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String insertstrukutal(ModelStruktural ms) {
        String sql = "insert into struktural values(null,?,?,?)";
        String value = "";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, ms.getKetua());
            statement.setString(2, ms.getSekretaris());
            statement.setString(3, ms.getBendahara());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                value = "Berhasil";
            } else {
                value = "Gagal";
            }

        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    @Override
    public String updatestruktural(int id, ModelStruktural ms) {
        PreparedStatement ps = null;
        String status = "";
        String sql = "UPDATE struktural SET ketua = ?, sekretaris=?, bendahara=? WHERE id= ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, ms.getKetua());
            ps.setString(3, ms.getSekretaris());
            ps.setString(4, ms.getBendahara());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public String deletestrukutal(int id) {
        PreparedStatement ps = null;
        String status = "";
        String sql = "DELETE FROM `struktural` WHERE id =?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public String insertsejarah(ModelSejarah s) {
        String sql = "insert into sejarah values(null,?)";
        String value = "";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getSejarah());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                value = "Berhasil";
            } else {
                value = "Gagal";
            }

        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    @Override
    public String updatesejarah(int id, ModelSejarah s) {
        PreparedStatement ps = null;
        String status = "";
        String sql = "UPDATE sejarah SET sejarah = ? WHERE id= ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(2, id);
            ps.setString(1, s.getSejarah());
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public String deletesejarah(int id) {
        PreparedStatement ps = null;
        String status = "";
        String sql = "DELETE FROM `sejarah` WHERE id =?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public String insertnamaangkatan(ModelNamaAngkatan mn) {
        String sql = "insert into namaangkatan values(null,?,?)";
        String value = "";

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, mn.getNama());
            statement.setString(2, mn.getTahun());

            int rowInserted = statement.executeUpdate();
            if (rowInserted > 0) {
                value = "Berhasil";
            } else {
                value = "Gagal";
            }

        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    @Override
    public String updatenamaangkatan(int id, ModelNamaAngkatan mn) {
        PreparedStatement ps = null;
        String status = "";
        String sql = "UPDATE namaangkatan SET nama = ?, tahun=? WHERE id= ?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setString(1, mn.getNama());
            ps.setString(2, mn.getTahun());
            ps.setInt(3, id);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return status;
    }

    @Override
    public String deletenamaangkatan(int id) {
        PreparedStatement ps = null;
        String status = "";
        String sql = "DELETE FROM `namaangkatan` WHERE id =?";
        try {
            ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return status;
    }

    @Override
    public List<ModelStruktural> getStruktural() throws RemoteException {
        List<ModelStruktural> data = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM struktural");
            while (rs.next()) {
                data.add(new ModelStruktural(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public List<ModelSejarah> getSejarah() throws RemoteException {
        List<ModelSejarah> data = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM sejarah");
            while (rs.next()) {
                data.add(new ModelSejarah(rs.getInt(1), rs.getString(2)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

    @Override
    public List<ModelNamaAngkatan> getNamaAngkatan() throws RemoteException {
        List<ModelNamaAngkatan> data = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM namaangkatan");
            while (rs.next()) {
                data.add(new ModelNamaAngkatan(rs.getInt(1), rs.getString(2), rs.getString(3)));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Crud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data;
    }

}
