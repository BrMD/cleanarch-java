package infraestructure.client.apiValidate;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import infraestructure.client.apiValidate.response.ApiValidateResponse;




@FeignClient(name = "ApiValidateClient", url="${client.url}")
public interface ApiValidationClient {

    @GetMapping
    ApiValidateResponse validate();
}
