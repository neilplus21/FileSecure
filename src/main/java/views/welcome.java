package views;

import dao.userdao;
import model.user;
import service.sendotp;
import service.userservice;
import service.generateotp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.Scanner;

public class Welcome {
    public void welcomeScreen() {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Wlcome to the app");
        System.out.println("Press 1 to login");
        System.out.println("Press 2 to signup");
        System.out.println("Press 0 to exit");
        int choice = 0;
        try {
            choice = Integer.parseInt(br.readLine());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        switch (choice) {
            case 1 -> login();
            case 2 -> signUp();
            case 0 -> System.exit(0);
        }
    }

    private void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter email");
        String email = sc.nextLine();
        try {
            if(userdao.isExists(email)) {
                String genOTP = generateotp.getOTP();
                sendotp.sendOTP(email, genOTP);
                System.out.println("Enter the otp");
                String otp = sc.nextLine();
                if(otp.equals(genOTP)) {
                    new UserView(email).home();

                } else {
                    System.out.println("Wrong OTP");
                }
            } else {
                System.out.println("User not found");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
    private void signUp() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter name");
        String name = sc.nextLine();
        System.out.println("Enter email");
        String email = sc.nextLine();
        if(email.)
        String genOTP = generateotp.getOTP();
        sendotp.sendOTP(email, genOTP);
        System.out.println("Enter the otp");
        String otp = sc.nextLine();
        if(otp.equals(genOTP)) {
            user user = new user(name, email);
            int response = userservice.saveuser(user);
            switch (response) {
                case 0 -> System.out.println("User registered");
                case 1 -> System.out.println("User already exists");
            }
        } else {
            System.out.println("Wrong OTP");
        }

    }
}
