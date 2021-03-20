package ac1.ac1.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ac1.ac1.dto.EventDTO;
import ac1.ac1.dto.EventInsertDTO;
import ac1.ac1.dto.EventUpdateDTO;
import ac1.ac1.entities.Event;
import ac1.ac1.repositories.EventRepository;

@Service
public class EventService {
    
    @Autowired
    private EventRepository repository;

    public List<EventDTO> getEvents(){
        List<Event> list = repository.findAll();
        return toDTOList(list);
    }

    public EventDTO getEventById(Long id){
        Optional<Event> op = repository.findById(id);
        Event event = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found"));

        return new EventDTO(event);
    }

    public EventDTO insert(EventInsertDTO dto){
        Event entity = new Event(dto);
        entity = repository.save(entity);
        return new EventDTO(entity);
    }

    public void delete(Long id){
        try{
            repository.deleteById(id);
        }
        catch(EmptyResultDataAccessException e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

    public EventDTO update(Long id, EventUpdateDTO dto){
        try{
            Event entity = repository.getOne(id);
            entity.setDescription(dto.getDescription());
            entity.setPlace(dto.getPlace());
            entity = repository.save(entity);
            return new EventDTO(entity);
        }
        catch(EntityNotFoundException ex){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Event not found");
        }
    }

    public List<EventDTO> toDTOList(List<Event> list){

        List<EventDTO> listDTO = new ArrayList<>();

        for(Event e : list){
            EventDTO dto = new EventDTO(e);
            listDTO.add(dto);
        }
        return listDTO;
    }
}