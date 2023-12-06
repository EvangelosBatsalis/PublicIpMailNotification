package gr.vbatsalis.PublicIpMailNotification;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class IpFinderMethod {
    String urlString = "https://checkip.amazonaws.com/";
    String ipVar="0.0.0.0";
    MailService mailService;
    @Scheduled(fixedRate = 50000)
    private void getIp() throws Exception{
        try {
            URL url = new URL(urlString); //Created a URL object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();//open a connection
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                //System.out.println(br.readLine());
                if(!(ipVar.equals(br.readLine()))){
                    ipVar=br.readLine();
                    mailService.sentTextEmail(ipVar);

                }


            } catch (IOException e) { throw new RuntimeException(e);}
        }catch (MalformedURLException e){ throw new RuntimeException("URL is malformed: ",e);
        }catch (IOException e) { throw new RuntimeException(e); }
    }

//
//    @Override
//    public void run(ApplicationArguments args) throws Exception {
//        getIp();
//    }
//
//    @Override
//    public void run(String... args) throws Exception {
//        getIp();
//    }
}

