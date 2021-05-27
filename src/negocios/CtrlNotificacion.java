/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package negocios;

import datos.FactoryDatos;
import datos.IDatos;
import equipo0_dominio.Cita;
import equipo0_dominio.SolicitudExpediente;
import org.apache.commons.io.IOUtils;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

/**
 *
 * @author Alfonso Felix
 */
class CtrlNotificacion {
    private final IDatos datos;

    public CtrlNotificacion(IDatos datos) {
        this.datos = datos;
    }
    
    public String enviarNotificacionPaciente(SolicitudExpediente solicitud) {
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("https://fcm.googleapis.com/fcm/send");
        httpPost.setHeader("Content-Type", "application/json");

        Cita cita=datos.obtenerCita(solicitud.getIdCita());
        
        String json = "{ \"data\": {\n"
                + "    \"idCita\":"+solicitud.getIdCita()+",\n"
                + "    \"aprobada\":false,\n"
                + "    \"body\":\""+solicitud.getNombreSolicitante()+" solicita acceso a tu expediente.\" \n"
                + "  },\n"
                + "  \"to\" : \""+cita.getPaciente().getTokenFirebase()+"\",\n"
                + "  \"direct_boot_ok\" : true\n"
                + "}";

        try {
            StringEntity entity = new StringEntity(json, ContentType.APPLICATION_JSON);

            System.out.println(entity);

            httpPost.setEntity(entity);
            httpPost.setHeader("Authorization", "key=AAAAYwqwFm8:APA91bGA3ZzTNP7Cr2STjn9r6u4q6ut3DOGXpm07NZ8y0RvCb_1MuPKxEAJQdR5o7IASGIxb3fSoDXwC3_nm4o_wqgaa06_ilClvGGuhWs78_V1KL8Gxs5X-zac7qo9WFwsxGYeVCyOl");

            CloseableHttpResponse response = client.execute(httpPost);

            System.out.println(IOUtils.toString(response.getEntity().getContent()));
            // assertThat(response.getStatusLine().getStatusCode(), equalTo(200));
            client.close();
        } catch (Exception e) {

        }
        return null;
    }

}
