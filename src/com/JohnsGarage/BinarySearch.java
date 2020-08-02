package com.JohnsGarage;

import java.util.ArrayList;
/**This class is responsible for the search operations of the program
*/
public class BinarySearch{
    //Used to search for a clients name
    public static int searchForName(ArrayList<Client> clients,int low,int high,String target){
        if(clients==null || high<low){
            return 0;
        }
        int mid=(high+low)/2;
        if((clients.get(mid).getFirstName().toLowerCase().trim()
        +" "+clients.get(mid).getLastName().toLowerCase().trim()).compareTo(target)<0){
            return searchForName(clients,mid+1,high,target);
        }else if((clients.get(mid).getFirstName().toLowerCase().trim()
        +" "+clients.get(mid).getLastName().toLowerCase().trim()).compareTo(target)>0){
            return searchForName(clients,low,mid-1,target);
        }else{
            return mid;
        }
    }
    //Used to search for a cars licence plate
    public static int searchForLicencePlate(ArrayList<Client> clients,int low,int high,String target){
        if(clients==null || high<low){
            return 0;
        }
        int mid=(high+low)/2;
        if(clients.get(mid).getClientsCar().getLicencePlate().toLowerCase().trim().compareTo(target)<0){
            return searchForLicencePlate(clients,mid+1,high,target);
        }else if(clients.get(mid).getClientsCar().getLicencePlate().toLowerCase().trim().compareTo(target)>0){
            return searchForLicencePlate(clients,low,mid-1,target);
        }else{
            return mid;
        }
    }
}