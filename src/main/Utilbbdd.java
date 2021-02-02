package main;

import java.io.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class Utilbbdd {


    public static void connectBbdd() {

        String url = "jdbc:mysql://localhost:3306/ibm?";
        String user = "root";
        String pass = "qwerty12345";
        String sql;

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            sql = "select * from ibm.proveedores";
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getString(2));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public StringBuffer getSql(String sql) {

        String url = "jdbc:mysql://localhost:3306/ibm";
        String user = "root";
        String pass = "qwerty12345";
        StringBuffer sb = new StringBuffer();

        try {
            Connection conn = DriverManager.getConnection(url, user, pass);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            boolean clientFound = true;

            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");

            while (rs.next()) {

                if (clientFound) {
                    clientFound = false;

                    String cab = "Id\tProveedor\tFecha de alta\tId Cliente\n";
                    System.out.println(cab);
                    sb.append(cab);
                }

                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(simpleDateFormat.format(rs.getDate(3)) + "\t\t");
                System.out.println(rs.getInt(4));

                sb.append(rs.getString(1) + "\t" +
                        rs.getString(2) + "\t" +
                        simpleDateFormat.format(rs.getDate(3)) + "\t\t" +
                        rs.getInt(4) + "\n");
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return sb;
    }

    public void getProveedores(String id) {
        StringBuffer sb = getSql("select * from proveedores where id_cliente =" + id);
        if (sb.length() == 0) {
            System.out.println("El cliente no tiene proveedores asignados.");
        } else {
            writeFile(sb, id);
        }
    }

    public void writeFile(StringBuffer sb, String id) {

        String os = System.getProperty("os.name").toLowerCase();
        BufferedWriter bw;

        try {
            String file = "proveedores_" + id + ".txt";
            if (os.contains("win")) {
                bw = new BufferedWriter(new FileWriter(new File("C:/" + file)));
            } else {
                bw = new BufferedWriter(new FileWriter(new File(file)));
            }
            bw.write(sb.toString());
            bw.flush();
            bw.close();

        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }

    }

    public static void main(String[] args) {
        connectBbdd();
    }

}
