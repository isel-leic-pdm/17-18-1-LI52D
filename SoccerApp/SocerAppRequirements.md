# Chelas Soccer Application

**Domain problem**: Soccer leagues information


## Requirements

### Functional Requirements

1. Search leagues by a string contained in its name


### Non Functional Requirements

1. Leagues data should be obtained from [Api FootballData](http://api.football-data.org/v1).
1. Interface with nativa application for Android devices


## Solution


1. Activities - View
  1. Role: Implement **every** aspect of the user interface and user interction
  1. Package view
  1. Activities
     *MainActivity - Activity to perform the search
       * Layouts
         * main_layout.xml - The form to search
     * ListLeaguesActivity - Shows the leagues obtained from search
        * Layouts
        * list_leagues_layout.xml - Layout with a List View to showing the leagues
        * league_item_layout.xml - Layout with a List View Item showing a league


1. Domain
  1. Represents all domain entities and supply all domain operations
  1. Package `domain`
  1. Entities
        * League - Represents a League

  1. Operations
      * GetLeagues


1.  Data Access
  1. Accesses the data. Deals with all communication and data format details.
  1. Package data
  1. Data classes that represent the API supplied format











