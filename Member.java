// Cooper Bartl
// CS145
// 3/13/2024

// This class manages member information. Each member is required to have 
// the following infromation: first name, last name, street address, zip code,
// email and phone number.


class Member {
    String firstName;
    String lastName;
    String streetAddress;
    String zipCode;
    String email;
    String phoneNumber;

    public Member(String firstName, String lastName, String streetAddress, String zipCode, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.zipCode = zipCode;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}