package org.example.sportflow.DAO;

import org.example.sportflow.bean.Entraineur;
import org.example.sportflow.bean.Membre;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EntraineurDAO {

    private Connection conn;

    public EntraineurDAO() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/sport","root","");
            System.out.println("Connected to the database successfully");

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Failed to connect to database");
        }
    }


    public  void  CreateTrainer (Entraineur entraineur){
        String sql = "insert into entraineur(name , specialite , role , username , password) values(?,?,?,?,?) ";
        try (PreparedStatement pr = conn.prepareStatement(sql)){
            pr.setString(1,entraineur.getName());
            pr.setString(2, entraineur.getSpecialite());
            pr.setString(3, entraineur.getRoole());
            pr.setString(4, entraineur.getUsrname());
            pr.setString(5 , entraineur.getPsw());
            pr.executeUpdate();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public List<Entraineur> getallTrainers() {
        List<Entraineur> trainersList = new ArrayList<>();
        String sql="SELECT * FROM entraineur";
        try(Statement stmt = conn.createStatement(); ResultSet res = stmt.executeQuery(sql)) {
            System.out.println("ww");
            while (res.next()) {
                Entraineur entraineur = new Entraineur();
                entraineur.setIdent(res.getInt("id_ent"));
                entraineur.setName(res.getString("name"));
                entraineur.setSpecialite(res.getString("specialite"));
                entraineur.setRoole(res.getString("role"));
                entraineur.setUsrname(res.getString("username"));
                entraineur.setPsw(res.getString("password"));
                trainersList.add(entraineur);
            }

        }catch (Exception e) {
            e.printStackTrace();
            System.out.println("qsqs");
        }
        return trainersList;

    }

    public Entraineur gettrainerBYid(int id) {
        Entraineur entraineur = null;
        String sql="SELECT * FROM entraineur WHERE id_ent = ?";
        try(PreparedStatement prest = conn.prepareStatement(sql)) {
            prest.setInt(1, id);
            try (ResultSet res = prest.executeQuery()){
                if (res.next()) {
                    entraineur = new Entraineur();
                    entraineur.setIdent(res.getInt("id_ent"));
                    entraineur.setName(res.getString("name"));
                    entraineur.setSpecialite(res.getString("specialite"));
                    entraineur.setRoole(res.getString("role"));
                    entraineur.setUsrname(res.getString("username"));
                    entraineur.setPsw(res.getString("password"));

                }

            }
            System.out.println("sffffff");

        }catch (Exception e) {
            System.out.println("trainer not found");
        }
        return entraineur;
    }

    public void modifierTrainer(Entraineur entraineur) {
        System.out.println("nnn");
        String query = "UPDATE entraineur SET name = ?, specialite = ? , role = ? , username = ? , password = ? WHERE id_ent = ?";
        try (PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, entraineur.getName());
            stmt.setString(2, entraineur.getSpecialite());
            stmt.setString(3, entraineur.getRoole());
            stmt.setString(4, entraineur.getUsrname());
            stmt.setString(5, entraineur.getPsw());
            stmt.setInt(6, entraineur.getIdent());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("trainer n f ");
        }
    }

    public  void deleteTrainer(int id) {
        String sql = "DELETE FROM entraineur WHERE id_ent = ?";
        try (PreparedStatement pres = conn.prepareStatement(sql)){
            pres.setInt(1,id);
            pres.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("trainer not founddd");
        }
    }

    public Entraineur getTrainerInfos(String username  , String password) {
        Entraineur entraineur = null;
        System.out.println("aaaaaaaaaa");
        String sql = "select * from entraineur where username=? and password=?";
        try (PreparedStatement pes = conn.prepareStatement(sql)){
            pes.setString(1, username);
            pes.setString(2, password);

            try (ResultSet res = pes.executeQuery()){
                if (res.next()) {
                    entraineur = new Entraineur();
                    entraineur.setIdent(res.getInt("id_ent"));
                    entraineur.setName(res.getString("name"));
                    entraineur.setSpecialite(res.getString("specialite"));
                    entraineur.setRoole(res.getString("role"));
                    entraineur.setUsrname(res.getString("username"));
                    entraineur.setPsw(res.getString("password"));

                }

            }

        }catch (Exception e) {
            e.printStackTrace();
        }
        return entraineur;
    }








}
