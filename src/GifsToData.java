
import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GifsToData {

    public static void main(String args[]) throws SQLException {
        File root;
        if (args.length > 0) root = new File(args[0]);
        else root = new File("C:\\Users\\toshýba\\Desktop\\Proje\\gifs and references");
        ls(root);
        Connection conn = Connector.getConnection();
        PreparedStatement ps = conn.prepareStatement("INSERT INTO gif (gifName, url) VALUES(?, ?)");
        File userDir = new File("C:\\Users\\toshýba\\Desktop\\Proje\\gifs and references");
        File[] files = userDir.listFiles();
        for (File f : files) {
            if (f.isFile()) {
                ps.setString(1, f.getName());
                ps.setString(2, f.getAbsolutePath());
                ps.executeUpdate();
            }
        }

    }

    private static void ls(File f) { 
        File[] list = f.listFiles();
        for (File file : list) {
            if (file.isDirectory()) ls(file);
            else System.out.println(file);
        }
    }
}