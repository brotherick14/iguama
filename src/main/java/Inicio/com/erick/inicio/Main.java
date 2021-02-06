/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio.com.erick.inicio;
import Inicio.com.erick.model.Transaction;
import Inicio.com.erick.util.Report;
import Inicio.com.erick.util.Utils;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author erick
 */
public class Main {
    
    public static void main(String[] args){
      
        showMenu();
    }
    
    public static void showMenu() {
		int exit = 0;
		do {
			System.out.println("BANCO IGUAMA");
			System.out.println("");
			System.out.println("Selecciona el número de la opción deseada");
			System.out.println("1. Ver reportes");
			System.out.println("2. Generar reportes");
			System.out.println("0. Exit");
			
			//Leer la respuesta del usuario
			int response = Utils.validateUserResponseMenu(0, 2);

			switch (response) {
				case 0:
					//salir
					exit = 0;
					break;
				case 1:
					showReport();
					break;
				case 2:
					generateReport();
					break;
				
				default:
					System.out.println();
					System.out.println("....¡¡Selecciona una opción!!....");
					System.out.println();
					exit = 1;
					break;
			}
			
			
		}while(exit != 0);
	}
    
    public static void showReport(){
        int exit = 1;
        do {
			System.out.println();
			System.out.println(":: VER REPORTE ::");
			System.out.println();
                        try {
                            Report.generateReport();
                        } catch (ParseException ex) {
                            System.out.println("error");
                        }
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = Utils.validateUserResponseMenu(0, 0);
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
		}while(exit !=0);
    }
    public static void generateReport(){
                int exit = 1;
        do {
			System.out.println();
			System.out.println(":: GENERAR REPORTE ::");
			System.out.println();
			
			System.out.println("0. Regresar al Menu");
			System.out.println();
			
			//Leer Respuesta usuario
			int response = Utils.validateUserResponseMenu(0, 0);
			
			if(response == 0) {
				exit = 0;
				showMenu();
			}
			
			if(response > 0) {
                            System.out.println("generar");
			}
			
		}while(exit !=0);

    }
    
}
