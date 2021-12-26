/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pendataankaryawan;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 *
 * @author Radaza Putri
 */
public class ProjectPendataanKaryawan {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {        
        ArrayList<ArrayList<String> > dataKaryawan = new ArrayList<>();
        Scanner input = new Scanner(System.in);        
        AddData add = new AddData();
        ShowData show = new ShowData();
        DeleteData delete = new DeleteData();
        SearchData search = new SearchData();    
        
        while(true) {
            System.out.println("Menu Data ArrayList");
            add.menu();            
            System.out.println("Menu pilihan : ");
            int menuChoosen = Integer.parseInt(input.next());
            switch(menuChoosen) {                
                case 1:
                OUTER:
                while (true) {
                    add.addData(dataKaryawan);
                    add.subMenu();
                    add.pilihSubMenu();
                    switch (add.pilihanSubMenu ) {
                        case 1:
                            break OUTER;
                        case 2:
                            continue;
                        default:
                            System.out.println("Inputan Salah");
                            break OUTER;
                    }
                }
                   break;               
                case 2:
                OUTER:
                while (true) {
                    delete.deleteData(dataKaryawan);
                    delete.subMenu();
                    delete.pilihSubMenu();
                    switch (delete.pilihanSubMenu ) {
                        case 1:
                            break OUTER;
                        case 2:
                            continue;
                        default:
                            System.out.println("Inputan Salah");
                            break OUTER;
                    }
                }
                    break;                    
                case 3:
                OUTER:
                while (true) {
                    search.searchData(dataKaryawan);
                    search.showData(dataKaryawan);                    
                    search.subMenu();
                    search.pilihSubMenu();
                    switch (search.pilihanSubMenu ) {
                        case 1:
                            break OUTER;
                        default:
                            System.out.println("Inputan Salah");
                            break OUTER;
                    }
                }
                    break;
                case 4:
                OUTER:
                while (true) {
                    show.showData(dataKaryawan);
                    show.subMenu();
                    show.pilihSubMenu();
                    switch (show.pilihanSubMenu ) {
                        case 1:
                            break OUTER;
                        default:
                            System.out.println("Inputan Salah");
                            break OUTER;
                    }
                }
                    break;
                case 5:
                    System.out.println("Keluar Program");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Pilih menu :");
                    break;
            }
        }
    }
}
