package com.JohnsGarage;

import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Date;
import java.text.SimpleDateFormat;
/**This class is responsible for accessing and modifying Johns Garage file and the backup file
*/
class CarFile{
    static final String FILENAME="John's Garage";
    static final String DIR="C:\\Users\\Public\\Johns Garage Backup";
    //This method is used to access the txt file and read the clients information which is then stored in an arraylist
    public ArrayList<Client> readFile(){
        ArrayList<Client> ArrayOfClients= new ArrayList<Client>();
        try{
            FileReader Carfile=new FileReader(FILENAME);
            BufferedReader input=new  BufferedReader(Carfile);

            String line;

            while((line=input.readLine())!=null){
                SimpleDateFormat t=new SimpleDateFormat("dd/MM/yyyy");

                int index =line.indexOf(":");
                int nextIndex=line.indexOf(":",index+1);

                String firstName=line.substring(0, index);

                String lastName=line.substring(index+1, nextIndex);

                index=nextIndex;
                nextIndex=line.indexOf(":", index+1);

                String email=line.substring(index+1,nextIndex);

                index=nextIndex;
                nextIndex=line.indexOf(":", index+1);

                Date dateOfDelivery=t.parse(line.substring(index+1, nextIndex));

                index=nextIndex;
                nextIndex=line.indexOf(":", index+1);

                String licencePlate=line.substring(index+1,nextIndex);

                index=nextIndex;
                nextIndex=line.indexOf(":", index+1);

                int frameNumber=Integer.parseInt(line.substring(index+1,nextIndex));

                index=nextIndex;
                nextIndex=line.indexOf(":", index+1);

                Date appointedDate=t.parse(line.substring(index+1, nextIndex));
                index=nextIndex;
                nextIndex=line.indexOf(":", index+1);

                boolean serviced=Boolean.parseBoolean(line.substring(index+1, nextIndex));

                Car newEntry=new Car(licencePlate, frameNumber, appointedDate, serviced);
                Client newEntry1=new Client(firstName, lastName, email, dateOfDelivery, newEntry);
                ArrayOfClients.add(newEntry1);
            }
        }catch(Exception e){
        }
        return ArrayOfClients;
    }
    //This method is used to write a new entry in the file by adding 
    //the entry to the existing arraylist of clients and then overwriting the list to the file
    public void writeClientToFile(Client te){
        ArrayList<Client> clients=readFile();
        if(clients.size()==8){
            System.out.println("The garage is at maximum capacity, please delete a car which has been received by the client");
            return;
        }
        clients.add(te);
        writeToFile(clients,false);
    }
    //This method is used to remove an entry from the file
    public void removeClientFromFile(String remove){
        ArrayList<Client> clients=readFile();
        QuickSort.sortByName(clients, 0, clients.size()-1);
        int temporary=BinarySearch.searchForName(clients, 0, clients.size()-1,remove);
        clients.remove(temporary);
        writeToFile(clients,false);
    }
    //This method is used to read the existing file and create a backup to another directory
    public void backUpFile(){
        ArrayList<Client> clients=readFile();
        writeToFile(clients,true);
    }
    //This method is used to write the information from the clients list to the file
    public void writeToFile(ArrayList<Client> clients, boolean backUp){
        PrintWriter output=null;
        try{
            if(backUp==true){
                output= new PrintWriter(DIR);
            }else{
                output= new PrintWriter(FILENAME);
            }
        }catch(Exception e){
        }
        
        for(int i=0;i<clients.size();i++){
            SimpleDateFormat t=new SimpleDateFormat("dd/MM/yyyy");

            String firstName=clients.get(i).getFirstName();
            String lastName=clients.get(i).getLastName();
            String email=clients.get(i).getEmail();
            Date dateOfDelivery=clients.get(i).getDateOfDelivery();
            Car clientsCar=clients.get(i).getClientsCar();

            String licencePlate=clientsCar.getLicencePlate();
            int frameNumber=clientsCar.getFrameNumber();
            Date appointedDate=clientsCar.getAppointedDate();
            boolean serviced=clientsCar.getServiced();

            String dateOfDelivery1=t.format(dateOfDelivery);
            String appointedDate1=t.format(appointedDate);

            output.print(firstName+":");
            output.print(lastName+":");
            output.print(email+":");
            output.print(dateOfDelivery1+":");
            output.print(licencePlate+":");
            output.print(frameNumber+":");
            output.print(appointedDate1+":");
            output.print(serviced+":");
            output.println();
        }

        output.close();
    }
    //This method is used to output the data from the file to the console
    public void outputAllClients(){
        ArrayList<Client> clients=readFile();
        if(clients.isEmpty()!=true){
            for(int i=0;i<clients.size();i++){
                SimpleDateFormat t=new SimpleDateFormat("dd/MM/yyyy");

                String firstName=clients.get(i).getFirstName();
                String lastName=clients.get(i).getLastName();
                String email=clients.get(i).getEmail();
                Date dateOfDelivery=clients.get(i).getDateOfDelivery();
                Car clientsCar=clients.get(i).getClientsCar();

                String licencePlate=clientsCar.getLicencePlate();
                int frameNumber=clientsCar.getFrameNumber();
                Date appointedDate=clientsCar.getAppointedDate();
                boolean serviced=clientsCar.getServiced();

                String dateOfDelivery1=t.format(dateOfDelivery);
                String appointedDate1=t.format(appointedDate);

                System.out.println("\nClient "+(i+1)+" details\n");
                System.out.println("Name: "+firstName+" "+lastName);
                System.out.println("Email: "+email);
                System.out.println("Day the client delivered the car: "+dateOfDelivery1);
                System.out.println("\nCar "+(i+1)+" details\n");
                System.out.println("Licence plate: "+ licencePlate);
                System.out.println("Frame number: "+frameNumber);
                System.out.println("Appointed Day for the maintanence: "+appointedDate1);
                System.out.println("Has it been serviced: "+serviced+"\n");
            }
        }else{
            System.out.println("\nThere are no cars to the file\n");
        }
    }
}