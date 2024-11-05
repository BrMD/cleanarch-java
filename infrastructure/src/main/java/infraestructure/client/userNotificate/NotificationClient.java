package infraestructure.client.userNotificate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "NotificationClient", url="https://run.mocky.io/v3/f7686d7c-6b83-4a3e-a019-14215abb263b")
public interface NotificationClient {
    @GetMapping
    NotificateResponse notificate();
}
