package com.nanoPay.services;

import com.nanoPay.factory.WalletFactory;
import com.nanoPay.models.User;
import com.nanoPay.models.Wallet;
import com.nanoPay.repository.WalletRepository;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    private WalletRepository walletRepository;
    private WalletFactory walletFactory;
    WalletService(WalletRepository walletRepository, WalletFactory walletFactory) {
        this.walletRepository = walletRepository;
        this.walletFactory = walletFactory;
    }

    public Wallet createWalletForUser(User user) {
        Wallet wallet = walletFactory.craeteWallet(user);
        return walletRepository.save(wallet);
    }
}
