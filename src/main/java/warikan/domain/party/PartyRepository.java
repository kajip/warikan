package warikan.domain.party;

/** 飲み会リスト */
public interface PartyRepository {

    /** 登録する */
    public Party register(Name name, EventDate eventDate);

    /** 探す */
    public Party search(PartyId partyId);
}
