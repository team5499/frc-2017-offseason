const $ = require("jquery");
// Define ui elements
let ui = {
    tabs: {
        container: document.getElementById('tab'),
        buttons: {
            driveButton: document.getElementById("drive"),
            pidButton: document.getElementById("pid"),
            debugButton: document.getElementById("debug"),
            varButton: document.getElementById("vars")
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

$("sectionWrapper").hide();