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

   WinActivate("Incoming Message")
   WinSetState("Incoming Message", "", @SW_MAXIMIZE)
   ControlCommand("Incoming Message", "", "[CLASS:Button; INSTANCE:2]", "Uncheck", "")