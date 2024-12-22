
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Tugas extends JFrame {

    private DefaultTableModel tableModel;

    public Tugas() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(700, 1000);
        this.setLayout(null);

        // Input for Name
        JLabel labelName = new JLabel("Nama");
        labelName.setBounds(15, 40, 350, 10);
        JTextField textFieldName = new JTextField();
        textFieldName.setBounds(15, 60, 350, 30);

        // Input for Phone Number
        JLabel labelPhone = new JLabel("Nomor HP");
        labelPhone.setBounds(15, 100, 350, 10);
        JTextField textFieldPhone = new JTextField();
        textFieldPhone.setBounds(15, 120, 350, 30);

        // Gender Selection
        JLabel labelGender = new JLabel("Jenis Kelamin");
        labelGender.setBounds(15, 150, 350, 10);
        JRadioButton radioButtonMale = new JRadioButton("Laki - Laki", true);
        radioButtonMale.setBounds(15, 170, 150, 30);
        JRadioButton radioButtonFemale = new JRadioButton("Perempuan");
        radioButtonFemale.setBounds(15, 205, 150, 30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonMale);
        bg.add(radioButtonFemale);

        // Nationality Checkbox
        JCheckBox checkBoxForeign = new JCheckBox("Warga Negara Asing");
        checkBoxForeign.setBounds(15, 240, 200, 30);

        // Savings Account Type (JComboBox)
        JLabel labelAccountType = new JLabel("Jenis Tabungan");
        labelAccountType.setBounds(15, 280, 350, 20);
        String[] accountTypes = {"Tabungan Reguler", "Tabungan Berjangka", "Deposito", "Tabungan Pendidikan"};
        JComboBox<String> comboBoxAccountType = new JComboBox<>(accountTypes);
        comboBoxAccountType.setBounds(15, 300, 350, 30);

        // Transaction Frequency Slider
        JLabel labelFrequency = new JLabel("Frekuensi Peminjaman (Bulan)");
        labelFrequency.setBounds(15, 340, 350, 20);
        JSlider sliderFrequency = new JSlider(1, 12);
        sliderFrequency.setMajorTickSpacing(1);
        sliderFrequency.setPaintTicks(true);
        sliderFrequency.setPaintLabels(true);
        sliderFrequency.setBounds(15, 360, 350, 50);

        // Spinner for Loan Date
        JLabel labelDOB = new JLabel("Tanggal Peminjaman");
        labelDOB.setBounds(15, 420, 350, 20);
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinnerDOB = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerDOB, "dd/MM/yyyy");
        spinnerDOB.setEditor(editor);
        spinnerDOB.setBounds(15, 440, 100, 30);

        // Table for Displaying Output Data
        tableModel = new DefaultTableModel(new Object[]{"Nama", "Nomor HP", "Jenis Kelamin", "WNA", "Jenis Tabungan", "Frekuensi Peminjaman", "Tanggal Peminjaman"}, 0);
        JTable tableData = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(tableData);
        scrollPane.setBounds(15, 530, 650, 150);

        // Menu Bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetItem = new JMenuItem("Reset");
        JMenuItem exitItem = new JMenuItem("Exit");

        // Reset Action
        resetItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textFieldName.setText("");
                textFieldPhone.setText("");
                bg.clearSelection();
                checkBoxForeign.setSelected(false);
                comboBoxAccountType.setSelectedIndex(0);
                sliderFrequency.setValue(1);
                spinnerDOB.setValue(new java.util.Date());

            }
        });

        // Exit Action
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

        // Submit Button
        JButton buttonSubmit = new JButton("Daftar");
        buttonSubmit.setBounds(20, 480, 100, 40);
        buttonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String gender = radioButtonMale.isSelected() ? "Laki - Laki" : "Perempuan";
                String accountType = (String) comboBoxAccountType.getSelectedItem();
                int transactionFrequency = sliderFrequency.getValue();
                String loanDate = editor.getFormat().format(spinnerDOB.getValue());

                // Add row to table
                tableModel.addRow(new Object[]{
                    textFieldName.getText(),
                    textFieldPhone.getText(),
                    gender,
                    checkBoxForeign.isSelected() ? "Ya" : "Tidak",
                    accountType,
                    transactionFrequency + "Bulan",
                    loanDate
                });
            }
        });

        // Delete Button
        JButton buttonDelete = new JButton("Hapus");
        buttonDelete.setBounds(130, 480, 100, 40);
        buttonDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = tableData.getSelectedRow(); // Get the selected row
                if (selectedRow != -1) { // Check if a row is selected
                    tableModel.removeRow(selectedRow); // Remove the selected row
                } else {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang ingin dihapus!", "Peringatan", JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // Adding Components
        this.add(labelName);
        this.add(textFieldName);
        this.add(labelPhone);
        this.add(textFieldPhone);
        this.add(labelGender);
        this.add(radioButtonMale);
        this.add(radioButtonFemale);
        this.add(checkBoxForeign);
        this.add(labelAccountType);
        this.add(comboBoxAccountType);
        this.add(labelFrequency);
        this.add(sliderFrequency);
        this.add(labelDOB);
        this.add(spinnerDOB);
        this.add(buttonSubmit);
        this.add(buttonDelete);
        this.add(scrollPane);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Tugas form = new Tugas();
                form.setVisible(true);
            }
        });
    }
}
