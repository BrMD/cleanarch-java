package infraestructure.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import infraestructure.client.dto.response.ApiValidateResponse;

@FeignClient(name = "ApiValidateClient", url="${client.url}")
public interface ApiValidationClient {

    @GetMapping
    ApiValidateResponse validate();
}
