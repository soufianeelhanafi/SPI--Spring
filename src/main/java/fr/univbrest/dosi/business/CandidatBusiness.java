package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Formation;

public interface CandidatBusiness 
{

	Candidat creerCandidat( Candidat candidatACreer);
	void supprimer ( String id);
	void supprimer ( Candidat candidat ) ;
	List <Candidat> findByNom (String nom );
	List <Candidat> findByuniversiteOrigine (String nom  ) ;
	List <Candidat> getAllCandidat() ;
	Candidat findById (String id) ; 
	
}
