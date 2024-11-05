package infraestructure.client.userNotificate;

import org.springframework.stereotype.Service;

@Service
public class NotificateClienteService {
    private NotificationClient notificationClient;

    public NotificateClienteService(NotificationClient notificationClient) {
        this.notificationClient = notificationClient;
    }
    
    public Boolean notificate(){
        var response = notificationClient.notificate();
        return response.success();
    }   
}
