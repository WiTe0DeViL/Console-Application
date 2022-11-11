package model;

import java.util.HashMap;
import java.util.Stack;

public class User {
    private String name;
    private String userName;
    private String email;
    private String password;
    private byte age;


    private Stack<String> personalFeed = new Stack<>();
    private String bio;

    private HashMap<User, Boolean> friendList = new HashMap<>();

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }


    public User(String name, byte age, String userName, String email, String password) {
        setAge(age);
        setEmail(email);
        setName(name);
        setUserName(userName);
        setPassword(password);
    }

    public User() {
    }

    public Stack<String> getPersonalFeed() {
        return personalFeed;
    }

    public void setPersonalFeed(String personalFeed) {
        this.personalFeed.push(personalFeed);
    }


    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    private void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    private void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    private void setPassword(String password) {
        this.password = password;
    }

    public byte getAge() {
        return age;
    }

    private void setAge(byte age) {
        this.age = age;
    }

    public HashMap<User, Boolean> getFriendList() {
        return friendList;
    }

    public void setFriendList(User friendRequest) {
        if (!friendList.containsKey(friendRequest)) friendList.put(friendRequest, false);
    }
}
