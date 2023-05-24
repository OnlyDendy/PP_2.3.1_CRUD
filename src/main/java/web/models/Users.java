package web.models;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Table(name = "users")
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String name;
    @Column(name = "last_name")
    private  String lastname;
    @Column(name = "age")
    private long age;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;
    @Column(name = "roles")
    private String roles;

    public Users() {
    }

    public Users(long id, String name, String lastname, long age, String email, String password, String roles) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.age = age;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

}