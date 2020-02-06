package warikan.domain.member;

import warikan.domain.payment.PaymentType;
import warikan.domain.payment.PaymentRateTable;
import warikan.domain.payment.PaymentRate;
import warikan.domain.payment.BasePaymentAmount;
import warikan.domain.payment.PaymentAmount;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import warikan.domain.invoice.Invoice;

/** 参加者 */
@RequiredArgsConstructor
@ToString
public class Member {

    final PaymentType paymentType;

    /** 支払割合を返す */
    PaymentRate getPaymentRate(PaymentRateTable paymentRateTable) {
        return paymentRateTable.getPaymentRate(paymentType);
    }

    /** 支払金額を計算する */
    public PaymentAmount calcPaymentAmount(BasePaymentAmount basePaymentAmount, PaymentRateTable paymentRateTable) {
        return paymentRateTable.getPaymentRate(paymentType).calcPaymentAmount(basePaymentAmount);
    }

    /** 自分宛ての請求書を作成する */
    public Invoice createInvoice(BasePaymentAmount basePaymentAmount, PaymentRateTable paymentRateTable) {
        return new Invoice(this, calcPaymentAmount(basePaymentAmount, paymentRateTable));
    }
}