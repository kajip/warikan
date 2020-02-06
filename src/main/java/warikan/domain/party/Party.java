package warikan.domain.party;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

/** 飲み会 */
@RequiredArgsConstructor
@EqualsAndHashCode(of = { "partyId" })
@Getter
@ToString
public class Party {
    private final PartyId partyId;
    private final Name name;
    private final EventDate eventDate;
}