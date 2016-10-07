package controller;

import models.Client;
import services.ClientService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

@ManagedBean(name = "clientController", eager = true)
@RequestScoped
public class ClientController implements Serializable{
    private static final long serialVersionUID = 1L;

    private ClientService clientService;

    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private Date birthday;
    private int accNumber;
    private double balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setClientService(ClientService clientService) {
        this.clientService = clientService;
    }

    public ArrayList<Client> getAllClients(){
        ArrayList<Client> clients = (ArrayList) clientService.getAllClients();
        id = clients.size() + 1;
        return clients;

    }
    public String deleteClient() {
        clientService.deleteClient(id);
        return null;
    }
    public String addClient() {
        Client client = new Client(id, surname, name, patronymic, birthday, accNumber, balance);
        id = id+1;
        surname = null;
        name = null;
        patronymic = null;
        birthday = null;
        accNumber = 0;
        balance = 0;
        clientService.addClient(client);
        return null;
    }
}
