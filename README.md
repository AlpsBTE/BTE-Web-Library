# BTE Build Team Web Library

This is a simple Java library for BTE Build Team leaders. You can easily access your build team data from the https://buildtheearth.net Website.
My library uses the [Build Team API](https://github.com/BuildTheEarth/build-team-api/) by [Xesau](https://github.com/Xesau).

To get started, have a look at the examples. It's my first library, so if you find any issue, please contact me! :)

## Current Features

- [x] **Members** (Access DiscordID, DiscordName, DiscordTag and Role of a member)
- [x] **Applications** (Access to pending applications and applications of a member)
- [ ] **Locations** (Access all locations of your build team)
- [ ] **Regions** (Access all claimed plots of a location of your build team)

## Examples

### Getting Started

Import *BTEWebLibrary* and pass your Build Team API-Key as parameter.
```
BTEWebLibrary bte = new BTEWebLibrary("API-KEY");
```

### Get Member(s)

**Structure**
* `ID`: Integer, Member ID from the BTE Website (The API currently doesn't provide this)
* `DiscordID`: Long, Discord ID
* `DiscordName`: String, Discord Name without Tag (#9999)
* `DiscordTag`: Integer, Discord Discriminator
* `Role`: Roles, Builder / Reviewer / CoLeader / Leader

```
bte.getMembers().getMemberByID("285480119575904256");
        
bte.getMembers().getMemberByName("R3tuxn");
        
bte.getMembers().getMembersByRole(Roles.Builder);
```

### Get Application(s)

**Structure**
* `ID`: Integer, Application ID from the BTE Website
* `Questions`: Map<String,String>, List of all Questions / Key: *ID*, Value: *Question*
* `Answers`: Map<String,String>, List of all Answers / Key: *ID*, Value: *Answer*

```
List<Application> applicationsByMember = bte.getApplicationsByMember(bte.getMembers().getMemberByID("285480119575904256"));

List<Application> pendingApplications = bte.getPendingApplications();
```
