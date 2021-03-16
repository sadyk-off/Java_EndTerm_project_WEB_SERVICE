package repositories;

import data.interfaces.IDB;
import entities.Parcel;
import repositories.interfaces.IParcelRepository;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class ParcelRepository implements IParcelRepository {
    @Inject
    private IDB db;

    @Override
    public boolean create(Parcel parcel) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "INSERT INTO parcel(from_address,to_address,type_delivery,weight,evaluate_cost,type_parcel,delivery_deadline,size) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(sql);

            st.setString(1, parcel.getFrom_address());
            st.setString(2, parcel.getTo_address());
            st.setString(3, parcel.getType_delivery());
            st.setString(4, parcel.getWeight());
            st.setDouble(5, parcel.getEvaluate_cost());
            st.setString(6, parcel.getType_parcel());
            st.setString(7, parcel.getDelivery_deadline());
            st.setString(8, parcel.getSize());
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
    public Parcel get(int id) {
        Connection con = null;
        try {
            con = db.getConnection();
            String sql = "SELECT id,from_address,to_address,type_delivery,weight,evaluate_cost,type_parcel,delivery_deadline,size" +
                    " FROM parcel";
            PreparedStatement st = con.prepareStatement(sql);

            st.setInt(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Parcel parcel = new Parcel(
                        rs.getInt("id"),
                        rs.getString("from_address"),
                        rs.getString("to_address"),
                        rs.getString("type_delivery"),
                        rs.getString("weight"),
                        rs.getDouble("evaluate_cost"),
                        rs.getString("type_parcel"),
                        rs.getString("delivery_deadline"),
                        rs.getString("size")
                );

                return parcel;
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
    public List<Parcel> getAll() {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
