
package model;

abstract public class Person {
    protected String typePerson;

    public String getTypePerson() {
        return typePerson;
    }

    public void setTypePerson(String typePerson) {
        this.typePerson = typePerson;
    }

    public Person(String typePerson) {
        this.typePerson = typePerson;
    }
}
