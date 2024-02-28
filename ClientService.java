package services;

import java.util.List;
import entities.Client;
import  repositories.ClientRepository;
public class ClientService {
     private ClientRepository clientRepository=new ClientRepository();
    
  public List<Client> listerClient(){
      return clientRepository.selectAll();
   }
   public Client listerClient(String telephone){
    return clientRepository.selectByTelephone(telephone);
   }
   public void ajouterClient(Client client){
    clientRepository.insert(client);
   }
   public  Client rechercherClientParTel(String tel){
    return clientRepository.selectByTelephone(tel);
}
}

