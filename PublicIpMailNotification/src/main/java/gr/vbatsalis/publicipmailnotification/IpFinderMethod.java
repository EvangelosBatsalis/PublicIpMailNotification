package gr.vbatsalis.publicipmailnotification;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//
@Component
public class IpFinderMethod {
    String urlString = "https://checkip.amazonaws.com/";
    String ipVar = "0.0.0.0";
    @Autowired
    MailService mailService;

    @Scheduled(fixedRate = 60000)
    private void getIp() throws Exception {
        try {
            URL url = new URL(urlString); //Created a URL object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();//open a connection
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//                System.out.println("Before if: "+br.readLine());
                String currentIp = br.readLine();
                System.out.println("Before if: " + currentIp);
                System.out.println("Before if: " + ipVar);

                if (!(ipVar.equals(currentIp))) {
                    ipVar = currentIp;
                    System.out.println("Inside if: " + currentIp);
                    System.out.println("Inside if: " + ipVar);
                    mailService.sentTextEmail(ipVar);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL is malformed: ", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}