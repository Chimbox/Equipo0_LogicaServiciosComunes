/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import equipo0_dominio.FirebaseCloudMessage;
import equipo0_dominio.NotificationData;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Alfonso Felix
 */
class CtrlNotificaciones {

    private final String authorizationKey = "key=AAAAYwqwFm8:APA91bGA3ZzTNP7Cr2STjn9r6u4q6ut3DOGXpm07NZ8y0RvCb_1MuPKxEAJQdR5o7IASGIxb3fSoDXwC3_nm4o_wqgaa06_ilClvGGuhWs78_V1KL8Gxs5X-zac7qo9WFwsxGYeVCyOl";

    public String enviarNotificacionPaciente(String token, int idCita, String nombreSolicitante, Date fecha) {
        Gson yison = new GsonBuilder().create();

        CloseableHttpClient httpclient = HttpClients.createDefault();//https://fcm.googleapis.com/fcm/send
        HttpPost post = new HttpPost("https://fcm.googleapis.com/fcm/send");
        StringEntity json;
        try {
            NotificationData data=new NotificationData(idCita, nombreSolicitante, fecha, false, "Solicitud de "+nombreSolicitante+" para revisar expediente.");
            FirebaseCloudMessage message=new FirebaseCloudMessage(data,token);
           
            //FirebaseCloudMessage message=new FirebaseCloudMessage(data,token);
            String str = yison.toJson(message);
            System.out.println(str);
            json = new StringEntity(str);
            json.setContentType("application/json");

            post.addHeader("Content-Type", "application/json; charset=utf-8");
            post.addHeader("Authorization", authorizationKey);

            post.setEntity(json);
            CloseableHttpResponse response = httpclient.execute(post);

            String s = IOUtils.toString(response.getEntity().getContent(), StandardCharsets.UTF_8.name());

            return s;
        } catch (UnsupportedEncodingException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        return "{}";
    }
}
