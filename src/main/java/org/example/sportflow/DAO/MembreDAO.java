package org.example.sportflow.DAO;

import org.example.sportflow.bean.Entraineur;
import org.example.sportflow.bean.Membre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MembreDAO {


    private Connection conn;

    public MembreDAO() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sport","root","");
            System.out.println("Connected to the database successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");
        }

    }

    public void CreateMembre(Membre membre) {
        String sql = "insert into membre(nom ,ladate, sport_pra   , role , username , password) values(?,?,?,?,?,?)";
        try (PreparedStatement pre = conn.prepareStatement(sql)){
            pre.setString(1,membre.getNom());
            pre.setString(2,membre.getDatenaissance());
            pre.setString(3, membre.getSportpratique());
            pre.setString(4,membre.getRole());
            pre.setString(5,membre.getUsername());
            pre.setString(6,membre.getPassword());
            pre.executeUpdate();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    public List<Membre> getallMembers() {
        List<Membre> membreList = new ArrayList<>();
        String sql="SELECT * FROM membre";
        try(Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery(sql)) {
            System.out.println("ww");
            while (res.next()) {
                Membre membre = new Membre();
                membre.setId(res.getInt("id_membre"));
                membre.setNom(res.getString("nom"));
                membre.setDatenaissance(res.getString("ladate"));
                membre.setSportpratique(res.getString("sport_pra"));
                membre.setRole(res.getString("role"));
                membre.setUsername(res.getString("username"));
                membre.setPassword(res.getString("password"));

                membreList.add(membre);
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("qsqs");
        }
        return membreList;

    }

    public Membre getmembreBYid(int id) {
        Membre membre = null;
        String sql="SELECT * FROM membre WHERE id_membre = ?";
        try(PreparedStatement prest = conn.prepareStatement(sql)) {
            prest.setInt(1, id);
            try (ResultSet res = prest.executeQuery()){
                if (res.next()) {
                    membre = new Membre();
                    membre.setId(res.getInt("id_membre"));
                    membre.setNom(res.getString("nom"));
                    membre.setDatenaissance(res.getString("ladate"));
                    membre.setSportpratique(res.getString("sport_pra"));
                    membre.setRole(res.getString("role"));
                    membre.setUsername(res.getString("username"));
                    membre.setPassword(res.getString("password"));

                }

            }
            System.out.println("sffffff");

        }catch (Exception e) {
            System.out.println("membre not found");
        }
        return membre;
    }

    public void modifiermember(Membre membre) {
        System.out.println("nnn");
        String query = "UPDATE membre SET nom = ?, ladate = ? , sport_pra = ? , role = ? , username = ? , password = ? WHERE id_membre = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, membre.getNom());
            stmt.setString(2, membre.getDatenaissance());
            stmt.setString(3, membre.getSportpratique());
            stmt.setString(4, membre.getRole());
            stmt.setString(5, membre.getUsername());
            stmt.setString(6, membre.getPassword());
            stmt.setInt(7, membre.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("membre n f ");
        }
    }

    public  void deletemembre(int id) {
        String sql = "DELETE FROM membre WHERE id_membre = ?";
        try (PreparedStatement pres = conn.prepareStatement(sql)){
            pres.setInt(1,id);
            pres.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("membre not founddd");
        }
    }

    public Membre getmembreInfos(String username  , String password) {
        Membre membre = null;
        System.out.println("aaaaaaaaaa");
        String sql = "select * from membre where username=? and password=?";
        try (PreparedStatement pes = conn.prepareStatement(sql)){
            pes.setString(1, username);
            pes.setString(2, password);

            try (ResultSet res = pes.executeQuery()){
                if (res.next()) {
                    membre = new Membre();
                    membre.setId(res.getInt("id_membre"));
                    membre.setNom(res.getString("nom"));
                    membre.setDatenaissance(res.getString("ladate"));
                    membre.setSportpratique(res.getString("sport_pra"));
                    membre.setRole(res.getString("role"));
                    membre.setUsername(res.getString("username"));
                    membre.setPassword(res.getString("password"));

                }

            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return membre;
    }



}
