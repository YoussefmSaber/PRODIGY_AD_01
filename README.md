# Calculator Application

A modern calculator app built with **Jetpack Compose**, featuring **StateFlow** integration, dynamic button layouts, and seamless state management using **Hilt**.

## Features

- **Dynamic button layout**: Buttons adjust based on screen size and orientation.
- **StateFlow integration**: Reactive programming for managing app states.
- **Seamless state management**: Leveraging **Hilt** for dependency injection.

## Technologies

- **Jetpack Compose**: UI framework for building modern Android UIs.
- **StateFlow**: Kotlin's reactive API for managing UI state.
- **Hilt**: Dependency injection library for managing app components.
- **Kotlin**: Primary language used for development.

## Dependencies

- Jetpack Compose
- StateFlow
- Hilt
- Kotlin

## Architecture

This project follows **MVVM** (Model-View-ViewModel) architecture with:

- **Model**: Handles business logic and data.
- **View**: Composed using Jetpack Compose UI elements.
- **ViewModel**: Manages UI-related data lifecycle and business logic with reactive **StateFlow**.

## Setup

1. Clone the repository:
   ```bash
   git clone https://github.com/YoussefmSaber/PRODIGY_AD_01.git
   cd PRODIGY_AD_01
   ```

2. Open the project in **Android Studio** and sync the project.

3. Run the app on an emulator or device.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgements

- [Jetpack Compose Documentation](https://developer.android.com/jetpack/compose)
- [Kotlin Lang](https://kotlinlang.org/)
- [Hilt Documentation](https://developer.android.com/training/dependency-injection/hilt-android)