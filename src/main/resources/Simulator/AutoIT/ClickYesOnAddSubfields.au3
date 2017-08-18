#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#RequireAdmin

If WinExists("Add Subfields") Then
	WinActivate("Add Subfields", "&Yes")
	ControlClick("Add Subfields", "", "[CLASS:Button; INSTANCE:1]")
	EndIf