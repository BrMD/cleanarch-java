package infraestructure.mapper;

import org.springframework.stereotype.Component;

import core.domain.TaxNumber;
import core.domain.User;
import infraestructure.dto.request.CreateUserRequest;
import infraestructure.entity.UserEntity;

@Component
public class UserMapper {
    public UserEntity toEntity(User user){
        return new UserEntity(user.getId(),
            user.getEmail(),
            user.getPassword(),
            user.getTaxNumber().getValue(),
            user.getFullName(),
            user.getType(),
            user.getCreatedAt(),
            user.getUpdateAt());
    }

    public User toUser(CreateUserRequest request) throws Exception{
        return new User(    
            request.email(),request.password(),new TaxNumber(request.taxNumber()),request.fullname(),request.type()
        );
    }

    public User toUser(UserEntity userEntity) throws Exception{
        return new User(    
            userEntity.getId(),
            userEntity.getEmail(),
            userEntity.getPassword(),
            new TaxNumber(userEntity.getTaxNumber()),
            userEntity.getFullName(),
            userEntity.getType(),
            userEntity.getCreatedAt(),
            userEntity.getUpdateAt()
        );
    }
}
