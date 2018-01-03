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

   WinActivate("VTS", "OK")
   ControlClick("VTS","","[CLASS:Button; INSTANCE:1]")

   WinActivate("Visa Test System (1)")

   WinActivate("Visa Test System (1) - DMS_TEST_FILE")