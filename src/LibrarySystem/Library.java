package LibrarySystem;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Library {

    public void addMember(Member member) {
        String sql = "INSERT INTO member VALUES (?, ?, ?)";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, member.getMemberId());
            ps.setString(2, member.getMemberName());
            ps.setString(3, member.getMemberAddress());

            ps.executeUpdate();
            System.out.println("Member Added Successfully ✅");

        } catch (Exception e) {
            System.out.println("Member already exists ❌");
        }
    }

    public void searchMember(int id) {
        String sql = "SELECT * FROM member WHERE member_id=?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println(
                        new Member(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3)
                        )
                );
            } else {
                System.out.println("Member Not Found ❌");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void removeMember(int id) {
        String sql = "DELETE FROM member WHERE member_id=?";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            if (ps.executeUpdate() > 0) {
                System.out.println("Member Removed ✅");
            } else {
                System.out.println("Member Not Found ❌");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void showAllMembers() {
        String sql = "SELECT * FROM member";

        try (Connection conn = DbUtil.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (!rs.isBeforeFirst()) {
                System.out.println("No Members Found");
            }

            while (rs.next()) {
                System.out.println(
                        new Member(
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3)
                        )
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}