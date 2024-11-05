package infraestructure.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import core.exception.InternalServerErrorException;
import core.exception.NotFoundException;
import core.exception.NotificationException;
import core.exception.PinException;
import core.exception.TransferException;
import infraestructure.dto.request.TransferRequest;
import infraestructure.dto.response.BaseResponse;
import infraestructure.dto.response.ConsultBalanceResponse;
import usecase.ConsultBalanceUseCase;
import usecase.TransferUseCase;

@RestController
@RequestMapping("api/v1/wallet")
public class WalletController {
    private ConsultBalanceUseCase consultBalanceUseCase;
    private TransferUseCase transferUseCase;

    public WalletController(ConsultBalanceUseCase consultBalanceUseCase,TransferUseCase transferUseCase) {
        this.consultBalanceUseCase = consultBalanceUseCase;
        this.transferUseCase = transferUseCase;
    }

    @GetMapping("/consultBalance/{taxNumber}")
    public BaseResponse<ConsultBalanceResponse> consultBanalance(@PathVariable String taxNumber) throws Exception{
        var balance = consultBalanceUseCase.consult(taxNumber);    
        return BaseResponse.<ConsultBalanceResponse>builder().success(true).result(new ConsultBalanceResponse(balance)).build();
        
    }

    @PostMapping("/transfer")
    public BaseResponse<String> transfer(@RequestBody TransferRequest transferRequest) throws InternalServerErrorException, TransferException, NotFoundException, NotificationException, PinException, Exception {
    transferUseCase.transfer(transferRequest.fromTaxNumber(),transferRequest.toTaxNumber(), transferRequest.value(), transferRequest.pin());

        return BaseResponse.<String>builder().success(true).message("Transferencia realizada com sucesso").build();

    }
}
