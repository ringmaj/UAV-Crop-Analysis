
@echo off

echo This script will automate the entire process for you. Please wait...
timeout 3

echo ---------------------------------------------------------------------------
echo.



echo Renaming all image files... 

cd Image Files

@echo off
setlocal EnableDelayedExpansion
set i=0
for %%a in (*.jpg) do (
    set /a i+=1
    ren "%%a" "!i!.new"
)
ren *.new *.jpg

timeout 10


echo ---------------------------------------------------------------------------
echo Renaming process is now complete
echo ---------------------------------------------------------------------------
echo.

echo Starting Microsoft ICE
timeout 5

cd..

cd Stitched Images

START iceFile.spj

exit 0

timeout 10





