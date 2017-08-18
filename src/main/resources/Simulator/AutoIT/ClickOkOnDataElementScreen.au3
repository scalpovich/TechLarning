#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#RequireAdmin

If WinExists("Data and Subdata Element Editing") Then

	WinActivate("Data and Subdata Element Editing", "OK")
	ControlClick("Data and Subdata Element Editing", "", "[NAME:cmd_OK]")

EndIf

