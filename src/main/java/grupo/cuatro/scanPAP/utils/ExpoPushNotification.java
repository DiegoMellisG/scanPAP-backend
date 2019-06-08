package grupo.cuatro.scanPAP.utils;

import com.kinoroy.expo.push.Message;
import com.kinoroy.expo.push.PushTicketResponse;
import grupo.cuatro.scanPAP.dao.PatientDAO;
import grupo.cuatro.scanPAP.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ExpoPushNotification {

    private final PatientDAO patientDAO;

    public ExpoPushNotification(PatientDAO patientDAO) {
        this.patientDAO = patientDAO;
    }

    @Scheduled(cron = "0 0 20 * * *")
    public void sendPushNotifications()
    {
        //OBTENEMOS LAS PACIENTES CUYO FECHA DE VIGENCIA SE ENCUENTRA VENCIDA
        List<Patient> patients = patientDAO.findPatientsByValidityDateBefore(ZonedDateTime.now());
        Iterator patientIterator = patients.iterator();
        /*INSTANCIAMOS UNA LISTA DE MENSAJES, QUE SERÍA EL CONTENIDO DE LA NOTIFICACIÓN QUE SE ENVIARÁ
        A LA PACIENTE*/
        List<Message> messages = new ArrayList<>();

        while(patientIterator.hasNext())
        {
            Patient patient = (Patient) patientIterator.next();
            Message message = new Message.Builder()
                    .to(patient.getAccessToken())
                    .title(patient.getName()+ "! tienes tu PAP vencido")
                    .body("Tienes tu examen PAP vencido, es importante que vayas a tu CESFAM y te lo realices")
                    .build();
            messages.add(message);
        }

        

    }
}
