#cs ----------------------------------------------------------------------------

 AutoIt Version: 3.3.14.2
 Author:         myName

 Script Function:
	Template AutoIt script.

#ce ----------------------------------------------------------------------------

; Script Start - Add your code below here
#RequireAdmin

If WinExists("FINsim - Connect To Server") Then
	WinActivate("FINsim - Connect To Server", "Server Name:")
	ControlClick("FINsim - Connect To Server", "", "[CLASS:Edit; INSTANCE:1]")
EndIf

