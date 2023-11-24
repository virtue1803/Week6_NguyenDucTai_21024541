package dev.week6_nguyenductai_21024541.backend.models;

import jakarta.persistence.*;
import lombok.NonNull;

import java.time.LocalDate;

@Entity
@Table(name="user")
public class User {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 50, nullable = false)
    @NonNull
    private String firstName;

    @Column(length = 50, nullable = false)
    @NonNull
    private String middleName;

    @Column(length = 50, nullable = false)
    @NonNull
    private String lastName;

    @Column(length = 15, nullable = false)
    @NonNull
    private String mobile;

    @Column(length = 50, nullable = false)
    @NonNull
    private String email;

    @Column(length = 32, nullable = false)
    @NonNull
    private String passwordHash;

    private LocalDate registerdAt;

    private LocalDate lastLogin;

    @Column(columnDefinition = "TINYINT", nullable = false)
    @NonNull
    private String intro;

    @Column(columnDefinition = "TEXT", nullable = false)
    @NonNull
    private String text;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", mobile='" + mobile + '\'' +
                ", email='" + email + '\'' +
                ", passwordHash='" + passwordHash + '\'' +
                ", registerdAt=" + registerdAt +
                ", lastLogin=" + lastLogin +
                ", intro='" + intro + '\'' +
                ", text='" + text + '\'' +
                '}';
    }

    public User() {
    }

    public User(long id, @NonNull String firstName, @NonNull String middleName, @NonNull String lastName, @NonNull String mobile, @NonNull String email, @NonNull String passwordHash, LocalDate registerdAt, LocalDate lastLogin, @NonNull String intro, @NonNull String text) {
        this.id = id;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registerdAt = registerdAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.text = text;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public LocalDate getRegisterdAt() {
        return registerdAt;
    }

    public void setRegisterdAt(LocalDate registerdAt) {
        this.registerdAt = registerdAt;
    }

    public LocalDate getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(LocalDate lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
