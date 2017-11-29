package model;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "USERS")
@Data
public class User extends BaseEntity {

    private String userName;

    private String password;

    private String email;

    private String firstName;

    private String lastName;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Enumerated(value = EnumType.STRING)
    private Role role;

    public enum Role {
        ADMIN, USER, OPERATOR, GUEST
    }

}
