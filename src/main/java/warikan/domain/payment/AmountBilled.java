package warikan.domain.payment;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/** 請求金額 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class AmountBilled {

    public final Integer value;

    /** 支払基準額を計算する */
    public BasePaymentAmount calcBasePaymentAmount(TotalPaymentRate totalPaymentRate) {
        return new BasePaymentAmount((int) (value / totalPaymentRate.value));
    }
}
