package org.example.Manager.Personnel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;

public class Manager implements Serializable {
    private String username;
    private String password;
    Date dateRegistered;
    int managerId;
    public static int ManagerId = 1;

    public Manager(String username, String password) throws IOException {
        this.username = username;
        this.password = password;
        this.dateRegistered = new Date();
        managerId = ManagerId;
        ManagerId++;
        System.out.println("Manger added successfully!\n");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String toString() {
        return String.format("\nManager,%s, %s,Registered at:%s\n", this.username, this.password, this.dateRegistered);
    }
}
