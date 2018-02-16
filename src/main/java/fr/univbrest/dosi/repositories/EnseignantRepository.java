package fr.univbrest.dosi.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantRepository extends CrudRepository<Enseignant, Long> 
{ 
     List <Enseignant> findBynom (String nom );
     Enseignant   findBynoEnseignant ( Long id);
}
