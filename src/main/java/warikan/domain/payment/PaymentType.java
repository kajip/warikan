package warikan.domain.payment;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/** 支払区分 */
@RequiredArgsConstructor
public enum PaymentType {
    MANY(new PaymentRate(2.0)), NORMAL(new PaymentRate(1.0)), LITTLE(new PaymentRate(0.5));

    @Getter
    private final PaymentRate defaultRate;
}
