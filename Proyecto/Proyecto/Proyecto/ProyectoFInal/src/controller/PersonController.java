
package controller;

import model.Client;
import model.Suplier;
import model.Transporter;

abstract public class PersonController {
    
    abstract boolean register(Client objClient, Suplier objSuplier, Transporter objTransporter);

    abstract String search(String name);

    abstract boolean update(String name, Client objClient, Suplier objSuplier, Transporter objTransporter);

    abstract boolean remove(String name);

    abstract String list();
}
