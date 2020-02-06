package warikan.domain.member;

import warikan.domain.party.Party;

/** 参加者リスト */
public interface MemberRepository {

    /** 参加する */
    public void join(Party party, Member member);

    /** キャンセルする */
    public void cancel(Party party, Member member);

    /** 飲み会の参加者リストを取得する */
    public MemberList getMemberList(Party party);

}
