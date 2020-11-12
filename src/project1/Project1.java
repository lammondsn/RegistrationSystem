package project1;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Project1 {

    public static void main(String[] args) throws IOException {
       
        String line;
        ArrayList<String> values; 
        ArrayList<Course> trialschedule = new ArrayList<>();
        ArrayList<ArrayList<String>> data = new ArrayList<>();
        
        ArrayList<Course> catalog = new ArrayList<>();
      
        try {
          
            Scanner in = new Scanner(Paths.get("project1input.txt"),"UTF-8"); 

           
            while(in.hasNextLine()){

               
                line = in.nextLine();
                
                values = new ArrayList<>(Arrays.asList(line.split("\t")));

                data.add(values);
            }
            
            
            for (int i = 0; i < data.size(); ++i){
                
      
                String courseName = data.get(i).get(0);
                int crn = Integer.parseInt(data.get(i).get(1));
                String courseNumber = data.get(i).get(2);
                int sectionNumber = Integer.parseInt(data.get(i).get(3));
                int credithours = Integer.parseInt(data.get(i).get(4));   
                
                if ( (data.get(i)).size() == 11) { 
                    
                    String startingTime = data.get(i).get(5);                   
                    String[] st = startingTime.split(":");
                    LocalTime startTime = LocalTime.of(Integer.parseInt(st[0]), Integer.parseInt(st[1]));
                    
                    String stoppingTime = data.get(i).get(6);
                    String[] sp = stoppingTime.split(":");
                    LocalTime stopTime = LocalTime.of(Integer.parseInt(sp[0]), Integer.parseInt(sp[1]));
                    
                    String scheduledMeeting = data.get(i).get(7);
                    String scheduledLocation = data.get(i).get(8);
                    
                    String courseType = data.get(i).get(9);
                    String instName = data.get(i).get(10);
                    
                    
                    TraditionalCourse c = new TraditionalCourse(courseName, crn, courseNumber, sectionNumber, credithours, courseType, 
                            instName, startTime, stopTime, scheduledMeeting, scheduledLocation );
                    
                    catalog.add(c);
                    
                }
                
                else if( (data.get(i)).size() == 7) {
                    
                    String courseType = data.get(i).get(5);
                    String instName = data.get(i).get(6);
                
                    Online c = new Online(courseName, crn, courseNumber, sectionNumber, credithours, courseType,instName);
                    catalog.add(c);
                   
                    
                }
            }
                
        }
        
        
        catch(IOException e) {
            System.out.println(e);
        }
        boolean quit = false;
        
        while (!quit) { 
                
            System.out.println("1) Search Courses"); 
            System.out.println("2) Register for Course");
            System.out.println("3) View Trial Schedule");
            System.out.println("4) Quit");

            Scanner scanner = new Scanner(System.in);
            System.out.print("Your choice? ");
            int userinput = scanner.nextInt();

            switch (userinput){
                case 1: 
                    Scanner fscanner = new Scanner(System.in);
                    System.out.println("Enter the course number in the format SSNN for example, CS201: ");
                    String finput = scanner.next();
                    String s = (finput.substring(0, 2)).toUpperCase() + " " + finput.substring(2,finput.length());

                    for(int i = 0; i < catalog.size(); ++i) {
                        if( (catalog.get(i)).getCourseNumber().equals(s)) 
                            System.out.println(catalog.get(i));
                    }
                                                
                    System.out.println();
                    break;
               
                case 2:
                    
                    Scanner sscanner = new Scanner(System.in);
                    System.out.println("Enter CRN number: ");
                    int sinput = scanner.nextInt();


                    for (int i = 0; i < catalog.size(); ++i) {

                        if ( (catalog.get(i)).getCrn() == (sinput)) {
                                                       
                            if(trialschedule.size() > 0) {
                            
                                for (Course c: trialschedule) {

                                    if ( (catalog.get(i)).ConflictsWith(c)) {
                                        System.out.println("Error, this course time conflicts with another!");
                                        break;
                                    }
                                    else  {

                                        trialschedule.add(catalog.get(i));
                                        System.out.println("Course added successfully!");
                                        break;                                        
                                    }
                                }
                            }
                            
                            else  {

                                trialschedule.add(catalog.get(i));
                                System.out.println("Course added successfully!");
                                break;
                            }
                            
                        }

                    }
                    System.out.println();
                    break;

                case 3: 
                    for (Course c: trialschedule)
                        System.out.println(c);
                    System.out.println();
                    break;
        
                case 4:
                    System.out.println("Thank you for using the Student Registration System!");
                    quit = true;
                    System.out.println();
                    break;
                    
        
            }
        }
    }
}    
    

       
       
    
        
        
        
    
    

       
