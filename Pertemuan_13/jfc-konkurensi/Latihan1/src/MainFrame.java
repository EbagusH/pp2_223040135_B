import javax.swing.*;
import java.awt.*;
import java.util.List;

public class MainFrame {
    public static void main(String[] args) {
        // Membuat Frame Utama
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Contoh Konkurensi di Swing");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(400, 200);
            frame.setLayout(new BorderLayout());

            // Label Untuk Status
            JLabel statusLabel = new JLabel("Tekan Tombol Untuk Mulai Tugas Berat", JLabel.CENTER);

            // Tombol Untuk Memulai Proses
            JButton startButton = new JButton("Mulai");

            // Progress Bar
            JProgressBar progressBar = new JProgressBar(0, 60);
            progressBar.setValue(0);
            progressBar.setStringPainted(true);

            // Tambahkan Komponen Ke Frame
            frame.add(statusLabel, BorderLayout.NORTH);
            frame.add(progressBar, BorderLayout.CENTER);
            frame.add(startButton, BorderLayout.SOUTH);

            // Tombol Aksi
            startButton.addActionListener(e -> {
                // Update Progress bar 1% Per Detik
                for (int i = 0; i <= 60; i++) {
                    progressBar.setValue(i);
                    try {
                        Thread.sleep(1000);
                    } catch (Exception ex) {
                        System.err.println(ex.getMessage());
                    }
                }
            });

            // Tampilkan Frame
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
