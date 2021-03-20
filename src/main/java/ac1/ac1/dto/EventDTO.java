package ac1.ac1.dto;

import java.time.format.DateTimeFormatter;

import ac1.ac1.entities.Event;

public class EventDTO {
    private Long id;
    private String name;
    private String description;
    private String place;
    private String startdate;
    private String enddate;
    private String starttime;
    private String endtime;
    private String emailcontact;
       
    public EventDTO(){

    }

    public EventDTO(Long id, String name, String description, String place, String startdate, String enddate, String starttime, String endtime, String emailcontact){
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.startdate = startdate;
        this.enddate = enddate;
        this.starttime = starttime;
        this.endtime = endtime;
        this.emailcontact = emailcontact;
    }

    public EventDTO(Event event){
        DateTimeFormatter data = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH-mm-ss");
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();
        this.place = event.getPlace();
        this.startdate = event.getStartdate().format(data);
        this.enddate = event.getEnddate().format(data);
        this.starttime = event.getStarttime().format(hora);
        this.endtime = event.getEndtime().format(hora);
        this.emailcontact = event.getEmailcontact();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getPlace() {
        return place;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public String getStartdate() {
        return startdate;
    }
    public void setStartdate(String startdate) {
        this.startdate = startdate;
    }
    public String getEnddate() {
        return enddate;
    }
    public void setEnddate(String enddate) {
        this.enddate = enddate;
    }
    public String getStarttime() {
        return starttime;
    }
    public void setStarttime(String starttime) {
        this.starttime = starttime;
    }
    public String getEndtime() {
        return endtime;
    }
    public void setEndtime(String endtime) {
        this.endtime = endtime;
    }
    public String getEmailcontact() {
        return emailcontact;
    }
    public void setEmailcontact(String emailcontact) {
        this.emailcontact = emailcontact;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
