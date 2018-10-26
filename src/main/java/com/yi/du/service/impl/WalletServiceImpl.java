package com.yi.du.service.impl;

import com.yi.du.dao.WalletDao;
import com.yi.du.bean.Wallet;
import com.yi.du.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Administrator on 2018/3/19.
 */
public class WalletServiceImpl implements WalletService {
    @Autowired
    WalletDao walletDao;

    @Override
    public Wallet selectByOpenId(Long id) {
        return walletDao.selectByOpenId(id);
    }
    @Override
    public int updateAccountWallet(Wallet wallet) {
        return walletDao.updateAccountWallet(wallet);
    }
}
