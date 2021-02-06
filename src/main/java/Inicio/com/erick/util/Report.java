/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio.com.erick.util;

import Inicio.com.erick.model.Transaction;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author erick
 */
public class Report {
    
    public static void generateReport(){
        //datos ingresados
        Transaction transaction = new Transaction(1,1,"prueba",5.10,50.0,0.0013);
        Transaction transaction1 = new Transaction(1,1,"prueba",5.10,50.0,10.0);
        Transaction transaction2 = new Transaction(1,1,"prueba",5.10,50.0,10.0);
        Transaction transaction3 = new Transaction(1,1,"prueba",5.10,50.0,10.0); 
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        transactions.add(transaction1);
        transactions.add(transaction2);
        transactions.add(transaction3);
        
        List<Transaction> transactionsToday = new ArrayList<>();
        List<Transaction> transactionsTomorrow = new ArrayList<>();

        
        transactions.forEach(t -> {
             java.util.Date temp = new SimpleDateFormat(t.getCreated_date().parse("yyyy-MM-dd HH:mm:ss z"));
             System.out.println(t.getCreated_date());
        });
        
        
    }
    
}
