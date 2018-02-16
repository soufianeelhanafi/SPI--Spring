package fr.univbrest.dosi.business;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.repositories.CandidatRepository;
import fr.univbrest.dosi.repositories.FormationRepository;

@Service
public class CandidatBusinessJPA implements CandidatBusiness
{
	private CandidatRepository repos ; 
	

	@Autowired
	public CandidatBusinessJPA(CandidatRepository repos) {
		this.repos = repos;
	}
	
	@Override
	public Candidat creerCandidat(Candidat candidatACreer) {
		
	    this.repos.save(candidatACreer) ; 
		return candidatACreer ;
	}

	@Override
	public void supprimer (String id) {
		
		this.repos.delete(id);
	}

	@Override
	public List<Candidat> findByNom(String nom) {
		
		return this.repos.findByNom(nom) ; 
	}

	@Override
	public List<Candidat> findByuniversiteOrigine(String nomUniversite) {
		
		return this.repos.findByuniversiteOrigine(nomUniversite);
				
	}

	@Override
	public List<Candidat> getAllCandidat() {
		return (List<Candidat>) this.repos.findAll(); 
	}

	@Override
	public Candidat findById(String id) 
	{
	
		return  this.repos.findOne(id) ; 
		
	}

	@Override
	public void supprimer(Candidat candidat) {
		
		this.repos.delete(candidat);
		
	}
	
	
   

}
