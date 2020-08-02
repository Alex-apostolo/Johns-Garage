package com.JohnsGarage;

import java.util.Scanner;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;
/**Through this class the user can input the information of a new client 
which is then used to create an instance of the Client class and the Car class*/
class InputTerminal{
    Scanner in=new Scanner(System.in);
    public Client terminal(){ 

        //Client details
        System.out.println();
        System.out.println("Client details:\n");

        String firstName="";
        System.out.println("Please enter the first name of the client");
        do{
            firstName=in.nextLine();
            if(!firstName.matches("[A-Za-z]+")){
                System.out.println("Please enter a valid name");
            }else{
                break;
            }
        }while(true);
        System.out.println();

        String lastName="";
        System.out.println("Please enter the last name of the client");
        do{
            lastName=in.nextLine();
            if(!lastName.matches("[A-Za-z]+")){
                System.out.println("Please enter a valid name");
            }else{
                break;
            }
        }while(true);
        System.out.println();

        String email="";
        System.out.println("Please enter the email of the client");
        do{
            email=in.nextLine();
            if(!email.matches("[A-Za-z0-9-_]+@[A-Za-z]+\\.[a-z]{2,4}")){
                System.out.println("Please enter a valid email");
            }else{
                break;
            }
        }while(true);
        System.out.println();

        Date dateOfDelivery=null;
        System.out.println("Please enter the day the client left his car in the format dd/MM/yyyy");
        do{
            try{
                String date=in.nextLine();
                Date d=new Date();
                SimpleDateFormat t=new SimpleDateFormat("dd/MM/yyyy");
                t.setLenient(false);
                dateOfDelivery=t.parse(date);

                Calendar c = Calendar.getInstance();
                c.setTime (d);
                c.add(Calendar.DATE, -1);
                d = c.getTime();
                if(dateOfDelivery.compareTo(d)<=0){
                    throw new Exception();
                }
                System.out.println();
                break;

            }catch(Exception e){
                System.out.println("Please enter a valid Date format dd/MM/yyyy");
            }
        }while(true);

        //Car details
        System.out.println("Car details:\n");

        String licencePlate="";
        System.out.println("Please enter the 7 character licence plate of the car, format AAA9999");
        do{
            licencePlate=in.nextLine();
            if(!licencePlate.matches("[A-Za-z]{3}[0-9]{4}")){
                System.out.println("Please enter a valid licence plate format AAA9999");
            }else{
                break;
            }
        }while(true);
        System.out.println();

        int frameNumber=0;
        System.out.println("Please enter the 5 digit frame number of the car, format 99999");
        do{
            try{
                Scanner in=new Scanner(System.in);
                int temp=in.nextInt();
                if(temp>99999 || temp<10000){
                    throw new Exception();
                }
                else{
                    frameNumber=temp;
                    break;
                }
            }catch(Exception e){
                System.out.println("Please enter a valid frame number format 99999");
            }
        }while(true);
        System.out.println();

        Date appointedDate=null;
        System.out.println("Please enter the appointed day for the maintanence of the clients car in the format dd/MM/yyyy");
        do{
            try{
                String date=in.nextLine();
                Date d=new Date();
                SimpleDateFormat t=new SimpleDateFormat("dd/MM/yyyy");
                t.setLenient(false);
                appointedDate=t.parse(date);

                Calendar c = Calendar.getInstance();
                c.setTime (d);
                c.add(Calendar.DATE, -1);
                d = c.getTime();
                if(appointedDate.compareTo(d)<=0){
                    throw new Exception();
                }

                if(dateOfDelivery.compareTo(appointedDate)>=0){
                    System.out.println("The appointed date needs to have a higher value than the date of delivery\n");
                    throw new Exception();
                }
                System.out.println();
                break;

            }catch(Exception e){
                System.out.println("Please enter a valid Date format dd/MM/yyyy");
            }
        }while(true);

        boolean serviced=false;
        Car temp=new Car(licencePlate,frameNumber,appointedDate,serviced);
        Client temp1=new Client(firstName, lastName, email, dateOfDelivery, temp);
        return temp1;
    }
}