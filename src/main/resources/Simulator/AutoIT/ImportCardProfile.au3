#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#RequireAdmin
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>
#include <Constants.au3>

   $CmdLine[0]
   $CmdLine[1]
	WinActivate("Select File", "&Open")
	sleep(500)

   $filePath = $CmdLine[$CmdLine[0]] ;Directory within the Appdata directory where the ini file should be.

	ControlSetText("Select File","","[CLASS:Edit; INSTANCE:1]", $filePath) ; erase the file name to make room for the $dest string
	sleep(1000)

   ControlClick("Select File","","[CLASS:Button; INSTANCE:1]")

   sleep(2000)

   WinWait("Import Card Profiles", "Row Description", "30")
   WinActivate("Import Card Profiles", "Row Description")
   sleep(1000)
   ControlClick("Import Card Profiles","","[NAME:Cmd_OK]")
