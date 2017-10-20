"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const electron = require("electron");

// Module to control application life.
const app = electron.app;

// Module to create native browser window.
const BrowserWindow = electron.BrowserWindow;

// Module for receiving messages from the BrowserWindow
const ipc = electron.ipcMain;

// Keep a global reference of the window object, if you don't, the window will
// be closed automatically when the JavaScript object is garbage collected.
let mainWindow;

let ready = false;
function createWindow() {
    // When the script starts running in the window set the ready variable
    ipc.on('ready', (ev, mesg) => {
        ready = true;
    });
    // Create the browser window.
    mainWindow = new BrowserWindow({
        width: 1366,
        height: 570,
        // 1366x570 is a good standard height, but you may want to change this to fit your DriverStation's screen better.
        // It's best if the dashboard takes up as much space as possible without covering the DriverStation application.
        // The window is closed until the python server is ready
        show: false
    });
    // Move window to top (left) of screen.
    mainWindow.setPosition(0, 0);
    // Load window.
    mainWindow.loadURL(`file://${__dirname}/index.html`);
    // Remove menu
    mainWindow.setMenu(null);
    // Emitted when the window is closed.
    mainWindow.on('closed', function () {
        // Dereference the window object, usually you would store windows
        // in an array if your app supports multi windows, this is the time
        // when you should delete the corresponding element.
        mainWindow = null;
    });

    mainWindow.show();
}

// This method will be called when Electron has finished
// initialization and is ready to create browser windows.
app.on('ready', () => {
    createWindow();
});

// Quit when all windows are closed.
app.on('window-all-closed', function () {
    // On OS X it is common for applications and their menu bar
    // to stay active until the user quits explicitly with Cmd + Q.
    // Not like we're creating a consumer application though.
    // Let's just kill it anyway.
    // If you want to restore the standard behavior, uncomment the next line.
    // if (process.platform !== "darwin")
    app.quit();
});

app.on('quit', function () {
    console.log('Application quit.');
});

app.on('activate', function () {
    // On OS X it's common to re-create a window in the app when the
    // dock icon is clicked and there are no other windows open.
    if (mainWindow == null) {
        createWindow();
    }
});
