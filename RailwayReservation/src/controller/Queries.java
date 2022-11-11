package controller;

public interface Queries {
    String loginFetch = "SELECT * FROM ";
    String fetchAll = "select * from ";
    String register = "insert into user(name,age,email,password) values(?,?,?,?)";
}
