@echo off
echo Wait...
ping 127.0.0.1 -n 2 > nul
echo Applying Update
move MyOrganizer.jar old
rename MyOrganizer-Update.jar MyOrganizer.jar
echo All done!
start MyOrganizer.jar
exit
