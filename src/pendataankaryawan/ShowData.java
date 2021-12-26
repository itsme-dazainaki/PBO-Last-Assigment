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
public class ShowData extends Menu {
    int pilihanSubMenu  = 1;
    Scanner key = new Scanner(System.in);
    
    @Override
    void subMenu() {
        System.out.println("1. Kembali ke Menu Utama");
    }

    @Override
    public void pilihSubMenu() {
        System.out.println("Menu Pilihan : ");
        pilihanSubMenu   = Integer.parseInt(key.nextLine());
    }
    
    public void showData(ArrayList<ArrayList<String>> dataKaryawan) {
        int i = 0;        
        while(i < dataKaryawan.size()) {
            if(dataKaryawan.get(i).size() == 7) {
                for(int j = 0; j < 7; j++) {
                    System.out.print(dataKaryawan.get(i).get(j) + "     ");
                }
                System.out.println("");
                i++;
            } else if (dataKaryawan.get(i).size() == 6) {
                for(int j = 0; j < 6; j++) {
                    System.out.print(dataKaryawan.get(i).get(j) + "     ");
                }
                System.out.println("");
                i++;
            }            
        }
    }
    
}
