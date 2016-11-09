package com.beimin.eveapi.response.corporation;

import java.util.ArrayList;
import java.util.List;

import com.beimin.eveapi.model.corporation.SecurityMember;
import com.beimin.eveapi.response.ApiResponse;

public class MemberSecurityResponse extends ApiResponse {
    private final List<SecurityMember> members = new ArrayList<>();

    public void addMember(final SecurityMember member) {
        members.add(member);
    }

    public List<SecurityMember> getMembers() {
        return members;
    }
}
