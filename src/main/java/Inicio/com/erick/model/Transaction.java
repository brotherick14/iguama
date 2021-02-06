/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio.com.erick.model;
import java.text.SimpleDateFormat;
import java.util.Date;



/**
 *
 * @author erick
 */
public class Transaction {
    private int id_orden;
    private  String created_date;
    private int id_cliente;
    private String product_name;
    private double total_amount;
    private double total_miles;
    private double exchange_rate;

    public Transaction(int id_orden, int id_cliente, String product_name, double total_amount, double total_miles, double exchange_rate) {
        this.id_orden = id_orden;
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss z");
        Date date = new Date(System.currentTimeMillis());
        this.created_date = formatter.format(date);
        this.id_cliente = id_cliente;
        this.product_name = product_name; //50 caracteres maximo
        this.total_amount = total_amount;
        this.total_miles = total_miles;
        this.exchange_rate = exchange_rate;
    }
    
      @Override
        public String toString() {
                String item = "\n :: Reporte ::" + 
                    "\n Id Transaccion: " + getId_orden() +
                    "\n Fecha de creacion: " + getCreated_date() + 
                    "\n Id Cliente: " + getId_cliente() +
                    "\n Nombre del producto: " + getProduct_name() +
                    "\n Monto total: " + "$"+getTotal_amount() +
                    "\n Total millas gastadas: Millas " + getTotal_miles() +
                    "\n Tipo de cambio: " + getExchange_rate();

		return  item;
        }
    
    /*
    Getters
    */

    public int getId_orden() {
        return id_orden;
    }

    public String getCreated_date() {
        return created_date;
    }

    public int getId_cliente() {
        return id_cliente;
    }

    public String getProduct_name() {
        return product_name;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public int getTotal_miles() {
        int result = (int) Math.round(total_amount/exchange_rate);
        return result;
    }

    public double getExchange_rate() {
        return exchange_rate;
    }
    
    /*
    Setters
    */

    public void setId_orden(int id_orden) {
        this.id_orden = id_orden;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public void setId_cliente(int id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public void setTotal_miles(double total_miles) {
        this.total_miles = total_miles;
    }

    public void setExchange_rate(double exchange_rate) {
        this.exchange_rate = exchange_rate;
    }
    
    
    
    
    
}
