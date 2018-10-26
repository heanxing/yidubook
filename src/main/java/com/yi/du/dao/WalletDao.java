package com.yi.du.dao;

import com.yi.du.bean.Wallet;
import org.springframework.stereotype.Repository;

/**
 * Created by Administrator on 2018/3/19.
 */
@Repository
public interface WalletDao {
    Wallet selectByOpenId(Long id);

    int updateAccountWallet(Wallet wallet);


}
