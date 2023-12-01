package com.example.sayhello.controllers;

import com.example.sayhello.model.learner;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

public class Mail_background {

    public static String otp;
    static learner learner1 = new learner();
    public  void set_lang(learner le)
    {
        learner1 = le;
    }

    static String un = new String();
    static String fullName = new String();
    public static int sendOTP(String userEmail) {
        final String username = "shoyebhaque017@gmail.com";
        final String password = "daivnfvhathmtdrj";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("shoyebhaque017@gmail.com"));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));

            // Generate a random 6-digit OTP
            otp = generateOTP();

            // Set the email content with the OTP
            message.setSubject(otp);
            message.setText("Your SayHello login OTP is: " + otp + "\n\n" +
                    "Please do not share this OTP with anyone.\n\n" +
                    "Regards,\n" +
                    "SayHello Team");

            Transport.send(message);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(otp);
    }

    public static void sendEmail(String subject, String message) {
        final String username = "shoyebhaque017@gmail.com";
        final String password = "daivnfvhathmtdrj";
        final String userEmail = "sifatbinasad@gmail.com";

        fullName = learner1.getFirst_name() + " " + learner1.getLast_name();
        un = learner1.getEmail();
        System.out.println(un + " " + fullName);


        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(username));
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(userEmail));
            msg.setSubject("Feedback: " + subject);
            msg.setText("Feedback from user: " + un + "\nName: " + fullName + "\n\nMessage: \n" + message+
                    //time and date
                    "\n\nDate: "+java.time.LocalDate.now()+"\n\n" +
                    "Regards,\n" +
                    "SayHello Team");
            Transport.send(msg);


        } catch (AddressException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    private static String generateOTP() {
        // Generate a random 6-digit OTP
        Random random = new Random();
        int otp = 100000 + random.nextInt(900000);
        return Integer.toString(otp);
    }

    public static void main(String[] args) {
        String userEmail = "shoyebhaque017@gmail.com";
        //sendOTP(userEmail);
    }
}
