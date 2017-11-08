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

If WinExists("Licence Key Validation Problem") Then
	WinActivate("Licence Key Validation Problem", "Your maintenance and support has expired.")
	ControlClick("Licence Key Validation Problem", "", "[CLASS:Button; INSTANCE:1]")
	 EndIf