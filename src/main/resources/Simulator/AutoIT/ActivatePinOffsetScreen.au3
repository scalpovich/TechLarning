#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#RequireAdmin

If WinExists("PIN Offset Calculator") Then
	WinActivate("PIN Offset Calculator", "Card Number :")
	ControlClick("PIN Offset Calculator", "", "[CLASS:Edit; INSTANCE:1]")
EndIf

