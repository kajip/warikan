package warikan.domain.invoice;

import io.vavr.collection.List;
import lombok.RequiredArgsConstructor;

/** 請求書一覧 */
@RequiredArgsConstructor
public class InvoiceList {

    final List<Invoice> invoiceList;

    @Override
    public String toString() {
        return invoiceList.toString();
    }
}
