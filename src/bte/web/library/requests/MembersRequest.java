package bte.web.library.requests;

import bte.web.library.models.Member;
import java.util.ArrayList;
import java.util.List;

public class MembersRequest {

    public List<Member> asList = new ArrayList<Member>();

    public Member getMemberByID(String discordId) {
        for (Member member : asList) {
            if (String.valueOf(member.getDiscord_ID()).equalsIgnoreCase(discordId)) {
                return member;
            }
        }
        return null;
    }

    public Member getMemberByName(String discordName) {
        for (Member member : asList) {
            if ((member.getDiscord_Name() + "#" + member.getDiscord_Tag()).equalsIgnoreCase(discordName)) {
                return member;
            }
        }
        return null;
    }

    public List<Member> getMembersByRole(Member.Roles role) {
        List<Member> membersByRole = new ArrayList<>();
        for(Member member : asList) {
            if(member.getRole().equals(role)) {
                membersByRole.add(member);
            }
        }
        return membersByRole;
    }
}
