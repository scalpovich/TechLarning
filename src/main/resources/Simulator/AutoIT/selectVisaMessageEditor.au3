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

    WinActivate("[CLASS:Visa Test System Sapphire Window Class (1)]")
	Send("!em")
	WinActivate("Message Editor")
	ControlCommand("Message Editor", "", "[CLASS:Button; INSTANCE:4]", "Uncheck", "")
