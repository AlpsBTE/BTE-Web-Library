package bte.web.library;

import bte.web.library.json.JSON_Reader;
import bte.web.library.models.Application;
import bte.web.library.models.Member;
import bte.web.library.requests.MembersRequest;
import org.json.JSONArray;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BTEWebLibrary extends JSON_Reader {

    private final MembersRequest MEMBERS_REQUEST = new MembersRequest();

    public BTEWebLibrary(String API_Key) {

        this.API_Key = API_Key;

    }

    public MembersRequest getMembers() throws IOException {
        JSONArray array = getJSONArray(getJSONObject(jsonGetRequest("members")), "members");

        MEMBERS_REQUEST.asList.clear();
        for (int i = 0; i < array.length(); i++ ) {
            MEMBERS_REQUEST.asList.add(new Member(
                    array.getJSONObject(i).getString("discordId"),
                    array.getJSONObject(i).getString("discordTag"),
                    array.getJSONObject(i).getString("role")));
        }

        return MEMBERS_REQUEST;
    }

    public List<Application> getApplicationsByMember(Member member) throws IOException {
        JSONArray applications = getJSONArray(getJSONObject(jsonGetRequest("applications/" + member.getID())), "applications");

        return getApplications(applications);
    }

    public List<Application> getPendingApplications() throws IOException {
        JSONArray applications = getJSONArray(getJSONObject(jsonGetRequest("applications/pending")), "applications");

        return getApplications(applications);
    }

    private List<Application> getApplications(JSONArray appl) {
        List<Application> applications = new ArrayList<>();

        for (int i = 0; i < appl.length(); i++) {
            applications.add(new Application(appl.getJSONObject(i).getInt("id"), getJSONArray(appl.getJSONObject(i), "answers")));
        }

        return applications;
    }
}
