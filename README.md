# Java code for the 2017 offseason

## Todo list
* Document code
    * Deoxygen
* Smart Dashboard
    * Add an interface for changing constants on the robot
    * Add a camera feed
    * Add a heat map for the robot position
    * Add a tab interface
        * Driving tab
            * Auto Selection
            * Camera View
            * Match Timer
            * Battery Voltage
            * Connection Status
        * PID tab
            * Error Graph
            * PID variables(editable)
        * Debugging/console tab
            * Console
            * List of variables
        * Variables/tuning tab
            * Variable inputs(other than PID)
* Autos
    * Write code to run auto routine in separate thread

##Deployment System
The deploy system on the roborio consists of an FTP server and an HTTP server.
Protocol:
* Client sends runtime libraries to temporary folder in /home/lvuser/
* Client sends robot program to /home/lvuser/
* Client notifies http server that it has deployed
* Http server moves files into place, and starts the new program

## Building and Deploying
1. use `gradle build` or `./gradlew build` to build
2. use `gradle deploy` or `./gradlew deploy` to deploy


## Smart Dashboard


