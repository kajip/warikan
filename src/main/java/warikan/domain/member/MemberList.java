package warikan.domain.member;

import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;
import warikan.domain.payment.AmountBilled;
import warikan.domain.payment.BasePaymentAmount;
import warikan.domain.payment.PaymentRateTable;
import warikan.domain.payment.TotalPaymentRate;
import warikan.domain.invoice.InvoiceList;

/** 参加者リスト */
@RequiredArgsConstructor
public class MemberList {

    private final List<Member> memberList;

    /** 請求書を生成する */
    public InvoiceList createInvoiceList(AmountBilled amountBilled, PaymentRateTable paymentRateTable) {
        TotalPaymentRate totalPaymentRate = getTotalPaymentRate(paymentRateTable);
        BasePaymentAmount basePaymentAmount = amountBilled.calcBasePaymentAmount(totalPaymentRate);
        return new InvoiceList(memberList.map(m -> m.createInvoice(basePaymentAmount, paymentRateTable)));
    }

    /** 支払割合の合計を返す */
    private TotalPaymentRate getTotalPaymentRate(PaymentRateTable paymentRateTable) {
        return new TotalPaymentRate(memberList.map(m -> m.getPaymentRate(paymentRateTable)).map(m -> m.value) // 値の取出し
                .sum() // 合計
                .doubleValue() // Number -> Doubleに変換
        );
    }

    @Override
    public String toString() {
        return memberList.toString();
    }
}
