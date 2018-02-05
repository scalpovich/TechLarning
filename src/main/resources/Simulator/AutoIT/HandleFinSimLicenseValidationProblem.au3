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
	Sleep(4000)
 EndIf


 ;to handle unwanted screen before we reach password screen
 If WinExists("Password Protected Sever") Then
	WinActivate("Password Protected Sever", "Help")
	ControlClick("Password Protected Sever", "", "[CLASS:Button; INSTANCE:2]")
	Sleep(4000)
 EndIf

 If WinExists("Licence Key Validation Problem") Then
	WinActivate("Licence Key Validation Problem", "Your maintenance and support has expired.")
	ControlClick("Licence Key Validation Problem", "", "[CLASS:Button; INSTANCE:1]")
	Sleep(4000)
 EndIf

 If WinExists("Password Protected Sever") Then
	WinActivate("Password Protected Sever", "Help")
	ControlClick("Password Protected Sever", "", "[CLASS:Button; INSTANCE:2]")
	Sleep(4000)
 EndIf

 If WinExists("FINsim - Connect To Server") Then
	WinActivate("FINsim - Connect To Server", "Server Name:")
	ControlClick("FINsim - Connect To Server", "", "[CLASS:Edit; INSTANCE:1]")
	Sleep(4000)
EndIf