package warikan.domain.payment;

import warikan.domain.party.Party;

/** 支払区分リスト */
public interface PaymentRateRepository {

    /** 登録する */
    public void register(Party party, PaymentType paymentType, PaymentRate paymentRate);

    /** 支払割合表を取得する */
    public PaymentRateTable getPaymentRateTable(Party party);
}
