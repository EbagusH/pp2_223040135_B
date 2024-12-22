package dao;

import db.MySqlConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MahasiswaDao {
    private Connection connection;

    public MahasiswaDao() throws SQLException {
        connection = MySqlConnection.getConnection();
    }

    public List<String[]> getAllMahasiswa() throws SQLException {
        List<String[]> mahasiswaList = new ArrayList<>();
        String query = "SELECT * FROM mahasiswa";
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);

        while (resultSet.next()) {
            String[] data = {
                    String.valueOf(resultSet.getInt("id")),
                    resultSet.getString("nama"),
                    resultSet.getString("nim"),
                    resultSet.getString("jurusan"),
                    String.valueOf(resultSet.getInt("angkatan")),
                    String.valueOf(resultSet.getFloat("ipk"))
            };
            mahasiswaList.add(data);
        }
        return mahasiswaList;
    }

    public void insertMahasiswa(String nama, String nim, String jurusan, int angkatan, float ipk) throws SQLException {
        String query = "INSERT INTO mahasiswa (nama, nim, jurusan, angkatan, ipk) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nama);
        preparedStatement.setString(2, nim);
        preparedStatement.setString(3, jurusan);
        preparedStatement.setInt(4, angkatan);
        preparedStatement.setFloat(5, ipk);
        preparedStatement.executeUpdate();
    }

    public void updateMahasiswa(int id, String nama, String nim, String jurusan, int angkatan, float ipk) throws SQLException {
        String query = "UPDATE mahasiswa SET nama = ?, nim = ?, jurusan = ?, angkatan = ?, ipk = ? WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, nama);
        preparedStatement.setString(2, nim);
        preparedStatement.setString(3, jurusan);
        preparedStatement.setInt(4, angkatan);
        preparedStatement.setFloat(5, ipk);
        preparedStatement.setInt(6, id);
        preparedStatement.executeUpdate();
    }

    public void deleteMahasiswa(int id) throws SQLException {
        String query = "DELETE FROM mahasiswa WHERE id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}

