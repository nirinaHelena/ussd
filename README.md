# USSD Simulator - Spring Boot Application

## Prerequisites

### Java JDK 17+
**Windows:**
1. Download from [Oracle JDK](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html) or [Adoptium](https://adoptium.net/)
2. Run installer
3. Set environment variables:
   ```cmd
   setx JAVA_HOME "C:\Program Files\Java\jdk-17.0.x"
   setx PATH "%PATH%;%JAVA_HOME%\bin"
   ```
**macOS/Linux: **
• Using Homebrew (macOS)
```cmd
  brew install openjdk@17
```
• Using SDKMAN
```cmd
  curl -s "https://get.sdkman.io" | bash
  source "$HOME/.sdkman/bin/sdkman-init.sh"
  sdk install java 17.0.6-tem
```
### Gradle 7.4+
**Windows: **
```cmd
  choco install gradle
```
**macOS/Linux: **
```cmd
  # Using SDKMAN
  sdk install gradle 7.6

  # Using Homebrew
  brew install gradle
```
### Git (Optional)
**Windows: **
```cmd
choco install git
```

**macOS: **
```cmd
brew install git
```

**Linux: **
```cmd
sudo apt install git
```
## Getting Started
### Clone repository:

```cmd
git clone https://github.com/your-repo/ussd-simulator.git
cd ussd-simulator
```
### Build project:

```cmd
gradle build
```
Run application:

```cmd
# Method 1 - Using generated JAR
java -jar build/libs/ussd-simulator-1.0.0.jar

# Method 2 - Using Gradle
gradle bootRun
```
