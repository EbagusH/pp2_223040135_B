import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Biodata extends JFrame {



    public Biodata() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Untuk Nama
        JLabel labelNama = new JLabel("Nama");
        labelNama.setBounds( 15, 40, 350, 10); // 15, 40, 350, 10

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30); // 15, 60, 350, 30

        // Untuk Nomor HP
        JLabel labelTelepon = new JLabel("Nomor HP");
        labelTelepon.setBounds(15, 100, 350, 30); // 15, 80, 350, 10

        JTextField textFieldTelepon = new JTextField();
        textFieldTelepon.setBounds(15, 130, 350, 30); // 15, 120, 350, 30

        JLabel labelRadio = new JLabel("Jenis Kelamin");
        labelRadio.setBounds(15, 150, 350, 60);

        JRadioButton radioButton1 = new JRadioButton("Laki - Laki", true);
        radioButton1.setBounds(15, 190, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Perempuan");
        radioButton2.setBounds(15, 225, 350, 30);

        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);

        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15,270,350,30);

        JButton button = new JButton("Simpan");
        button.setBounds(15,320,100,40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(15,370,350,280);
        txtOutput.setEditable(false);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = "";
                if (radioButton1.isSelected()) {
                    jenisKelamin = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisKelamin = radioButton2.getText();
                }

                    String nama = textFieldNama.getText();
                    String telepon = textFieldTelepon.getText();
                    txtOutput.append("Nama  :   "+nama+"\n");
                    txtOutput.append("Nomor HP  :   "+telepon+"\n");
                    txtOutput.append("Jenis Kelamin :   "+jenisKelamin+"\n");
                    if (checkBox.isSelected()) {
                        txtOutput.append("WNA  : Ya  \n");
                    } else {
                        txtOutput.append("WNA  : Tidak  \n");
                    }
                    txtOutput.append("================================\n");
                    textFieldNama.setText("");

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
        this.add(checkBox);
        this.add(txtOutput);

        this.setSize(400,700);
        this.setLayout(null);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Biodata b = new Biodata();
                b.setVisible(true);
            }
        });
    }

}