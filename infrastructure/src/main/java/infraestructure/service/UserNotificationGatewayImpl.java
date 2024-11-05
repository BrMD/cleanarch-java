package infraestructure.service;

import org.springframework.stereotype.Service;

import application.gateway.UserNotificationGateway;
import core.domain.Transaction;
import infraestructure.client.userNotificate.NotificateClienteService;

@Service
public class UserNotificationGatewayImpl implements UserNotificationGateway{
    private NotificateClienteService notificateClienteService;
    
    public UserNotificationGatewayImpl(NotificateClienteService notificateClienteService) {
        this.notificateClienteService = notificateClienteService;
    }

    @Override
    public Boolean notificate(Transaction transaction, String email){
        return notificateClienteService.notificate(); 
    }
}
