package controller;

import java.util.ArrayList;
import model.Client;
import model.Suplier;
import model.Transporter;

public class ClientController extends PersonController {

    private final ArrayList<Client> listClient = new ArrayList<>();

    @Override
    public boolean register(Client objClient, Suplier objSuplier, Transporter objTransporter) {
        try {
            if (objClient == null) {
                return false;
            } else {
                this.listClient.add(objClient);

                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String search(String name) {
        String result = "";

        for (int i = 0; i < this.listClient.size(); i++) {
            if (this.listClient.get(i).getFirstName().equals(name)) {
                result = this.listClient.get(i).getTypePerson() + " - "
                        + this.listClient.get(i).getFirstName() + " - "
                        + this.listClient.get(i).getLastName() + " - "
                        + this.listClient.get(i).getAdress() + " - "
                        + this.listClient.get(i).getPhoneNumber();
                break;
            }
        }
        return result;
    }

    @Override
    public boolean update(String name, Client objClient, Suplier objSuplier, Transporter objTransporter) {
        boolean result = true;
        try {
            if (objClient == null) {
                result = false;
                return result;
            } else {
                for (Client objtClient : this.listClient) {
                    if (objtClient.getFirstName().equals(name)) {
                        objtClient.setTypePerson(objClient.getTypePerson());
                        objtClient.setFirstName(objClient.getFirstName());
                        objtClient.setLastName(objClient.getLastName());
                        objtClient.setAdress(objClient.getAdress());
                        objtClient.setPhoneNumber(objClient.getPhoneNumber());

                        break;
                    }
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public boolean remove(String name) {
        boolean result = true;
        try {
            if (name == null) {
                result = false;
                return result;
            } else {
                for (Client objtClient : this.listClient) {
                    if (objtClient.getFirstName().equals(name)) {
                        this.listClient.remove(objtClient);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    @Override
    public String list() {
        String listClient = "";

        for (int i = 0; i < this.listClient.size(); i++) {
            listClient += this.listClient.get(i).getTypePerson() + " - "
                    + this.listClient.get(i).getFirstName() + " - "
                    + this.listClient.get(i).getLastName() + " - "
                    + this.listClient.get(i).getAdress() + " - "
                    + this.listClient.get(i).getPhoneNumber() + "\n";
        }

        return listClient;
    }

}
