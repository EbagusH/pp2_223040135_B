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
                startButton.setEnabled(false); // Nonaktifkan Tombol Saat Proses Berjalan
                statusLabel.setText("Proses Berjalan...");

                // Buat SwingWorker Untuk Menangani Tugas Berat
                SwingWorker<Void, Integer> worker = new SwingWorker<>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        //Simulasi Tugas Berat
                        for (int i = 0; i <= 100; i++) {
                            Thread.sleep(50); // Simulasi Delay
                            publish(i); // Perbarui Progres
                        }
                        return null;
                    }

                    @Override
                    protected void process(List<Integer> chunks) {
                        // Perbarui Progress Bar
                        int latestProgress = chunks.get(chunks.size() - 1);
                        progressBar.setValue(latestProgress);
                    }

                    @Override
                    protected void done() {
                        // Aksi Setelah Tugas Selesai
                        startButton.setEnabled(true);
                        statusLabel.setText("Proses Selesai");
                    }
                };

                // Jalankan SwingWorker
                worker.execute();
            });

            // Tampilkan Frame
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
