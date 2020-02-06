package warikan.domain.member

import spock.lang.Specification
import spock.lang.Unroll

import io.vavr.collection.HashMap

import warikan.domain.payment.*

@Unroll
class MemberSpec extends Specification {

    def paymentRateTable = new PaymentRateTable(HashMap.of(
        PaymentType.MANY, new PaymentRate(2.0),
        PaymentType.NORMAL, new PaymentRate(1.0),
        PaymentType.LITTLE, new PaymentRate(0.5)
    ))

    def "getPaymentRateのテスト #paymentType"() {
        setup:
        def member = new Member(paymentType)

        expect:
        member.getPaymentRate(paymentRateTable) == new PaymentRate(expected)

        where:
        paymentType        || expected
        PaymentType.MANY   || 2.0
        PaymentType.NORMAL || 1.0
        PaymentType.LITTLE || 0.5
    }

    def "calcPaymentAmountのテスト #paymentType"() {
        setup:
        def member = new Member(paymentType)
        def basePaymentAmount = new BasePaymentAmount(1000)

        expect:
        member.calcPaymentAmount(basePaymentAmount, paymentRateTable) == new PaymentAmount(expected)

        where:
        paymentType        || expected
        PaymentType.MANY   || 2000
        PaymentType.NORMAL || 1000
        PaymentType.LITTLE ||  500
    }


    def "createInvoiceのテスト #paymentType"() {
        setup:
        def member = new Member(paymentType)
        def basePaymentAmount = new BasePaymentAmount(1000)

        expect:
        def invoke = member.createInvoice(basePaymentAmount, paymentRateTable)
        invoke.member == member
        invoke.paymentAmount == new PaymentAmount(expected)

        where:
        paymentType        || expected
        PaymentType.MANY   || 2000
        PaymentType.NORMAL || 1000
        PaymentType.LITTLE ||  500
    }
}
