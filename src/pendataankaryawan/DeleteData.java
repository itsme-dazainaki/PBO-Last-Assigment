/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Radaza Putri
 */
public class DeleteData extends Menu {
    int pilihanSubMenu  = 1;
    Scanner key = new Scanner(System.in);
    
    @Override
    void subMenu() {
        System.out.println("1. Kembali ke Menu Utama");
        System.out.println("2. Hapus Data Kembali");
    }

    @Override
    public void pilihSubMenu() {
        System.out.println("Menu Pilihan : ");
        pilihanSubMenu  = Integer.parseInt(key.nextLine());
    }
    
    public void deleteData(ArrayList<ArrayList<String>> dataKaryawan) {
        System.out.println("Kode Karyawan yang mau dihapus : ");
        String kode = key.nextLine();        
        boolean temukan = false;
        int index = 0;
        
        for(int i = 0; i < dataKaryawan.size(); i++) {
            String dataKode = dataKaryawan.get(i).get(0);            
            if(dataKode.equals(kode)){
                temukan = true;
                index = i;
            }
        }           
        if(temukan == true) {
            dataKaryawan.remove(index);
            System.out.println("Data Karyawan " + kode + " berhasil dihapus");
        } else {
            System.out.println("Data Karyawan tidak ada");
        }    
    }
}
