package bte.web.library.models;

import org.json.JSONObject;

public class Member {

    public enum Roles {
        Builder, Reviewer, CoLeader, Leader
    }

    private final int ID, DISCORD_TAG;
    private final long DISCORD_ID;
    private final String DISCORD_NAME;
    private final Roles ROLE;

    public Member(String discordId, String discordTag, String role) {

        // Get Discord Member ID (e.g. 285480119575904256)
        this.DISCORD_ID = Long.parseLong(discordId);

        // Get Discord Member Tag ID (e.g. 7169)
        this.DISCORD_TAG = Integer.parseInt(discordTag.substring(discordTag.lastIndexOf('#') + 1));

        // Get Discord Member Name (e.g. R3tuxn)
        this.DISCORD_NAME = discordTag.substring(0, discordTag.lastIndexOf('#'));

        // Get Website Role of the Member
        if (role.equalsIgnoreCase("builder")) {
            this.ROLE = Roles.Builder;
        } else if(role.equalsIgnoreCase("reviewer")) {
            this.ROLE = Roles.Reviewer;
        } else if(role.equalsIgnoreCase("co-leader")) {
            this.ROLE = Roles.CoLeader;
        } else {
            this.ROLE = Roles.Leader;
        }

        // Unable to get Member ID from the BTE Website API
        this.ID = 0;
    }

    @Deprecated
    public int getID() {
        return ID;
    }

    public long getDiscord_ID() {
        return DISCORD_ID;
    }

    public int getDiscord_Tag() {
        return DISCORD_TAG;
    }

    public String getDiscord_Name() {
        return DISCORD_NAME;
    }

    public Roles getRole() {
        return ROLE;
    }

    @Override
    public String toString() {
        return new JSONObject().put("discordId", getDiscord_ID()).put("discordTag", getDiscord_Name() + "#" + getDiscord_Tag()).put("role", getRole()).toString();
    }
}
