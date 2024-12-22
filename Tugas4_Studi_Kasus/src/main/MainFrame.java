package main;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import dao.MahasiswaDao;

public class MainFrame extends JFrame {
    private JTextField textFieldNama, textFieldNim, textFieldJurusan, textFieldAngkatan, textFieldIpk;
    private JTable table;
    private DefaultTableModel tableModel;
    private MahasiswaDao mahasiswaDao;

    public MainFrame() throws SQLException {
        mahasiswaDao = new MahasiswaDao();

        // Frame setup
        this.setTitle("Aplikasi CRUD Mahasiswa");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLayout(null);

        // Input fields
        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(20, 20, 100, 25);
        textFieldNama = new JTextField();
        textFieldNama.setBounds(120, 20, 200, 25);

        JLabel labelNim = new JLabel("NIM:");
        labelNim.setBounds(20, 60, 100, 25);
        textFieldNim = new JTextField();
        textFieldNim.setBounds(120, 60, 200, 25);

        JLabel labelJurusan = new JLabel("Jurusan:");
        labelJurusan.setBounds(20, 100, 100, 25);
        textFieldJurusan = new JTextField();
        textFieldJurusan.setBounds(120, 100, 200, 25);

        JLabel labelAngkatan = new JLabel("Angkatan:");
        labelAngkatan.setBounds(20, 140, 100, 25);
        textFieldAngkatan = new JTextField();
        textFieldAngkatan.setBounds(120, 140, 200, 25);

        JLabel labelIpk = new JLabel("IPK:");
        labelIpk.setBounds(20, 180, 100, 25);
        textFieldIpk = new JTextField();
        textFieldIpk.setBounds(120, 180, 200, 25);

        // Buttons
        JButton buttonAdd = new JButton("Tambah");
        buttonAdd.setBounds(20, 220, 100, 30);
        buttonAdd.addActionListener(this::addMahasiswa);

        JButton buttonUpdate = new JButton("Update");
        buttonUpdate.setBounds(130, 220, 100, 30);
        buttonUpdate.addActionListener(this::updateMahasiswa);

        JButton buttonDelete = new JButton("Delete");
        buttonDelete.setBounds(240, 220, 100, 30);
        buttonDelete.addActionListener(this::deleteMahasiswa);

        // Table
        tableModel = new DefaultTableModel(new String[]{"ID", "Nama", "NIM", "Jurusan", "Angkatan", "IPK"}, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 270, 740, 280);

        loadTableData();

        // Add components
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelNim);
        this.add(textFieldNim);
        this.add(labelJurusan);
        this.add(textFieldJurusan);
        this.add(labelAngkatan);
        this.add(textFieldAngkatan);
        this.add(labelIpk);
        this.add(textFieldIpk);
        this.add(buttonAdd);
        this.add(buttonUpdate);
        this.add(buttonDelete);
        this.add(scrollPane);

        this.setLocationRelativeTo(null);
    }

    private void loadTableData() throws SQLException {
        tableModel.setRowCount(0);
        for (String[] data : mahasiswaDao.getAllMahasiswa()) {
            tableModel.addRow(data);
        }
    }

    private void addMahasiswa(ActionEvent e) {
        try {
            String nama = textFieldNama.getText();
            String nim = textFieldNim.getText();
            String jurusan = textFieldJurusan.getText();
            int angkatan = Integer.parseInt(textFieldAngkatan.getText());
            float ipk = Float.parseFloat(textFieldIpk.getText());
            mahasiswaDao.insertMahasiswa(nama, nim, jurusan, angkatan, ipk);
            loadTableData();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void updateMahasiswa(ActionEvent e) {
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int id = Integer.parseInt((String) tableModel.getValueAt(selectedRow, 0));
                String nama = textFieldNama.getText();
                String nim = textFieldNim.getText();
                String jurusan = textFieldJurusan.getText();
                int angkatan = Integer.parseInt(textFieldAngkatan.getText());
                float ipk = Float.parseFloat(textFieldIpk.getText());
                mahasiswaDao.updateMahasiswa(id, nama, nim, jurusan, angkatan, ipk);
                loadTableData();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    private void deleteMahasiswa(ActionEvent e) {
        try {
            int selectedRow = table.getSelectedRow();
            if (selectedRow != -1) {
                int id = Integer.parseInt((String) tableModel.getValueAt(selectedRow, 0));
                mahasiswaDao.deleteMahasiswa(id);
                loadTableData();
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        try {
            new MainFrame().setVisible(true);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

