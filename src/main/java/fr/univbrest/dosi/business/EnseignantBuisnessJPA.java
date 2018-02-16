package fr.univbrest.dosi.business;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.repositories.EnseignantRepository;

@Service
public class EnseignantBuisnessJPA implements EnseignantBusiness{

	EnseignantRepository repos ; 
	
	@Autowired
	public EnseignantBuisnessJPA (EnseignantRepository repos)
	{
		this.repos =repos ; 
		
	}
	
	
	@Override
	public Enseignant creerEnseignant(Enseignant Enseignant) {
	
		return this.repos.save(Enseignant) ; 
	}

	@Override
	public void supprimer(Long id) {
		
		 this.repos.delete(id);
		
	}

	@Override
	public void supprimer(Enseignant enseignant) {
		
		this.repos.delete(enseignant);
		
	}

	@Override
	public List<Enseignant> getAllEnseignants() {
		
		return (List<Enseignant>) this.repos.findAll() ;
	}

	@Override
	public Enseignant findById(Long id) {
		
		return this.repos.findOne(id);
	}

	@Override
	public List<Enseignant> findByNom(String nom) {
		
		return this.repos.findBynom(nom);
	}


	@Override
	public Enseignant MajEnseignant(Enseignant Enseignant) {
		
		return this.repos.save(Enseignant) ; 
	}

}
