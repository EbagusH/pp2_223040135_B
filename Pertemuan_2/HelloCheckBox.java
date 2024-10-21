import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class HelloCheckBox extends JFrame {

    private boolean checkBoxSelected;

    public HelloCheckBox() {
        this.checkBoxSelected = false;
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelNama = new JLabel("Nama:");
        labelNama.setBounds(15, 40, 350, 10);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(15, 60, 350, 30);

        JCheckBox checkBox = new JCheckBox("Saya menyetujui syarat dan ketentuan yang berlaku");
        checkBox.setBounds(15,100,350,30);

        JButton button = new JButton("Simpan");
        button.setBounds(15,150,100,40);

        JTextArea txtOutput = new JTextArea();
        txtOutput.setBounds(15,200,350,100);

        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange()==1;
            }
        });

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (checkBoxSelected) {
                    String nama = textFieldNama.getText();
                    txtOutput.append("Nama: " + nama + "\n");
                    textFieldNama.setText("");
                } else {
                    txtOutput.append("Anda tidak mencentangkan kotak persetujuan\n");
                }
            }
        });

        this.add(button);
        this.add(textFieldNama);
        this.add(checkBox);
        this.add(labelNama);
        this.add(txtOutput);

        this.setSize(400,500);
        this.setLayout(null);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloCheckBox h = new HelloCheckBox();
                h.setVisible(true);
            }
        });
    }

}
