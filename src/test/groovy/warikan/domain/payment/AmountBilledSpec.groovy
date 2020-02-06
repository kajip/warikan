package warikan.domain.payment

import spock.lang.Specification
import spock.lang.Unroll

import io.vavr.collection.HashMap

@Unroll
class AmountBilledSpec extends Specification {

    def "getVirtualMemberCountのテスト #memberCount"() {
        setup:
        def amountBilled = new AmountBilled(12000)
        def virtualMemberCount = new TotalPaymentRate(totalPaymentRate)

        expect:
        amountBilled.calcBasePaymentAmount(virtualMemberCount) == new BasePaymentAmount(expected)

        where:
        totalPaymentRate || expected
        3                || 4000
        3.5              || 3428
        4.5              || 2666
    }
}
