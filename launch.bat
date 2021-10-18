::
:: Yoinked from Omnifactory, Credit goes to them
::

:: DO NOT EDIT UNLESS YOU KNOW WHAT YOU'RE DOING
@ECHO OFF
SET FORGEJAR=forge-1.12.2-14.23.5.2855.jar
:: these you can edit
SET MIN_RAM=2048M
SET MAX_RAM=2048M

:: DO NOT EDIT ANYTHING PAST THIS LINE
SET LAUNCHPARAMS=-server -Xms%MIN_RAM% -Xmx%MAX_RAM% %JAVA_PARAMETERS% -jar %FORGEJAR% nogui
echo Checking java version...
echo.
java -version
echo.
echo The expected java version is 1.8. Not higher, not lower.
echo.

echo Launching the server...
echo.
echo ^> java %LAUNCHPARAMS%
java %LAUNCHPARAMS%
