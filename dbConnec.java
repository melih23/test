/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.swing.JOptionPane;

/**
 *
 * @author Melih
 */
public class dbConnec {

    public static Connection connection() {
        Connection conn = null;
        PreparedStatement ps = null;

        String query = "SELECT moduleId, moduleCode, module, professorIds from Course";
        ResultSet rs = null;

        try {

            Class.forname("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/admin", "root", "");

            ps = conn.prepareStatement(query);

            rs = ps.executeQuery();

            List<Module> moduleList = new ArrayList<Module>();

            while (rs.next()) {

                Module module = null;

                List<String> professorIdsStrList = Arrays.asList(rs.getString("professorIds").split("\\s*,\\s*"));
                List<Integer> professorIdsIntList = professorIdsStrList.stream()
                        .map(s -> Integer.parseInt(s))
                        .collect(Collectors.toList());

                module = new Module(rs.getInt("moduleId"), rs.getString("moduleCode"), rs.getString("module"), professorIdsIntList);

                moduleList.add(module);

            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());

        }
        
        return conn;
    }
}
