package Logica;

import java.util.Properties;
import jakarta.mail.*;
import jakarta.mail.internet.*;

public class Correo {

    private static final String Main_Usuario = "leandro.falcon.99@gmail.com"; 
    private static final String Contra_Main_Usuario = "oqcg kvdd oxes jwjz";
    
    public static void enviarCorreoRecuperacion(String destinoEmail, String token) throws MessagingException {

        try{
                    Properties props = new Properties();
        
        props.put("mail.smtp.host", "smtp.gmail.com"); 
        props.put("mail.smtp.port", "587");

        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        
        props.put("mail.smtp.ssl.trust", "smtp.gmail.com");
        
        props.put("mail.smtp.timeout", "10000"); 
        props.put("mail.smtp.connectiontimeout", "10000");


        Session session = Session.getInstance(props, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(Main_Usuario, Contra_Main_Usuario);
            }
        });

        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(Main_Usuario));
        
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(destinoEmail));
        
        message.setSubject("Código de Recuperación de Contraseña");

        String cuerpo = "Hola,\n\n"
                      + "Tu código de recuperación es: " + token + "\n\n"
                      + "Este código expirará en 30 minutos.\n"
                      + "Si no solicitaste este cambio, ignora este correo.";

        message.setText(cuerpo);

        // 4. Envío del Mensaje
        Transport.send(message);
        } catch(Exception e){
            System.out.println("error: "+e);
        }
    }
}
