# Java Codebase

## Todo list
* Document code
    * Deoxygen?
    * Use style-guide provided 
* Improve Smart Dashboards
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
* Json file parsing
    * Reading the json variables(done)
    * writing to the json file
    * syncing the file between computers
* Autos
    * Test the center auto for reliability
    * Write a turn command
    * Tune the turn command
    * Write the left and right auto
    * Tune the left and right auto
* Fix LED class (Done)

## Building and Deploying
1. `cd` into the frc-2017-java directory
2. use `gradle build` or `/gradlew build` to build or use `gradle deploy` or `/gradlew deploy` to deploy


## Smart Dashboard

Based on [`FRC Dashboard`](https://frcdashboard.github.io/).

### Setup
* If you haven't done so already, install the dependencies:
    * [`nodejs`](https://nodejs.org)
    * [`npm`](https://npmjs.com)

* In the dashboard directory, run `npm install`

### Building
1. `cd` into the dashboard directory
2. Run `npm i` to install all of the dependencies
3. Run `npm run dist` to pack the entire application into a single file

### Running
While in the dashboard directory, type `npm start`.