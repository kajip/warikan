package warikan.domain.invoice;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import warikan.domain.member.Member;
import warikan.domain.payment.PaymentAmount;

/** 請求書 */
@RequiredArgsConstructor
@ToString
public class Invoice {

    public final Member member;
    public final PaymentAmount paymentAmount;
}
