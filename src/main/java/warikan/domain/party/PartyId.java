package warikan.domain.party;

import lombok.EqualsAndHashCode;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/** 飲み会 */
@RequiredArgsConstructor
@EqualsAndHashCode
@ToString
public class PartyId {
    private final String value;
}