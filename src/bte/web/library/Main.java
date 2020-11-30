package bte.web.library;

import bte.web.library.models.Member;
import bte.web.library.models.Application;
import java.io.IOException;
import java.util.List;

public class Main {
    public static void main (String[] args) throws IOException {

        //------------------------
        // Getting Started
        //------------------------

        // Import BTEWebLibrary and pass your Build Team API-Key as parameter.
        BTEWebLibrary bte = new BTEWebLibrary("API-KEY");


        //------------------------
        // Members
        //------------------------

        // Get all Members as a list
        List<Member> members = bte.getMembers().asList;

        // Get Member by Discord ID
        bte.getMembers().getMemberByID("285480119575904256");

        // Get Member by Discord Name
        bte.getMembers().getMemberByName("R3tuxn");

        // Get Members by a Role
        bte.getMembers().getMembersByRole(Member.Roles.Builder);



        //------------------------
        // Applications
        //------------------------

        // Get all applications by a Member
        //List<Application> applicationsByMember = bte.getApplicationsByMember(bte.getMembers().getMemberByID("285480119575904256"));

        // Get all pending applications
        List<Application> pendingApplications = bte.getPendingApplications();
    }
}
