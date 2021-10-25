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
            String strLine;

            if (resSet.next()) {
                question = new Question(resSet.getString(1),
                        resSet.getString(2), resSet.getString(3),
                        resSet.getString(4), resSet.getString(5),
                        resSet.getString(6), resSet.getInt(7));
            }

            resSet.close();
            conn.close();
        } catch (Exception ex) {
            System.out.println(ex.toString());
        } finally {
            try { resSet.close(); } catch (Exception e) { /* Ignored */ }
            try { statement.close(); } catch (Exception e) { /* Ignored */ }
            try { conn.close(); } catch (Exception e) { /* Ignored */ }
}
        return question;
    }
}
