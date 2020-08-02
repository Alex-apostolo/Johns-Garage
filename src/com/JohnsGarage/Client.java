package com.JohnsGarage;

import java.util.Date;
/** This class is responsible for abstracting the characteristics and functions of a real client
*/
public class Client
{
    //Instance Variables
    private String firstName;
    private String lastName;
    private String email;
    private Date dateOfDelivery;
    private Car clientsCar;
    
    //Constructor
    public Client(String firstName, String lastName, String email, Date dateOfDelivery, Car clientsCar){
        this.firstName=firstName;
        this.lastName=lastName;
        this.email=email;
        this.dateOfDelivery=dateOfDelivery;
        this.clientsCar=clientsCar;
    }
    
    //Mutators and Accessors
    public void setFirstName(String f){
        this.firstName=f;
    }

    public String getFirstName(){
        return firstName;
    }
    
    public void setLastName(String l){
        this.lastName=l;
    }
    
    public String getLastName(){
        return lastName;
    }
    
    public void setEmail(String e){
        this.email=e;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setDateOfDelivery(Date d){
        this.dateOfDelivery=d;
    }

    public Date getDateOfDelivery(){
        return dateOfDelivery;
    }

    public void setClientsCar(Car c){
        this.clientsCar=c;
    }

    public Car getClientsCar(){
        return clientsCar;
    }
}