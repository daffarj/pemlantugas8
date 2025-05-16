import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FormPendaftaranMahasiswa extends JFrame {
    // Komponen form
    private JTextField txtNama, txtTanggalLahir, txtNoPendaftaran, txtNoTelp, txtEmail;
    private JTextArea txtAlamat;
    private JButton btnSubmit;
    
    public FormPendaftaranMahasiswa() {
        // Set properti frame
        setTitle("Form Pendaftaran Mahasiswa");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Inisialisasi komponen
        initComponents();
        
        // Tampilkan frame
        setVisible(true);
    }
    
    private void initComponents() {
        // Panel utama
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(new Color(240, 240, 245));
        
        // Label dan TextField untuk Nama Lengkap
        JLabel lblNama = new JLabel("Nama Lengkap");
        lblNama.setBounds(30, 30, 150, 25);
        txtNama = new JTextField();
        txtNama.setBounds(170, 30, 280, 25);
        
        // Label dan TextField untuk Tanggal Lahir
        JLabel lblTanggalLahir = new JLabel("Tanggal Lahir");
        lblTanggalLahir.setBounds(30, 70, 150, 25);
        txtTanggalLahir = new JTextField();
        txtTanggalLahir.setBounds(170, 70, 280, 25);
        
        // Label dan TextField untuk Nomor Pendaftaran
        JLabel lblNoPendaftaran = new JLabel("Nomor Pendaftaran");
        lblNoPendaftaran.setBounds(30, 110, 150, 25);
        txtNoPendaftaran = new JTextField();
        txtNoPendaftaran.setBounds(170, 110, 280, 25);
        
        // Label dan TextField untuk No. Telp
        JLabel lblNoTelp = new JLabel("No. Telp");
        lblNoTelp.setBounds(30, 150, 150, 25);
        txtNoTelp = new JTextField();
        txtNoTelp.setBounds(170, 150, 280, 25);
        
        // Label dan TextArea untuk Alamat
        JLabel lblAlamat = new JLabel("Alamat");
        lblAlamat.setBounds(30, 190, 150, 25);
        txtAlamat = new JTextArea();
        txtAlamat.setBounds(170, 190, 280, 50);
        txtAlamat.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        // Label dan TextField untuk E-mail
        JLabel lblEmail = new JLabel("E-mail");
        lblEmail.setBounds(30, 255, 150, 25);
        txtEmail = new JTextField();
        txtEmail.setBounds(170, 255, 280, 25);
        
        // Tombol Submit
        btnSubmit = new JButton("submit");
        btnSubmit.setBounds(400, 300, 80, 30);
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(validateForm()) {
                    int confirm = JOptionPane.showConfirmDialog(
                        FormPendaftaranMahasiswa.this,
                        "Apakah anda yakin data yang Anda isi sudah benar?",
                        "Konfirmasi Data",
                        JOptionPane.YES_NO_OPTION
                    );
                    
                    if(confirm == JOptionPane.YES_OPTION) {
                        showDataResult();
                    }
                }
            }
        });
        
        // Tambahkan komponen ke panel
        mainPanel.add(lblNama);
        mainPanel.add(txtNama);
        mainPanel.add(lblTanggalLahir);
        mainPanel.add(txtTanggalLahir);
        mainPanel.add(lblNoPendaftaran);
        mainPanel.add(txtNoPendaftaran);
        mainPanel.add(lblNoTelp);
        mainPanel.add(txtNoTelp);
        mainPanel.add(lblAlamat);
        mainPanel.add(txtAlamat);
        mainPanel.add(lblEmail);
        mainPanel.add(txtEmail);
        mainPanel.add(btnSubmit);
        
        // Tambahkan panel ke frame
        add(mainPanel);
    }
    
    private boolean validateForm() {
        if(txtNama.getText().trim().isEmpty() || 
           txtTanggalLahir.getText().trim().isEmpty() ||
           txtNoPendaftaran.getText().trim().isEmpty() ||
           txtNoTelp.getText().trim().isEmpty() ||
           txtAlamat.getText().trim().isEmpty() ||
           txtEmail.getText().trim().isEmpty()) {
            
            JOptionPane.showMessageDialog(
                this,
                "Semua kolom harus diisi!",
                "Validasi Form",
                JOptionPane.WARNING_MESSAGE
            );
            return false;
        }
        return true;
    }
    
    private void showDataResult() {
        // Buat jendela baru
        JFrame resultFrame = new JFrame("Data Mahasiswa");
        resultFrame.setSize(450, 350);
        resultFrame.setLocationRelativeTo(this);
        resultFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        resultFrame.setResizable(false);
        
        // Panel utama
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(new Color(220, 225, 235));
        
        // Label judul
        JLabel titleLabel = new JLabel("Data Mahasiswa");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0));
        panel.add(titleLabel, BorderLayout.NORTH);
        
        // Panel data
        JPanel dataPanel = new JPanel();
        dataPanel.setLayout(null);
        dataPanel.setBackground(Color.WHITE);
        dataPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        
        // Tampilkan data dalam panel
        JLabel lblDataNama = new JLabel("Nama");
        lblDataNama.setBounds(20, 20, 120, 25);
        JLabel lblDataTL = new JLabel("Tanggal Lahir");
        lblDataTL.setBounds(20, 50, 120, 25);
        JLabel lblDataNoPen = new JLabel("No.Pendaftaran");
        lblDataNoPen.setBounds(20, 80, 120, 25);
        JLabel lblDataNoTelp = new JLabel("No.Telp");
        lblDataNoTelp.setBounds(20, 110, 120, 25);
        JLabel lblDataAlamat = new JLabel("Alamat");
        lblDataAlamat.setBounds(20, 140, 120, 25);
        JLabel lblDataEmail = new JLabel("E-mail");
        lblDataEmail.setBounds(20, 170, 120, 25);
        
        JLabel lblTitik1 = new JLabel(":");
        lblTitik1.setBounds(140, 20, 10, 25);
        JLabel lblTitik2 = new JLabel(":");
        lblTitik2.setBounds(140, 50, 10, 25);
        JLabel lblTitik3 = new JLabel(":");
        lblTitik3.setBounds(140, 80, 10, 25);
        JLabel lblTitik4 = new JLabel(":");
        lblTitik4.setBounds(140, 110, 10, 25);
        JLabel lblTitik5 = new JLabel(":");
        lblTitik5.setBounds(140, 140, 10, 25);
        JLabel lblTitik6 = new JLabel(":");
        lblTitik6.setBounds(140, 170, 10, 25);
        
        JLabel lblValueNama = new JLabel(txtNama.getText());
        lblValueNama.setBounds(160, 20, 250, 25);
        JLabel lblValueTL = new JLabel(txtTanggalLahir.getText());
        lblValueTL.setBounds(160, 50, 250, 25);
        JLabel lblValueNoPen = new JLabel(txtNoPendaftaran.getText());
        lblValueNoPen.setBounds(160, 80, 250, 25);
        JLabel lblValueNoTelp = new JLabel(txtNoTelp.getText());
        lblValueNoTelp.setBounds(160, 110, 250, 25);
        JLabel lblValueAlamat = new JLabel(txtAlamat.getText());
        lblValueAlamat.setBounds(160, 140, 250, 25);
        JLabel lblValueEmail = new JLabel(txtEmail.getText());
        lblValueEmail.setBounds(160, 170, 250, 25);
        
        // Tambahkan komponen ke panel data
        dataPanel.add(lblDataNama);
        dataPanel.add(lblDataTL);
        dataPanel.add(lblDataNoPen);
        dataPanel.add(lblDataNoTelp);
        dataPanel.add(lblDataAlamat);
        dataPanel.add(lblDataEmail);
        
        dataPanel.add(lblTitik1);
        dataPanel.add(lblTitik2);
        dataPanel.add(lblTitik3);
        dataPanel.add(lblTitik4);
        dataPanel.add(lblTitik5);
        dataPanel.add(lblTitik6);
        
        dataPanel.add(lblValueNama);
        dataPanel.add(lblValueTL);
        dataPanel.add(lblValueNoPen);
        dataPanel.add(lblValueNoTelp);
        dataPanel.add(lblValueAlamat);
        dataPanel.add(lblValueEmail);
        
        // Tambahkan panel data ke panel utama
        JPanel centerPanel = new JPanel(new BorderLayout());
        centerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centerPanel.add(dataPanel);
        panel.add(centerPanel, BorderLayout.CENTER);
        
        // Tambahkan panel ke jendela
        resultFrame.add(panel);
        
        // Tampilkan jendela
        resultFrame.setVisible(true);
    }
    
    public static void main(String[] args) {
        // Set Look and Feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Jalankan aplikasi
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new FormPendaftaranMahasiswa();
            }
        });
    }
}