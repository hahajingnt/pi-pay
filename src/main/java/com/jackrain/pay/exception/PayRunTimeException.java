/**
 *
 */
package com.jackrain.pay.exception;


/**
 * @author zc
 */
public class PayRunTimeException extends RuntimeException {
    public PayRunTimeException() {
    }
    public PayRunTimeException(Throwable ex) {
        super(ex);
    }

    public PayRunTimeException(String message) {
        super(message);
    }

    public PayRunTimeException(String message, Throwable ex) {
        super(message, ex);
    }

}
