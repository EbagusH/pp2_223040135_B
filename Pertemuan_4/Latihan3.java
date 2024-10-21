// Materi KeyListenerExample

import javax.swing.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Latihan3 {
    public static void main(String[] args) {
        // Membuat Frame
        JFrame frame = new JFrame("KeyListener Example");

        // Membuat  label untuk menampilkan pesan
        JLabel label = new JLabel("Tekan Tombol Pada Keyboard");
        label.setBounds(50, 50, 300, 30);

        // Membuat text field untuk fokus keyboard
        JTextField textField = new JTextField();
        textField.setBounds(50, 100, 200, 30);

        // Menambahkan KeyListener ke text field
        textField.addKeyListener(new KeyAdapter() {
           // Dijalankan ketika tombol ditekan
           public void keyPressed(KeyEvent e) {
               label.setText("Key Pressed: " + KeyEvent.getKeyText(e.getKeyCode()));
           }

           // Dijalankan ketika tombol dilepaskan
            public void keyReleased(KeyEvent e) {
               label.setText("Key Released: " + KeyEvent.getKeyText(e.getKeyCode()));
            }

            // Dijalankan ketika tombol ditekan dan dilepaskan (sama dengan mengetik karakter)
            public void keyTyped(KeyEvent e) {
               label.setText("Key Typed: " + e.getKeyChar());
            }
        });

        // Menambahkan komponen ke frame
        frame.add(label);
        frame.add(textField);

        // Setting Frame
        frame.setSize(400, 200);
        frame.setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
