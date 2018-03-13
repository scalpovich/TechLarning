#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>
#include <Constants.au3>

   $CmdLine[0]
   $CmdLine[1]
   WinActivate("Open", "File &name:")
   sleep(500)
   $filePath = $CmdLine[$CmdLine[0]] ;Directory within the Appdata directory where the ini file should be.
   ControlSetText("Open","","[CLASS:Edit; INSTANCE:1]", $CmdLine[1]) ; erase the file name to make room for the $dest string
   sleep(1000)
   ControlClick("Open","","[CLASS:Button; INSTANCE:1]")
   sleep(3000)

   ControlClick("VTS","","[CLASS:Button; INSTANCE:1]")
