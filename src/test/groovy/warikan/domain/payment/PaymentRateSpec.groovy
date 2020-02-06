package warikan.domain.payment

import spock.lang.Specification
import spock.lang.Unroll

import io.vavr.collection.Map
import io.vavr.collection.HashMap

@Unroll
class PaymentRateSpec extends Specification {

    def "calcPaymentAmountのテスト #paymentRate"() {
        setup:
        def basePaymentAmount = new BasePaymentAmount(1000)

        expect:
        paymentRate.calcPaymentAmount(basePaymentAmount) == new PaymentAmount(expected)

        where:
        paymentRate          || expected
        new PaymentRate(2.0) || 2000
        new PaymentRate(1.0) || 1000
        new PaymentRate(0.5) ||  500
    }
}
