#!/bin/bash
vars_directory=$2
team_number=5499

if [ "${1}" == "push" ]; then
    scp ${vars_directory} admin@roborio-${team_number}-frc.local:/home/lvuser/vars.json
else
    scp admin@roborio-${team_number}-frc.local:/home/lvuser/vars.json ${vars_directory}
fi