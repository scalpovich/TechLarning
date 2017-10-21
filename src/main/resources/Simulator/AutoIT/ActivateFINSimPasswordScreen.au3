#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#RequireAdmin

If WinExists("Password Protected Sever") Then
	WinActivate("Password Protected Sever", "Help")
	ControlClick("Password Protected Sever", "", "[CLASS:Edit; INSTANCE:2]")
	ControlFocus("Password Protected Sever", "", "[CLASS:Edit; INSTANCE:2]")
EndIf

