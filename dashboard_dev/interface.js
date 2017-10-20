"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
const electron = require("electron");

// Define ui elements
let ui = {
    tabs: {
        container: document.getElementById('tab'),
        buttons: {
            driveButton: document.getElementById("drive"),
            pidButton: document.getElementById("pid"),
            debugButton: document.getElementById("debug"),
            varButton: document.getElementsById("vars")
        }
    },
    sections: {
        container: document.getElementById("sectionWrapper"),
        sects: {
            drive: document.getElementById("driveTab"),
            pid:  document.getElementById("pidTab"),
            debug:  document.getElementById("debugTab"),
            vars:  document.getElementById("varsTab")
        } 
    }
}

