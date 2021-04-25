package hello.core.member;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> memberHashMap = new ConcurrentHashMap<Long, Member>();

    @Override
    public void save(Member member) {
        memberHashMap.put(member.getId(), member);
    }

    @Override
    public Member findMember(Long id) {
        return memberHashMap.get(id);
    }
}
