package dao;
import util.Koneksi;
import model.Barang;
import java.sql.*;
import java.util.*;

public class BarangDAO {
    public void insert(Barang b) throws SQLException {
        String sql = "INSERT INTO barang (nama_barang, stok, harga, id_supplier) VALUES (?,?,?,?)";
        PreparedStatement ps = Koneksi.getConnection().prepareStatement(sql);
        ps.setString(1, b.getNama());
        ps.setInt(2, b.getStok());
        ps.setDouble(3, b.getHarga());
        ps.setInt(4, b.getIdSupplier());
        ps.executeUpdate();
    }

    public List<Barang> getAll() throws SQLException {
        List<Barang> list = new ArrayList<>();
        String sql = "SELECT * FROM barang";
        Statement st = Koneksi.getConnection().createStatement();
        ResultSet rs = st.executeQuery(sql);
        while (rs.next()) {
            Barang b = new Barang();
            b.setId(rs.getInt("id_barang"));
            b.setNama(rs.getString("nama_barang"));
            b.setStok(rs.getInt("stok"));
            b.setHarga(rs.getDouble("harga"));
            b.setIdSupplier(rs.getInt("id_supplier"));
            list.add(b);
        }
        return list;
    }
}
