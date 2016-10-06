package controller;

import models.Client;
import services.ClientService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;

@ManagedBean(name = "clientController", eager = true)
@RequestScoped
public class ClientController implements Serializable{

    private ClientService clientService;

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public ArrayList<Client> getAllClients(){
        return (ArrayList) clientService.getAllClients();
    }
}
