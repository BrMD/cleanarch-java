package infraestructure.client.apiValidate;

import org.springframework.stereotype.Service;

import infraestructure.client.apiValidate.response.ApiValidateResponse;



@Service
public class ApiValidateService {
    private ApiValidationClient apiValidationClient;

    public ApiValidateService(ApiValidationClient apiValidationClient) {
        this.apiValidationClient = apiValidationClient;
    }

    public ApiValidateResponse validate(){
        try{
            return apiValidationClient.validate();
        }
        catch(Exception e){
            return null;
        }
        
    }
}
