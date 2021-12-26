/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author Radaza Putri
 */
public class AddData extends Menu {
    //variabel
    String kode, nama, alamat, tglLahir, golongan, jmlAnak, status;
    int pilihanSubMenu = 1;
    Scanner input = new Scanner(System.in);
    ArrayList<ArrayList<String>> dataKaryawan = new ArrayList<>();
    
    @Override
    void subMenu() {
        System.out.println("1. Kembali ke Menu Utama");
        System.out.println("2. Tambah Data Kembali");
    }
    @Override
    public void pilihSubMenu() {
        System.out.println("Menu Pilihan : ");
        pilihanSubMenu  = Integer.parseInt(input.nextLine());
    }
    
    public void addData(ArrayList<ArrayList<String>> dataKaryawan) {        
        System.out.println("Masukkan Kode Karyawan : ");
        kode = input.nextLine();
        System.out.println("Masukkan Nama Karyawan : ");
        nama = input.nextLine();
        System.out.println("Masukkan Alamat : ");
        alamat = input.nextLine();
        System.out.println("Masukkan Tanggal Lahir (dd-mm-yyyy) : ");
        tglLahir = input.nextLine();
        System.out.println("Masukkan Golongan (A, B, C) : ");
        golongan = input.nextLine();
        switch(golongan) {
            case "A" :
                break;
            case "B" :
                break;
            case "C" :
                break;
            default :
                System.out.println("Golongan Tidak Valid");
                addData(dataKaryawan);
        }
        
        System.out.println("Masukkan Status Menikah ( 0 jika belum, 1 jika sudah) : ");
        status = input.nextLine();
        if(Integer.parseInt(status) == 0) {
            dataKaryawan.add(new ArrayList<String>(
                Arrays.asList(kode, nama, alamat, tglLahir, golongan, "Belum Menikah")
            ));
        } else if(Integer.parseInt(status) == 1) {
            System.out.println("Masukkan Jumlah Anak : ");
            jmlAnak = input.nextLine();            
            dataKaryawan.add(new ArrayList<String>(
                Arrays.asList(kode, nama, alamat, tglLahir, golongan, "Sudah Menikah", jmlAnak)
            ));
        } else {
            System.out.println("Status Menikah Salah");
            addData(dataKaryawan);
        }
    }
}