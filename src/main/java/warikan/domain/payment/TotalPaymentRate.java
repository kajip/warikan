package warikan.domain.payment;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/** 支払割合の合計 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class TotalPaymentRate {

    public final Double value;
}
