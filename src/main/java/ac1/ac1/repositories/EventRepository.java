package ac1.ac1.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ac1.ac1.entities.Event;

@Repository
public interface EventRepository extends JpaRepository <Event, Long>{
    
}