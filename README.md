# Fetch Rewards Coding Exercise - Android Application

This is an Android application built for the Fetch Rewards Coding Exercise. The application retrieves data from a JSON API, groups the data by "listId", and displays it in a sorted list, filtering out any items where "name" is blank or null.

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites
- Android Studio 4.2 or later
- JDK 8
- Android SDK 30
- Latest Android Build Tools
- Android Support Repository

### Cloning
To clone this repository, use the following command in your terminal:
```bash
git clone https://github.com/bvedang/FetchRewards.git
```

### Building
To build the application, open the project in Android Studio and select **"Build > Make Project"** from the menu.

### Running
You can run the application on an Android emulator or a physical Android device.

Running on an emulator
1. Open the AVD Manager by selecting **"Tools > AVD Manager"** from the menu.
2. Create a new AVD if you don't already have one.
3. Click the green play button in the AVD Manager to start the emulator.
4. Select **"Run > Run 'app'"** from the menu.

Running on a device
1. Connect your Android device to your computer.
2. Select "Run > Run 'app'" from the menu.

## Application Architecture
The application uses a simple MVVM (Model-View-ViewModel) architecture with the following components:

- `Item`: This class represents the items fetched from the server.
- `ItemAdapter`: This class is a RecyclerView adapter that binds Item objects to RecyclerView item views.
- `ApiService`: This interface defines the HTTP request to fetch the items.
- `MainActivity`: This is the main activity of the application. It initializes the ApiService and RecyclerView, fetches the items, filters out items where "name" is blank or null, sorts the items, and updates the RecyclerView with the sorted items.
