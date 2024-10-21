import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloTextArea extends JFrame {

    public HelloTextArea() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInputNama = new JLabel("Nama:");
        labelInputNama.setBounds(130,40,100,10);

        JTextField textFieldNama = new JTextField();
        textFieldNama.setBounds(130,60,100,30);

        JButton button = new JButton("Klik");
        button.setBounds(130,100,100,40);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(130,150,100,100);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama= textFieldNama.getText();
                txtOutput.append("Hello "+nama+"\n");
                textFieldNama.setText("");

            }
        });

        this.add(button);
        this.add(textFieldNama);
        this.add(labelInputNama);
        this.add(txtOutput);

        this.setSize(400,500);
        this.setLayout(null);

    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloTextArea h =new HelloTextArea();
                h.setVisible(true);
            }
        });
    }

}
