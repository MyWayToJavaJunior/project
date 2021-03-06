package com.freimanvs.company.entities;


import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="login")
    private String login;

    @Column(name="password")
    private String password;

    @Column(name="fio")
    private String fio;

    @Column(name="department")
    private String department;

    @Column(name="city")
    private String city;

    @Column(name="salary")
    private double salary;

    @Column(name="phoneNumber")
    private String phoneNumber;

    @Column(name="email")
    private String email;

    @ManyToMany()
    @JoinTable(name = "employee_position", joinColumns = {
            @JoinColumn(name = "employeeId")},
            inverseJoinColumns = {@JoinColumn(name = "positionId")})
    private Set<Position> positions = new HashSet<>();

    @ManyToMany()
    @JoinTable(name = "employee_role", joinColumns = {
            @JoinColumn(name = "employeeId")},
            inverseJoinColumns = {@JoinColumn(name = "roleId")})
    private Set<Role> roles = new HashSet<>();

    public Employee() {
    }

    public Employee(String login, String password, String fio, String department, String city,
                    double salary, String phoneNumber, String email) {
        this.login = login;
        this.password = password;
        this.fio = fio;
        this.department = department;
        this.city = city;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public long getId() {
        return id;
    }

    @XmlAttribute(required = true)
    public void setId(long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }


    @XmlElement(required = true)
    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getFio() {
        return fio;
    }

    @XmlElement(required = true)
    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    @XmlElement()
    public void setPassword(String password) {
        this.password = password;
    }


    public String getDepartment() {
        return department;
    }

    @XmlElement(required = true)
    public void setDepartment(String department) {
        this.department = department;
    }

    public String getCity() {
        return city;
    }

    @XmlElement(required = true)
    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    @XmlElement()
    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @XmlElement(required = true)
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @XmlElement(required = true)
    public void setEmail(String email) {
        this.email = email;
    }

    public Set<Position> getPositions() {
        return positions;
    }

    @XmlElement
    public void setPositions(Set<Position> positions) {
        this.positions = positions;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    @XmlElement
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append( "Employee{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", fio='" + fio + '\'' +
                ", department='" + department + '\'' +
                ", city='" + city + '\'' +
                ", salary=" + salary +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'');

        sb.append(", roles=[");
        if (roles != null && !roles.isEmpty()) {
            for (Role role :
                    roles) {
                sb.append(role.getName() + ", ");
            }
            if (!roles.isEmpty()) {
                sb = sb.delete(sb.length() - 2, sb.length());
            }
        }
        sb.append("]");

        sb.append(", positions=[");
        if (positions != null && !positions.isEmpty()) {
            for (Position pos :
                    positions) {
                sb.append(pos.getName() + ", ");
            }
            sb = sb.delete(sb.length() - 2, sb.length());
        }
        sb.append("]}");

        return sb.toString();
    }
}
