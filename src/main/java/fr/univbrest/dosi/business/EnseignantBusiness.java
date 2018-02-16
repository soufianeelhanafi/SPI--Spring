package fr.univbrest.dosi.business;

import java.util.List;


import fr.univbrest.dosi.bean.Enseignant;

public interface EnseignantBusiness {

	Enseignant creerEnseignant( Enseignant Enseignant);
	Enseignant MajEnseignant ( Enseignant Enseignant) ; 
	void supprimer ( Long id);
	void supprimer ( Enseignant enseignant ) ;
	List <Enseignant> getAllEnseignants() ;
	Enseignant findById (Long id) ; 
	List <Enseignant> findByNom (String nom );
	
	
	
}
