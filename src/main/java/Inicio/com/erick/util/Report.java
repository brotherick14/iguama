/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio.com.erick.util;

import Inicio.com.erick.model.Transaction;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 *
 * @author erick
 */
public class Report {
    
    public static void generateReport() throws ParseException{
        //fechas
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");
        Date date = dateFormat.parse("2021-02-06 15:00:00.191");
        Date date2 = dateFormat.parse("2021-02-07 13:21:02.191");
        Timestamp timestamp = new Timestamp(date.getTime());
        Timestamp timestamp2 = new Timestamp(date2.getTime());
        
        //datos ingresados
        Transaction transaction = new Transaction(1,timestamp,1,"prueba",5.10,50.0,0.0013);
        Transaction transaction1 = new Transaction(1,timestamp2,1,"prueba",5.10,50.0,10.0);
        List<Transaction> transactions = new ArrayList<>();
        transactions.add(transaction);
        transactions.add(transaction1);
        
        //list where we are going to save today and tomorrow reports
        List<Transaction> transactionsToday = new ArrayList<>();
        List<Transaction> transactionsTomorrow = new ArrayList<>();
        
        Date dates= new Date();
        Timestamp ts = new Timestamp(dates.getTime());

        //verify dates in order to save data in the right place
        transactions.forEach(t -> {
            Calendar cal = Calendar.getInstance();
            Calendar cal2 = Calendar.getInstance();
            cal.setTime(new Date(t.getCreated_date().getTime()));
            cal2.setTime(new Date(ts.getTime()));
            
            if(cal.get(Calendar.YEAR) == cal2.get(Calendar.YEAR) && cal.get(Calendar.MONTH) == cal2.get(Calendar.MONTH)){
                if(cal.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH) && (cal.get(Calendar.HOUR_OF_DAY) <= 17 )   ){
                    if(cal.get(Calendar.SECOND) == 0){ //saving in today
                        transactionsToday.add(t);
                    }else{//saving in tomorrow
                        transactionsTomorrow.add(t);
                    }
                }else if((cal.get(Calendar.DAY_OF_MONTH)) == (cal2.get(Calendar.DAY_OF_MONTH)+1)){
                    transactionsTomorrow.add(t); //saving in tomorrow
                }
            }
        });
        //today and tomorrow date
        String pattern = "yyyy-MM-dd";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        String actuald = simpleDateFormat.format(new Date());
        Date dt = new Date();
        Calendar c = Calendar.getInstance(); 
        c.setTime(dt); 
        c.add(Calendar.DATE, 1);
        dt = c.getTime();
        String actuald2 = simpleDateFormat.format(dt);
        
        //prints today report
        System.out.println("Reporte del dia "+actuald);
        transactionsToday.forEach(today -> {
            System.out.println(today);
        });

        //prints tomorrow report
        System.out.println("Reporte del dia "+actuald2);
        transactionsToday.forEach(today -> {
            System.out.println(today);
        });
        
        
    }
    
}
