package grupo.cuatro.scanPAP.utils;

import com.kinoroy.expo.push.*;
import grupo.cuatro.scanPAP.dao.PatientDAO;
import grupo.cuatro.scanPAP.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
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

    @Scheduled(cron = "0 55 22 * * *")
    public void sendPushNotifications()
    {
        //OBTENEMOS LAS PACIENTES CUYA FECHA DE VIGENCIA SE ENCUENTRA VENCIDA
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
                    .title("¡Tienes tu PAP vencido!")
                    .body(patient.getName()+" es importante que vayas a tu CESFAM y te lo realices")
                    .build();
            messages.add(message);
        }

        try {
            PushTicketResponse response = ExpoPushClient.sendPushNotifications(messages);
            List<ExpoError> errors = response.getErrors();


            if (errors != null) {
                for (ExpoError error : errors) {
                    // Handle the errors
                }
            }
            // If there are errors that affect individual messages but not the entire request,
            // errors will be null and each push ticket will individually contain the status
            // of each message (ok or error)
            List<PushTicket> tickets = response.getTickets();
            if (tickets != null) {
                for (PushTicket ticket : tickets) {
                    // Handle each ticket (namely, check the status, and save the ID!)
                    // NOTE: If a ticket status is error, you can get the specific error
                    // from the details object. You must handle it appropriately.
                    // The error codes are listed in PushError
                    if (ticket.getStatus() == Status.OK) {
                        String id = ticket.getId();
                        // Save this id somewhere for later
                    } else {
                        // Handle the error
                        PushError e = ticket.getDetails().getError();
                        switch (e) {
                            case MESSAGE_TOO_BIG:
                            case INVALID_CREDENTIALS:
                            case DEVICE_NOT_REGISTERED:
                            case MESSAGE_RATE_EXCEEDED:
                        }

                    }
                }
            }
        } catch (IOException e) {
            // Handle a network error here
            System.out.println(e.getMessage());
        }


    }
}
