import java.util.List;
import java.util.Scanner;
import entities.Client;
import entities.Adresse;
import services.AdresseService;
import services.ClientService;

public class View {
    
    public static void main(String[] args) throws Exception {
       int choix;
        Scanner sc=new Scanner(System.in);
        //Dependances
        ClientService clientServices=new ClientService();
        AdresseService AdresseService=new AdresseService();
       
        do {
            System.out.println("1-Créer un client");
            System.out.println("2-Lister Tous les clients"); 
            System.out.println("3-Ajouter une adresse et lui associe un client"); 
            System.out.println("4-Lister les adresse en affichant le nom du client");
            System.out.println("5-Quitter"); 
             choix=sc.nextInt();
             sc.nextLine();
            switch (choix) {
                case 1:
                     System.out.println("Entrer un nomComplet");
                     String nomComplet=sc.nextLine(); 
                     System.out.println("Entrer un Telephone");
                     String tel=sc.nextLine();  
                     System.out.println("Entrer une Email");
                     String email=sc.nextLine();   
                     Client cl=new Client();
                      cl.setNomComplet(nomComplet);
                      cl.setTelephone(tel);
                      cl.setEmail(email);
                    clientServices.ajouterClient(cl);
                    break;
                
                case 2:
                    List<Client> clients=  clientServices.listerClient();
                     for (Client client: clients) {
                          System.out.println("NomComplet "+ client.getNomComplet());
                          System.out.println("Telephone "+ client.getTelephone());
                          System.out.println("Email "+ client.getEmail());
                          System.out.println("=================================");
                     }
                    break;


                    case 3:
                     System.out.println("Entrer le Telephone");
                     tel=sc.nextLine();
                     Client client=  clientServices.rechercherClientParTel(tel);
                     if (client!=null) {
                          System.out.println("Ce numero de Telephone existe deja");
                     } else {
                        System.out.println("Entrer un nomComplet");
                        String nommComplet=sc.nextLine(); 
                        System.out.println("Entrer un Telephone");
                        String tell=sc.nextLine();  
                        System.out.println("Entrer une Email");
                        String emaill=sc.nextLine();   
                        Client cl1=new Client();
                         cl1.setNomComplet(nommComplet);
                         cl1.setTelephone(tell);
                         cl1.setEmail(emaill);
                       clientServices.ajouterClient(cl1);
                     }
                   break;
                   case 4:

                   List<Adresse> adresses = AdresseService.listeradresse();
                    for (Adresse cpte : adresses) {
                        System.out.println("Entrer le numero du client");
                        client=clientServices.rechercherClientParTel(sc.nextLine());
                        if(client!=null){
                            adresses=client.getAdresses();
                            if (adresses !=null){
                                for(Adresse cpt: adresses){
                                    System.out.println(cpt);
                                }
                            }else{
                                   System.out.println("Ce client n'a pas d'adrese");
                            }
                           }else{
                            System.out.println("Ce client n'existe pas");
                           }
        

                        System.out.println("Ville " + cpte.getVille());
                        System.out.println("quartier" + cpte.getQuartier());
                        System.out.println("NumVilla " + cpte.getNumVilla());
                        System.out.println("Client " + cpte.getClient());
                        System.out.println("=================================");
                    }
                  
                   
                   
                   break;
                   
                default:
                    break;
            }

        } while (choix!=5);
        
    }
}
