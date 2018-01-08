#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#include <AutoItConstants.au3>

	WinActivate("Add BIN Range", "General")
	ControlClick("Add BIN Range", "", "[NAME:Text2]")
    Send("{SHIFTDOWN}")
	Send("{TAB}")
	Send("{TAB}")
    Send("{TAB}")
    Send("{TAB}")
	Send("{SHIFTUP}")