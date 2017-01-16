package com.shmouradko.totalizator.entity;

/**
 * Created by Revotech on 05.01.2017.
 */
public class Person extends Component{
    private String name;
    private String surname;
    private String login;
    private String password;
    private String country;
    private String secretQuestion;
    private String secretAnswer;
    private String email;
    private int age;
    private int role;
    private double balance;

    public Person(long id, String name, String surname, String login, String password, String country, String secretQuestion, String secretAnswer, String email, int age, int role, double balance){
        super(id);
        this.name = name;
        this.surname = surname;
        this.login = login;
        this.password = password;
        this.country = country;
        this.secretQuestion = secretQuestion;
        this.secretAnswer = secretAnswer;
        this.email = email;
        this.age = age;
        this.role = role;
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }

    public String getSecretQuestion() {
        return secretQuestion;
    }

    public String getSecretAnswer() {
        return secretAnswer;
    }

    public String getEmail() {
        return email;
    }

    public int getRole() {
        return role;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }
}
