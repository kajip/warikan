package warikan.domain.payment;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/** 支払割合 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class PaymentRate {

    public final Double value;

    /** 支払金額を計算する */
    public PaymentAmount calcPaymentAmount(BasePaymentAmount basePaymentAmount) {
        return new PaymentAmount((int) (basePaymentAmount.value * this.value));
    }
}
