
# ContactTor

## Table of Contents
1. [Overview](#Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
2. [Schema](#Schema)

## Overview
### Description
ContactTor is an app designed for persons to log the people who they have been in contact with to make the contact tracing process easier in the event that said individual was to contract the COVID-19 Virus.

### App Evaluation
[Evaluation of your app across the following attributes]
- **Category:** Social Networking
- **Mobile:** This app would be primarily developed for mobile.
- **Story:** Allows user to enter the persons who they’ve been in contact with. 
- **Market:** This app is geared towards anyone who desires to use it for contact tracing purposes.
- **Habit:** This app could be used as often or unoften as the user desires.
- **Scope:** We would start by creating a tree like structure with indiviuals the user has been in contact with and if that user is also a user of the app then the tree would branch showing who that user was in contact with.

## Product Spec

### 1. User Stories (Required and Optional)

**Required Must-have Stories**

* [X] Log in / Registration Screen.
* [ ] Compose Screen to allow the user to add information about who they’ve been in contact with.
* [ ] Home Screen to see the contact tree created.
* [ ]  Log out screen.
  
**Optional Nice-to-have Stories**

* Able to message persons from in the app 
* Profile Screen to add personal information and a profile picture

### 2. Screen Archetypes

* Login / Register - User signs up or logs into their account
* Compose Screen
  * Allows the user to add information about who they’ve been in contact with.
* Home Screen 
  * Allows the user to view the generated contact tree.
* Log out Screen
  * Allows the user to sign out of the application.

### 3. Navigation

**Tab Navigation** (Tab to Screen)

* Login / Registration
* Home
* Log out

**Flow Navigation** (Screen to Screen)

* Log-in -> Account creation if no log in is available
* Compose Screen -> Jumps to Home screen to display contact tree
* Log out  -> Returns to log in screen


## Wireframes

### [BONUS] Digital Wireframes & Mockups
<img src="https://github.com/ContactTor/ContactTor/blob/main/Digital%20Wireframe.png" width=600>

### [BONUS] Interactive Prototype
<img src="https://github.com/ContactTor/ContactTor/blob/main/Prototype.gif" width=600>
<img src=contactro.gif width=400>

## Schema 
### Models
#### Post

   | Property      | Type     | Description |
   | ------------- | -------- | ------------|
   | objectId      | String   | unique id for the user post (default field) |
   | author        | Pointer to User| post author |
   | p_image       | File     | Profile picture |
   | description   | String   | location description by author |
   | createdAt     | DateTime | date when post is created (default field) |
   | updatedAt     | DateTime | date when post is last updated (default field) |
### Networking
#### List of network requests by screen
   - Home Feed Screen
      - (Read/GET) Query all posts where user is author
         ```swift
         let query = PFQuery(className:"Post")
         query.whereKey("author", equalTo: currentUser)
         query.order(byDescending: "createdAt")
         query.findObjectsInBackground { (posts: [PFObject]?, error: Error?) in
            if let error = error { 
               print(error.localizedDescription)
            } else if let posts = posts {
               print("Successfully retrieved \(posts.count) posts.")
           // TODO: Do something with posts...
            }
         }
         ```
      - (Create/POST) Create a new like on a post
      - (Delete) Delete existing like
      - (Create/POST) Create a new comment on a post
      - (Delete) Delete existing comment
   - Create Post Screen
      - (Create/POST) Create a new post object
   - Profile Screen
      - (Read/GET) Query logged in user object
      - (Update/PUT) Update user profile image
#### [OPTIONAL:] Existing API Endpoints
##### Twitter API
- Base URL - [http://www.anapioficeandfire.com/api](http://www.anapioficeandfire.com/api)

   HTTP Verb | Endpoint | Description
   ----------|----------|------------
    `GET`    | /characters | get all characters
    `GET`    | /characters/?name=name | return specific character by name
    `GET`    | /houses   | get all houses
    `GET`    | /houses/?name=name | return specific house by name

