package warikan.domain.payment

import spock.lang.Specification
import spock.lang.Unroll

import io.vavr.collection.Map
import io.vavr.collection.HashMap

@Unroll
class PaymentRateTableSpec extends Specification {

    def "#message のテスト"() {
        setup:
        def paymentRateTable = new PaymentRateTable(table)

        expect:
        paymentRateTable.getPaymentRate(PaymentType.MANY).value == 2.0
        paymentRateTable.getPaymentRate(PaymentType.NORMAL).value == 1.0
        paymentRateTable.getPaymentRate(PaymentType.LITTLE).value == 0.5

        where:
        message | table || many | normal | little
        "基本形" | HashMap.of(
            PaymentType.MANY, new PaymentRate(2.0),
            PaymentType.NORMAL, new PaymentRate(1.0),
            PaymentType.LITTLE, new PaymentRate(0.5)
        ) || 2.0 | 1.0 | 0.5

        "未指定でデフォルト値を使う" |HashMap.of(
            PaymentType.NORMAL, new PaymentRate(1.0),
            PaymentType.LITTLE, new PaymentRate(0.5)
        ) || 2.0 | 1.0 | 0.5
    }
}
