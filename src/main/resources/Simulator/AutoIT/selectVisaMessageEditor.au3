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

   WinActivate("Visa Test System")
   WinMenuSelectItem("Visa Test System", "", "&Edit", "&Message Editor...")
   Send("!em")
   WinWaitActive("Message Editor", "" , 50)
   WinSetState("Message Editor", "", @SW_MAXIMIZE)
   ControlCommand("Message Editor", "", "[CLASS:Button; INSTANCE:4]", "Uncheck", "")
