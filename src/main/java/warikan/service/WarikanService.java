package warikan.service;

import warikan.domain.party.*;
import warikan.domain.member.*;
import warikan.domain.payment.*;

import lombok.RequiredArgsConstructor;

/** 開催日 */
@RequiredArgsConstructor
public class WarikanService {

    private final PartyRepository partyRepository;
    private final MemberRepository memberRepository;
    private final PaymentRateRepository paymentRateRepository;

    // 幹事が、システム上に、開催した 飲み会 の 名前, 開催日時などを設定する
    public Party registerParty(Name name, EventDate eventDate) {
        return partyRepository.register(name, eventDate);
    }

    // 幹事が、システム上の、開催した 飲み会 の 参加者 を追加する
    public void joinParty(Party party, Member member) {
        memberRepository.join(party, member);
    }

    // 幹事が、システム上の、開催した 飲み会 の 参加者 を削除する
    public void cancelMember(Party party, Member member) {
        memberRepository.cancel(party, member);
    }

    // 幹事が、システム上の、開催した 飲み会 の 支払区分 (多め,普通,少なめ)ごとに 支払割合 を設定する
    public void addMember(Party party, PaymentType paymentType, PaymentRate paymentRate) {
        paymentRateRepository.register(party, paymentType, paymentRate);
    }

    // 幹事が、システム上の、開催した 飲み会 の 請求金額 を設定する
    // 幹事が、システムを利用して 飲み会 の 参加者ごとの支払金額 を計算する
    public void createInvoiceList(Party party, AmountBilled amountBilled) {
        MemberList memberList = memberRepository.getMemberList(party);
        PaymentRateTable paymentRateTable = paymentRateRepository.getPaymentRateTable(party);

        memberList.createInvoiceList(amountBilled, paymentRateTable);
    }
}