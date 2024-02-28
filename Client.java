package entities;

import java.util.ArrayList;
import java.util.List;


public class Client{

   
    private int id;
    private String nomComplet;
    public String getTelephone() {
        return telephone;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    private String telephone;
    private String email;

    List<Adresse>  adresses =new ArrayList<>();

    public void setAdresses(List<Adresse> adresses) {
        this.adresses = adresses;
    }
    public List<Adresse> getAdresses() {
        return adresses;
    }
    public Client() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNomComplet() {
        return nomComplet;
    }
    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }
   
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }




}