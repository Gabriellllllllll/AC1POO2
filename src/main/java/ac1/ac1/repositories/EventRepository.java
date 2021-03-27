package ac1.ac1.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ac1.ac1.entities.Event;

@Repository
public interface EventRepository extends JpaRepository <Event, Long>{
    
    @Query("SELECT c FROM Event c " + "WHERE " + "(LOWER(c.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " + "(LOWER(c.place) LIKE LOWER(CONCAT('%', :place, '%'))) AND " + "(LOWER(c.description) LIKE LOWER(CONCAT('%', :description, '%')))")
    public Page <Event> find(Pageable pageRequest, String name, String place, String description);
}