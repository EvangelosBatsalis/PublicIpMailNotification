package gr.vbatsalis.PublicIpMailNotification;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramSocket;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) {
        String urlString = "http://checkip.amazonaws.com/";
        try {
            URL url = new URL(urlString); // Create a URL object
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(); // Open a connection
            try (BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                System.out.println(br.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("URL is malformed", e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    }

