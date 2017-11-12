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
                String skype, String email, int index, String cityOfResidence,
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
        this.address = new Address(index, cityOfResidence, street,
                                numHome, numFlat);
    }

    @Override
    public String toString() {
        return "Note{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", secondName='" + secondName + '\'' +
                ", initials='" + initials + '\'' +
                ", login='" + login + '\'' +
                ", commentary='" + commentary + '\'' +
                ", group=" + group +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", email='" + email + '\'' +
                ", skype='" + skype + '\'' +
                ", address=" + address +
                '}';
    }

    /**
     * This class contains information about address of
     * person in notebook.
     */
    public class Address {

        private int index;
        private String cityOfResidence;
        private String street;
        private String numHome;
        private String numFlat;

        Address(int index, String cityOfResidence,
                String street, String numHome, String numFlat) {
            this.index = index;
            this.cityOfResidence = cityOfResidence;
            this.street = street;
            this.numHome = numHome;
            this.numFlat = numFlat;
        }

        @Override
        public String toString() {
            return index + ", " + cityOfResidence + ", " + street
                    + ", " + numHome + (numFlat.equals("0")  ? "" : ", "  + numFlat);
        }
    }

}
