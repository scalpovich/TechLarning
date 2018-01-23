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

if(WinExists("Microsoft Visual C++ Debug Library")) Then
    WinActivate("Microsoft Visual C++ Debug Library")
	 ControlClick("Microsoft Visual C++ Debug Library","","[CLASS:Button; INSTANCE:1]")
EndIf

if(WinExists("VTS")) Then
   WinActivate("VTS", "OK")
   ControlClick("VTS","","[CLASS:Button; INSTANCE:1]")
EndIf

if(WinExists("Visa Test System")) Then
   WinActivate("Visa Test System", "OK")
EndIf