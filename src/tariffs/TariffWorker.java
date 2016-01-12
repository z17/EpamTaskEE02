package tariffs;

import cp.ConnectionPool;

import java.sql.*;
import java.util.ArrayList;

public interface TariffWorker {
    String TABLE_NAME = "tariffs";

    String ID = "id";
    String NAME = "name";
    String DESCRIPTION = "description";
    String MINUTE_PRICE = "minute_price";
    String MONTH_PRICE = "month_price";

    static boolean add(String name, String description, int minutePrice, int monthPrice) {
        String insert = "INSERT INTO " + TABLE_NAME + " (" + NAME + ", " + DESCRIPTION + ", " + MINUTE_PRICE + ", " + MONTH_PRICE + ") VALUES (?, ?, ?, ?)";
        ConnectionPool pool = ConnectionPool.getInstance();

        try(Connection connection = pool.takeConnection();
            PreparedStatement ps = connection.prepareStatement(insert)
        ) {
            ps.setString(1, name);
            ps.setString(2, description);
            ps.setInt(3, minutePrice);
            ps.setInt(4, monthPrice);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    static boolean add(Tariff tariff) {
        return add(tariff.getName(), tariff.getDescription(), tariff.getMinutePrice(), tariff.getMonthPrice());
    }

    static ArrayList<Tariff> get() {
        String select = "SELECT " + ID + ", " + NAME + ", " + DESCRIPTION + ", " + MINUTE_PRICE + ", " + MONTH_PRICE + " FROM " + TABLE_NAME;
        ConnectionPool pool = ConnectionPool.getInstance();
        ArrayList<Tariff> result =  null;
        try (Connection connection = pool.takeConnection();
             PreparedStatement ps = connection.prepareStatement(
                select,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_READ_ONLY
             );
             ResultSet rs = ps.executeQuery()
        ){
            result = new ArrayList<>();
            while (rs.next()) {
                int id = rs.getInt(ID);
                int priceMinute = rs.getInt(MINUTE_PRICE);
                int priceMonth = rs.getInt(MONTH_PRICE);
                String name = rs.getString(NAME);
                String description = rs.getString(DESCRIPTION);
                result.add(new Tariff(id, name, description, priceMinute, priceMonth));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    static Tariff get(int id) {
        String select = "SELECT " + ID + ", " + NAME + ", " + DESCRIPTION + ", " + MINUTE_PRICE + ", " + MONTH_PRICE + " FROM " + TABLE_NAME + " WHERE " + ID + " = ? LIMIT 1";
        ConnectionPool pool = ConnectionPool.getInstance();
        Tariff result =  null;
        try (Connection connection = pool.takeConnection();
             PreparedStatement ps = connection.prepareStatement(
                     select,
                     ResultSet.TYPE_SCROLL_INSENSITIVE,
                     ResultSet.CONCUR_READ_ONLY
             )
        ){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    int priceMinute = rs.getInt(MINUTE_PRICE);
                    int priceMonth = rs.getInt(MONTH_PRICE);
                    String name = rs.getString(NAME);
                    String description = rs.getString(DESCRIPTION);
                    result = new Tariff(id, name, description, priceMinute, priceMonth);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return result;
    }

    static boolean update(Tariff tariff) {
        String update = "UPDATE " + TABLE_NAME + " SET " + NAME + " = ?, " + DESCRIPTION + " = ?, " + MINUTE_PRICE + " = ?, " + MONTH_PRICE + " = ? WHERE " + ID + " = ?";
        ConnectionPool pool = ConnectionPool.getInstance();
        try (Connection connection = pool.takeConnection();
             PreparedStatement ps = connection.prepareStatement(update)
            ){
            ps.setString(1, tariff.getName());
            ps.setString(2, tariff.getDescription());
            ps.setInt(3, tariff.getMinutePrice());
            ps.setInt(4, tariff.getMonthPrice());
            ps.setInt(5, tariff.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    static boolean delete (int id) {
        String delete = "DELETE FROM " + TABLE_NAME + " WHERE " + ID + " = ?";
        ConnectionPool pool = ConnectionPool.getInstance();
        try (Connection connection = pool.takeConnection();
             PreparedStatement ps = connection.prepareStatement(delete)
        ){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }
}
