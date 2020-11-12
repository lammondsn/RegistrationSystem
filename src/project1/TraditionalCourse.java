package project1;

import java.time.LocalTime;

public class TraditionalCourse extends Course {
    
    private LocalTime startingTime;
    private LocalTime stoppingTime;
    private String scheduledMeeting;
    private String scheduledLocation;
    
    public TraditionalCourse(String courseName, int crn, String courseNumber, int sectionNumber, int credithours,  
           String courseType, String instName, LocalTime startingTime, LocalTime stoppingTime, String scheduledMeeting, String scheduledLocation){
        super(courseName, crn, courseNumber, sectionNumber,  credithours, courseType,  instName);
    
        this.startingTime = startingTime;
        this.stoppingTime = stoppingTime;
        this.scheduledMeeting = scheduledMeeting;
        this.scheduledLocation = scheduledLocation;
    }
    
    public LocalTime getstartingTime() {
        return startingTime;
        }
    public void setstartingTime(LocalTime startingTime ) {
      this.startingTime = startingTime;
    }
    
      public LocalTime getstoppingTime() {
          return stoppingTime;
      }
      public void setstoppingTime(LocalTime stoppingTime) {
          this.stoppingTime = stoppingTime;
      }
      public String getscheduledMeeting() {
          return scheduledMeeting;
      }
      public void setscheduledMeeting(String scheduledMeeting) {
          this.scheduledMeeting = scheduledMeeting;
      }
      public String getscheduledLocation() {
          return scheduledLocation;
      }
      public void setscheduledLocation(String scheduledLocation) {
          this.scheduledLocation = scheduledLocation;
      }
      
      @Override
    public String toString(){
       //#21721: CS 230-001 (Fundamentals of Computing), Christopher Carroll Ogden, Lecture, 10:00 - 11:00, MWF, Ayers Hall 355
       
       return ("#" + super.getCrn() + ":" + super.getCourseNumber() + "(" + super.getCourseName() + ")" + ", " + super.getInstName() + ", " + super.getCourseType()
               + ", " + getstartingTime() + " - " + getstoppingTime() + ", " + getscheduledMeeting() + ", " + getscheduledLocation());
          
    
    }
    
    @Override
    public boolean ConflictsWith(Course c) {
        
        boolean conflicts = false;
        
        String firstcoursedays = this.getscheduledMeeting();
        LocalTime firststartingtime = this.getstartingTime();
        LocalTime firststoppingtime = this.getstoppingTime();
        
        if(c instanceof TraditionalCourse) {
            
            String secondcoursedays = ((TraditionalCourse)c).getscheduledMeeting();
            LocalTime secondstartingtime = ((TraditionalCourse) c).getstartingTime();
            LocalTime secondstoppingtime = ((TraditionalCourse) c).getstoppingTime();
            
            for (int i = 0; i < firstcoursedays.length(); ++i)  {
                
                for (int j = 0; j < secondcoursedays.length(); ++j)  {
            
                    if (firstcoursedays.charAt(i) == secondcoursedays.charAt(j)) {

                        if (firststartingtime.equals(secondstartingtime))
                            conflicts = true;
                        if (firststoppingtime.equals(secondstoppingtime))
                            conflicts = true;
                        if (secondstartingtime.isAfter(firststartingtime) && secondstartingtime.isBefore(firststoppingtime))
                            conflicts = true;
                        if (secondstoppingtime.isAfter(firststartingtime) && secondstoppingtime.isBefore(firststoppingtime))
                            conflicts = true;


                    }
                
                }
                
            }
               
            
     
        }
        
        
        
        
        
        return conflicts;
        
    }
}

