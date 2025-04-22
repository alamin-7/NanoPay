package com.nanoPay.factory;

import com.nanoPay.models.User;
import com.nanoPay.models.Wallet;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class WalletFactory {

    private Wallet wallet;

    public WalletFactory() {
        this.wallet = new Wallet();
    }

    public Wallet craeteWallet(User user) {
        wallet.setUser(user);
        wallet.setBalance(BigDecimal.valueOf(0.0));
        wallet.setCurrency("BDT");
        return wallet;
    }

}
