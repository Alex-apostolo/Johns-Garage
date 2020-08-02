package com.JohnsGarage;

import java.util.Date;
/** This class is responsible for abstracting the characteristics and functions of a real car
*/
public class Car
{
    //Instance Variables
    private String licencePlate;
    private int frameNumber;
    private Date appointedDate;
    private boolean serviced;
    
    //Constructor
    public Car(String licencePlate,int frameNumber,Date appointedDate,boolean serviced){
        this.licencePlate=licencePlate;
        this.frameNumber=frameNumber;
        this.appointedDate=appointedDate;
        this.serviced=serviced;
    }
    
    //Mutators and Accessors
    public void setLicencePlate(String l){
        this.licencePlate=l;
    }

    public String getLicencePlate(){
        return this.licencePlate;
    }

    public void setFrameNumber(int f){
        this.frameNumber=f;
    }

    public int getFrameNumber(){
        return this.frameNumber;
    }

    public void setAppointedDate(Date a){
        this.appointedDate=a;
    }

    public Date getAppointedDate(){
        return this.appointedDate;
    }

    public void setServiced(boolean s){
        this.serviced=s;
    }

    public boolean getServiced(){
        return this.serviced;
    }
}