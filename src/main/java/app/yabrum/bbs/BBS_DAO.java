package app.yabrum.bbs;

import app.yabrum.Share;
import app.yabrum.data.Post;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BBS_DAO {
    private static String ORIGIN;
    private static final String URL;
    private static final String USER = "global";
    private static final String PASSWORD = "Pn32-55qm1";
    private static List<Post> lastData = new ArrayList<>();
    private static int lastIndex = -1;

    static {
        if (Share.DEBUG_MODE) {
            ORIGIN = "192.168.0.55";
        } else {
            ORIGIN = "yabrum.f5.si";
        }

        URL = "jdbc:mysql://" + ORIGIN + "/yabrum?enabledTLSProtocols=TLSv1.2";
    }
    public static List<Post> getAllPosts() {
        List<Post> allPosts = new ArrayList<>();
        final String SQL = "SELECT * FROM bbs;";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(SQL)) {

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    allPosts.add(new Post(rs.getInt("id"), rs.getString("name"), rs.getString("content")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        lastData = allPosts;

        lastIndex = allPosts.get(allPosts.size() - 1).id();

        return allPosts;
    }

    public static List<Post> getNewPosts() {
        if (lastIndex == -1) {
            getAllPosts();
        }

        List<Post> posts = new ArrayList<>();
        final String SQL = "SELECT * FROM bbs WHERE id>?;";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setInt(1, lastIndex);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    posts.add(new Post(rs.getInt("id"), rs.getString("name"), rs.getString("content")));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        lastData.addAll(posts);
        lastIndex = lastData.get(lastData.size() - 1).id();

        return posts;
    }

    public static void insert(String name, String content) {
        final String SQL = "INSERT INTO bbs(name, content) VALUES(?, ?);";

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement ps = conn.prepareStatement(SQL)) {
            ps.setString(1, name);
            ps.setString(2, content);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
