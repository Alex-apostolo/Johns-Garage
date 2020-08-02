package com.JohnsGarage;

import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
/**This class is responsible for the sorting operations of the program
*/
public class QuickSort{
    //Used to sort using the name of the clients
    public static void sortByName(ArrayList<Client> clients, int low, int high){
        if(clients==null || clients.size()==0 || low>=high){
            return;
        }
        int mid=(high+low)/2;
        String t=clients.get(mid).getFirstName().toLowerCase().trim();
        String t1=clients.get(mid).getLastName().toLowerCase().trim();
        String pivot=t + t1;

        int l=low;
        int r=high;
        while(l<=r){

            while((clients.get(l).getFirstName().toLowerCase().trim()+clients.get(l).getLastName().toLowerCase().trim()).compareTo(pivot)<0){
                l++;
            }
            while((clients.get(r).getFirstName().toLowerCase().trim()+clients.get(r).getLastName().toLowerCase().trim()).compareTo(pivot)>0){
                r--;
            }
            if(l<=r){
                Client temp=clients.get(l);
                clients.set(l,clients.get(r));
                clients.set(r,temp);
                l++;
                r--;
            }
        }
        if(r>low){
            sortByName(clients,low,r);
        }
        if(l<high){
            sortByName(clients,l,high);
        }
    }
    //Used to sort using the licence plate of the cars
    public static void sortByLicencePlate(ArrayList<Client> clients, int low, int high){
        if(clients==null || clients.size()==0 || low>=high){
            return;
        }
        int mid=(high+low)/2;
        String pivot=clients.get(mid).getClientsCar().getLicencePlate().toLowerCase().trim();
        
        int l=low;
        int r=high;
        while(l<=r){

            while(clients.get(l).getClientsCar().getLicencePlate().toLowerCase().trim().compareTo(pivot)<0){
                l++;
            }
            while(clients.get(r).getClientsCar().getLicencePlate().toLowerCase().trim().compareTo(pivot)>0){
                r--;
            }
            if(l<=r){
                Client temp=clients.get(l);
                clients.set(l,clients.get(r));
                clients.set(r,temp);
                l++;
                r--;
            }
        }
        if(r>low){
            sortByLicencePlate(clients,low,r);
        }
        if(l<high){
            sortByLicencePlate(clients,l,high);
        }
    }
    //Used to sort using the date the clients delivered their car to Johns garage
    public static void sortByDeliveryDate(ArrayList<Client> clients, int low, int high){
        SimpleDateFormat t=new SimpleDateFormat("dd/MM/yyyy");
        if(clients==null || clients.size()==0 || low>=high){
            return;
        }
        int mid=(high+low)/2;
        Date pivot=clients.get(mid).getDateOfDelivery();
        int l=low;
        int r=high;
        while(l<=r){

            while(clients.get(l).getDateOfDelivery().compareTo(pivot)<0){
                l++;
            }
            while(clients.get(r).getDateOfDelivery().compareTo(pivot)>0){
                r--;
            }
            if(l<=r){
                Client temp=clients.get(l);
                clients.set(l,clients.get(r));
                clients.set(r,temp);
                l++;
                r--;
            }
        }
        if(r>low){
            sortByDeliveryDate(clients,low,r);
        }
        if(l<high){
            sortByDeliveryDate(clients,l,high);
        }
    }
    //Used to sort using the date the user has set for the maintanence of the cars
    public static void sortByAppointedDate(ArrayList<Client> clients, int low, int high){
        SimpleDateFormat t=new SimpleDateFormat("dd/MM/yyyy");
        if(clients==null || clients.size()==0 || low>=high){
            return;
        }
        int mid=(high+low)/2;
        Date pivot=clients.get(mid).getClientsCar().getAppointedDate();
        int l=low;
        int r=high;
        while(l<=r){

            while(clients.get(l).getClientsCar().getAppointedDate().compareTo(pivot)<0){
                l++;
            }
            while(clients.get(r).getClientsCar().getAppointedDate().compareTo(pivot)>0){
                r--;
            }
            if(l<=r){
                Client temp=clients.get(l);
                clients.set(l,clients.get(r));
                clients.set(r,temp);
                l++;
                r--;
            }
        }
        if(r>low){
            sortByAppointedDate(clients,low,r);
        }
        if(l<high){
            sortByAppointedDate(clients,l,high);
        }
    }
}