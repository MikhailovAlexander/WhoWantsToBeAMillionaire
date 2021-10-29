/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.whowantstobeamillionaire;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author User
 */
public class DbAdapter {
    private static String driver = "org.sqlite.JDBC";
    private String dbUrl;
    
    public DbAdapter(String dbUrl){
        this.dbUrl = dbUrl;
    }
    
    public Question GetQuestionByLevel(Integer level){
        Question question = new Question();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resSet = null;
        try{
            Class.forName(DbAdapter.driver);
            conn = DriverManager.getConnection(this.dbUrl);

            String query = "select\n" +
                "	question_text,\n" +
                "	question_1_answer,\n" +
                "	question_2_answer,\n" +
                "	question_3_answer,\n" +
                "	question_4_answer,\n" +
                "	question_right_answer,\n" +
                "	question_level\n" +
                "from question\n" +
                "where question_level = ?\n" +
                "order by random()\n" +
                "limit 1";
            statement = conn.prepareStatement(query);
            statement.setInt(1, level);

            resSet = statement.executeQuery();

            if (resSet.next()) {
                question = new Question(resSet.getString(1),
                        resSet.getString(2), resSet.getString(3),
                        resSet.getString(4), resSet.getString(5),
                        resSet.getString(6), resSet.getInt(7));
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try { resSet.close(); } catch (Exception e) { /* Ignored */ }
            try { statement.close(); } catch (Exception e) { /* Ignored */ }
            try { conn.close(); } catch (Exception e) { /* Ignored */ }
        }
        return question;
    }
    
    public void SaveWinner(String name, int amount){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resSet = null;
        String query;
        int gamer_id = GetGamerId(name);
        try{
            Class.forName(DbAdapter.driver);
            conn = DriverManager.getConnection(this.dbUrl);

            query = "insert into winner(winner_amount, winner_dt, gamer_id) values(?,current_timestamp,?)";
            statement = conn.prepareStatement(query);
            statement.setInt(1, amount);
            statement.setInt(2, gamer_id);
            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try { resSet.close(); } catch (Exception e) { /* Ignored */ }
            try { statement.close(); } catch (Exception e) { /* Ignored */ }
            try { conn.close(); } catch (Exception e) { /* Ignored */ }
        }
    }
    
    private int GetGamerId(String name){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resSet = null;
        String query;
        int gamer_id = -1;
        try{
            Class.forName(DbAdapter.driver);
            conn = DriverManager.getConnection(this.dbUrl);

            query = "select gamer_id from gamer where gamer_name = ?";
            statement = conn.prepareStatement(query);
            statement.setString(1, name);

            resSet = statement.executeQuery();
            if (resSet.next()) {
                gamer_id = resSet.getInt(1);
                resSet.close();
                statement.close();
            }
            else{
                query = "insert into gamer(gamer_name) values(?) returning gamer_id";
                statement = conn.prepareStatement(query);
                statement.setString(1, name);
                resSet = statement.executeQuery();
                if (resSet.next()) {
                    gamer_id = resSet.getInt(1);
                }
            }
            resSet.close();
            statement.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try { resSet.close(); } catch (Exception e) { /* Ignored */ }
            try { statement.close(); } catch (Exception e) { /* Ignored */ }
            try { conn.close(); } catch (Exception e) { /* Ignored */ }
        }
        return gamer_id;
        
    }
    
    public Object[][] GetWinnersList(){
        List<Object[]> result = new ArrayList<Object[]>();
        Connection conn = null;
        Statement statement = null;
        ResultSet resSet = null;
        try{
            Class.forName(DbAdapter.driver);
            conn = DriverManager.getConnection(this.dbUrl);

            String query = "select * from v_winners_list";
            statement = conn.createStatement();
            resSet = statement.executeQuery(query);

            while (resSet.next()) {
                result.add(new Object[]{
                    resSet.getString(1),
                    resSet.getInt(2),
                    resSet.getString(3)});
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try { resSet.close(); } catch (Exception e) { /* Ignored */ }
            try { statement.close(); } catch (Exception e) { /* Ignored */ }
            try { conn.close(); } catch (Exception e) { /* Ignored */ }
        }
        Object[][] arr = new Object[result.size()][];
        arr = result.toArray(arr);
        return arr;
    }
    
    public Object[][] GetFriends(String name){
        List<Object[]> result = new ArrayList<Object[]>();
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resSet = null;
        String query;
        int gamer_id = GetGamerId(name);
        try{
            Class.forName(DbAdapter.driver);
            conn = DriverManager.getConnection(this.dbUrl);

            query = "select friend_name, friend_phone from friend where gamer_id = ?";
            statement = conn.prepareStatement(query);
            statement.setInt(1, gamer_id);
            
            resSet = statement.executeQuery();
            while (resSet.next()) {
                result.add(new Object[]{
                    resSet.getString(1),
                    resSet.getString(2)});
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try { resSet.close(); } catch (Exception e) { /* Ignored */ }
            try { statement.close(); } catch (Exception e) { /* Ignored */ }
            try { conn.close(); } catch (Exception e) { /* Ignored */ }
        }
        Object[][] arr = new Object[result.size()][];
        arr = result.toArray(arr);
        return arr;
    }
    
    public void SaveFriend(String name, String friend_name, String phone){
        Connection conn = null;
        PreparedStatement statement = null;
        ResultSet resSet = null;
        String query;
        int gamer_id = GetGamerId(name);
        try{
            Class.forName(DbAdapter.driver);
            conn = DriverManager.getConnection(this.dbUrl);

            query = "insert into friend(friend_name, friend_phone, gamer_id) values(?,?,?)";
            statement = conn.prepareStatement(query);
            statement.setString(1, friend_name);
            statement.setString(2, phone);
            statement.setInt(3, gamer_id);
            statement.executeUpdate();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try { resSet.close(); } catch (Exception e) { /* Ignored */ }
            try { statement.close(); } catch (Exception e) { /* Ignored */ }
            try { conn.close(); } catch (Exception e) { /* Ignored */ }
        }
    }
}
