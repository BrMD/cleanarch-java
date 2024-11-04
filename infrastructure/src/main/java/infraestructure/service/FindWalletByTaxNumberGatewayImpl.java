package infraestructure.service;

import org.springframework.stereotype.Service;

import application.gateway.FindWalletByTaxNumberGateway;
import core.domain.Wallet;
import infraestructure.mapper.WalletMapper;
import infraestructure.repository.WalletEntityRepository;

@Service
public class FindWalletByTaxNumberGatewayImpl implements FindWalletByTaxNumberGateway{
    private WalletEntityRepository walletEntityRepository;
    private WalletMapper walletMapper;

    public FindWalletByTaxNumberGatewayImpl(WalletEntityRepository walletEntityRepository,WalletMapper walletMapper) {
        this.walletEntityRepository = walletEntityRepository;
        this.walletMapper = walletMapper;
    }

    @Override
    public Wallet findByTaxNumber(String taxNumber) throws Exception{
        return walletMapper.toWallet(walletEntityRepository.findByUserIdTaxNumber(taxNumber));
    }

    

}
