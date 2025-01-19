# NetworkUserApp


**The application was created in collaboration by 4 students:** 

**Norbert Kabziński, Ksawery Kosarski, Łukasz Serwatka, and Mikołaj Ćmok**

NetworkUserApp is an Android application designed to fetch and display user data from a remote API (JSONPlaceholder) and show it within a simple UI built using Jetpack Compose. The app allows users to view a list of users.
## Features
API Integration: Fetches user data from JSONPlaceholder.

User Interface: Displays a list of users with their name, username, and location.

**Offline Support:** Caches user data locally using Room Database.

**Network Check:** Automatically checks internet availability before fetching data.

**Jetpack Compose:** A modern toolkit for building native UI in Android.

**Clean Architecture:** Uses ViewModel, Repository, UseCases, and Dependency Injection with Hilt.

**Error Handling:** The app is designed to handle errors gracefully, displaying appropriate messages for network failures, API errors, or other unexpected issues.

## Architecture

**MVVM:** The app follows the Model-View-ViewModel (MVVM) design pattern.

**Retrofit:** Used for network operations (fetching data).

**Room Database:** Caches data locally to allow offline access.

**Hilt:** Dependency injection to manage instances and dependencies.

## Components

### 1. UserCard Composable

Displays individual user details including:

Name

Username

City

Profile picture placeholder (default icon)

The card is clickable, and you can expand it to display more information.


### 2. UserList Composable

Displays a scrollable list of users using LazyColumn.

### 3. MainScreen Composable

The main screen contains:

A top bar with the app title and settings button.

A bottom bar for navigation.

A loading spinner when the data is being fetched.

Displays user information or an error message if fetching fails.

### 4. NetworkUtils

A utility class to check if the device has an active internet connection.

### 5. ViewModel & Repository

The UserViewModel handles the UI-related logic.

The UserRepository manages the fetching of data from the API and local database.

## Technologies Used

**Kotlin:** Programming language.

**Jetpack Compose:** UI framework for modern Android development.

**Retrofit:** Used to fetch data from the API.

**Room Database:** For local storage of user data.

**Hilt:** For dependency injection.

