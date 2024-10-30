package application.usecaseimpl;

import application.gateway.UserNotificationGateway;
import core.domain.Transaction;
import usecase.UserNotificationUseCase;

public class UserNotificationUseCaseImpl implements UserNotificationUseCase{
    private UserNotificationGateway userNotificationGateway;
    

    public UserNotificationUseCaseImpl(UserNotificationGateway userNotificationGateway) {
        this.userNotificationGateway = userNotificationGateway;
    }


    @Override
    public Boolean notificate(Transaction transaction, String email){
        return true;
    }
}
