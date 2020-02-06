package warikan.domain.payment;

import io.vavr.collection.Map;
import lombok.RequiredArgsConstructor;

/** 支払割合表 */
@RequiredArgsConstructor
public class PaymentRateTable {

    public final Map<PaymentType, PaymentRate> table;

    public PaymentRate getPaymentRate(PaymentType paymentType) {
        return table.get(paymentType).getOrElse(paymentType.getDefaultRate());
    }
}
