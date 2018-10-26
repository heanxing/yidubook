package com.yi.du.service;

import com.yi.du.bean.Wallet;

/**
 * Created by Administrator on 2018/3/19.
 */
public interface WalletService {
    Wallet selectByOpenId(Long id);

    int updateAccountWallet(Wallet wallet);

}
