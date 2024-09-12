package com.mama.pride.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.springframework.format.annotation.DateTimeFormat;

import com.mama.pride.enums.Gender;
import com.mama.pride.enums.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "users")
public class UserProfile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;

    @Column(name = "username", unique = true, nullable = false)
    @Size(max = 20, min = 3, message = "Username must not be empty")
    private String username;

    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "password", nullable = false)
    private String password;
    @Column(name = "created_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Column(name = "updated_at", insertable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;

    private String state;
    private String city;
    private String country;

    @Column(name = "phone_number", insertable = true, nullable = false, unique = true)
    private String phoneNumber;

    @Column(name = "date_of_birth", insertable = true, nullable = false, updatable = false)
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    @Temporal(TemporalType.DATE)
    private java.util.Date dateOfBirth;
    private String address;
    @Column(name = "zip_code")
    private String zipCode;
    // @Lob
    @Column(name = "profile_picture")
    // private byte[] profilePicture;
    private String profilePicture;
    private Gender gender;
    private Role role;

    @Column(name = "wallet_balance")
    private double walletBalance;

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Order> orders;

    @OneToMany(mappedBy = "userId", fetch = FetchType.EAGER)
    @Fetch(value = FetchMode.SUBSELECT)
    private List<Review> reviews;

    public UserProfile(String username, String firstName, String lastName, String email, String password,
            Date createdAt, Date updatedAt, String state, String city, String country, String phoneNumber,
            Date dateOfBirth, String address, String zipCode, String profilePicture, Gender gender, Role role,
            double walletBalance) {
        this.address = address;
        this.city = city;
        this.country = country;
        this.createdAt = createdAt;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.firstName = firstName;
        this.gender = gender;
        this.lastName = lastName;
        this.orders = new ArrayList<Order>();
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.profilePicture = profilePicture;
        this.reviews = new ArrayList<Review>();
        this.role = role;
        this.state = state;
        this.updatedAt = updatedAt;
        this.username = username;
        this.walletBalance = walletBalance;
        this.zipCode = zipCode;

    }

    public UserProfile() {
        this.orders = new ArrayList<Order>();
        this.reviews = new ArrayList<Review>();
    }

    @Override
    public String toString() {
        return "UserProfile [userId= " + userId + ", username= " + username + ", first_name= " + firstName
                + ", address = "
                + address + ", city = " + city + ", country = " + country + ", created_at = " + createdAt
                + ", date_of_birth = "
                + dateOfBirth + ", email = " + email + ", first_name = " + firstName + ", gender = " + gender
                + ", last_name = "
                + lastName + ", orders = " + orders + ", password = " + password + ", phone_number = " + phoneNumber
                + ", profile_picture = " + profilePicture + ", reviews = " + reviews + ", role = " + role + ", state = "
                + state
                + ", updated_at = " + updatedAt + ", username = " + username + ",wallet_balance = " + walletBalance
                + ", zip_code = " + zipCode + "]";
    }

    /**
     * @return the reviews
     */
    public List<Review> getReviews() {
        return reviews;
    }

    /**
     * @param reviews the reviews to set
     */
    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    /**
     * @return the orders
     */
    public List<Order> getOrders() {
        return orders;
    }

    /**
     * @param orders the orders to set
     */
    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    /**
     * @return the walletBalance
     */
    public double getWalletBalance() {
        return walletBalance;
    }

    /**
     * @param walletBalance the walletBalance to set
     */
    public void setWalletBalance(double walletBalance) {
        this.walletBalance = walletBalance;
    }

    /**
     * @return the role
     */
    public Role getRole() {
        return role;
    }

    /**
     * @param role the role to set
     */
    public void setRole(Role role) {
        this.role = role;
    }

    /**
     * @return the gender
     */
    public Gender getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(Gender gender) {
        this.gender = gender;
    }

    /**
     * @return the profilePicture
     */
    public String getProfilePicture() {
        return profilePicture;
    }

    /**
     * @param profilePicture the profilePicture to set
     */
    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    /**
     * @return the zipCode
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * @param zipCode the zipCode to set
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the dateOfBirth
     */
    public java.util.Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(java.util.Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * @return the state
     */
    public String getState() {
        return state;
    }

    /**
     * @param state the state to set
     */
    public void setState(String state) {
        this.state = state;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the country
     */
    public String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * @return the updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * @param updatedAt the updatedAt to set
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    /**
     * @return the createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * @param createdAt the createdAt to set
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * @param lastName the lastName to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * @param firstName the firstName to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @paramuserId the userId to set
     */
    public void setId(int userId) {
        this.userId = userId;
    }

}
