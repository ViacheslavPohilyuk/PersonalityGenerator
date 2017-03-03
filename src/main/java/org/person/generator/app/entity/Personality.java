package org.person.generator.app.entity;

/**
 * Created by mac on 28.01.17.
 */
public class Personality implements IPersonality {
            public String lname;
            public String fname;
            public String patronymic;
            public String gender;
            public String date;
            public String postcode;
            public String city;
            public String street;
            public int house;
            public int apartment;
            public String phone;
            public String login;
            public String password;
            public String color;
            public String userpic;

    public Personality() {

    }

    public Personality( String lname,  String fname,  String patronymic,  String gender,  String date,
                        String postcode,  String city,  String street, int house, int apartment,
                        String phone,  String login,  String password,  String color,  String userpic)
    {
        this.lname = lname;
        this.fname = fname;
        this.patronymic = patronymic;
        this.gender = gender;
        this.date = date;
        this.postcode = postcode;
        this.city = city;
        this.street = street;
        this.house = house;
        this.apartment = apartment;
        this.phone = phone;
        this.login = login;
        this.password = password;
        this.color = color;
        this.userpic = userpic;
    }

    @Override
    public String getLname() { return lname; }

    @Override
    public String getFname() {
        return fname;
    }

    @Override
    public String getPatronymic() {
        return patronymic;
    }

    @Override
    public String getGender() {
        return gender;
    }

    @Override
    public String getDate() {
        return date;
    }

    @Override
    public String getPostcode() {
        return postcode;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public int getHouse() {
        return house;
    }

    @Override
    public int getApartment() {
        return apartment;
    }

    @Override
    public String getPhone() {
        return phone;
    }

    @Override
    public String getLogin() {
        return login;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getUserpic() {
        return userpic;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void print() {
        System.out.println("Фамилия - " + lname);
        System.out.println("Имя - " + fname);
        System.out.println("Отчество - " + patronymic);
        System.out.println("Пол - " + gender);
        System.out.println("Дата рождения - " + date);
        System.out.println("Почтовый индекс - " + postcode);
        System.out.println("Город - " + city);
        System.out.println("Улица - " + street);
        System.out.println("Дом - " + house);
        System.out.println("Квартира - " + apartment);
        System.out.println("Телефон - " + phone);
        System.out.println("Логин - " + login);
        System.out.println("Пароль - " + password);
        System.out.println("Любимый цвет - " + color);
        System.out.println("Аватар - " + userpic);
    }
}
