#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#include <AutoItConstants.au3>


	WinActivate($CmdLine[1], "Test Options")
	ControlClick($CmdLine[1], "", "Allows preparing the test cases")

	WinWait($CmdLine[1], "[NAME:TabStrip]", "60")