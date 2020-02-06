package warikan.domain.payment;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/** 支払金額 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class PaymentAmount {
    public final Integer value;
}
