package ac1.ac1.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import ac1.ac1.dto.EventInsertDTO;

@Entity
@Table(name="TB_EVENT")
public class Event implements Serializable{
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String place;
    private LocalDate startdate;
    private LocalDate enddate;
    private LocalTime starttime;
    private LocalTime endtime;
    private String emailcontact;
    
    public Event(){

    }

    public Event(EventInsertDTO dto){
        DateTimeFormatter data = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter hora = DateTimeFormatter.ofPattern("HH-mm-ss");
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.place = dto.getPlace();
        this.startdate = LocalDate.parse(dto.getStartdate(), data);
        this.enddate = LocalDate.parse(dto.getEnddate(), data);
        this.starttime = LocalTime.parse(dto.getStarttime(), hora);
        this.endtime = LocalTime.parse(dto.getEndtime(), hora);
        this.emailcontact = dto.getEmailcontact();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Event other = (Event) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getStartdate() {
        return startdate;
    }

    public void setStartdate(LocalDate startdate) {
        this.startdate = startdate;
    }

    public LocalDate getEnddate() {
        return enddate;
    }

    public void setEnddate(LocalDate enddate) {
        this.enddate = enddate;
    }

    public LocalTime getStarttime() {
        return starttime;
    }

    public void setStarttime(LocalTime starttime) {
        this.starttime = starttime;
    }

    public LocalTime getEndtime() {
        return endtime;
    }

    public void setEndtime(LocalTime endtime) {
        this.endtime = endtime;
    }

    public String getEmailcontact() {
        return emailcontact;
    }

    public void setEmailcontact(String emailcontact) {
        this.emailcontact = emailcontact;
    }
}
