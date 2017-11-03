#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#include <MsgBoxConstants.au3>
#include <WinAPIFiles.au3>
#include <Date.au3>
#include <File.au3>
#include <MsgBoxConstants.au3>

	sleep(5000)
 	WinActivate("Open IPM File", "Files of &type:")
	sleep(2000)
    ControlSetText("Open IPM File","","Edit1", $CmdLine[1])
	sleep(1000)
    ControlClick("Open IPM File","","[CLASS:Button; INSTANCE:1]")