
package controller;

import java.util.ArrayList;
import model.Client;
import model.Suplier;
import model.Transporter;


public class TransporterController extends PersonController{
     private final ArrayList<Transporter> listTransporter = new ArrayList<>();
    
    @Override
    public boolean register(Client objClient, Suplier objSuplier, Transporter objTransporter) {
        try {
            if (objTransporter == null) {
                return false;
            } else {
                this.listTransporter.add(objTransporter);

                return true;
            }
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String search(String name) {
        String result = "";

        for (int i = 0; i < this.listTransporter.size(); i++) {
            if (this.listTransporter.get(i).getName().equals(name)) {
                result = this.listTransporter.get(i).getTypePerson() + " - "
                        + this.listTransporter.get(i).getName() + " - "
                        + this.listTransporter.get(i).getTypeTransport() + " - "
                        + this.listTransporter.get(i).getAbility();
                break;
            }
        }
        return result;
    }

    @Override
    public boolean update(String name, Client objClient, Suplier objSuplier, Transporter objTransporter) {
        boolean result = true;
        try {
            if (objTransporter == null) {
                result = false;
                return result;
            } else {
                for (Transporter objtTransporter : this.listTransporter) {
                    if (objtTransporter.getName().equals(name)) {
                        objtTransporter.setTypePerson(objTransporter.getTypePerson());
                        objtTransporter.setName(objTransporter.getName());
                        objtTransporter.setName(objTransporter.getAbility());

                        break;
                    }
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }


    public boolean remove(String name) {
        boolean result = true;
        try {
            if (name == null) {
                result = false;
                return result;
            } else {
                for (Transporter objtTransporter : this.listTransporter) {
                    if (objtTransporter.getName().equals(name)) {
                        this.listTransporter.remove(objtTransporter);
                        break;
                    }
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public String list() {
        String listTransporter = "";

        for (int i = 0; i < this.listTransporter.size(); i++) {
            listTransporter += this.listTransporter.get(i).getTypePerson() + " - "
                    + this.listTransporter.get(i).getName() + "\n";
        }

        return listTransporter;
    }
    
}
