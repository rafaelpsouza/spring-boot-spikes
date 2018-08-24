package br.eng.rafaelpsouza.movie;

import br.eng.rafaelpsouza.entity.Movie;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author Rafael Souza
 */

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends PagingAndSortingRepository<Movie, Long> {
    
    List<Movie> findByName(@Param("name") String name);
    
}
