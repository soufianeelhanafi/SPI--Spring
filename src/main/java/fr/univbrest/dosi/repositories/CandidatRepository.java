package fr.univbrest.dosi.repositories;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import fr.univbrest.dosi.bean.Candidat;

public interface CandidatRepository extends CrudRepository < Candidat, String >  
{
	
	List<Candidat> findByNom (String nom );
	
	List<Candidat> findByuniversiteOrigine (String nomUniversite );

	
}
