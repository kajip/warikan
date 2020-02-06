package warikan.domain.member

import spock.lang.Specification
import spock.lang.Unroll

import io.vavr.collection.List
import io.vavr.collection.HashMap

import warikan.domain.payment.*

@Unroll
class MemberListSpec extends Specification {

    def paymentRateTable = new PaymentRateTable(HashMap.of(
        PaymentType.MANY, new PaymentRate(2.0),
        PaymentType.NORMAL, new PaymentRate(1.0),
        PaymentType.LITTLE, new PaymentRate(0.5)
    ))

    def "getTotalPaymentRateのテスト #members"() {
        setup:
        MemberList memberList = new MemberList(members)

        expect:
        memberList.getTotalPaymentRate(paymentRateTable) == new TotalPaymentRate(expected)

        where:
        members || expected
        List.of(new Member(PaymentType.MANY),new Member(PaymentType.NORMAL),new Member(PaymentType.LITTLE))                                || 3.5
        List.of(new Member(PaymentType.MANY),new Member(PaymentType.MANY),new Member(PaymentType.NORMAL),new Member(PaymentType.LITTLE))   || 5.5
        List.of(new Member(PaymentType.MANY),new Member(PaymentType.NORMAL),new Member(PaymentType.NORMAL),new Member(PaymentType.LITTLE)) || 4.5
    }

    def "createInvoiceListのテスト #members"() {
        setup:
        MemberList memberList = new MemberList(members)
        def basePaymentAmount = new BasePaymentAmount(1000)

        expect:
        def invoiceList = memberList.createInvoiceList(basePaymentAmount, paymentRateTable)
        System.out.println(invoiceList)

        where:
        members || expected
        List.of(new Member(PaymentType.MANY),new Member(PaymentType.NORMAL),new Member(PaymentType.LITTLE))                                || 3.5
        List.of(new Member(PaymentType.MANY),new Member(PaymentType.MANY),new Member(PaymentType.NORMAL),new Member(PaymentType.LITTLE))   || 5.5
        List.of(new Member(PaymentType.MANY),new Member(PaymentType.NORMAL),new Member(PaymentType.NORMAL),new Member(PaymentType.LITTLE)) || 4.5
    }
}
