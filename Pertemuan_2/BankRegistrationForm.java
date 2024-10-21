import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BankRegistrationForm extends JFrame {

    public BankRegistrationForm() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 1000);
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

        // Savings Account Type Selection
        JLabel labelAccountType = new JLabel("Jenis Tabungan");
        labelAccountType.setBounds(15, 280, 350, 10);
        String[] accountTypes = {"Tabungan Reguler", "Tabungan Berjangka", "Deposito", "Tabungan Pendidikan"};
        JList<String> listAccountType = new JList<>(accountTypes);
        listAccountType.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(listAccountType);
        scrollPane.setBounds(15, 300, 350, 60);

        // Transaction Frequency Slider
        JLabel labelFrequency = new JLabel("Frekuensi Transaksi per Bulan (0-100)");
        labelFrequency.setBounds(15, 370, 350, 10);
        JSlider sliderFrequency = new JSlider(0, 100);
        sliderFrequency.setMajorTickSpacing(20);
        sliderFrequency.setMinorTickSpacing(1);
        sliderFrequency.setPaintTicks(true);
        sliderFrequency.setPaintLabels(true);
        sliderFrequency.setBounds(15, 390, 350, 50);

        // Password Fields
        JLabel labelPassword = new JLabel("Password");
        labelPassword.setBounds(15, 450, 350, 10);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(15, 470, 350, 30);

        JLabel labelConfirmPassword = new JLabel("Confirm Password");
        labelConfirmPassword.setBounds(15, 510, 350, 10);
        JPasswordField confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(15, 530, 350, 30);

        // Date of Birth Spinner
        JLabel labelDOB = new JLabel("Tanggal Lahir");
        labelDOB.setBounds(15, 570, 350, 10);
        SpinnerDateModel model = new SpinnerDateModel();
        JSpinner spinnerDOB = new JSpinner(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(spinnerDOB, "dd/MM/yyyy");
        spinnerDOB.setEditor(editor);
        spinnerDOB.setBounds(15, 590, 100, 30);

        // Output Area
        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(15, 630, 350, 200);
        txtOutput.setEditable(false);
        txtOutput.setLineWrap(true);
        txtOutput.setWrapStyleWord(true);

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
                listAccountType.clearSelection();
                sliderFrequency.setValue(0);
                passwordField.setText("");
                confirmPasswordField.setText("");
                txtOutput.setText("");
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
        buttonSubmit.setBounds(15, 800, 100, 40);
        buttonSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String gender = radioButtonMale.isSelected() ? "Laki - Laki" : "Perempuan";
                String accountType = listAccountType.getSelectedValue();
                int transactionFrequency = sliderFrequency.getValue();
                String password = new String(passwordField.getPassword());
                String confirmPassword = new String(confirmPasswordField.getPassword());
                String passwordMatch = password.equals(confirmPassword) ? "Cocok" : "Tidak Cocok";

                // Output
                txtOutput.append("Nama: " + textFieldName.getText() + "\n");
                txtOutput.append("Nomor HP: " + textFieldPhone.getText() + "\n");
                txtOutput.append("Jenis Kelamin: " + gender + "\n");
                txtOutput.append("WNA: " + (checkBoxForeign.isSelected() ? "Ya" : "Tidak") + "\n");
                txtOutput.append("Jenis Tabungan: " + (accountType != null ? accountType : "Tidak dipilih") + "\n");
                txtOutput.append("Frekuensi Transaksi: " + transactionFrequency + "\n");
                txtOutput.append("Tanggal Lahir: " + editor.getFormat().format(spinnerDOB.getValue()) + "\n");
                txtOutput.append("Password: " + passwordMatch + "\n");
                txtOutput.append("================================\n");

                // Clear password fields
                passwordField.setText("");
                confirmPasswordField.setText("");
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
        this.add(scrollPane);
        this.add(labelFrequency);
        this.add(sliderFrequency);
        this.add(labelPassword);
        this.add(passwordField);
        this.add(labelConfirmPassword);
        this.add(confirmPasswordField);
        this.add(labelDOB);
        this.add(spinnerDOB);
        this.add(buttonSubmit);
        this.add(txtOutput);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BankRegistrationForm form = new BankRegistrationForm();
                form.setVisible(true);
            }
        });
    }
}
