/*
 *  Note
 *
 *  13.11.2017
 *
 *  created by Vlad
 */

package kpi.fpm.model;

/**
 * This class contains information about persons in notebook.
 */
public class Note {

    private String name;
    private String surname;
    private String secondName;
    private String initials;
    private String login;
    private String commentary;
    private ContactGroup group;
    private String mobilePhone;
    private String email;
    private String skype;
    private Address address;

    public Note(String name, String surname, String secondName, String login,
                String commentary, ContactGroup group, String mobilePhone,
                String skype, String email, String cityOfResidence,
                String street, String numHome, String numFlat) {
        this.name = name;
        this.surname = surname;
        this.secondName = secondName;
        this.initials = (surname + " " + name.charAt(0) + ".");
        this.login = login;
        this.commentary = commentary;
        this.group = group;
        this.mobilePhone = mobilePhone;
        this.email = email;
        this.skype = skype;
        this.address = new Address(cityOfResidence, street, numHome, numFlat);
    }

    public String getLogin() {
        return login;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj != null) && (this.getClass().equals(obj.getClass()))) {
            Note n = (Note) obj;
            return login.equals(n.login);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return login.hashCode() * 31 + address.hashCode() * 31;
    }

    @Override
    public String toString() {
        return "Note{" +
                "\n name='" + name + '\'' +
                "\n surname='" + surname + '\'' +
                "\n secondName='" + secondName + '\'' +
                "\n initials='" + initials + '\'' +
                "\n login='" + login + '\'' +
                "\n commentary='" + commentary + '\'' +
                "\n group=" + group +
                "\n mobilePhone='" + mobilePhone + '\'' +
                "\n email='" + email + '\'' +
                "\n skype='" + skype + '\'' +
                "\n address=" + address +
                '}';
    }

    /**
     * This class contains information about address of
     * person in notebook.
     */
    public class Address {

        private String cityOfResidence;
        private String street;
        private String numHome;
        private String numFlat;

        Address(String cityOfResidence,
                String street, String numHome, String numFlat) {
            this.cityOfResidence = cityOfResidence;
            this.street = street;
            this.numHome = numHome;
            this.numFlat = numFlat;
        }

        @Override
        public int hashCode() {
            return cityOfResidence.hashCode()
                    * 31 + street.hashCode()
                        * 31 + numHome.hashCode()
                            * 31 + numFlat.hashCode() * 31;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if ((obj != null) && (this.getClass().equals(obj.getClass()))) {
                Address a = (Address) obj;
                return a.cityOfResidence.equals(this.cityOfResidence)
                        && a.street.equals(this.street) && a.numHome.equals(this.numHome)
                        && a.numFlat.equals(this.numFlat);
            }
            return false;
        }

        @Override
        public String toString() {
            return cityOfResidence + ", " + street
                    + ", " + numHome + (numFlat.equals("0")  ? "" : ", "  + numFlat);
        }
    }

}
