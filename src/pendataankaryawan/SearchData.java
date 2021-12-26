/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
/**
 *
 * @author Radaza Putri
 */
public class SearchData extends Menu {
    int pilihanSubMenu  = 1;
    Scanner key = new Scanner(System.in);    
    boolean temukan = false;
    int index = 0;    
    int usia, jmlAnak, gajiPokok, tunjanganMenikah, tunjanganPegawai, tunjanganAnak, gajiKotor;
    double potongan, gajiBersih;
    String golongan, statusMenikah;
    
    @Override
    void subMenu() {
        System.out.println("1. Kembali ke Menu Utama");
    }

    @Override
    public void pilihSubMenu() {
        System.out.print("Menu Pilihan : ");
        pilihanSubMenu  = Integer.parseInt(key.nextLine());
    }
    
    public void searchData(ArrayList<ArrayList<String>> dataKaryawan) throws ParseException {
        System.out.print("Masukkan kode karyawan : ");
        String kode = key.nextLine();        
        for(int i = 0; i < dataKaryawan.size(); i++) {
            String dataKode = dataKaryawan.get(i).get(0);            
            if(dataKode.equals(kode)){
                temukan = true;
                index = i;
            } else {
                System.out.println("Data Karyawan tidak ditemukan");
            }
        }   
    }
    
    public void gaji() {
        switch(golongan) {
            case "A" :
                gajiPokok = 5000000;
                break;
                
            case "B" :
                gajiPokok = 6000000;
                break;
            
            case "C" :
                gajiPokok = 7000000;
                break;
        }
        
        if(statusMenikah == "Sudah Menikah") {
            tunjanganMenikah = (gajiPokok * 10) / 100;
        } else {
            tunjanganMenikah = 0;
        }        
        if(usia > 30) {
            tunjanganPegawai = (gajiPokok * 15) / 100;
        } else {
            tunjanganPegawai = 0;
        }        
        if(jmlAnak > 0) {
            tunjanganAnak = (gajiPokok * 5 / 100) * jmlAnak;
        } else {
            tunjanganAnak = 0;
        }
        
        gajiKotor = gajiPokok + tunjanganMenikah + tunjanganPegawai + tunjanganAnak;
        potongan = (gajiKotor * 2.5) / 100;
        gajiBersih = gajiKotor - potongan;
    }
    
    public void showData(ArrayList<ArrayList<String>> dataKaryawan) throws ParseException {
        String kode = dataKaryawan.get(index).get(0);
        String nama = dataKaryawan.get(index).get(1);
        golongan = dataKaryawan.get(index).get(4);    
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        Date date = formatter.parse(dataKaryawan.get(index).get(3));
        LocalDate birthDay = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        Period period = Period.between(birthDay, LocalDate.now());
        usia = period.getYears();
        
        statusMenikah = dataKaryawan.get(index).get(5);        
        if(statusMenikah == "Sudah Menikah") {
            jmlAnak = Integer.parseInt(dataKaryawan.get(index).get(6));
        } else {
            jmlAnak = 0;
        }
        
        gaji();
        System.out.println("==================================="); 
        System.out.println("DATA PROFILE KARYAWAN");
        System.out.println("==================================="); 
        System.out.println("Kode Karyawan : " + kode);
        System.out.println("Nama Karyawan : " + nama);
        System.out.println("Golongan : " + golongan);
        System.out.println("Usia : " + usia);
        System.out.println("Status Pernikahan : " + statusMenikah);
        System.out.println("Jumlah Anak : " + jmlAnak);        
        System.out.println("===================================");        
        System.out.println("Gaji Pokok : Rp. " + gajiPokok);
        System.out.println("Tunjangan Pernikahan : Rp. " + tunjanganMenikah);
        System.out.println("Tunjangan Pegawai : Rp. " + tunjanganPegawai);
        System.out.println("Tunjangan Anak : Rp. " + tunjanganAnak);        
        System.out.println("===================================");        
        System.out.println("Gaji Kotor : Rp. " + gajiKotor);
        System.out.println("Potongan : Rp. " + potongan);        
        System.out.println("===================================");        
        System.out.println("Gaji Bersih : Rp. " + gajiBersih);
        System.out.println(""); 
    }
}
