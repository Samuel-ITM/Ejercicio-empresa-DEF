
package model;


public class Transporter extends Person{
    private byte typeTransport;
    private String ability;
    private String name;

    public byte getTypeTransport() {
        return typeTransport;
    }

    public void setTypeTransport(byte typeTransport) {
        this.typeTransport = typeTransport;
    }

    public String getAbility() {
        return ability;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Transporter(byte typeTransport, String ability, String name, String typePerson) {
        super(typePerson);
        this.typeTransport = typeTransport;
        this.ability = ability;
        this.name = name;
    }

}
