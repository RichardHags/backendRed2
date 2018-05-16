package se.backend.groupred2.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Collection;

@Entity
public final class User {


    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName, lastName, userName;
    private boolean active;

    @Column(nullable = false, unique = true)
    private Long userNumber;

    @ManyToOne //(fetch = FetchType.LAZY)
    @JsonBackReference
    private Team team;

    @JsonIgnore
    @OneToMany(mappedBy = "user")
    private Collection<Task> tasks;

    protected User() {
    }

    public User(String firstName, String lastName, String userName, boolean active, Long userNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.active = active;
        this.userNumber = userNumber;
    }


    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isActive() {
        return active;
    }

    public Long getUserNumber() {
        return userNumber;
    }

    public Team getTeam() {
        return team;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setUserNumber(Long userNumber) {
        this.userNumber = userNumber;
    }

    public void deActivate() {
        this.active = false;
    }

    public void setTeam(Team team) {
        this.team = team;
    }


    public void setTasks(Collection<Task> tasks) {
        this.tasks = tasks;
    }

    public Collection<Task> getTasks() {
        return tasks;
    }

    //TODO add task / remove task / toString ?
}
