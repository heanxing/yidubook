package com.yi.du.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Administrator on 2018/3/19.
 */
@RestController
@RequestMapping("api/wallet")
public class WalletController  {
//    private WalletService  walletService;
//    /**
//     * 针对业务系统高并发-----修改用户钱包数据余额，采用乐观锁
//     *
//     * @return
//     */
//    @RequestMapping(value = "/walleroptimisticlock.action", method = RequestMethod.POST)
//    @ResponseBody
//    public  String walleroptimisticlock(HttpServletRequest request){
////        String result="";
////        try {
//            //获取 openID openType amount参数
//            String openId = request.getParameter("openId") == null ? null : request.getParameter("openID").trim();//用户唯一编号
//            String openType = request.getParameter("openType") == null ? null : request.getParameter("openType").trim();  //1:代表增加，2代表减少
//            String amount = request.getParameter("amount") == null ? null : request.getParameter("amount").trim();//金额
//            //判断几个参数为空返回的结果
//            if (org.apache.commons.lang.StringUtils.isEmpty(openId)) {
//                return "openId is null";
//            }
//            if (org.apache.commons.lang.StringUtils.isEmpty(openType)) {
//                    return "openType is null";
//            }
//            if (org.apache.commons.lang.StringUtils.isEmpty(amount)) {
//                        return "amount is null";
//            }
//
//                        //
//                    Wallet wallet = walletService.selectByOpenId(Long.valueOf(openId));
//                    //用户操作金额
//                    BigDecimal cash = BigDecimal.valueOf(Double.parseDouble(amount));//创建一个具有参数所指定整数值
//                    cash.doubleValue();
//                    cash.floatValue();
//                    if (Integer.parseInt(openType) == 1) {
//                        wallet.setUser_amount(wallet.getUser_amount().add(cash));
//
//                    } else if (Integer.parseInt(openType) == 2) {
//
//                        wallet.setUser_amount(wallet.getUser_amount().subtract(cash));
//                    }
//                    int target = walletService.updateAccountWallet(wallet);//修改用户数据
//                    System.out.println("修改用户金额是否：" + (target == 1 ? "成功" : "失败"));
//
//        }catch (Exception e){
//            result=e.getMessage();
//            return  result;
//        }
//
//        return "success";
//    }

}
