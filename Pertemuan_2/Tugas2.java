import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tugas2 extends JFrame {



    public Tugas2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Untuk Nama
        JLabel labelNama = new JLabel("Nama");
        labelNama.setBounds( 15, 40, 350, 10);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        // Untuk Nomor HP
        JLabel labelTelepon = new JLabel("Nomor HP");
        labelTelepon.setBounds(15, 100, 350, 10);

        JTextField textFieldTelepon = new JTextField();
        textFieldTelepon.setBounds(15, 120, 350, 30);

        // Jenis Kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin");
        labelRadio.setBounds(15, 140, 350, 60);

        JRadioButton radioButton1 = new JRadioButton("Laki - Laki", true);
        radioButton1.setBounds(15, 180, 100, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(130, 180, 100, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        // Jenis Tabungan
        JLabel JenisTabungan = new JLabel("Jenis Tabungan");
        JenisTabungan.setBounds(15, 215, 100, 20);
        String[] jenisTabungan = {"Tabungan Reguler", "Tabungan Nikah", "Tabungan Pendidikan", "Tabungan Usaha"};
        JList<String> listJenisTabungan = new JList<>(jenisTabungan);
        listJenisTabungan.setBounds(15, 240, 200, 60);
        listJenisTabungan.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPanel = new JScrollPane(listJenisTabungan);
        scrollPanel.setBounds(15, 240, 200, 60);

        // Tanggal Lahir
        JLabel labelTanggalLahir = new JLabel("Tanggal Lahir");
        labelTanggalLahir.setBounds(250, 215, 100, 20);
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinnerTanggalLahir = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerTanggalLahir, "dd/MM/yyyy");
        spinnerTanggalLahir.setEditor(editor);
        spinnerTanggalLahir.setBounds(250, 240, 100, 30);

        // Transaksi Slider
        JLabel labelSlider = new JLabel("Frekuensi Transaksi per Bulan");
        labelSlider.setBounds(15, 300, 350, 30);
        JSlider sliderTransaksi = new JSlider(0, 100);
        sliderTransaksi.setMajorTickSpacing(10);
        sliderTransaksi.setMinorTickSpacing(0);
        sliderTransaksi.setPaintTicks(true);
        sliderTransaksi.setPaintLabels(true);
        sliderTransaksi.setBounds(15, 330, 350, 40);

        // Password
        JLabel labelPassword = new JLabel("Password");
        labelPassword.setBounds( 15, 390, 100, 10);

        JPasswordField fieldPassword = new JPasswordField();
        fieldPassword.setBounds(15, 410, 150, 30);

        JLabel labelKonfirmasiPassword = new JLabel("Konfirmasi Password");
        labelKonfirmasiPassword.setBounds( 220, 390, 200, 10);

        JPasswordField fieldKonfirmasiPassword = new JPasswordField();
        fieldKonfirmasiPassword.setBounds(220, 410, 150, 30);

        // WNA
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15,450,350,30);

        JButton button = new JButton("Daftar");
        button.setBounds(140,490,100,40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,530,350,280);
        txtOutput.setEditable(false);

        // Menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetItem = new JMenuItem("Reset");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Reset
        resetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldNama.setText("");
                textFieldTelepon.setText("");
                listJenisTabungan.clearSelection();
                sliderTransaksi.setValue(50);
                checkBox.setSelected(false);
                fieldPassword.setText("");
                fieldKonfirmasiPassword.setText("");
                txtOutput.setText("");
            }
        });

        // Exit
        exitItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        menu.add(resetItem);
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                // Pengecekan password
                String password = new String(fieldPassword.getPassword());
                String confirmPassword = new String(fieldKonfirmasiPassword.getPassword());
                String passwordMassage = password.equals(confirmPassword) ? "Password cocok." : "Password tidak cocok.";

                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }
                String accountType = listJenisTabungan.getSelectedValue();
                String nama = textFieldNama.getText();
                String telepon = textFieldTelepon.getText();

                txtOutput.append("Nama  :   "+nama+"\n");
                txtOutput.append("Nomor HP  :   "+telepon+"\n");
                txtOutput.append("Jenis Kelamin :   "+jenisKelamin+"\n");
                txtOutput.append("Jenis Tabungan    :   " + (accountType != null ? accountType : "Tidak dipilih") + "\n");
                txtOutput.append("Tanggal Lahir :   " + editor.getFormat().format(spinnerTanggalLahir.getValue()) + "\n");
                txtOutput.append("Frekuensi Transaksi per Bulan :   "+ sliderTransaksi.getValue() + "/Bulan\n");
                txtOutput.append("Password: " + passwordMassage + "\n");
                    if (checkBox.isSelected()) {
                        txtOutput.append("WNA  : Ya  \n");
                    } else {
                        txtOutput.append("WNA  : Tidak  \n");
                    }
                txtOutput.append("================================\n");
                textFieldNama.setText("");

                fieldPassword.setText("");
                fieldKonfirmasiPassword.setText("");

            }
        });

        this.add(button);
        this.add(labelNama);
        this.add(textFieldNama);
        this.add(labelTelepon);
        this.add(textFieldTelepon);
        this.add(labelRadio);
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(JenisTabungan);
        this.add(scrollPanel);
        this.add(labelTanggalLahir);
        this.add(spinnerTanggalLahir);
        this.add(labelSlider);
        this.add(sliderTransaksi);
        this.add(labelPassword);
        this.add(labelKonfirmasiPassword);
        this.add(fieldPassword);
        this.add(fieldKonfirmasiPassword);
        this.add(checkBox);
        this.add(txtOutput);

        this.setSize(400,700);
        this.setLayout(null);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Tugas2 t = new Tugas2();
                t.setVisible(true);
            }
        });
    }

}