package warikan.domain.party;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;

/** 開催日 */
@RequiredArgsConstructor
@EqualsAndHashCode
public class EventDate {

    private final LocalDateTime value;

    public String toString() {
        return value.format(DateTimeFormatter.ISO_DATE_TIME);
    }
}