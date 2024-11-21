package controller;

import java.util.ArrayList;
import model.Client;
import model.Suplier;
import model.Transporter;

public class SuplierController extends PersonController {

    private final ArrayList<Suplier> listSuplier = new ArrayList<>();

    @Override
    public boolean register(Client objClient, Suplier objSuplier, Transporter objTransporter) {
        try {
            if (objSuplier == null) {
                return false;
            } else {
                this.listSuplier.add(objSuplier);

                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String search(String name) {
        String result = "";

        for (int i = 0; i < this.listSuplier.size(); i++) {
            if (this.listSuplier.get(i).getName().equals(name)) {
                result = this.listSuplier.get(i).getTypePerson() + " - "
                        + this.listSuplier.get(i).getName() + " - "
                        + this.listSuplier.get(i).getCity() + " - "
                        + this.listSuplier.get(i).getDate();
                
                break;
            }
        }
        return result;
    }

    @Override
    public boolean update(String name, Client objClient, Suplier objSuplier, Transporter objTransporter) {
        boolean result = true;
        try {
            if (objSuplier == null) {
                result = false;
                return result;
            } else {
                for (Suplier objtSuplier : this.listSuplier) {
                    if (objtSuplier.getName().equals(name)) {
                        objtSuplier.setTypePerson(objSuplier.getTypePerson());
                        objtSuplier.setName(objSuplier.getName());
                        objtSuplier.setName(objSuplier.getCity());
                        objtSuplier.setDate(objSuplier.getDate());

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
                for (Suplier objtSuplier : this.listSuplier) {
                    if (objtSuplier.getName().equals(name)) {
                        this.listSuplier.remove(objtSuplier);
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
        String listSuplier = "";

        for (int i = 0; i < this.listSuplier.size(); i++) {
            listSuplier += this.listSuplier.get(i).getTypePerson() + " - "
                    + this.listSuplier.get(i).getName() + " - "
                    + this.listSuplier.get(i).getCity() + " - "
                    + this.listSuplier.get(i).getDate() + "\n";
        }

        return listSuplier;
    }

}
