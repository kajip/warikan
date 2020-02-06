package warikan.domain.payment;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/** 支払基準金額 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class BasePaymentAmount {
    public final Integer value;
}
