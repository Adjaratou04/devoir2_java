package services;

import java.util.List;
import entities.Adresse;
import repositories.AdresseRepository;

public class AdresseService {
   
    AdresseRepository adresseRepository=new AdresseRepository();
    public void ajouterAdresse(Adresse adresse){
        adresseRepository.insert(adresse);
    }

    public List<Adresse> listeradresse(){
        return adresseRepository.selectAll();
    }
}
