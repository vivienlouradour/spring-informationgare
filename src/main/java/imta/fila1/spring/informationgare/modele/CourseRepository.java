package imta.fila1.spring.informationgare.modele;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * Interface Repository des courses
 * 
 * @author Cédric GARCIA
 *
 */
public interface CourseRepository extends CrudRepository<Course, String>{
	
	// List<Course> findByDescription(String description);
}
