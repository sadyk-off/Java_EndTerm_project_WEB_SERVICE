package repositories;

import data.interfaces.IDB;
import entities.Deliveryman;
import repositories.interfaces.IDeliverymanRepository;

import javax.inject.Inject;
import java.sql.*;
import java.util.LinkedList;
import java.util.List;

public class DeliverymanRepository implements IDeliverymanRepository {
    @Inject
    private IDB db;

    @Override
    public boolean create(Deliveryman deliveryman) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO deliveryman(name,surname,gender) VALUES (?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, deliveryman.getName());
            st.setString(2, deliveryman.getSurname());
            st.setBoolean(3, deliveryman.getGender());

            st.execute();
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Deliveryman get(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender FROM deliverymen WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Deliveryman deliveryman = new Deliveryman(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender")
                );

                return deliveryman;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Deliveryman> getAll() {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,name,surname,gender FROM deliverymen";
            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(sql);
            List<Deliveryman> deliverymen = new LinkedList<>();
            while (rs.next()) {
                Deliveryman deliveryman = new Deliveryman(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getBoolean("gender"));

                deliverymen.add(deliveryman);
            }

            return deliverymen;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean delete(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "DELETE FROM deliverymen WHERE id=?";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            st.execute();

            return st.getUpdateCount() > 0;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                con.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        return false;
    }

}
