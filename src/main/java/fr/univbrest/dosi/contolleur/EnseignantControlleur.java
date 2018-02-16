package fr.univbrest.dosi.contolleur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.univbrest.dosi.bean.Candidat;
import fr.univbrest.dosi.bean.Enseignant;
import fr.univbrest.dosi.business.EnseignantBuisnessJPA;
import fr.univbrest.dosi.business.EnseignantBusiness;

@RestController
@RequestMapping("/enseignants")

public class EnseignantControlleur {
	
	
    private EnseignantBusiness businness ; 
    
	@Autowired
	public EnseignantControlleur (EnseignantBusiness businness )
	{
		this.businness = businness ; 
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public List<Enseignant> recupererToutEnseignants ()
	{
		return businness.getAllEnseignants() ; 
	}
	
	@RequestMapping(method = RequestMethod.GET , value="/nom/{nom}")
	public List<Enseignant> recupererUnEnseignantByNom (@PathVariable String nom)
	{
		return businness.findByNom(nom) ;
	}
	
	@RequestMapping(method = RequestMethod.GET , value="/ID/{id}")
	public Enseignant recupererUnEnseignantById (@PathVariable String id)
	{
		return businness.findById(Long.parseLong(id, 10) );
	}
	

	@RequestMapping(method = RequestMethod.POST)
	public Enseignant creerEnseignant(@RequestBody Enseignant Enseignant ) {
		return businness.creerEnseignant(Enseignant); 
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	public Enseignant MajEnseignant(@RequestBody Enseignant Enseignant ) {
		return businness.MajEnseignant(Enseignant);
	}
	
	@RequestMapping(method = RequestMethod.DELETE ,  value="/{id}")
	public void  supprimerEnseignant(@PathVariable String id) {
		businness.supprimer(Long.parseLong(id, 10)); 
		 
	}

}
