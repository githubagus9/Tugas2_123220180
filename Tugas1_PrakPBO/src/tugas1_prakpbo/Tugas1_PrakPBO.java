/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas1_prakpbo;
import Perhitungan.Balok;
import Perhitungan.Persegi;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

class loginPage extends JFrame implements ActionListener{
    JLabel headerLogin = new JLabel("Selamat Datang !");
    JLabel tulisan = new JLabel("Silahkan masuk untuk melanjutkan.");
    JLabel username = new JLabel("Username");
    JLabel password = new JLabel("Password");
    JLabel jenisKelamin = new JLabel("Jenis Kelamin");
    JTextField inputUsername = new JTextField();
    JPasswordField inputPassword = new JPasswordField();
    JRadioButton lakilaki = new JRadioButton("Laki-laki", true);
    JRadioButton perempuan = new JRadioButton("Perempuan");
    JButton login = new JButton("LOGIN");
    
    loginPage(){
        setVisible(true);
        setSize(500,350);
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(null);
        add(headerLogin);
        headerLogin.setFont(new Font("arial", Font.BOLD,20));
        headerLogin.setBounds(25,5,170,35);
        
        add(tulisan);
        tulisan.setFont(new Font("arial", Font.BOLD,15));
        tulisan.setBounds(25,25,250,35);
        
        add(username);
        username.setBounds(25,60,150,35);
        
        add(inputUsername);
        inputUsername.setBounds(25,90,435,25);
        
        add(password);
        password.setBounds(25,120,150,35);
        
        add(inputPassword);
        inputPassword.setBounds(25,150,435,25);
        
        add(jenisKelamin);
        jenisKelamin.setBounds(25,180,150,35);
        
        ButtonGroup pilihJenisKelamin = new ButtonGroup();
        pilihJenisKelamin.add(lakilaki);
        pilihJenisKelamin.add(perempuan);
        add(lakilaki);
        lakilaki.setBounds(25, 210, 75, 25);
        
        add(perempuan);
        perempuan.setBounds(100, 210, 100, 25);
        
        add(login);
        login.addActionListener(this);
        login.setBounds(40, 250, 400, 35);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    try{
        String username = inputUsername.getText();
        String password = inputPassword.getText();
        String jenisKelamin = lakilaki.isSelected() ? "Mr. " : "Mrs. "; 
        
        if(username.isEmpty()){
            throw new Exception("Diharapkan login terlebih dahulu !");
        }
        if(password.isEmpty()){
            throw new Exception("Password tidak boleh kosong!");
        }
        new tugas1_prakpbo.halamanUtama(username, jenisKelamin);
        this.dispose(); 
    } 
    catch(Exception error){
        JOptionPane.showMessageDialog(null, error.getMessage());
      
    }
  }
}

class halamanUtama extends JFrame implements ActionListener{
    JLabel headerUtama = new JLabel();
    JLabel perintah = new JLabel("Tentukan panjang, lebar, dan tinggi untuk menghitung balok");
    JLabel panjang = new JLabel("Panjang");
    JTextField isiPanjang = new JTextField();
    JLabel lebar = new JLabel("Lebar");
    JTextField isiLebar = new JTextField();
    JLabel tinggi = new JLabel("Tinggi");
    JTextField isiTinggi = new JTextField();
    JButton hitung = new JButton("Hitung");
    JButton reset = new JButton("Reset");
    JLabel hasil = new JLabel("Hasil");
    JLabel LPersegi = new JLabel("Luas Persegi");
    JLabel hasilLPersegi = new JLabel("[Hasil berupa angka]");
    JLabel KelPersegi = new JLabel("Keliling Persegi");
    JLabel hasilKelPersegi = new JLabel("[Hasil berupa angka]");
    JLabel VolBalok = new JLabel("Volume Balok");
    JLabel hasilVolBalok = new JLabel("[Hasil berupa angka]");
    JLabel LPBalok = new JLabel("Luas Permukaan Balok");
    JLabel hasilLPBalok = new JLabel("[Hasil berupa angka]");
    
    halamanUtama(String username, String jenisKelamin){
        setVisible(true);
        setSize(530,490);
        setTitle("Halaman Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        setLayout(null);
        
        add(headerUtama);
        headerUtama.setText("Welcome, " + jenisKelamin + username);
        headerUtama.setFont(new Font("arial", Font.BOLD, 20));
        headerUtama.setBounds(25,5,310,35);
        
        add(perintah);
        perintah.setFont(new Font("arial", Font.BOLD, 15));
        perintah.setBounds(25,30,450,35);
        
        add(panjang);
        panjang.setBounds(25,80,50,15);
        
        add(isiPanjang);
        isiPanjang.setBounds(150,75,335,30);
        
        add(lebar);
        lebar.setBounds(25,120,50,15);
        
        add(isiLebar);
        isiLebar.setBounds(150,113,335,30);
        
        add(tinggi);
        tinggi.setBounds(25,160,50,15);
        
        add(isiTinggi);
        isiTinggi.setBounds(150,150,335,30);
        
        add(hitung);
        hitung.setBounds(25,200,460,35);
        
        add(reset);
        reset.setBounds(25,245,460,35);
        
        add(hasil);
        hasil.setBounds(241,300,50,15);
        
        add(LPersegi);
        LPersegi.setBounds(25,330,100,15);
        
        add(hasilLPersegi);
        hasilLPersegi.setBounds(195,330,150,15);
        
        add(KelPersegi);
        KelPersegi.setBounds(25,355,100,15);
        
        add(hasilKelPersegi);
        hasilKelPersegi.setBounds(195,355,150,15);
        
        add(VolBalok);
        VolBalok.setBounds(25,380,100,15);
        
        add(hasilVolBalok);
        hasilVolBalok.setBounds(195,380,150,15);
        
        add(LPBalok);
        LPBalok.setBounds(25,405,150,15);
        
        add(hasilLPBalok);
        hasilLPBalok.setBounds(195,405,150,15);
        
        hitung.addActionListener(this);
        reset.addActionListener(this);
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == hitung){
            double panjang = Double.parseDouble(isiPanjang.getText());
            double lebar = Double.parseDouble(isiLebar.getText());
            double tinggi = Double.parseDouble(isiTinggi.getText());


            Persegi bangun1 = new Persegi(panjang, lebar);
            Balok bangun2 = new Balok(panjang, lebar, tinggi);
            
            String Hasilluas = String.valueOf(bangun1.Luas());
            String Hasilkeliling = String.valueOf(bangun1.Keliling());
            
            String Hasilvolume = String.valueOf(bangun2.Volume());
            String Hasilluaspermukaan = String.valueOf(bangun2.LuasPermukaan());
            
            hasilLPersegi.setText(Hasilluas);
            hasilKelPersegi.setText(Hasilkeliling);
            hasilVolBalok.setText(Hasilvolume);
            hasilLPBalok.setText(Hasilluaspermukaan);

        }
        else if(e.getSource() == reset){
            hasilLPersegi.setText("[Hasil berupa angka]");
            hasilKelPersegi.setText("[Hasil berupa angka]");
            hasilVolBalok.setText("[Hasil berupa angka]");
            hasilLPBalok.setText("[Hasil berupa angka]");
    }
  }
}

/**
 *
 * @author WIN 10
 */

public class Tugas1_PrakPBO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      loginPage loginFrame = new loginPage(); 
  
    }
}