package com.jackrain.pay.api;

import com.jackrain.pay.pi.model.jumppay.JumpPayEntity;
import com.jackrain.pay.pi.model.jumppay.JumpPayResponseEntity;
import com.jackrain.pay.pi.model.jumppay.JumpRefundEntity;
import com.jackrain.pay.pi.model.jumppay.JumpRefundResponseEntity;

/**
 * @Author:lin.jh
 * @Date:2021/5/10 15:26
 */
public interface PiJumpPayApi {

    JumpPayResponseEntity jumpPay(JumpPayEntity jumpPayEntity);

    JumpRefundResponseEntity jumpRefund(JumpRefundEntity jumpRefundEntity);

}
