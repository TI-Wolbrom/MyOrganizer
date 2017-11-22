#!/bin/bash
echo Wait...
sleep 2s
echo Applying Update
mv MyOrganizer.jar old
mv MyOrganizer-Update.jar MyOrganizer.jar
echo All done!
java -jar MyOrganizer.jar