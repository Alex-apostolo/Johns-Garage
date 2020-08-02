package com.JohnsGarage;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.text.SimpleDateFormat;
import javax.mail.Session;
import javax.mail.PasswordAuthentication;
import javax.mail.Message; 
import javax.mail.Transport;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.InternetAddress;
/**
 * This class is responsible for providing the user with an interactable menu 
 * Furthermore this is the main class from where all the other classes are accessed
 */
public class Garage{
    CarFile cf;
    boolean first=true;
    Scanner in=new Scanner(System.in);

    public static void main(String[] args){
        new Garage();
    }

    public Garage(){
        cf=new CarFile();
        showMenu();
    }
    //This method displays a menu where the user can choose between the 11 different options
    public void showMenu(){
        if(first){
            decrypt();
            first=false;
            System.out.println("");
            System.out.println("         __    ______    __    __  ,__   __,       _______,");
            System.out.println("            |  |  /  __  \\  |  |  |  | |  \\ |  |     /       |");
            System.out.println("        |  | |  |  |  | |  |__|  | |   \\|  |    |   (----`");
            System.out.println("      ,--,  |  | |  |  |  | |   __   | |  , `  |     \\   \\ ");
            System.out.println("      |  `--'  | |  `--'  | |  |  |  | |  |\\   | ,----)   |");
            System.out.println("       \\______/   \\______/  |__|  |__| |__| \\__| |_______/");
            System.out.println("                                                        ");
            System.out.println("  _______      ___      ,______          ___       _______  _______");
            System.out.println(" /  _____|    /   \\     |   _  \\        /   \\     /  _____||   ____|");
            System.out.println("|  |  __     /  ^  \\    |  |_)  |      /  ^  \\   |  |  __  |  |__  ");
            System.out.println("|  | |_ |   /  /_\\  \\   |      /      /  /_\\  \\  |  | |_ | |   __| ");
            System.out.println("|  |__| |  /  _____  \\  |  |\\  \\----,/  _____  \\ |  |__| | |  |____ ");
            System.out.println(" \\______| /__/     \\__\\ | _| `,_____/__/     \\__\\ \\______| |_______|");
            System.out.println("");
            System.out.println("");
            try{
                Thread.sleep(1500);
            }catch(Exception e)
            {
            }
            System.out.println("       __---****--__                      __--****---__");
            System.out.println("     `\\---********\\\\                    //********---/' ");
            System.out.println("       \\/*********\\||                  ||/*********\\/ ");
            System.out.println("                   `\\\\                //'");
            System.out.println("                     `\\\\            //'");
            System.out.println("                       ||          ||");
            System.out.println("             ______--******************--______ ");
            System.out.println("        ___ // _-*                        *-_ \\\\ ___ ");
            System.out.println("       `\\__)\\/*                              *\\/(__/' ");
            System.out.println("        _--`-___                            ___-'--_ ");
            System.out.println("      /*     `\\ ********------------******** /'     *\\   ");
            System.out.println("     /|        `\\         ________         /'        |\\ ");
            System.out.println("    | `\\   ______`\\_      \\------/      _/'______   /' | ");
            System.out.println("    |    `\\_______\\ *-________________-* /_______/'   |");
            System.out.println("    `.     *-__________________________________-*     .' ");
            System.out.println("     `.      [_______/------|**|------\\_______]      .'");
            System.out.println("      `\\--___((____)(________\\/________)(____))___--/' ");
            System.out.println("      |>>>>>>||                            ||<<<<<<|");
            System.out.println("");
            System.out.println("");
            try{
                Thread.sleep(1000);
            }catch(Exception e)
            {
            }
        }
        System.out.println("Please select one of the following actions");
        System.out.println();
        System.out.println("a List all the client data");
        System.out.println("b Add a client");
        System.out.println("c Remove a client");
        System.out.println("d Search a client using their full name");
        System.out.println("e Search a car using its licence plate");
        System.out.println("f Sort clients using the date they delivered their car to the garage");
        System.out.println("g Sort cars using their appointed dates for maintanence");
        System.out.println("h Assign a car that has undergone service");
        System.out.println("i Change the appointed date for maintanence of a car");
        System.out.println("j Email all the clients whose car has undergone service");
        System.out.println("k exit");

        try{
            Scanner in=new Scanner(System.in);
            String selection=in.nextLine();
            char selection1=selection.charAt(0);
            if(selection.length()>1 || selection==null){
                System.out.println("\nError please enter a character between a and k\n");
                showMenu();
            }else if(selection1<'a'||selection1>'k'){
                System.out.println("\nError please enter a character between a and k\n");
                showMenu();
            }else{
                switch(selection1){
                    case 'a':listAllClients();
                    break;
                    case 'b':addClient();
                    break;
                    case 'c':removeClient();
                    break;
                    case 'd':binarySearch(true);
                    break;
                    case 'e':binarySearch(false);
                    break;
                    case 'f':quickSort(true);
                    break;
                    case 'g':quickSort(false);
                    break;
                    case 'h':serviceIsCompleted();
                    break;
                    case 'i':changeAppointedDate();
                    break;
                    case 'j':emailClients();
                    break;
                    case 'k':encrypt();
                    cf.backUpFile();
                    System.exit(0);
                }
            }
        }catch(Exception e){

        }
    }
    //This method lists all the clients to the terminal
    public void listAllClients(){
        cf.outputAllClients();
        System.out.println("Type any character to go back to the main menu");
        in.nextLine();
        System.out.println();
        showMenu();
    }
    //This method is used to access the InputTerminal class and then the CarFile class to add a new Client with his car to the database
    public void addClient(){
        InputTerminal addClient=new InputTerminal();
        Client b=addClient.terminal();
        cf.writeClientToFile(b);
        System.out.println("\nThe Client "+b.getFirstName()+" "+b.getLastName()+" was added to the database\n ");
        System.out.println("Type any character to go back to the main menu");
        in.nextLine();
        System.out.println();
        showMenu();
    }
    //This method is used to receive the target clients information and then call the CarFile class to remove the target 
    public void removeClient(){
        ArrayList<Client> clients=cf.readFile();
        if(clients.isEmpty()==true){
            System.out.println("\nThere are no cars to the file\n");
            System.out.println("Type any character to go back to the main menu");
            in.nextLine();
            System.out.println();
            showMenu();
        }
        System.out.println("\nThe names in alphabetical order are ");
        QuickSort.sortByName(clients, 0, clients.size()-1);
        for(int i=0;i<clients.size();i++){
            System.out.println(clients.get(i).getFirstName().trim()+" "+clients.get(i).getLastName().trim());
        }
        System.out.println();
        System.out.println("Type the full name of the client");
        String fn;
        boolean match=false;
        do{
            fn=in.nextLine();
            if(!fn.matches("[A-Za-z]+[ ]{1}[A-Za-z]+")){
                System.out.println("Please enter a valid full name");
            }else{
                for(int i=0;i<clients.size();i++){
                    if(fn.toLowerCase().trim().matches(clients.get(i).getFirstName().toLowerCase().trim()+" "+clients.get(i).getLastName().toLowerCase().trim())){
                        match=true;
                    }
                }
                if(match){
                    break;
                }else{
                    System.out.println("Please enter a valid full name");
                }
            }
        }while(true);
        System.out.println();
        cf.removeClientFromFile(fn.toLowerCase());
        System.out.println("The Client "+fn+" was removed from the database\n");
        System.out.println("Type any character to go back to the main menu");
        in.nextLine();
        System.out.println();
        showMenu();
    }

    //This method is used to call the QuickSort class and to provide the sorted arraylist as a parameter for the BinarySearch class
    public void binarySearch(boolean useFullName){
        ArrayList<Client> clients=cf.readFile();
        if(clients.isEmpty()==true){
            System.out.println("\nThere are no cars to the file\n");
            System.out.println("Type any character to go back to the main menu");
            in.nextLine();
            System.out.println();
            showMenu();
        }
        Client temp=null;
        if(useFullName){
            QuickSort.sortByName(clients, 0, clients.size()-1);
            System.out.println("\nThe names in alphabetical order are ");
            for(int i=0;i<clients.size();i++){
                System.out.println(clients.get(i).getFirstName().trim()+" "+clients.get(i).getLastName().trim());
            }
            System.out.println();
            System.out.println("Type the full name of the client");
            String fn;
            boolean match=false;
            do{
                fn=in.nextLine();
                if(!fn.matches("[A-Za-z]+[ ]{1}[A-Za-z]+")){
                    System.out.println("Please enter a valid full name");
                }else{
                    for(int i=0;i<clients.size();i++){
                        if(fn.toLowerCase().trim().matches(clients.get(i).getFirstName().toLowerCase().trim()+" "+clients.get(i).getLastName().toLowerCase().trim())){
                            match=true;
                        }
                    }
                    if(match){
                        break;
                    }else{
                        System.out.println("Please enter a valid full name");
                    }
                }
            }while(true);
            int temporary=BinarySearch.searchForName(clients, 0, clients.size()-1,fn.toLowerCase().trim());
            temp=clients.get(temporary);
        }else{
            QuickSort.sortByLicencePlate(clients, 0, clients.size()-1);
            System.out.println("\nThe licence plates in decsending order are ");
            for(int i=0;i<clients.size();i++){
                System.out.println(clients.get(i).getClientsCar().getLicencePlate().trim());
            }
            System.out.println();
            System.out.println("Type the licence plate of the car");
            String fn;
            boolean match=false;
            do{
                fn=in.nextLine();
                if(!fn.matches("[A-Za-z]{3}[0-9]{4}")){
                    System.out.println("Please enter a valid licence plate");
                }else{
                    for(int i=0;i<clients.size();i++){
                        if(fn.toLowerCase().trim().matches(clients.get(i).getClientsCar().getLicencePlate().toLowerCase().trim())){
                            match=true;
                        }
                    }
                    if(match){
                        break;
                    }else{
                        System.out.println("Please enter a valid licence plate");
                    }
                }
            }while(true);
            int temporary=BinarySearch.searchForLicencePlate(clients, 0, clients.size()-1,fn.toLowerCase().trim());
            temp=clients.get(temporary);
        }
        SimpleDateFormat t=new SimpleDateFormat("dd/MM/yyyy");
        System.out.println("\nClient details\n");
        System.out.println("Full Name: "+temp.getFirstName().trim()+" "+temp.getLastName().trim());
        System.out.println("Email: "+temp.getEmail().trim());
        System.out.println("Day the client delivered the car: "+t.format(temp.getDateOfDelivery()));
        System.out.println("\nCar details\n");
        System.out.println("Licence plate: "+ temp.getClientsCar().getLicencePlate());
        System.out.println("Frame number: "+temp.getClientsCar().getFrameNumber());
        System.out.println("Appointed Day for the maintanence: "+t.format(temp.getClientsCar().getAppointedDate()));
        System.out.println("Has it been serviced: "+temp.getClientsCar().getServiced()+"\n");

        System.out.println("Type any character to go back to the main menu");
        in.nextLine();
        System.out.println();
        showMenu();
    }
    //This method is used for accessing the QuickSort class and then the CarFile to overwrite all the clients information with the sorted ones
    public void quickSort(boolean useDeliveryDate){
        ArrayList<Client> clients=cf.readFile();
        if(clients.isEmpty()==true){
            System.out.println("\nThere are no cars to the file\n");
            System.out.println("Type any character to go back to the main menu");
            in.nextLine();
            System.out.println();
            showMenu();
        }

        if(useDeliveryDate){
            QuickSort.sortByDeliveryDate(clients, 0, clients.size()-1);
        }else{
            QuickSort.sortByAppointedDate(clients, 0, clients.size()-1);
        }
        cf.writeToFile(clients,false);
        cf.outputAllClients();
        System.out.println("Type any character to go back to the main menu");
        in.nextLine();
        System.out.println();
        showMenu();
    }
    //This method is used for assigning a car which has been serviced, furthermore this method accesses the BinarySearch class to find the target client and the CarFile to overwrite the data with the new information
    public void serviceIsCompleted(){
        ArrayList<Client> clients=cf.readFile();
        if(clients.isEmpty()==true){
            System.out.println("\nThere are no cars to the file\n");
            System.out.println("Type any character to go back to the main menu");
            in.nextLine();
            System.out.println();
            showMenu();
        }
        QuickSort.sortByLicencePlate(clients, 0, clients.size()-1);
        System.out.println("\nThe licence plates in decsending order are ");
        for(int i=0;i<clients.size();i++){
            System.out.println(clients.get(i).getClientsCar().getLicencePlate().trim());
        }
        System.out.println("\nType the licence plate of the serviced car");
        String fn;
        boolean match=false;
        do{
            fn=in.nextLine();
            if(!fn.matches("[A-Za-z]{3}[0-9]{4}")){
                System.out.println("Please enter a valid licence plate");
            }else{
                for(int i=0;i<clients.size();i++){
                    if(fn.toLowerCase().trim().matches(clients.get(i).getClientsCar().getLicencePlate().toLowerCase().trim())){
                        match=true;
                    }
                }
                if(match){
                    break;
                }else{
                    System.out.println("Please enter a valid licence plate");
                }
            }
        }while(true);
        int temporary=BinarySearch.searchForLicencePlate(clients, 0, clients.size()-1,fn.toLowerCase().trim());
        clients.get(temporary).getClientsCar().setServiced(true);
        cf.writeToFile(clients,false);

        System.out.println("\nThe car of the client "+clients.get(temporary).getFirstName()+" "+clients.get(temporary).getLastName()+" has been assigned as serviced");
        System.out.println("\nType any character to go back to the main menu");
        in.nextLine();
        System.out.println();
        showMenu();
    }
    //This method is used to change the appointed date for the service of a car by accessing the CarFile and searching for a target client through the BinarySearch class
    public void changeAppointedDate(){
        ArrayList<Client> clients=cf.readFile();
        if(clients.isEmpty()==true){
            System.out.println("\nThere are no cars to the file\n");
            System.out.println("Type any character to go back to the main menu");
            in.nextLine();
            System.out.println();
            showMenu();
        }
        QuickSort.sortByLicencePlate(clients, 0, clients.size()-1);
        System.out.println("\nThe licence plates in decsending order are ");
        for(int i=0;i<clients.size();i++){
            System.out.println(clients.get(i).getClientsCar().getLicencePlate().trim());
        }
        System.out.println("\nType the licence plate of the car");
        String fn;
        boolean match=false;
        do{
            fn=in.nextLine();
            if(!fn.matches("[A-Za-z]{3}[0-9]{4}")){
                System.out.println("Please enter a valid licence plate");
            }else{
                for(int i=0;i<clients.size();i++){
                    if(fn.toLowerCase().trim().matches(clients.get(i).getClientsCar().getLicencePlate().toLowerCase().trim())){
                        match=true;
                    }
                }
                if(match){
                    break;
                }else{
                    System.out.println("Please enter a valid licence plate");
                }
            }
        }while(true);
        int temporary=BinarySearch.searchForLicencePlate(clients, 0, clients.size()-1,fn.toLowerCase().trim());
        System.out.println("\nPlease enter the new appointed day for maintanence for the car "+clients.get(temporary).getClientsCar().getLicencePlate());
        Date appointedDate=null;
        do{
            try{
                String date=in.nextLine();
                if(date.matches("[0-9]{1,2}\\/[0-9]{1,2}\\/[2]{1}[0-9]{1}[0-9]{1}[0-9]{1}")){
                    SimpleDateFormat t=new SimpleDateFormat("dd/MM/yyyy");
                    t.setLenient(false);
                    appointedDate=t.parse(date);
                    System.out.println();
                    break;
                }else{
                    throw new Exception();
                }
            }catch(Exception e){
                System.out.println("Please enter a valid Date format dd/MM/yyyy");
            }
        }while(true);
        SimpleDateFormat t=new SimpleDateFormat("dd/MM/yyyy");
        clients.get(temporary).getClientsCar().setAppointedDate(appointedDate);
        cf.writeToFile(clients,false);

        System.out.println("The new appointade date of maintanence for the car "+clients.get(temporary).getClientsCar().getLicencePlate()+" has been assigned to "+t.format(appointedDate)+"\n");
        System.out.println("Type any character to go back to the main menu");
        in.nextLine();
        System.out.println();
        showMenu();
    }
    //This method is used to email all the clients whose car has undergone service
    public void emailClients(){
        ArrayList<Client> clients=cf.readFile();
        if(clients.isEmpty()==true){
            System.out.println("\nThere are no clients in the file\n");
            System.out.println("Type any character to go back to the main menu");
            in.nextLine();
            System.out.println();
            showMenu();
        }
        ArrayList<Client> clientsWithServicedCar=new ArrayList<Client>();
        for(int i=0;i<clients.size();i++){
            if(clients.get(i).getClientsCar().getServiced()==true){
                clientsWithServicedCar.add(clients.get(i));
            }
        }
        boolean m=true;
        for(int i=0;i<clientsWithServicedCar.size();i++){
            final String user = "alexjapostolo@gmail.com";
            final String password = "Popolola1";

            Properties p = new Properties();
            p.put("mail.smtp.auth", "true");
            p.put("mail.smtp.starttls.enable", "true");
            p.put("mail.smtp.host", "smtp.gmail.com");
            p.put("mail.smtp.port", "587");

            Session session = Session.getInstance(p,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(user, password);
                        }
                    });

            try {

                Message mail = new MimeMessage(session);
                mail.setFrom(new InternetAddress(user));
                mail.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(clientsWithServicedCar.get(i).getEmail()));
                mail.setSubject("John's Garage");
                mail.setText("Hello "+clientsWithServicedCar.get(i).getFirstName()+" "+clientsWithServicedCar.get(i).getLastName()+", i am informing you that your car with licence plate "+clientsWithServicedCar.get(i).getClientsCar().getLicencePlate()+" has been serviced and is ready for pickup from the garage.\n\nThank you for choosing us");  

                Transport.send(mail);

            } catch (MessagingException e) {
                m=false;
                System.out.println("Could not send an email to "+clientsWithServicedCar.get(i).getFirstName()+" "+clientsWithServicedCar.get(i).getLastName());
            }
        }
        if(m){
            System.out.println("\nYou have successfully send an email to the clients who had their car serviced\n");
        }
        System.out.println("Type any character to go back to the main menu");
        in.nextLine();
        System.out.println();
        showMenu();
    }
    //This method is used to encrypt the emails for all clients
    public void encrypt(){
        ArrayList<Client> clients=cf.readFile();
        if(clients.isEmpty()==true){
            return;
        }
        char[] encrypt=null;
        for(int i=0;i<clients.size();i++){
            encrypt=clients.get(i).getEmail().toCharArray();
            for(int j=0;j<encrypt.length;j++){
                int temp=(int)encrypt[j]+5;
                encrypt[j]=(char)temp;
            }
            clients.get(i).setEmail(String.valueOf(encrypt));
        }
        cf.writeToFile(clients,false);
    }
    //This method is used to decrypt the emails for all clients
    public void decrypt(){
        ArrayList<Client> clients=cf.readFile();
        if(clients.isEmpty()==true){
            return;
        }
        char[] decrypt=null;
        for(int i=0;i<clients.size();i++){
            decrypt=clients.get(i).getEmail().toCharArray();
            for(int j=0;j<decrypt.length;j++){
                int temp=(int)decrypt[j]-5;
                decrypt[j]=(char)temp;
            }
            clients.get(i).setEmail(String.valueOf(decrypt));
        }
        cf.writeToFile(clients,false);       
    }
}

